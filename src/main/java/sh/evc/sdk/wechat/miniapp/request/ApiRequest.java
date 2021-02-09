package sh.evc.sdk.wechat.miniapp.request;


import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.response.ApiResponse;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;

import java.io.File;

/**
 * api request
 *
 * @author winixi
 * @date 2021/1/18 10:34 AM
 */
public abstract class ApiRequest<T extends ApiResponse> {

  /**
   * 获取请求参数
   *
   * @return
   */
  public abstract ParamsMap getEntityParams();

  /**
   * 获取基本请求参数
   *
   * @return
   */
  public abstract ParamsMap getBasicParams();

  /**
   * 获取接口地址
   *
   * @return
   */
  public abstract String getUri();

  /**
   * 获取文件
   *
   * @return
   */
  public File getFile() {
    return null;
  }

  /**
   * 获取请求方法
   *
   * @return
   */
  public abstract RequestMethod getMethod();

  /**
   * 获取返回对象类型
   *
   * @return
   */
  public abstract Class<T> getResponseClass();

}
