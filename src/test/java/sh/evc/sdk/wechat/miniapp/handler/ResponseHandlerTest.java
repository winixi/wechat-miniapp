package sh.evc.sdk.wechat.miniapp.handler;

import sh.evc.sdk.wechat.miniapp.response.JsonResponse;

/**
 * test response handler
 *
 * @author winixi
 * @date 2021/1/8 1:52 PM
 */
public class ResponseHandlerTest implements ResponseHandler {

  @Override
  public void append(JsonResponse response) {
    System.out.println(response.toString());
  }
}
