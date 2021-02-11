package sh.evc.sdk.wechat.miniapp.request;

import sh.evc.sdk.wechat.miniapp.dict.Lang;
import sh.evc.sdk.wechat.miniapp.dict.MiniProgramState;
import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.domain.SubscribeMsgItem;
import sh.evc.sdk.wechat.miniapp.response.SubscribeMessageSendResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 发送订阅消息
 *
 * @author winixi
 * @date 2021/2/10 7:02 PM
 */
public class SubscribeMessageSendRequest extends ApiRequest<SubscribeMessageSendResponse> {

  /**
   * 访问令牌
   */
  private String accessToken;

  /**
   * 接收者（用户）的 openid
   */
  private String toUser;

  /**
   * 所需下发的订阅模板id
   */
  private String templateId;

  /**
   * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
   */
  private String page;

  /**
   * 模板内容，格式形如 { "key1": { "value": any }, "key2": { "value": any } }
   */
  private LinkedHashMap<String, SubscribeMsgItem> data;

  /**
   * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
   */
  private MiniProgramState miniProgramState = MiniProgramState.RELEASE;

  /**
   * 进入小程序查看”的语言类型，支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN
   */
  private Lang lang = Lang.zh_CN;

  /**
   * 构造
   *
   * @param accessToken
   * @param toUser
   * @param templateId
   * @param page
   * @param data
   */
  public SubscribeMessageSendRequest(String accessToken, String toUser, String templateId, String page, LinkedHashMap<String, SubscribeMsgItem> data) {
    this.accessToken = accessToken;
    this.toUser = toUser;
    this.templateId = templateId;
    this.page = page;
    this.data = data;
  }

  public void setMiniProgramState(MiniProgramState miniProgramState) {
    this.miniProgramState = miniProgramState;
  }

  public void setLang(Lang lang) {
    this.lang = lang;
  }

  @Override
  public ParamsMap getEntityParams() {
    ParamsMap params = new ParamsMap();
    params.add("touser", toUser);
    params.add("template_id", templateId);
    params.add("page", page);
    params.add("data", data);
    params.add("lang", lang.name());
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
    return "/cgi-bin/message/subscribe/send";
  }

  @Override
  public RequestMethod getMethod() {
    return RequestMethod.POST;
  }

  @Override
  public Class<SubscribeMessageSendResponse> getResponseClass() {
    return SubscribeMessageSendResponse.class;
  }
}
