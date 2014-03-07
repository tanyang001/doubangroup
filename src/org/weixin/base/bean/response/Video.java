package org.weixin.base.bean.response;

import java.io.Serializable;
/**
 * 视频model
 * @author kid
 *
 */
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;
	private String MediaId; //视频id
	private String Title; //视频标题
	private String Description; //视频描述
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
