package sh.evc.sdk.wechat.miniapp.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 登录会话返回
 *
 * @author winixi
 * @date 2018/11/29 9:43 PM
 */
public class SnsSessionResponse extends ApiResponse {

  /**
   * 用户唯一标识
   */
  @JsonProperty("openid")
  private String openId;

  /**
   * 会话密钥
   */
  private String sessionKey;

  /**
   * 用户在开放平台的唯一标识符。本字段在满足一定条件的情况下才返回。具体参看UnionID机制说明
   */
  @JsonProperty("unionid")
  private String unionId = "";

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getSessionKey() {
    return sessionKey;
  }

  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }

  public String getUnionId() {
    return unionId;
  }

  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }

  @Override
  public String toString() {
    return "SnsSessionResponse{" +
            "openId='" + openId + '\'' +
            ", sessionKey='" + sessionKey + '\'' +
            ", unionId='" + unionId + '\'' +
            '}';
  }
}
