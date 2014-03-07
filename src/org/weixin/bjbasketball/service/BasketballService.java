package org.weixin.bjbasketball.service;

import java.util.ArrayList;
import java.util.List;

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
import org.weixin.base.bean.response.Article;
import org.weixin.base.bean.response.BaseMessage;
import org.weixin.base.bean.response.WxMsgType;
import org.weixin.base.service.IWxRequestService;
import org.weixin.bjbasketball.util.BCConvert;
import org.weixin.bjbasketball.util.SysConstant;

public class BasketballService implements IWxRequestService {

	public BaseMessage response(org.weixin.base.bean.request.BaseMessage message) {
		BaseMessage baseMessage = null;
		if (message instanceof SubscribeEventMessage) {
			org.weixin.base.bean.response.TextMessage textMessage = new org.weixin.base.bean.response.TextMessage();
			textMessage.setFromUserName(message.getToUserName());
			textMessage.setToUserName(message.getFromUserName());
			textMessage.setCreateTime(System.currentTimeMillis());
			textMessage.setMsgType(WxMsgType.text);
			StringBuffer str = new StringBuffer("您好！\n 感谢关注北京豆瓣\ue42a小组！\n");
			str.append("官方地址：<a href=\"http://www.douban.com/group/bjbasketball/\">北京豆瓣篮球小组</a> \n \n");
			str.append("微信公众平台正在建设中...如果您有好的提议和方案，请联系管理员.");
			str.append("\n \n 回复 \"?\"即可显示主菜单 \n \n");
			textMessage.setContent(str.toString());
			baseMessage = textMessage;
		}

		if (message instanceof TextMessage) {
			TextMessage tmp_textMessage = (TextMessage) message;
			String content = tmp_textMessage.getContent();
			content = BCConvert.qj2bj(content);
			if (content.startsWith("?")) {
				org.weixin.base.bean.response.TextMessage textMessage = new org.weixin.base.bean.response.TextMessage();
				textMessage.setFromUserName(message.getToUserName());
				textMessage.setToUserName(message.getFromUserName());
				textMessage.setCreateTime(System.currentTimeMillis());
				textMessage.setMsgType(WxMsgType.text);
				StringBuffer str = new StringBuffer("请回复数字选择服务： \n \n");
				str.append("1 篮球小组简介 \n");
				str.append("2 查看本周报名  \n");
				str.append("3 周边查询  \n");
				str.append("4 天气预报  \n");
				textMessage.setContent(str.toString());
				baseMessage = textMessage;
			} else if (content.startsWith("1")) {
				org.weixin.base.bean.response.NewsMessage newsMessage = new org.weixin.base.bean.response.NewsMessage();
				newsMessage.setFromUserName(message.getToUserName());
				newsMessage.setToUserName(message.getFromUserName());
				newsMessage.setCreateTime(System.currentTimeMillis());
				newsMessage.setMsgType(WxMsgType.news);
				List<Article> articleList = new ArrayList<Article>();
				Article article = new Article(); 
				article.setTitle("北京豆瓣篮球小组");
				article.setDescription("一个篮球，一堆兄弟姐妹 ，一起站在篮球场上并肩流汗， 来吧！一起享受篮球带给我们的快乐与伤痛！！");
				article.setUrl("http://www.douban.com/group/bjbasketball/");
				article.setPicUrl("http://bjbasketballwechat.sinaapp.com/imgages/2014-03-06_144810.png");
				articleList.add(article);
				newsMessage.setArticleCount(articleList.size());
                newsMessage.setArticles(articleList);
                baseMessage = newsMessage;
			} else if (content.startsWith("2")) {
				org.weixin.base.bean.response.TextMessage textMessage = new org.weixin.base.bean.response.TextMessage();
				textMessage.setFromUserName(message.getToUserName());
				textMessage.setToUserName(message.getFromUserName());
				textMessage.setCreateTime(System.currentTimeMillis());
				textMessage.setMsgType(WxMsgType.text);
				StringBuffer str = new StringBuffer("本周报名帖地址：");
				str.append("<a href=\"" + SysConstant.APPLY_URL + "\">查看报名</a>"
						+ " \n \n");
				str.append("本周已报名人数： ");
				str.append(SysConstant.APPLY_MEMBER_COUNT + "\n \n");
				if (SysConstant.APPLY_MEMBER_COUNT < 16) {
					str.append("本周报名人数过少，请大家积极报名！！！\n \ue42a \ue42a \ue42a \n");
				}
				textMessage.setContent(str.toString());
				baseMessage = textMessage;

			} else if (content.startsWith("3")) {

			} else if (content.startsWith("4")) {

			}
		}
		return baseMessage;
	}

	public BaseMessage image(final ImageMessage imageMessage) {
		return response(imageMessage);
	}

	public BaseMessage link(final LinkMessage linkMessage) {
		return response(linkMessage);
	}

	public BaseMessage location(final LocationMessage locationMessage) {
		return response(locationMessage);
	}

	public BaseMessage text(final TextMessage textMessage) {
		return response(textMessage);
	}

	public BaseMessage video(final VideoMessage videoMessage) {
		return response(videoMessage);
	}

	public BaseMessage voice(final VoiceMessage voiceMessage) {
		return response(voiceMessage);
	}

	public BaseMessage clickEvent(ClickEventMessage clickEventMessage) {
		return null;
	}

	public BaseMessage locationEvent(LocationEventMessage locationEventMessage) {
		return null;
	}

	public BaseMessage subsrcibeEvent(
			SubscribeEventMessage subscribeEventMessage) {
		return response(subscribeEventMessage);
	}

	public BaseMessage unsubscribeEvent(
			UnsubscribeEventMessage unsubscribeEventMessage) {
		return null;
	}

	public BaseMessage scanEvent(ScanEventMessage scanEventMessage) {
		return null;
	}
}
