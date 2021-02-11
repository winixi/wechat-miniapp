package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.ActivityTargetState;
import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.domain.activity.TemplateInfo;
import sh.evc.sdk.wechat.miniapp.response.ActivityUpdateResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 修改被分享的动态消息
 *
 * @author winixi
 * @date 2021/2/9 3:43 PM
 */
public class ActivityUpdateRequest extends ApiRequest<ActivityUpdateResponse> {

  /**
   * 接口调用凭证
   */
  private String accessToken;

  /**
   * 动态消息的 ID
   */
  private String activityId;

  /**
   * 消息状态
   */
  private ActivityTargetState targetState;

  /**
   * 动态消息对应的模板信息
   */
  private TemplateInfo templateInfo;

  /**
   * 构造
   *
   * @param accessToken
   * @param activityId
   * @param targetState
   * @param templateInfo
   */
  public ActivityUpdateRequest(String accessToken, String activityId, ActivityTargetState targetState, TemplateInfo templateInfo) {
    this.accessToken = accessToken;
    this.activityId = activityId;
    this.targetState = targetState;
    this.templateInfo = templateInfo;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("activity_id", activityId);
    params.add("target_state", targetState.getValue());
    params.add("template_info", templateInfo);
    return params;
  }

  @Override
  public Map<String, String> getBasicParams() {
    Map<String, String> params = new HashMap<>();
    params.put("access_token", accessToken);
    return params;
  }

  @Override
  public String getUri() {
    return "/cgi-bin/message/wxopen/updatablemsg/send";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.POST;
  }

  @Override
  public Class<ActivityUpdateResponse> getResponseClass() {
    return ActivityUpdateResponse.class;
  }
}
