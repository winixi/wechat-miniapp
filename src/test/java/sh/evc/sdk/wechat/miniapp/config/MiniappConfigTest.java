package sh.evc.sdk.wechat.miniapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 测试配置
 *
 * @author winixi
 * @date 2021/1/21 4:43 PM
 */
public class MiniappConfigTest implements MiniappConfig {

  private final static Logger logger = LoggerFactory.getLogger(MiniappConfigTest.class);

  private String appId;
  private String appSecret;
  private String token;
  private String encodingAesKey;

  public MiniappConfigTest() {
    InputStream in = this.getClass().getResourceAsStream("/config.properties");
    try {
      InputStreamReader inputStreamReader = new InputStreamReader(in, StandardCharsets.UTF_8);
      Properties props = new Properties();
      props.load(inputStreamReader);
      appId = props.getProperty("appId");
      appSecret = props.getProperty("appSecret");
      token = props.getProperty("token");
      encodingAesKey = props.getProperty("encodingAesKey");

    } catch (IOException e) {
      logger.error("读取配置错误", e);
    }
  }

  @Override
  public String getAppId() {
    return appId;
  }

  @Override
  public String getAppSecret() {
    return appSecret;
  }

  @Override
  public String getToken() {
    return token;
  }

  @Override
  public String getEncodingAesKey() {
    return encodingAesKey;
  }
}
