package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.response.MsgSecCheckResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

/**
 * 检查一段文本是否含有违法违规内容
 *
 * @author winixi
 * @date 2021/2/9 2:56 PM
 */
public class MsgSecCheckRequest extends ApiRequest<MsgSecCheckResponse> {

  /**
   * 接口调用凭证
   */
  private String accessToken;

  /**
   * 内容
   */
  private String content;

  public MsgSecCheckRequest(String accessToken, String content) {
    this.accessToken = accessToken;
    this.content = content;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("content", content);
    return params;
  }

  @Override
  public ParamsMap getBasicParams() {
    ParamsMap params = new ParamsMap();
    params.add("access_token", accessToken);
    return params;
  }

  @Override
  public String getUri() {
    return "/wxa/msg_sec_check";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.POST;
  }

  @Override
  public Class<MsgSecCheckResponse> getResponseClass() {
    return MsgSecCheckResponse.class;
  }
}
