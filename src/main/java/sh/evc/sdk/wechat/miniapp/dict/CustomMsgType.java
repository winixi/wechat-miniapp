package sh.evc.sdk.wechat.miniapp.dict;

/**
 * 客服消息类型
 *
 * @author winixi
 * @date 2021/2/9 4:48 PM
 */
public enum CustomMsgType {

  /**
   * 文本
   */
  TEXT("text"),

  /**
   * 图片
   */
  IMAGE("image"),

  /**
   * 链接
   */
  LINK("link"),

  /**
   * 小程序卡片
   */
  MINI_APP_PAGE("miniprogrampage"),

  /**
   * 事件
   */
  EVENT("event");

  private String value;

  CustomMsgType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
