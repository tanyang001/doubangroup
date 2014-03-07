package org.weixin.base.bean.response;
/**
 * 文本消息响应
 * @author kid
 *
 */
public class TextMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(final String content) {
		Content = content;
	}
}
