package sh.evc.sdk.wechat.miniapp.util.client;

import sh.evc.sdk.wechat.miniapp.domain.MediaFile;

import java.io.File;
import java.util.Map;

/**
 * 代理请求实现接口.不同客户端实现需实现该接口.
 *
 * @author vioao
 */
public interface HttpDelegate {

  /**
   * 发送GET请求。
   */
  String get(String url, Map<String, String> params);

  /**
   * 发送POST请求。
   */
  String post(String url, Map<String, String> params, String postData);

  /**
   * 发送post请求，获取小程序二维码
   *
   * @param url
   * @param postData
   * @return
   */
  byte[] post(String url, String postData);

  /**
   * 上传文件.
   */
  String upload(String url, Map<String, String> params, File file);

  /**
   * 下载文件.
   */
  MediaFile download(String url, Map<String, String> params);
}
