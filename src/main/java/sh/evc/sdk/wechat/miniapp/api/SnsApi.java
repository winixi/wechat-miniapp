package sh.evc.sdk.wechat.miniapp.api;

import sh.evc.sdk.wechat.miniapp.Const;
import sh.evc.sdk.wechat.miniapp.response.SnsSessionResponse;
import sh.evc.sdk.wechat.miniapp.util.Params;
import sh.evc.sdk.wechat.miniapp.util.client.HttpUtil;

import java.util.Map;

/**
 * 会话api
 *
 * @author winixi
 * @date 2018/11/29 9:42 PM
 */
public class SnsApi {

  private static final String SNS_OAUTH2_TOKEN = Const.Uri.API_URI + "/sns/jscode2session";

  /**
   * 通过code换取网页授权access_token.
   *
   * @param appId  公众号的唯一标识
   * @param secret 公众号的appsecret
   * @param jscode 填写第一步获取的code参数
   */
  public static SnsSessionResponse jscode2Session(String appId, String secret, String jscode) {
    Map<String, String> params = Params.create("appid", appId).put("secret", secret).put("js_code", jscode)
            .put("grant_type", "authorization_code").get();
    return HttpUtil.getJsonBean(SNS_OAUTH2_TOKEN, params, SnsSessionResponse.class);
  }
}
