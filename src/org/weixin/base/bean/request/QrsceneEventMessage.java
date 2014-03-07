package org.weixin.base.bean.request;

/**
 * 扫描带参数二维码事件消息(用户未关注时，进行关注后的事件推送)
 * @author kid
 *
 */
public class QrsceneEventMessage extends EventMessage{

	private static final long serialVersionUID = 1L;
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
