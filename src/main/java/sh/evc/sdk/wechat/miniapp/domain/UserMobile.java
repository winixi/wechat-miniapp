package sh.evc.sdk.wechat.miniapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 用户手机
 *
 * @author winixi
 * @date 2019/2/5 7:45 PM
 */
public class UserMobile {

  //用户绑定的手机号（国外手机号会有区号）
  @JsonProperty("phoneNumber")
  private String phoneNumber;

  //没有区号的手机号
  @JsonProperty("purePhoneNumber")
  private String purePhoneNumber;

  //区号
  @JsonProperty("countryCode")
  private String countryCode;

  private Watermark watermark;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPurePhoneNumber() {
    return purePhoneNumber;
  }

  public void setPurePhoneNumber(String purePhoneNumber) {
    this.purePhoneNumber = purePhoneNumber;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Watermark getWatermark() {
    return watermark;
  }

  public void setWatermark(Watermark watermark) {
    this.watermark = watermark;
  }
}
