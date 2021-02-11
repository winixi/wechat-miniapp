package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.GrantType;
import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.response.Code2SessionResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录凭证校验
 *
 * @author winixi
 * @date 2021/2/10 6:33 PM
 */
public class Code2SessionRequest extends ApiRequest<Code2SessionResponse> {

  /**
   * 小程序appId
   */
  private String appId;

  /**
   * 小程序 appSecret
   */
  private String secret;

  /**
   * 登录时获取的 code
   */
  private String jsCode;

  /**
   * 授权类型，此处只需填写 authorization_code
   */
  private GrantType grantType = GrantType.AUTHORIZATION_CODE;

  /**
   * 构造
   *
   * @param appId
   * @param secret
   * @param jsCode
   */
  public Code2SessionRequest(String appId, String secret, String jsCode) {
    this.appId = appId;
    this.secret = secret;
    this.jsCode = jsCode;
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
    params.put("js_code", jsCode);
    params.put("grant_type", grantType.getValue());
    return params;
  }

  @Override
  public String getUri() {
    return "/sns/jscode2session";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.GET;
  }

  @Override
  public Class<Code2SessionResponse> getResponseClass() {
    return Code2SessionResponse.class;
  }
}
