package sh.evc.sdk.wechat.miniapp.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 登录凭证校验
 *
 * @author winixi
 * @date 2021/2/10 6:14 PM
 */
public class Code2SessionResponse extends JsonResponse {

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
   * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
   */
  @JsonProperty("unionid")
  private String unionId;

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
    return "LoginResponse{" +
            "openId='" + openId + '\'' +
            ", sessionKey='" + sessionKey + '\'' +
            ", unionId='" + unionId + '\'' +
            "} " + super.toString();
  }
}
