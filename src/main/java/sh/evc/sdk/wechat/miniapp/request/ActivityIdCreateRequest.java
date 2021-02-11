package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.response.ActivityIdCreateResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态消息id创建
 *
 * @author winixi
 * @date 2021/2/9 3:07 PM
 */
public class ActivityIdCreateRequest extends ApiRequest<ActivityIdCreateResponse> {

  /**
   * 接口调用凭证
   */
  private String accessToken;

  /**
   * 为私密消息创建activity_id时，指定分享者为unionid用户。
   * 其余用户不能用此activity_id分享私密消息。
   * openid与unionid填一个即可。私密消息暂不支持云函数生成activity id。
   */
  private String unionId;
  private String openId;

  public ActivityIdCreateRequest(String accessToken, String unionId, String openId) {
    this.accessToken = accessToken;
    this.unionId = unionId;
    this.openId = openId;
  }

  @Override
  public ParamsMap getEntityParams() {
    return null;
  }

  @Override
  public Map<String, String> getBasicParams() {
    Map<String, String> params = new HashMap<>();
    params.put("access_token", accessToken);
    params.put("unionid", unionId);
    params.put("openid", openId);
    return params;
  }

  @Override
  public String getUri() {
    return "/cgi-bin/message/wxopen/activityid/create";
  }

  @Override
  public Class<ActivityIdCreateResponse> getResponseClass() {
    return ActivityIdCreateResponse.class;
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.GET;
  }
}
