package sh.evc.sdk.wechat.miniapp.response;

/**
 * 获取小程序全局唯一后台接口调用凭据（access_token）
 *
 * @author winixi
 * @date 2021/2/10 6:53 PM
 */
public class AccessTokenGetResponse extends JsonResponse {

  /**
   * 获取到的凭证
   */
  private String accessToken;

  /**
   * 凭证有效时间，单位：秒。目前是7200秒之内的值。
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
    return "AccessTokenGetResponse{" +
            "accessToken='" + accessToken + '\'' +
            ", expiresIn=" + expiresIn +
            "} " + super.toString();
  }
}
