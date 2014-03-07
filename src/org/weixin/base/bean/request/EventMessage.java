package org.weixin.base.bean.request;

public class EventMessage extends BaseMessage{

	private static final long serialVersionUID = 1L;
	//事件类型
    private String event;
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}

}
