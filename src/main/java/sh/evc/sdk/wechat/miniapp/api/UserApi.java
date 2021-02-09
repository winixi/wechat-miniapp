package sh.evc.sdk.wechat.miniapp.api;

import sh.evc.sdk.wechat.miniapp.Const;
import sh.evc.sdk.wechat.miniapp.response.UserResponse;
import sh.evc.sdk.wechat.miniapp.util.Params;
import sh.evc.sdk.wechat.miniapp.util.client.HttpUtil;

import java.util.Map;

/**
 * 微信关注用户相关API接口.
 *
 * @author vioao
 */
public class UserApi {

  private static final String USER_INFO = Const.Uri.API_URI + "/cgi-bin/user/info";

  /**
   * 获取用户基本信息.
   *
   * @param accessToken 公众号的全局唯一接口调用凭据
   * @param lang        返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
   * @param openId      普通用户的标识，对当前公众号唯一
   */
  public static UserResponse getUserInfo(String accessToken, String lang, String openId) {
    Map<String, String> params = Params.create("access_token", accessToken).put("openid", openId)
            .put("lang", lang).get();
    return HttpUtil.getJsonBean(USER_INFO, params, UserResponse.class);
  }

  /**
   * 获取简体用户基本信息
   */
  public static UserResponse getUserInfo(String accessToken, String openId) {
    return getUserInfo(accessToken, Const.Lang.ZH_CN, openId);
  }

}
