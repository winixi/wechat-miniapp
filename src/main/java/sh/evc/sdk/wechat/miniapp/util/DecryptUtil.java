package sh.evc.sdk.wechat.miniapp.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.miniapp.domain.UserInfo;
import sh.evc.sdk.wechat.miniapp.domain.UserMobile;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

/**
 * 解密数据
 *
 * @author winixi
 * @date 2018/11/29 10:28 PM
 */
public class DecryptUtil {

  private static final Logger log = LoggerFactory.getLogger(DecryptUtil.class);
  private static final String KEY_ALGORITHM = "AES";
  private static final String ALGORITHM_STR = "AES/CBC/PKCS7Padding";

  public static void main(String[] args) {
    UserInfo userInfo = getUserInfo(
            "+6fr9M+bNeRk8LQOOuxqBLuzsydnIh7D2UvImuWicfzJsbrRFptPr7yXHubgTdRd6JHwvjDXD+Q9L0oeTjXlBZilfipjRZJSV7nOpaq++DB5wQr6hKAPsvLmUjOpTPocpVrRDbkXRQKAgl6uTXkR8SdUL3j0zihANr3ANaz2kgg8X+iCJKSxmCuxwPswFCrYaXih2Z7+s/EqWU0ACFgaoZMNkliYBy9mF/pwzCfzsDVx+eJu1eG2UmU6e0e8rUOcEGv4KxfYntvLBN7LJEfOEfYcyemNYtVt3ALDE2sOxI4pb8XxUUO3zn+Yt7e5xWqmfqFj1YK3CCl0ILHle5JlZxGz178PsztDoCnOMoA4NwEoGfqCsUH1pM7AsyfcOh27yqqk=",
            "2gCRTCyEpjQTW5Fc89yg==",
            "XBzf8VMLBIsFBZvjOWNg=="
    );
    System.out.println("userInfo = " + userInfo);
  }

  /**
   * 获取用户手机信息
   *
   * @param encryptDataB64
   * @param sessionKeyB64
   * @param ivB64
   * @return
   */
  public static UserMobile getUserMobile(String encryptDataB64, String sessionKeyB64, String ivB64) {
    try {
      String userMobile = new String(
              decryptOfDiyIV(
                      Base64.decode(encryptDataB64),
                      Base64.decode(sessionKeyB64),
                      Base64.decode(ivB64)
              )
      );
      log.debug("解密用户手机" + userMobile);
      return SerializeUtil.jsonToBean(userMobile, UserMobile.class);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("解密失败" + e.getLocalizedMessage());
      return null;
    }
  }

  /**
   * 获取用户信息
   *
   * @param encryptDataB64
   * @param sessionKeyB64
   * @param ivB64
   * @return
   */
  public static UserInfo getUserInfo(String encryptDataB64, String sessionKeyB64, String ivB64) {
    try {
      String userInfo = new String(
              decryptOfDiyIV(
                      Base64.decode(encryptDataB64),
                      Base64.decode(sessionKeyB64),
                      Base64.decode(ivB64)
              )
      );
      log.debug("解密用户信息" + userInfo);
      return SerializeUtil.jsonToBean(userInfo, UserInfo.class);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("解密失败" + e.getLocalizedMessage());
      return null;
    }
  }

  /**
   * 解密方法
   *
   * @param encryptedData 要解密的字符串
   * @param keyBytes      解密密钥
   * @param ivs           自定义对称解密算法初始向量 iv
   * @return 解密后的字节数组
   */
  private static byte[] decryptOfDiyIV(byte[] encryptedData, byte[] keyBytes, byte[] ivs) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

    // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
    int base = 16;
    if (keyBytes.length % base != 0) {
      int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
      byte[] temp = new byte[groups * base];
      Arrays.fill(temp, (byte) 0);
      System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
      keyBytes = temp;
    }

    // 初始化
    Security.addProvider(new BouncyCastleProvider());

    // 转化成JAVA的密钥格式
    Key key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);

    // 初始化cipher
    Cipher cipher = Cipher.getInstance(ALGORITHM_STR, "BC");

    cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivs));
    return cipher.doFinal(encryptedData);
  }

}
