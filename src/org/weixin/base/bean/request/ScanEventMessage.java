package org.weixin.base.bean.request;

/**
 *扫描带参数二维码事件
 * 
 * @author kid
 * 
 */
public class ScanEventMessage extends EventMessage {

	private static final long serialVersionUID = 1L;
    private long EventKey; //事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
    private String ticket; //二维码的ticket，可用来换取二维码图片
    
	public long getEventKey() {
		return EventKey;
	}
	public void setEventKey(long eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
    

}
