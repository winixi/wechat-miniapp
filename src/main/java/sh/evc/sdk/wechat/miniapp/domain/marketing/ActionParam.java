package sh.evc.sdk.wechat.miniapp.domain.marketing;

/**
 * 动作参数
 *
 * @author winixi
 * @date 2019/9/8 4:22 PM
 */
public class ActionParam {

  /**
   * 值
   */
  private Integer value;

  /**
   * 构造
   *
   * @param value
   */
  public ActionParam(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "ActionParam{" +
            "value=" + value +
            '}';
  }
}
