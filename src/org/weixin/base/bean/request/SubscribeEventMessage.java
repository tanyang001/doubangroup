package org.weixin.base.bean.request;

/**
 * 关注事件信息
 * 
 * @author kid
 * 
 */
public class SubscribeEventMessage extends EventMessage {

	private static final long serialVersionUID = 1L;
    //以下是在扫描二维码时存在
	private String EventKey; //事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String Ticket; //二维码的ticket，可用来换取二维码图片

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}
