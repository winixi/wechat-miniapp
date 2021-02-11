package sh.evc.sdk.wechat.miniapp.util.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.miniapp.domain.MediaFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.apache.commons.codec.Charsets.UTF_8;

/**
 * http client实现
 *
 * @author winixi
 * @date 2021/2/11 4:29 PM
 */
public class HttpClient {

  private static final Logger log = LoggerFactory.getLogger(HttpClient.class);
  private static final CloseableHttpClient httpClient = HttpClientBuilder.custom().build();
  private static final StringResponseHandler stringHandler = new StringResponseHandler();
  private static final MediaFileResponseHandler fileHandler = new MediaFileResponseHandler();
  private static final ByteArrayResponseHandler byteArrayHandler = new ByteArrayResponseHandler();

  public String get(String url, Map<String, String> params) {
    String response = null;
    try {
      response = httpClient.execute(buildGetRequest(url, params), stringHandler);
    } catch (Exception e) {
      log.error("Get error.url: " + url + ", params: " + params, e);
    }
    return response;
  }

  public String post(String url, Map<String, String> params, String postData) {
    String response = null;
    try {
      response = httpClient.execute(buildPostRequest(url, params, postData), stringHandler);
    } catch (Exception e) {
      log.error("Post error.url: " + url + ", params: " + params + ", postData: " + postData, e);
    }
    return response;
  }

  /**
   * 提交，接收buffer
   *
   * @param url
   * @param params
   * @param postData
   * @return
   */
  public byte[] postReceiveBuffer(String url, Map<String, String> params, String postData) {
    byte[] response = null;
    try {
      response = httpClient.execute(buildPostRequest(url, params, postData), byteArrayHandler);
    } catch (Exception e) {
      log.error("Post error.url: " + url + ", postData: " + postData, e);
    }
    return response;
  }

  public String upload(String url, Map<String, String> params, File file) {
    String response = null;
    try {
      response = httpClient.execute(buildUploadRequest(url, params, file), stringHandler);
    } catch (Exception e) {
      log.error("Upload error.url: " + url + ", params: " + params, e);
    }
    return response;
  }

  public MediaFile download(String url, Map<String, String> params) {
    MediaFile response = null;
    try {
      response = httpClient.execute(buildGetRequest(url, params), fileHandler);
    } catch (Exception e) {
      log.error("Download error.url: " + url + ", params: " + params, e);
    }
    return response;
  }

  /**
   * 构造GET请求.
   */
  private static HttpUriRequest buildGetRequest(String url, Map<String, String> params) {
    return buildRequest(HttpGet.METHOD_NAME, url, params, null, null);
  }

  /**
   * 构造POST请求.
   */
  private static HttpUriRequest buildPostRequest(String url, Map<String, String> params, String data) {
    return buildRequest(HttpPost.METHOD_NAME, url, params, data, null);
  }

  /**
   * 构造文件上传请求.
   */
  private static HttpUriRequest buildUploadRequest(String url, Map<String, String> params, File file) {
    return buildRequest(HttpPost.METHOD_NAME, url, params, null, file);
  }

  /**
   * 构造HttpUriRequest请求.
   *
   * @param method 请求方法
   * @param url    请求地址
   * @param params 请求(key,value)数据
   * @param data   请求体文本数据
   * @param file   请求体二进制文件
   */
  private static HttpUriRequest buildRequest(String method, String url, Map<String, String> params, String data, File file) {
    RequestBuilder builder = RequestBuilder.create(method).setUri(url);
    if (params != null) {
      for (String key : params.keySet()) {
        builder.addParameter(new BasicNameValuePair(key, params.get(key)));
      }
    }
    if (data != null) {
      builder.setEntity(new StringEntity(data, StandardCharsets.UTF_8));
    }
    if (file != null) {
      MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create().addBinaryBody("media", file);
      builder.setEntity(entityBuilder.build());
    }
    return builder.build();
  }

  /**
   * 返回字节数组
   */
  private static class ByteArrayResponseHandler implements ResponseHandler<byte[]> {
    @Override
    public byte[] handleResponse(HttpResponse response) throws IOException {
      int status = response.getStatusLine().getStatusCode();
      if (status >= 200 && status < 300) {
        HttpEntity entity = response.getEntity();
        if (!entity.isStreaming()) {
          throw new ClientProtocolException("返回数据格式不是流" + EntityUtils.toString(entity, UTF_8));
        }
        byte[] resp = EntityUtils.toByteArray(entity);
        return resp;
      } else {
        throw new ClientProtocolException("Unexpected response status:" + status);
      }
    }
  }

  /**
   * 返回字符串
   */
  private static class StringResponseHandler implements ResponseHandler<String> {
    @Override
    public String handleResponse(HttpResponse response) throws IOException {
      int status = response.getStatusLine().getStatusCode();
      if (status >= 200 && status < 300) {
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "UTF-8");
        return str;
      } else {
        throw new ClientProtocolException("Unexpected response status:" + status);
      }
    }
  }

  /**
   * 返回媒体文件
   */
  private static class MediaFileResponseHandler implements ResponseHandler<MediaFile> {
    @Override
    public MediaFile handleResponse(HttpResponse response) throws IOException {
      MediaFile mediaFile = new MediaFile();
      int status = response.getStatusLine().getStatusCode();
      if (status >= 200 && status < 300) {
        String contentType = response.getEntity().getContentType().getValue();
        if (contentType.equalsIgnoreCase("text/plain")) {
          // 定义BufferedReader输入流来读取URL的响应
          HttpEntity entity = response.getEntity();
          String str = EntityUtils.toString(entity, StandardCharsets.UTF_8);
          mediaFile.setError(str);
        } else {
          Header dispositionHeader = response.getFirstHeader("Content-disposition");
          if (dispositionHeader != null) {
            String ds = response.getFirstHeader("Content-disposition").getValue();
            String fullName = ds.substring(ds.indexOf("filename=\"") + 10, ds.length() - 1);
            String relName = fullName.substring(0, fullName.lastIndexOf("."));
            String suffix = fullName.substring(relName.length() + 1);
            mediaFile.setFullName(fullName);
            mediaFile.setFileName(relName);
            mediaFile.setSuffix(suffix);
          }
          mediaFile.setContentLength(response.getEntity().getContentLength());
          mediaFile.setContentType(contentType);
          BufferedInputStream bis = new BufferedInputStream(response.getEntity().getContent());
          mediaFile.setFileStream(bis);
        }
      }
      return mediaFile;
    }
  }
}
