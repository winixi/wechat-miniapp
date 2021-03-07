package sh.evc.sdk.wechat.miniapp;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.miniapp.client.MiniappClient;
import sh.evc.sdk.wechat.miniapp.config.MiniappConfig;
import sh.evc.sdk.wechat.miniapp.config.MiniappConfigTest;
import sh.evc.sdk.wechat.miniapp.dict.ActionType;
import sh.evc.sdk.wechat.miniapp.dict.ActivityTargetState;
import sh.evc.sdk.wechat.miniapp.domain.LineColor;
import sh.evc.sdk.wechat.miniapp.domain.activity.TemplateInfo;
import sh.evc.sdk.wechat.miniapp.domain.activity.TemplateParam;
import sh.evc.sdk.wechat.miniapp.domain.marketing.ActionParam;
import sh.evc.sdk.wechat.miniapp.domain.marketing.Trace;
import sh.evc.sdk.wechat.miniapp.domain.marketing.UserAction;
import sh.evc.sdk.wechat.miniapp.handler.ResponseHandler;
import sh.evc.sdk.wechat.miniapp.handler.ResponseHandlerTest;
import sh.evc.sdk.wechat.miniapp.request.*;
import sh.evc.sdk.wechat.miniapp.response.*;
import sh.evc.sdk.wechat.miniapp.util.JsonFormat;

import java.io.File;

/**
 * 客户端测试
 *
 * @author winixi
 * @date 2021/2/9 2:54 PM
 */
public class MiniappClientTest {

  public final static Logger log = LoggerFactory.getLogger(MiniappClientTest.class);
  public MiniappClient client;
  public MiniappConfig config = new MiniappConfigTest();
  public ResponseHandler handler = new ResponseHandlerTest();

  /**
   * 2021-02-18
   */
  private String accessToken = "42_hPi-uMjgIF5rAiMIT-PITUP_KyFU1TuW6xNNRIEG2hcmi40p185pe8HHrIP9Nx5DzOJkJtI7K-KVatBIIzSyCizkzwDdlpuvMZyjv4DsSDaZ3mjaU5TwCJAgZwDyyOIByPpB_7rUxJBnbsuvIMKjAJALPN";

  @Before
  public void before() {
    client = new MiniappClient(config, handler);
  }

  /**
   * 访问令牌
   */
  @Test
  public void accessToken() {
    AccessTokenGetRequest request = new AccessTokenGetRequest(config.getAppId(), config.getAppSecret());
    AccessTokenGetResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  /**
   * 测试信息安全验证
   */
  @Test
  public void msgSecCheck() {
    String content = "特3456书yuuo莞6543李zxcz蒜7782法fgnv级";
    MsgSecCheckRequest request = new MsgSecCheckRequest(accessToken, content);
    MsgSecCheckResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  /**
   * 图片安全检查
   */
  @Test
  public void imgSecCheck() {
    File file = new File(getClass().getClassLoader().getResource("vio.jpg").getFile());
    ImgSecCheckRequest request = new ImgSecCheckRequest(accessToken, file);
    ImgSecCheckResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  /**
   * 创建动态消息id
   */
  @Test
  public void activityIdCreate() {
    String unionId = "";
    String openId = "";
    ActivityIdCreateRequest request = new ActivityIdCreateRequest(accessToken, unionId, openId);
    ActivityIdCreateResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  /**
   * 修改动态消息
   */
  @Test
  public void activityUpdate() {
    String activityId = "";
    ActivityTargetState targetState = ActivityTargetState.WAITING;
    TemplateParam memberCount = new TemplateParam("member_count", "1");
    TemplateParam roomLimit = new TemplateParam("room_limit", "10");
    TemplateParam[] params = new TemplateParam[]{
            memberCount, roomLimit
    };
    TemplateInfo templateInfo = new TemplateInfo(params);
    ActivityUpdateRequest request = new ActivityUpdateRequest(accessToken, activityId, targetState, templateInfo);
    ActivityUpdateResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  /**
   * 用户广告动作
   */
  @Test
  public void userActionAdd() {
    String userActionSetId = "123";
    String url = "http://baidu.com";
    int actionTime = (int) (System.currentTimeMillis() / 1000);
    String clickId = "123456";
    int paramValue = 1;
    UserAction userAction = new UserAction(userActionSetId, url, actionTime, ActionType.RESERVATION, new Trace(clickId), new ActionParam(paramValue));
    UserActionAddRequest request = new UserActionAddRequest(accessToken, new UserAction[]{userAction});
    UserActionAddResponse response = client.execute(request);
    JsonFormat.print(response);
  }

  @Test
  public void QrCodeUnlimitedGet() {
    String page = "player/fieldTimeJoin/info/info";
    int width = 430;
    boolean autoColor = false;
    LineColor lineColor = new LineColor("0", "0", "0");
    boolean isHyaline = false;
    String scene = "aaa";
    QrCodeUnlimitedGetRequest request = new QrCodeUnlimitedGetRequest(accessToken, scene, page, width, autoColor, lineColor, isHyaline);
    QrCodeUnlimitedGetResponse response = client.execute(request);
    JsonFormat.print(response);
  }
}
