package sh.evc.sdk.wechat.miniapp.dict;

/**
 * 授权类型
 *
 * @author winixi
 * @date 2021/2/10 6:12 PM
 */
public enum GrantType {

  /**
   * 授权码
   */
  AUTHORIZATION_CODE("authorization_code"),

  /**
   * 客户端
   */
  CLIENT_CREDENTIAL("client_credential");

  private String value;

  GrantType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
