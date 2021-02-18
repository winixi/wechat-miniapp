package sh.evc.sdk.wechat.miniapp.domain.marketing;

import java.util.Arrays;

/**
 * 广告动作大结构
 *
 * @author winixi
 * @date 2019/9/8 8:43 PM
 */
public class AdActions {

  /**
   * 动作数组
   */
  private UserAction[] actions;

  /**
   * 构造
   *
   * @param actions
   */
  public AdActions(UserAction[] actions) {
    this.actions = actions;
  }

  public UserAction[] getActions() {
    return actions;
  }

  public void setActions(UserAction[] actions) {
    this.actions = actions;
  }

  @Override
  public String toString() {
    return "AdActions{" +
            "actions=" + Arrays.toString(actions) +
            '}';
  }
}
