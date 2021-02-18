package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.domain.marketing.UserAction;
import sh.evc.sdk.wechat.miniapp.response.UserActionAddResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户动作请求
 *
 * @author winixi
 * @date 2021/2/18 2:56 PM
 */
public class UserActionAddRequest extends ApiRequest<UserActionAddResponse> {

  /**
   * 访问令牌
   */
  private String accessToken;

  /**
   * 版本
   */
  private String version = "v1.0";

  /**
   * 用户动作
   */
  private UserAction[] actions;

  /**
   * 构造
   *
   * @param accessToken
   * @param actions
   */
  public UserActionAddRequest(String accessToken, UserAction[] actions) {
    this.accessToken = accessToken;
    this.actions = actions;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("actions", actions);
    return params;
  }

  @Override
  public Map<String, String> getBasicParams() {
    Map<String, String> params = new HashMap<>();
    params.put("access_token", accessToken);
    params.put("version", version);
    return params;
  }

  @Override
  public String getUri() {
    return "/marketing/user_actions/add";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.POST;
  }

  @Override
  public Class<UserActionAddResponse> getResponseClass() {
    return UserActionAddResponse.class;
  }
}
