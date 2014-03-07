package org.weixin.base.bean.response;

import java.io.Serializable;

/**
 * 图片model
 * @author kid
 *
 */
public class Image implements Serializable{

	private static final long serialVersionUID = 1L;
    private String MediaId; //通过上传多媒体文件，得到的id。
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
    
    
}
