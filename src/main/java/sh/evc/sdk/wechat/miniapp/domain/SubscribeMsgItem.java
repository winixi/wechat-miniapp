package sh.evc.sdk.wechat.miniapp.domain;

/**
 * 订阅消息
 *
 * @author winixi
 */
public class SubscribeMsgItem {

  /**
   * 消息内容文本（20字以内）
   */
  private String value;

  /**
   * 构造模板消息-data组件.
   */
  public SubscribeMsgItem(String value) {
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
    return "SubscribeMsgItem{" +
            "value='" + value + '\'' +
            '}';
  }
}
