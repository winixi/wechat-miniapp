package sh.evc.sdk.wechat.miniapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author winixi
 * @date 2019-06-07 14:15
 */
public class MiniProgramPage {

  private String title;

  @JsonProperty("pagepath")
  private String pagePath;

  private String thumbMediaId;

  public MiniProgramPage() {
  }

  public MiniProgramPage(String title, String pagePath, String thumbMediaId) {
    this.title = title;
    this.pagePath = pagePath;
    this.thumbMediaId = thumbMediaId;
  }
}
