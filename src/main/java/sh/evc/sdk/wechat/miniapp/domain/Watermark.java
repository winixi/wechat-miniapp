package sh.evc.sdk.wechat.miniapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 水印
 *
 * @author winixi
 * @date 2018/11/29 10:59 PM
 */
public class Watermark {

  /**
   * appId
   */
  @JsonProperty("appid")
  private String appId;

  /**
   * 时间戳
   */
  private long timestamp;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "Watermark{" +
            "appId='" + appId + '\'' +
            ", timestamp=" + timestamp +
            '}';
  }
}
