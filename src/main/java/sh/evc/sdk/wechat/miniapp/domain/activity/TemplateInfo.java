package sh.evc.sdk.wechat.miniapp.domain.activity;

import java.util.Arrays;

/**
 * 动态消息模版信息
 *
 * @author winixi
 * @date 2021/2/9 4:03 PM
 */
public class TemplateInfo {

  /**
   * 模版参数
   */
  private TemplateParam[] parameterList;

  public TemplateInfo(TemplateParam[] parameterList) {
    this.parameterList = parameterList;
  }

  public TemplateParam[] getParameterList() {
    return parameterList;
  }

  public void setParameterList(TemplateParam[] parameterList) {
    this.parameterList = parameterList;
  }

  @Override
  public String toString() {
    return "ActivityTemplateInfo{" +
            "parameterList=" + Arrays.toString(parameterList) +
            '}';
  }
}
