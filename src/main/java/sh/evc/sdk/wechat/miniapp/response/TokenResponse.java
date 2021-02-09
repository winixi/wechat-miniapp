package sh.evc.sdk.wechat.miniapp.response;

/**
 * 令牌返回
 *
 * @author winixi
 * @date 2018/11/26 10:44 PM
 */
public class TokenResponse extends ApiResponse {

  /**
   * 访问令牌
   */
  private String accessToken;

  /**
   * 过期
   */
  private Integer expiresIn;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public Integer getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }

  @Override
  public String toString() {
    return "TokenResponse{" +
            "accessToken='" + accessToken + '\'' +
            ", expiresIn=" + expiresIn +
            "} " + super.toString();
  }
}
