package org.weixin.base.bean.response;

import java.io.Serializable;
/**
 * 语音model
 * @author kid
 *
 */
public class Voice implements Serializable {

	private static final long serialVersionUID = 1L;
	private String MediaId; //语音id
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
