package org.weixin.base.bean.request;

/**
 * 音频消息
 * 
 * @author kid
 * 
 */
public class VoiceMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	// 媒体ID
	private String MediaId;
	// 语音格式
	private String Format;
    //语音识别结果，UTF8编码
	private String Recognition;
	

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(final String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(final String format) {
		Format = format;
	}
}
