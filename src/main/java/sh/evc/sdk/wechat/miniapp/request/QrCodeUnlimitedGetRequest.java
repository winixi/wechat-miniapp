package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.dict.ResponseType;
import sh.evc.sdk.wechat.miniapp.domain.LineColor;
import sh.evc.sdk.wechat.miniapp.response.QrCodeUnlimitedGetResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 无限量二维码生成请求
 *
 * @author winixi
 * @date 2021/2/11 4:33 PM
 */
public class QrCodeUnlimitedGetRequest extends ApiRequest<QrCodeUnlimitedGetResponse> {

  /**
   * 接口访问凭证
   */
  private String accessToken;

  /**
   * 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
   */
  private String scene;

  /**
   * 必须是已经发布的小程序存在的页面（否则报错），例如 pages/index/index, 根路径前不要填加 /,不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
   */
  private String page;

  /**
   * 二维码的宽度，单位 px，最小 280px，最大 1280px
   */
  private Integer width = 430;

  /**
   * 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认 false
   */
  private Boolean autoColor;

  /**
   * auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
   */
  private LineColor lineColor;

  /**
   * 是否需要透明底色，为 true 时，生成透明底色的小程序
   */
  private Boolean isHyaline;

  /**
   * 构造
   *
   * @param accessToken
   * @param scene
   */
  public QrCodeUnlimitedGetRequest(String accessToken, String scene) {
    this.accessToken = accessToken;
    this.scene = scene;
  }

  /**
   * 构造
   *
   * @param accessToken
   * @param scene
   * @param page
   * @param width
   * @param autoColor
   * @param lineColor
   * @param isHyaline
   */
  public QrCodeUnlimitedGetRequest(String accessToken, String scene, String page, Integer width, Boolean autoColor, LineColor lineColor, Boolean isHyaline) {
    this.accessToken = accessToken;
    this.scene = scene;
    this.page = page;
    this.width = width;
    this.autoColor = autoColor;
    this.lineColor = lineColor;
    this.isHyaline = isHyaline;
  }

  public void setPage(String page) {
    this.page = page;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public void setAutoColor(Boolean autoColor) {
    this.autoColor = autoColor;
  }

  public void setLineColor(LineColor lineColor) {
    this.lineColor = lineColor;
  }

  public void setHyaline(Boolean hyaline) {
    isHyaline = hyaline;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("scene", scene);
    params.add("page", page);
    params.add("width", width);
    params.add("auto_color", autoColor);
    params.add("line_color", lineColor);
    params.add("is_hyaline", isHyaline);
    return params;
  }

  @Override
  public Map<String, String> getBasicParams() {
    Map<String, String> params = new HashMap<>();
    params.put("access_token", accessToken);
    return params;
  }

  @Override
  public String getUri() {
    return "/wxa/getwxacodeunlimit";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.POST;
  }

  @Override
  public Class<QrCodeUnlimitedGetResponse> getResponseClass() {
    return QrCodeUnlimitedGetResponse.class;
  }

  @Override
  public ResponseType getResponseType() {
    return ResponseType.BUFFER;
  }
}
