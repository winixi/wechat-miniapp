package sh.evc.sdk.wechat.miniapp.api;

import sh.evc.sdk.wechat.miniapp.Const;
import sh.evc.sdk.wechat.miniapp.domain.CustomLink;
import sh.evc.sdk.wechat.miniapp.domain.CustomText;
import sh.evc.sdk.wechat.miniapp.response.ApiResponse;
import sh.evc.sdk.wechat.miniapp.util.Params;
import sh.evc.sdk.wechat.miniapp.util.SerializeUtil;
import sh.evc.sdk.wechat.miniapp.util.client.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 客服消息接口
 *
 * @author winixi
 * @date 2019-06-07 14:17
 */
public class CustomApi {

  private static final String MSG_CUSTOM_SEND = Const.Uri.API_URI + "/cgi-bin/message/custom/send";

  /**
   * 发送文本消息
   *
   * @param accessToken
   * @param toUser
   * @param customText
   * @return
   */
  public static ApiResponse sendText(String accessToken, String toUser, CustomText customText) {
    Map<String, String> params = Params.create("access_token", accessToken).get();

    Map<String, Object> data = new HashMap<>();
    data.put("touser", toUser);
    data.put("msgtype", "text");
    data.put("text", customText);
    String postData = SerializeUtil.beanToJson(data);
    return HttpUtil.postJsonBean(MSG_CUSTOM_SEND, params, postData, ApiResponse.class);
  }

  /**
   * 发送链接消息
   *
   * @param accessToken
   * @param customLink
   * @return
   */
  public static ApiResponse sendLink(String accessToken, String toUser, CustomLink customLink) {
    Map<String, String> params = Params.create("access_token", accessToken).get();

    Map<String, Object> data = new HashMap<>();
    data.put("touser", toUser);
    data.put("msgtype", "link");
    data.put("link", customLink);
    String postData = SerializeUtil.beanToJson(data);
    return HttpUtil.postJsonBean(MSG_CUSTOM_SEND, params, postData, ApiResponse.class);
  }

}
