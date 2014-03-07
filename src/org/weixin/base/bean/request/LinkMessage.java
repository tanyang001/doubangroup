package org.weixin.base.bean.request;

/**
 * 链接消息
 * 
 * @author kid
 * 
 */
public class LinkMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	// 消息标题
	private String Title;
	// 消息描述
	private String Description;
	// 消息链接
	private String Url;

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

	public String getUrl() {
		return Url;
	}

	public void setUrl(final String url) {
		Url = url;
	}
}
