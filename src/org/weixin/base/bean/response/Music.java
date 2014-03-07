package org.weixin.base.bean.response;

import java.io.Serializable;

/**
 * 音乐model
 * 
 * @author kid
 * 
 */
public class Music implements Serializable{
	private static final long serialVersionUID = 1L;
	// 音乐名称
	private String Title;
	// 音乐描述
	private String Description;
	// 音乐链接
	private String MusicUrl;
	// 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	private String HQMusicUrl;

	public String getTitle() {
		return Title;
	}

	public void setTitle(final String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(final String description) {
		Description = description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(final String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(final String musicUrl) {
		HQMusicUrl = musicUrl;
	}
}
