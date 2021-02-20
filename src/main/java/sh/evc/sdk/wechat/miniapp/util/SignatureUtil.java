package sh.evc.sdk.wechat.miniapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 与微信服务交互相关的安全校验.
 *
 * @author winixi
 */
public class SignatureUtil {

  private final static Logger logger = LoggerFactory.getLogger(SignatureUtil.class);

  /**
   * 验证签名.
   *
   * @param originalSignature 正确的签名
   * @param params            待验证的参数
   * @return {boolean}
   */
  public static boolean check(String originalSignature, String... params) {
    if (StringUtil.areNotEmpty(params)) {
      String calculated = signature(params);
      return calculated.equals(originalSignature);
    }
    return false;
  }

  /**
   * 对参数排序后进行SHA1加密得到16进制字符串.
   *
   * @param params 加密的参数
   * @return SHA1加密后的16进制字符串
   */
  public static String signature(String... params) {
    Arrays.sort(params);

    StringBuilder src = new StringBuilder();
    for (String param : params) {
      src.append(param);
    }

    try {
      return DigestUtil.sha1Hex(src.toString());
    } catch (Exception e) {
      logger.error(ErrorUtil.getStackTraceAsString(e));
      return null;
    }
  }
}
