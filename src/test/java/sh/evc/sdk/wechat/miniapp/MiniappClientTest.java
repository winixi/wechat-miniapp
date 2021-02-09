package sh.evc.sdk.wechat.miniapp;

import org.junit.Test;
import sh.evc.sdk.wechat.miniapp.dict.ActivityTargetState;
import sh.evc.sdk.wechat.miniapp.domain.ActivityTemplateInfo;
import sh.evc.sdk.wechat.miniapp.domain.ActivityTemplateParam;
import sh.evc.sdk.wechat.miniapp.request.ActivityIdCreateRequest;
import sh.evc.sdk.wechat.miniapp.request.ActivityUpdateRequest;
import sh.evc.sdk.wechat.miniapp.request.ImgSecCheckRequest;
import sh.evc.sdk.wechat.miniapp.request.MsgSecCheckRequest;
import sh.evc.sdk.wechat.miniapp.response.ActivityIdCreateResponse;
import sh.evc.sdk.wechat.miniapp.response.ActivityUpdateResponse;
import sh.evc.sdk.wechat.miniapp.response.ImgSecCheckResponse;
import sh.evc.sdk.wechat.miniapp.response.MsgSecCheckResponse;
import sh.evc.sdk.wechat.miniapp.util.JsonFormat;

import java.io.File;

/**
 * 客户端测试
 *
 * @author winixi
 * @date 2021/2/9 2:54 PM
 */
public class MiniappClientTest extends BaseTest {

  private String accessToken = "";

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
    ActivityTemplateParam memberCount = new ActivityTemplateParam("member_count", "1");
    ActivityTemplateParam roomLimit = new ActivityTemplateParam("room_limit", "10");
    ActivityTemplateParam[] params = new ActivityTemplateParam[]{
            memberCount, roomLimit
    };
    ActivityTemplateInfo templateInfo = new ActivityTemplateInfo(params);
    ActivityUpdateRequest request = new ActivityUpdateRequest(accessToken, activityId, targetState, templateInfo);
    ActivityUpdateResponse response = client.execute(request);
    JsonFormat.print(response);
  }
}
