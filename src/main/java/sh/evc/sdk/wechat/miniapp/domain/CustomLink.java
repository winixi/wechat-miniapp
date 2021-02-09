package sh.evc.sdk.wechat.miniapp.domain;

/**
 * 连接消息
 *
 * @author winixi
 * @date 2019-06-07 14:09
 */
public class CustomLink {

  /**
   * 消息标题
   */
  private String title;

  /**
   * 图文链接消息
   */
  private String description;

  /**
   * 点击跳转链接
   */
  private String url;

  /**
   * 图文链接消息的图片链接，支持 JPG、PNG 格式，较好的效果为大图 640 X 320，小图 80 X 80
   */
  private String thumbUrl;

  public CustomLink(String title, String description, String url, String thumbUrl) {
    this.title = title;
    this.description = description;
    this.url = url;
    this.thumbUrl = thumbUrl;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getThumbUrl() {
    return thumbUrl;
  }

  public void setThumbUrl(String thumbUrl) {
    this.thumbUrl = thumbUrl;
  }

  @Override
  public String toString() {
    return "Link{" +
            "title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", url='" + url + '\'' +
            ", thumbUrl='" + thumbUrl + '\'' +
            '}';
  }
}
