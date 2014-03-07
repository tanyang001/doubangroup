package org.weixin.base.bean.request;


public class VideoMessage extends BaseMessage {
	private static final long serialVersionUID = 1L;
	// 视频ID
	private String MediaId;
	// 视频消息缩略图的媒体id
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(final String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(final String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
