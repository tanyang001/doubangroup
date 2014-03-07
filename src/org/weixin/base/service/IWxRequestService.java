package org.weixin.base.service;


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
import org.weixin.base.bean.response.BaseMessage;

public interface IWxRequestService {
	/**
	 * 文本消息处理函数
	 * 
	 * @param message
	 * @param textMessage
	 * @return
	 */
	BaseMessage text(final TextMessage message);

	/**
	 * 图片消息处理函数
	 * 
	 * @param imageMessage
	 * @return
	 */
	BaseMessage image(final ImageMessage imageMessage);

	/**
	 * 链接消息处理函数
	 * 
	 * @param linkMessage
	 * @return
	 */
	BaseMessage link(final LinkMessage linkMessage);

	/**
	 * 地理位置消息处理函数
	 * 
	 * @param locationMessage
	 * @return
	 */
	BaseMessage location(final LocationMessage locationMessage);

	/**
	 * 视频消息处理函数
	 * 
	 * @param videoMessage
	 * @return
	 */
	BaseMessage video(final VideoMessage videoMessage);

	/**
	 * 音频消息处理函数
	 * 
	 * @param voiceMessage
	 * @return
	 */
	BaseMessage voice(final VoiceMessage voiceMessage);

    /**
     * 菜单点击事件消息处理函数
     * @param clickEventMessage
     * @return
     */
	BaseMessage clickEvent(final ClickEventMessage clickEventMessage);
    /**
     * 地理位置上报事件消息处理函数
     * @param locationEventMessage
     * @return
     */
	BaseMessage locationEvent(final LocationEventMessage locationEventMessage);

    /**
     * 关注事件消息处理函数
     * @param subscribeEventMessage
     * @return
     */
	BaseMessage subsrcibeEvent(final SubscribeEventMessage subscribeEventMessage);
    /**
     * 取消关注事件消息处理函数
     * @param unsubscribeEventMessage
     * @return
     */
	BaseMessage unsubscribeEvent(final UnsubscribeEventMessage unsubscribeEventMessage);

    /**
     * 用户已关注时的扫描二维码事件消息处理函数
     * @param scanEventMessage
     * @return
     */
	BaseMessage scanEvent(final ScanEventMessage scanEventMessage);

}
