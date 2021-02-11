package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.GrantType;
import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.response.AccessTokenGetResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取小程序全局唯一后台接口调用凭据（access_token）
 *
 * @author winixi
 * @date 2021/2/10 6:55 PM
 */
public class AccessTokenGetRequest extends ApiRequest<AccessTokenGetResponse> {

  /**
   * 小程序appId
   */
  private String appId;

  /**
   * 小程序 appSecret
   */
  private String secret;

  /**
   * 授权类型，此处只需填写 authorization_code
   */
  private GrantType grantType = GrantType.CLIENT_CREDENTIAL;

  /**
   * 构造
   *
   * @param appId
   * @param secret
   */
  public AccessTokenGetRequest(String appId, String secret) {
    this.appId = appId;
    this.secret = secret;
  }

  @Override
  public ParamsMap getEntityParams() {
    return null;
  }

  @Override
  public Map<String, String> getBasicParams() {
    Map<String, String> params = new HashMap<>();
    params.put("appid", appId);
    params.put("secret", secret);
    params.put("grant_type", grantType.getValue());
    return params;
  }

  @Override
  public String getUri() {
    return "/cgi-bin/token";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.GET;
  }

  @Override
  public Class<AccessTokenGetResponse> getResponseClass() {
    return AccessTokenGetResponse.class;
  }
}
