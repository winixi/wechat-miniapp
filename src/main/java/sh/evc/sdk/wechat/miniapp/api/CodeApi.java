package sh.evc.sdk.wechat.miniapp.api;

import sh.evc.sdk.wechat.miniapp.Const;
import sh.evc.sdk.wechat.miniapp.domain.LineColor;
import sh.evc.sdk.wechat.miniapp.util.StringUtil;
import sh.evc.sdk.wechat.miniapp.util.client.HttpUtil;
import sh.evc.sdk.wechat.miniapp.util.SerializeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 小程序码获取接口
 *
 * @author winixi
 * @date 2019-03-14 18:50
 */
public class CodeApi {

  private static final String WXA_CODE = Const.Uri.API_URI + "/wxa/getwxacodeunlimit";

  /**
   * 获取小程序码
   *
   * @param accessToken
   * @param scene
   * @param page
   * @param width
   * @param autoColor
   * @param lineColor
   * @param isHyaline
   * @return
   * @throws Exception
   */
  public static byte[] codeBytes(String accessToken, String scene, String page, int width, boolean autoColor, LineColor lineColor, boolean isHyaline) throws Exception {
    if (StringUtil.isEmpty(scene)) {
      throw new Exception("scene参数不能为空");
    }

    String url = WXA_CODE + "?access_token=" + accessToken;

    Map<String, Object> postData = new HashMap<>();
    postData.put("scene", scene);
    postData.put("page", page);
    postData.put("width", width);
    postData.put("auto_color", autoColor);
    postData.put("line_color", lineColor);
    postData.put("is_hyaline", isHyaline);

    String postStr = SerializeUtil.beanToJson(postData);
    byte[] result = HttpUtil.post(url, postStr);
    return result;
  }
}
