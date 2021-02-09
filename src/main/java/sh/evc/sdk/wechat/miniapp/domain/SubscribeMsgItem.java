package sh.evc.sdk.wechat.miniapp.domain;

/**
 * 订阅消息
 *
 * @author vioao
 */
public class SubscribeMsgItem {

  private String value; //消息内容文本（20字以内）

  /**
   * 构造模板消息-data组件.
   */
  public SubscribeMsgItem(String value) {
    this.value = value;
  }
}
