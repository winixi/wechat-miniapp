package sh.evc.sdk.wechat.miniapp.domain;

/**
 * @author winixi
 * @date 2019-05-24 14:28
 */
public class LineColor {

  private String r = "0";
  private String g = "0";
  private String b = "0";

  public LineColor() {
  }

  public LineColor(String r, String g, String b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public String getR() {
    return r;
  }

  public void setR(String r) {
    this.r = r;
  }

  public String getG() {
    return g;
  }

  public void setG(String g) {
    this.g = g;
  }

  public String getB() {
    return b;
  }

  public void setB(String b) {
    this.b = b;
  }

  @Override
  public String toString() {
    return "LineColor{" +
            "r='" + r + '\'' +
            ", g='" + g + '\'' +
            ", b='" + b + '\'' +
            '}';
  }
}
