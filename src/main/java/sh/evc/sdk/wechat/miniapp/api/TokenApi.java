package sh.evc.sdk.wechat.miniapp.api;

import sh.evc.sdk.wechat.miniapp.Const;
import sh.evc.sdk.wechat.miniapp.response.TokenResponse;
import sh.evc.sdk.wechat.miniapp.util.Params;
import sh.evc.sdk.wechat.miniapp.util.client.HttpUtil;

import java.util.Map;

/**
 * 微信Token相关API接口.
 *
 * @author vioao
 */
public class TokenApi {

  private static final String ACCESS_TOKEN_URL = Const.Uri.API_URI + "/cgi-bin/token";

  /**
   * 获取access_token.
   *
   * @param appId  第三方用户唯一凭证
   * @param secret 第三方用户唯一凭证密钥，即appsecret
   */
  public static TokenResponse token(String appId, String secret) {
    Map<String, String> params = Params.create("grant_type", "client_credential").put("appid", appId)
            .put("secret", secret).get();
    return HttpUtil.getJsonBean(ACCESS_TOKEN_URL, params, TokenResponse.class);
  }
}
