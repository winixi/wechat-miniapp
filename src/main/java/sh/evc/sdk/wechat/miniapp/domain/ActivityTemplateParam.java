package sh.evc.sdk.wechat.miniapp.domain;

/**
 * 活动消息模版参数
 *
 * @author winixi
 * @date 2021/2/9 4:11 PM
 */
public class ActivityTemplateParam {

  /**
   * 属性名
   */
  private String name;

  /**
   * 属性值
   */
  private String value;

  public ActivityTemplateParam(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "ActivityTemplateParam{" +
            "name='" + name + '\'' +
            ", value='" + value + '\'' +
            '}';
  }
}
