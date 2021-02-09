package sh.evc.sdk.wechat.miniapp.response;

/**
 * 动态消息
 *
 * @author winixi
 * @date 2019/10/9 5:30 PM
 */
public class ActivityIdCreateResponse extends ApiResponse {

  /**
   * 活动编号
   */
  private String activityId;

  /**
   * activity_id 的过期时间戳。默认24小时后过期。
   */
  private Integer expirationTime;

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public Integer getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(Integer expirationTime) {
    this.expirationTime = expirationTime;
  }

  @Override
  public String toString() {
    return "ActivityResponse{" +
            "activityId='" + activityId + '\'' +
            ", expirationTime=" + expirationTime +
            '}';
  }
}
