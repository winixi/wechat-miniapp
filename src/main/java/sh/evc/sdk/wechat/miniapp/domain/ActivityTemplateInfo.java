package sh.evc.sdk.wechat.miniapp.domain;

import java.util.Arrays;

/**
 * 动态消息模版信息
 *
 * @author winixi
 * @date 2021/2/9 4:03 PM
 */
public class ActivityTemplateInfo {

  /**
   * 模版参数
   */
  private ActivityTemplateParam[] parameterList;

  public ActivityTemplateInfo(ActivityTemplateParam[] parameterList) {
    this.parameterList = parameterList;
  }

  public ActivityTemplateParam[] getParameterList() {
    return parameterList;
  }

  public void setParameterList(ActivityTemplateParam[] parameterList) {
    this.parameterList = parameterList;
  }

  @Override
  public String toString() {
    return "ActivityTemplateInfo{" +
            "parameterList=" + Arrays.toString(parameterList) +
            '}';
  }
}
