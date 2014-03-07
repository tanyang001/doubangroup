package org.weixin.base.service;

import java.beans.IntrospectionException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.weixin.base.bean.request.ClickEventMessage;
import org.weixin.base.bean.request.ImageMessage;
import org.weixin.base.bean.request.LinkMessage;
import org.weixin.base.bean.request.LocationEventMessage;
import org.weixin.base.bean.request.LocationMessage;
import org.weixin.base.bean.request.ScanEventMessage;
import org.weixin.base.bean.request.SubscribeEventMessage;
import org.weixin.base.bean.request.TextMessage;
import org.weixin.base.bean.request.UnsubscribeEventMessage;
import org.weixin.base.bean.request.VideoMessage;
import org.weixin.base.bean.request.VoiceMessage;
import org.weixin.base.bean.request.WxEventType;
import org.weixin.base.bean.request.WxMsgType;
import org.weixin.base.bean.response.BaseMessage;
import org.weixin.base.tools.XmlBeanUtil;


public class WxBaseService {
	private XmlBeanUtil beanUtil = null;

	/**
	 * 初始化资源
	 */
	public WxBaseService() {
		// TODO Auto-generated constructor stub
		beanUtil = XmlBeanUtil.getInstance();
	}

	/**
	 * 消息处理函数,分发操作
	 * 
	 * @param in
	 * @throws IOException
	 */
	public BaseMessage request(final HttpServletRequest request,final IWxRequestService service) throws IOException {
		// TODO Auto-generated method stub
		BaseMessage responseObject = null;
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> requestMap = (Map<String, String>) request
					.getSession().getAttribute("requestMap");
			switch (WxMsgType.valueOf(requestMap.get("MsgType").toUpperCase())) { // 分发消息处理
			case TEXT: // 文本消息
				TextMessage textMessage = (TextMessage) beanUtil.mapToBean(
						requestMap, new TextMessage());
				responseObject = service.text(textMessage);
				textMessage = null;
				break;
			case IMAGE: // 图片消息
				ImageMessage imageMessage = (ImageMessage) beanUtil.mapToBean(
						requestMap, new ImageMessage());
				responseObject = service.image(imageMessage);
				imageMessage = null;
				break;
			case LINK: // 链接消息
				LinkMessage linkMessage = (LinkMessage) beanUtil.mapToBean(
						requestMap, new LinkMessage());
				responseObject = service.link(linkMessage);
				linkMessage = null;
				break;
			case LOCATION: // 地理位置消息
				LocationMessage locationMessage = (LocationMessage) beanUtil
						.mapToBean(requestMap, new LocationMessage());
				responseObject = service.location(locationMessage);
				locationMessage = null;
				break;
			case VIDEO: // 视频
				VideoMessage videoMessage = (VideoMessage) beanUtil.mapToBean(
						requestMap, new VideoMessage());
				responseObject = service.video(videoMessage);
				videoMessage = null;
				break;
			case VOICE: // 音频
				VoiceMessage voiceMessage = (VoiceMessage) beanUtil.mapToBean(
						requestMap, new VoiceMessage());
				responseObject = service.voice(voiceMessage);
				voiceMessage = null;
				break;
			case EVENT: // 事件
				responseObject = doEvent(requestMap, service); // 事件处理函数
				break;
			}
			// TODO Auto-generated catch block
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseObject;
	}

	/**
	 * 响应消息,返回xml
	 * 
	 * @param responseObject
	 * @return
	 */
	public String response(final BaseMessage responseObject) {
		// TODO Auto-generated method stub
		try {
			return beanUtil.beanToXml(responseObject);// 转换xml
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 事件处理函数
	 * 
	 * @param requestMap
	 * @param service
	 * @return
	 * @throws IntrospectionException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private BaseMessage doEvent(final Map<String, String> requestMap,
			final IWxRequestService service) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			IntrospectionException {
		BaseMessage responseObject = null;
		switch (WxEventType.valueOf(requestMap.get("Event"))) {
		case CLICK: // 菜单点击
			ClickEventMessage clickEventMessage = (ClickEventMessage) beanUtil
					.mapToBean(requestMap, new ClickEventMessage());
			responseObject = service.clickEvent(clickEventMessage);
			break;
		case LOCATION: // 地理位置
			LocationEventMessage locationEventMessage = (LocationEventMessage) beanUtil
					.mapToBean(requestMap, new LocationEventMessage());
			responseObject = service.locationEvent(locationEventMessage);
			break;
		case scan: // 扫描二维码
			ScanEventMessage scanEventMessage = (ScanEventMessage) beanUtil
					.mapToBean(requestMap, new ScanEventMessage());
			responseObject = service.scanEvent(scanEventMessage);
			break;
		case subscribe: // 关注
			SubscribeEventMessage subscribeEventMessage = (SubscribeEventMessage) beanUtil
					.mapToBean(requestMap, new SubscribeEventMessage());
			responseObject = service.subsrcibeEvent(subscribeEventMessage);
			break;
		case unsubscribe: // 取消关注
			UnsubscribeEventMessage unsubscribeEventMessage = (UnsubscribeEventMessage) beanUtil
					.mapToBean(requestMap, new UnsubscribeEventMessage());
			responseObject = service.unsubscribeEvent(unsubscribeEventMessage);
			break;
		}
		return responseObject;
	}
}
