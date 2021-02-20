package sh.evc.sdk.wechat.miniapp.util;

import com.fasterxml.jackson.core.type.TypeReference;
import sh.evc.sdk.wechat.miniapp.util.serialize.JacksonSerialize;
import sh.evc.sdk.wechat.miniapp.util.serialize.SerializeDelegate;

/**
 * 序列号单元
 *
 * @author winixi
 */
public class SerializeUtil {

  /**
   * 使用jackson实现的序列化工具.如有自定义的实现修改此处即可
   */
  private final static SerializeDelegate delegate = new JacksonSerialize();

  /**
   * JSON字符串转Bean.
   */
  public static <T> T jsonToBean(String json, Class<T> clazz) {
    return delegate.jsonToBean(json, clazz);
  }

  /**
   * JSON字符串转Bean.
   */
  public static <T> T jsonToBean(String json, TypeReference valueTypeRef) {
    return delegate.jsonToBean(json, valueTypeRef);
  }

  /**
   * Bean转JSON字符串.
   */
  public static String beanToJson(Object object) {
    return delegate.beanToJson(object);
  }

  /**
   * 将xml转换为对象.
   */
  public static <T> T xmlToBean(String xml, Class<T> clazz) {
    return delegate.xmlToBean(xml, clazz);
  }

  /**
   * 将对象转换为xml.
   */
  public static String beanToXml(Object object) {
    return delegate.beanToXml(object);
  }

}
