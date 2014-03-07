package org.weixin.base.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * 微信消息过滤服务类,由于经常使用,采用单例
 * 
 * @author kid
 * 
 */
public class WxFilterService {

	private static WxFilterService filterService = null;

	/**
	 * 私有构造
	 */
	private WxFilterService() {
	}

	/**
	 * 单例
	 * 
	 * @return
	 */
	public static WxFilterService getInstance() {
		if (filterService == null) {
			filterService = new WxFilterService();
		}
		return filterService;
	}

	/**
	 * 检查是否有微信服务器重复请求的存在
	 * 
	 * @param request
	 * 
	 * @param bean
	 * @return
	 */
	public boolean isRepeat(final Map<String, String> requestMap,
			final HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, String> tempMap = (Map<String, String>) request
				.getSession().getAttribute("requestMap");
		if (null == tempMap) {
			return false;
		}
		if (requestMap.get("MsgType").equals("event")) { // 如果消息类型为事件采用FromUserName
			// + CreateTime
			return tempMap.get("FromUserName").equals(
					requestMap.get("FromUserName"))
					&& tempMap.get("CreateTime").equals(
							requestMap.get("CreateTime"));
		} else { // 非事件类型采用MsgId
			return tempMap.get("MsgId").equals(requestMap.get("MsgId"));
		}
	}
}
