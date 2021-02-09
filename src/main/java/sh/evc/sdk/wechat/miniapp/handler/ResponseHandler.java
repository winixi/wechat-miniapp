package sh.evc.sdk.wechat.miniapp.handler;

import sh.evc.sdk.wechat.miniapp.response.ApiResponse;

/**
 * response handler
 *
 * @author winixi
 * @date 2021/1/18 11:37 AM
 */
public interface ResponseHandler {

  /**
   * 用来做日志或数据记录
   *
   * @param response
   */
  void append(ApiResponse response);
}
