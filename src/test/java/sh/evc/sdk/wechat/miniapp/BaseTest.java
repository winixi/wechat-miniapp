package sh.evc.sdk.wechat.miniapp;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.miniapp.client.MiniappClient;
import sh.evc.sdk.wechat.miniapp.config.MiniappConfig;
import sh.evc.sdk.wechat.miniapp.config.TestConfig;
import sh.evc.sdk.wechat.miniapp.handler.ResponseHandler;
import sh.evc.sdk.wechat.miniapp.handler.TestResponseHandler;

/**
 * 基本测试
 *
 * @author winixi
 * @date 2021/1/8 1:52 PM
 */
public class BaseTest {

  public final static Logger log = LoggerFactory.getLogger(BaseTest.class);
  public MiniappClient client;
  public MiniappConfig config = new TestConfig();
  public ResponseHandler handler = new TestResponseHandler();

  @Before
  public void before() {
    client = new MiniappClient(config, handler);
  }

}
