package sh.evc.sdk.wechat.miniapp.dict;

/**
 * 广告动作类型
 *
 * @author winixi
 * @date 2021/2/18 3:14 PM
 */
public enum ActionType {

  /**
   * 下单
   */
  COMPLETE_ORDER("下单"),

  /**
   * 付费
   */
  PURCHASE("付费"),

  /**
   * 预约
   */
  RESERVATION("预约"),

  /**
   * 注册
   */
  REGISTER("注册");

  private String value;

  ActionType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
