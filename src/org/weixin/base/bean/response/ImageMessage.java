package org.weixin.base.bean.response;

/**
 * 图片消息响应
 * 
 * @author kid
 * 
 */
public class ImageMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	private Image Image; // 图片

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

}
