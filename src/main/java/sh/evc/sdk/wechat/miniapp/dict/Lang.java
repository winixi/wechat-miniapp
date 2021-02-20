package sh.evc.sdk.wechat.miniapp.dict;

/**
 * 语言
 *
 * @author winixi
 * @date 2021/2/11 4:15 PM
 */
public enum Lang {

  /**
   * 简体中文
   */
  zh_CN("简体中文"),

  /**
   * 英文
   */
  en_US("英文"),

  /**
   * 繁体中文
   */
  zh_HK("繁体中文"),

  /**
   * 繁体中文
   */
  zh_TW("繁体中文");

  private String value;

  Lang(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Lang{" +
            "value='" + value + '\'' +
            "} " + super.toString();
  }
}
