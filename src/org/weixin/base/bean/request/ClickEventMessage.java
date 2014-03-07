package org.weixin.base.bean.request;

/**
 * 自定义菜单事件消息
 * @author kid
 *
 */
public class ClickEventMessage extends EventMessage {

	private static final long serialVersionUID = 1L;
    private String EventKey; //事件KEY值，与自定义菜单接口中KEY值对应
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
    
}
