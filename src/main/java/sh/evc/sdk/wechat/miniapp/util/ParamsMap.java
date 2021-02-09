package sh.evc.sdk.wechat.miniapp.util;

import java.util.HashMap;

/**
 * 参数map
 *
 * @author winixi
 * @date 2021/1/26 10:02 AM
 */
public class ParamsMap extends HashMap<String, Object> {

  /**
   * 添加参数
   *
   * @param key
   * @param val
   */
  public void add(String key, Object val) {
    if (val == null) {
      return;
    }
    if (val instanceof String && StringUtil.isEmpty((String) val)) {
      return;
    }
    super.put(key, val);
  }
}
