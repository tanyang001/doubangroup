package org.weixin.base.bean.request;

/**
 * 图片消息
 * 
 * @author kid
 * 
 */
public class ImageMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	// 图片链接
	private String PicUrl;
    private String MediaId;
    

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(final String picUrl) {
		PicUrl = picUrl;
	}
}
