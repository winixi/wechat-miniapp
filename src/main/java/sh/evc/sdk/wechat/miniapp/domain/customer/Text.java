package sh.evc.sdk.wechat.miniapp.domain.customer;

/**
 * 客服消息文本
 *
 * @author winixi
 * @date 2019-06-07 16:36
 */
public class Text {

  /**
   * 消息内容
   */
  private String content;

  public Text(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Text{" +
            "content='" + content + '\'' +
            '}';
  }
}
