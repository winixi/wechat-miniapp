package sh.evc.sdk.wechat.miniapp.domain.marketing;

/**
 * @author winixi
 * @date 2019/9/8 4:21 PM
 */
public class Trace {

  /**
   * 广告的点击编号
   */
  private String clickId;

  public Trace(String clickId) {
    this.clickId = clickId;
  }

  public String getClickId() {
    return clickId;
  }

  public void setClickId(String clickId) {
    this.clickId = clickId;
  }

  @Override
  public String toString() {
    return "Trace{" +
            "clickId='" + clickId + '\'' +
            '}';
  }
}
