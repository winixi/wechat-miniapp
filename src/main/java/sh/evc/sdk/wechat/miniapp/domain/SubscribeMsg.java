package sh.evc.sdk.wechat.miniapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

/**
 * 订阅消息
 *
 * @author winixi
 * @date 2019-05-16 16:53
 */
public class SubscribeMsg {

  private String touser;          //接收者（用户）的 openid

  @JsonProperty("template_id")
  private String templateId;     //所需下发的订阅模板id

  private String page;            //点击模板卡片后的跳转页面

  private LinkedHashMap<String, SubscribeMsgItem> data; //模板数据

  public SubscribeMsg() {
  }

  public SubscribeMsg(String touser, String templateId, String page, LinkedHashMap<String, SubscribeMsgItem> data) {
    this.touser = touser;
    this.templateId = templateId;
    this.page = page;
    this.data = data;
  }
}
