package org.weixin.base.bean.request;
/**
 * 事件类型
 * @author kid
 *
 */
public enum WxEventType {
	subscribe, //关注
	unsubscribe, //取消关注
	scan, //二维码扫描
	LOCATION, //上报地理位置
	CLICK //菜单
}
