package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.response.ImgSecCheckResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 检查一张图片是否含有违法违规内容
 *
 * @author winixi
 * @date 2021/2/9 2:56 PM
 */
public class ImgSecCheckRequest extends ApiRequest<ImgSecCheckResponse> {

  /**
   * 接口调用凭证
   */
  private String accessToken;

  /**
   * 内容
   */
  private File file;

  public ImgSecCheckRequest(String accessToken, File file) {
    this.accessToken = accessToken;
    this.file = file;
  }

  @Override
  public ParamsMap getEntityParams() {
    return null;
  }

  @Override
  public Map<String, String> getBasicParams() {
    Map<String, String> params = new HashMap<>();
    params.put("access_token", accessToken);
    return params;
  }

  @Override
  public String getUri() {
    return "/wxa/img_sec_check";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.POST;
  }

  @Override
  public Class<ImgSecCheckResponse> getResponseClass() {
    return ImgSecCheckResponse.class;
  }
}
