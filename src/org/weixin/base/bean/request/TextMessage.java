package org.weixin.base.bean.request;

/**
 * 文本消息
 * 
 * @author kid
 * 
 */
public class TextMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(final String content) {
		Content = content;
	}
}
