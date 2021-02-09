package sh.evc.sdk.wechat.miniapp.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;

import static org.apache.http.Consts.UTF_8;

/**
 * 微信请求对象
 *
 * @author winixi
 * @date 2018/11/22 11:41 PM
 */
public class HttpRequest {

  private final static Logger log = LoggerFactory.getLogger(HttpRequest.class);

  /**
   * HTTP(S) 连接超时时间，单位毫秒
   *
   * @return
   */
  int connectTimeoutMs = 3000;

  /**
   * HTTP(S) 读数据超时时间，单位毫秒
   *
   * @return
   */
  int readTimeoutMs = 6000;

  /**
   * 构造HttpUriRequest请求.
   *
   * @param method 请求方法
   * @param url    请求地址
   * @param params 请求参数
   * @param data   请求体文本数据
   * @param file   请求体二进制文件
   */
  private HttpUriRequest buildRequest(String method, String url, ParamsMap params, String data, File file) {
    RequestBuilder builder = RequestBuilder.create(method).setUri(url);
    if (params != null) {
      for (String key : params.keySet()) {
        builder.addParameter(new BasicNameValuePair(key, (String) params.get(key)));
      }
    }
    if (data != null) {
      builder.setEntity(new StringEntity(data, UTF_8));
    }
    if (file != null) {
      MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create().addBinaryBody("media", file);
      builder.setEntity(entityBuilder.build());
    }
    RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeoutMs).setConnectTimeout(connectTimeoutMs).build();
    builder.setConfig(requestConfig);
    return builder.build();
  }

  /**
   * 不带证书请求
   *
   * @param method
   * @param url
   * @param data
   * @param file
   * @return
   */
  public String request(RequestMethod method, String url, ParamsMap params, String data, File file) {
    HttpClientConnectionManager connManager = getConnectionManager();
    HttpClient client = HttpClientBuilder.create().setConnectionManager(connManager).build();
    HttpUriRequest request = buildRequest(method.name(), url, params, data, file);
    return getResponse(client, request);
  }

  /**
   * 带证书请求
   *
   * @param method
   * @param url
   * @param params
   * @param data
   * @param file
   * @param password
   * @param certStream
   * @return
   */
  public String request(RequestMethod method, String url, ParamsMap params, String data, File file, char[] password, InputStream certStream) {
    HttpClientConnectionManager connManager;
    try {
      connManager = getCertConnectionManager(password, certStream);
    } catch (NoSuchAlgorithmException | KeyStoreException | IOException | CertificateException | UnrecoverableKeyException | KeyManagementException e) {
      log.error("使用证书连接发生错误{}", ErrorUtil.getStackTraceAsString(e));
      return null;
    }
    HttpClient client = HttpClientBuilder.create().setConnectionManager(connManager).build();
    HttpUriRequest request = buildRequest(method.name(), url, params, data, file);
    return getResponse(client, request);
  }

  /**
   * 获取返回值
   *
   * @param client
   * @param request
   * @return
   */
  private String getResponse(HttpClient client, HttpUriRequest request) {
    HttpResponse response;
    try {
      response = client.execute(request);
    } catch (IOException e) {
      log.error("http请求发生错误{}", ErrorUtil.getStackTraceAsString(e));
      return null;
    }
    HttpEntity entity = response.getEntity();
    try {
      return EntityUtils.toString(entity, StandardCharsets.UTF_8);
    } catch (IOException e) {
      log.error("返回信息转换错误", ErrorUtil.getStackTraceAsString(e));
      return null;
    }
  }

  /**
   * 获取普通连接，信任所有证书
   *
   * @return
   */
  private HttpClientConnectionManager getConnectionManager() {
    return new BasicHttpClientConnectionManager(
            RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", SSLConnectionSocketFactory.getSocketFactory())
                    .build(),
            null,
            null,
            null
    );
  }

  /**
   * 获取带证书的连接，使用指定的证书和密码
   *
   * @param password
   * @param certStream
   * @return
   */
  private HttpClientConnectionManager getCertConnectionManager(char[] password, InputStream certStream) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException, KeyManagementException {
    KeyStore ks = KeyStore.getInstance("PKCS12");
    ks.load(certStream, password);

    // 实例化密钥库 & 初始化密钥工厂
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(ks, password);

    // 创建 SSLContext
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());

    SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
            sslContext,
            new String[]{"TLSv1"},
            null,
            new DefaultHostnameVerifier());

    return new BasicHttpClientConnectionManager(
            RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslConnectionSocketFactory)
                    .build(),
            null,
            null,
            null
    );
  }

}
