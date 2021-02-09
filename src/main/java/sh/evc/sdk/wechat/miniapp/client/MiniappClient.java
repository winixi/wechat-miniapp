package sh.evc.sdk.wechat.miniapp.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.miniapp.Const;
import sh.evc.sdk.wechat.miniapp.config.MiniappConfig;
import sh.evc.sdk.wechat.miniapp.dict.RequestMethod;
import sh.evc.sdk.wechat.miniapp.handler.ResponseHandler;
import sh.evc.sdk.wechat.miniapp.request.ApiRequest;
import sh.evc.sdk.wechat.miniapp.response.ApiResponse;
import sh.evc.sdk.wechat.miniapp.util.HttpRequest;
import sh.evc.sdk.wechat.miniapp.util.ParamsMap;
import sh.evc.sdk.wechat.miniapp.util.SerializeUtil;

import java.io.File;
import java.util.Date;

/**
 * 客户端
 *
 * @author winixi
 * @date 2021/2/9 2:00 PM
 */
public class MiniappClient {

  private final static Logger logger = LoggerFactory.getLogger(MiniappClient.class);
  private final MiniappConfig config;
  private final ResponseHandler handler;
  private final HttpRequest request = new HttpRequest();

  public MiniappClient(MiniappConfig config, ResponseHandler handler) {
    this.config = config;
    this.handler = handler;
  }

  /**
   * 执行请求
   *
   * @param request
   * @param <T>
   * @return
   */
  public <T extends ApiResponse> T execute(ApiRequest<T> request) {
    RequestMethod method = request.getMethod();
    String url = Const.SERVER_URL + request.getUri();
    ParamsMap basicParams = request.getBasicParams();
    String entityData = getEntityData(request.getEntityParams());
    Date requestTime = new Date();
    File file = request.getFile();
    String res = this.request.request(method, url, basicParams, entityData, file);
    T response = SerializeUtil.jsonToBean(res, request.getResponseClass());

    response.setReqUrl(url);
    response.setBasicParams(basicParams);
    response.setEntityData(entityData);
    response.setMethod(request.getMethod());
    response.setRequestTime(requestTime);
    response.setResponseTime(new Date());
    response.setResponseBody(res);

    handler.append(response);
    return response;
  }

  /**
   * 整理data
   *
   * @param params
   * @return
   */
  private String getEntityData(ParamsMap params) {
    if (params == null || params.isEmpty()) {
      return "";
    }
    return SerializeUtil.beanToJson(params);
  }
}
