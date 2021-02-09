package sh.evc.sdk.wechat.miniapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 用户信息
 *
 * @author vioao
 */
public class UserInfo {

  @JsonProperty("openId")
  private String openId; //用户的标识，对当前公众号唯一

  @JsonProperty("unionId")
  private String unionId = "";

  @JsonProperty("nickName")
  private String nickName; //用户的昵称

  private Integer gender; //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
  private String language; //用户的语言，简体中文为zh_CN
  private String city; //用户所在城市
  private String province; //用户所在省份
  private String country; //用户所在国家

  @JsonProperty("avatarUrl")
  private String avatarUrl;

  private Watermark watermark;

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getUnionId() {
    return unionId;
  }

  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public Watermark getWatermark() {
    return watermark;
  }

  public void setWatermark(Watermark watermark) {
    this.watermark = watermark;
  }
}
