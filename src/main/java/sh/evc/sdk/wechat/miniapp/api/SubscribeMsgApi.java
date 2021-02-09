package sh.evc.sdk.wechat.miniapp.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.miniapp.Const;
import sh.evc.sdk.wechat.miniapp.domain.SubscribeMsg;
import sh.evc.sdk.wechat.miniapp.response.ApiResponse;
import sh.evc.sdk.wechat.miniapp.util.Params;
import sh.evc.sdk.wechat.miniapp.util.client.HttpUtil;
import sh.evc.sdk.wechat.miniapp.util.SerializeUtil;

import java.util.Map;

/**
 * 订阅消息api
 *
 * @author winixi
 * @date 2019/12/27 2:04 PM
 */
public class SubscribeMsgApi {

  private static final Logger log = LoggerFactory.getLogger(SubscribeMsgApi.class);
  private static final String MSG_SUBSCRIBE_SEND = Const.Uri.API_URI + "/cgi-bin/message/subscribe/send";

  /**
   * 发送订阅消息，消息体是结构
   *
   * @param accessToken
   * @param message
   * @return
   */
  public static ApiResponse send(String accessToken, SubscribeMsg message) {
    String postData = SerializeUtil.beanToJson(message);
    Map<String, String> params = Params.create("access_token", accessToken).get();
    log.info("发送小程序订阅消息" + postData);
    return HttpUtil.postJsonBean(MSG_SUBSCRIBE_SEND, params, postData, ApiResponse.class);
  }
}
