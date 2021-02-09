package sh.evc.sdk.wechat.miniapp.domain;

/**
 * 图片模板消息
 *
 * @author winixi
 * @date 2019-06-07 14:05
 */
public class Image {

  //发送的图片的媒体ID，通过 新增素材接口 上传图片文件获得。
  private String mediaId;

  public Image() {
  }

  public Image(String mediaId) {
    this.mediaId = mediaId;
  }
}
