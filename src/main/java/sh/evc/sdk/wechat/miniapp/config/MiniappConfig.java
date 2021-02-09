package sh.evc.sdk.wechat.miniapp.config;

/**
 * 小程序配置
 *
 * @author winixi
 * @date 2019-02-16 22:49
 */
public interface MiniappConfig {

  /**
   * 获取小程序应用编号
   *
   * @return
   */
  String getAppId();

  /**
   * 获取小程序密钥
   *
   * @return
   */
  String getAppSecret();

  /**
   * 获取接口访问令牌
   *
   * @return
   */
  String getToken();

  /**
   * 获取AES编码密钥
   *
   * @return
   */
  String getEncodingAesKey();

}
