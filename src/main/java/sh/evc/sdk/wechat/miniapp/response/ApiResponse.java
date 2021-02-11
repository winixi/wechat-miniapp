package sh.evc.sdk.wechat.miniapp.response;

import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 微信请求返回基本状态数据.
 *
 * @author winixi
 */
public class ApiResponse {

  /**
   * 请求url
   */
  private String reqUrl;

  /**
   * 请求方法
   */
  private RequestMethod method;

  /**
   * 请求时间
   */
  private Date requestTime;

  /**
   * 返回时间
   */
  private Date responseTime;

  /**
   * 基本url参数
   */
  private Map<String, String> basicParams;

  /**
   * body参数
   */
  private String entityData;

  /**
   * 返回内容
   */
  private String responseBody;

  /**
   * 二维码图片二进制数据
   */
  private byte[] responseBuffer;

  public String getReqUrl() {
    return reqUrl;
  }

  public void setReqUrl(String reqUrl) {
    this.reqUrl = reqUrl;
  }

  public RequestMethod getMethod() {
    return method;
  }

  public void setMethod(RequestMethod method) {
    this.method = method;
  }

  public Date getRequestTime() {
    return requestTime;
  }

  public void setRequestTime(Date requestTime) {
    this.requestTime = requestTime;
  }

  public Date getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(Date responseTime) {
    this.responseTime = responseTime;
  }

  public Map<String, String> getBasicParams() {
    return basicParams;
  }

  public void setBasicParams(Map<String, String> basicParams) {
    this.basicParams = basicParams;
  }

  public String getEntityData() {
    return entityData;
  }

  public void setEntityData(String entityData) {
    this.entityData = entityData;
  }

  public String getResponseBody() {
    return responseBody;
  }

  public void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }

  public byte[] getResponseBuffer() {
    return responseBuffer;
  }

  public void setResponseBuffer(byte[] responseBuffer) {
    this.responseBuffer = responseBuffer;
  }

  @Override
  public String toString() {
    return "ApiResponse{" +
            "reqUrl='" + reqUrl + '\'' +
            ", method=" + method +
            ", requestTime=" + requestTime +
            ", responseTime=" + responseTime +
            ", basicParams=" + basicParams +
            ", entityData='" + entityData + '\'' +
            ", responseBody='" + responseBody + '\'' +
            ", responseBuffer=" + Arrays.toString(responseBuffer) +
            '}';
  }
}
