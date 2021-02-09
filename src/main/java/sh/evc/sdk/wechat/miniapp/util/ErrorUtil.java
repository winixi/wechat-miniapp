package sh.evc.sdk.wechat.miniapp.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 错误信息处理
 *
 * @author winixi
 * @date 2021/1/22 1:32 PM
 */
public class ErrorUtil {

  /**
   * 获取错误信息
   *
   * @param t
   * @return
   */
  public static String getStackTraceAsString(Throwable t) {
    // StringWriter将包含堆栈信息
    StringWriter stringWriter = new StringWriter();
    //必须将StringWriter封装成PrintWriter对象，
    //以满足printStackTrace的要求
    PrintWriter printWriter = new PrintWriter(stringWriter);
    //获取堆栈信息
    t.printStackTrace(printWriter);
    //转换成String，并返回该String
    StringBuffer error = stringWriter.getBuffer();
    return error.toString();
  }
}
