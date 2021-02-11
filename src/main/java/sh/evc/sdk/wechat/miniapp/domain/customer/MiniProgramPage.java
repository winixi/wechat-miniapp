package sh.evc.sdk.wechat.miniapp.domain.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服消息小程序卡片结构
 *
 * @author winixi
 * @date 2021/2/9 5:06 PM
 */
public class MiniProgramPage {

  /**
   * 消息标题
   */
  private String title;

  /**
   * 小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
   */
  @JsonProperty("pagepath")
  private String pagePath;

  /**
   * 小程序消息卡片的封面， image 类型的 media_id，通过 新增素材接口 上传图片文件获得，建议大小为 520*416
   */
  private String thumbMediaId;

  public MiniProgramPage(String title, String pagePath, String thumbMediaId) {
    this.title = title;
    this.pagePath = pagePath;
    this.thumbMediaId = thumbMediaId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPagePath() {
    return pagePath;
  }

  public void setPagePath(String pagePath) {
    this.pagePath = pagePath;
  }

  public String getThumbMediaId() {
    return thumbMediaId;
  }

  public void setThumbMediaId(String thumbMediaId) {
    this.thumbMediaId = thumbMediaId;
  }

  @Override
  public String toString() {
    return "CustomMiniappPage{" +
            "title='" + title + '\'' +
            ", pagePath='" + pagePath + '\'' +
            ", thumbMediaId='" + thumbMediaId + '\'' +
            '}';
  }
}
