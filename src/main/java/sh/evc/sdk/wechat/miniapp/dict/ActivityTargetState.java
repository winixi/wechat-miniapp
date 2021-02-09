package sh.evc.sdk.wechat.miniapp.dict;

/**
 * 动态消息状态
 *
 * @author winixi
 * @date 2021/2/9 3:51 PM
 */
public enum ActivityTargetState {

  /**
   * 未开始
   */
  WAITING("0"),

  /**
   * 已开始
   */
  STARTED("1");

  private String value;

  ActivityTargetState(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
