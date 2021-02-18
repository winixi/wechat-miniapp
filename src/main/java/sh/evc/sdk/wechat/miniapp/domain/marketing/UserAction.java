package sh.evc.sdk.wechat.miniapp.domain.marketing;

import sh.evc.sdk.wechat.miniapp.dict.ActionType;

/**
 * 用户动作
 *
 * @author winixi
 * @date 2019/9/8 4:11 PM
 */
public class UserAction {

  /**
   * action set id
   */
  private String userActionSetId;

  /**
   * url
   */
  private String url;

  /**
   * 时间
   */
  private Integer actionTime;

  /**
   * 动作类型
   */
  private ActionType actionType;

  /**
   * 跟踪
   */
  private Trace trace;

  /**
   * 动作参数
   */
  private ActionParam actionParam;

  /**
   * 构造
   *
   * @param userActionSetId
   * @param url
   * @param actionTime
   * @param actionType
   * @param trace
   * @param actionParam
   */
  public UserAction(String userActionSetId, String url, Integer actionTime, ActionType actionType, Trace trace, ActionParam actionParam) {
    this.userActionSetId = userActionSetId;
    this.url = url;
    this.actionTime = actionTime;
    this.actionType = actionType;
    this.trace = trace;
    this.actionParam = actionParam;
  }

  public String getUserActionSetId() {
    return userActionSetId;
  }

  public void setUserActionSetId(String userActionSetId) {
    this.userActionSetId = userActionSetId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getActionTime() {
    return actionTime;
  }

  public void setActionTime(Integer actionTime) {
    this.actionTime = actionTime;
  }

  public ActionType getActionType() {
    return actionType;
  }

  public void setActionType(ActionType actionType) {
    this.actionType = actionType;
  }

  public Trace getTrace() {
    return trace;
  }

  public void setTrace(Trace trace) {
    this.trace = trace;
  }

  public ActionParam getActionParam() {
    return actionParam;
  }

  public void setActionParam(ActionParam actionParam) {
    this.actionParam = actionParam;
  }

  @Override
  public String toString() {
    return "UserAction{" +
            "userActionSetId='" + userActionSetId + '\'' +
            ", url='" + url + '\'' +
            ", actionTime=" + actionTime +
            ", actionType='" + actionType + '\'' +
            ", trace=" + trace +
            ", actionParam=" + actionParam +
            '}';
  }
}
