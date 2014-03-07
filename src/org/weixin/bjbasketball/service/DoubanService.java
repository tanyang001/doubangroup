package org.weixin.bjbasketball.service;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.weixin.bjbasketball.model.Comment;
import org.weixin.bjbasketball.model.Comments;
import org.weixin.bjbasketball.model.Topics;
import org.weixin.bjbasketball.model.Topicss;
import org.weixin.bjbasketball.util.BCConvert;
import org.weixin.bjbasketball.util.DateUtil;
import org.weixin.bjbasketball.util.GsonUtil;
import org.weixin.bjbasketball.util.SysConstant;


/**
 * @COMPANY: 北京亿脑信息技术有限公司
 * @CLASS: DoubanService
 * @DESCRIPTION: 解析豆瓣返回结果值
 * @AUTHOR: tanyang
 * @VERSION: v1.0
 * @DATE: 2014-3-5 上午10:49:33
 */
public class DoubanService {

	private static String topicss_url = "http://api.douban.com/v2/group/bjbasketball/topics?start=0";

	private static String group_url = "http://api.douban.com/v2/group/bjbasketball/";

	private static String comments_url = "http://api.douban.com/v2/group/topic/:id/comments";

	private final static Logger log = Logger.getLogger(DoubanService.class);

	private static ObjectMapper mapper = new ObjectMapper();

	public static void getApplyURLByJson() {
		String strJson_topicss = HttpService.httpRequest(topicss_url);
		net.sf.json.JSONObject topicss_json = JSONObject
				.fromObject(strJson_topicss);
		net.sf.json.JSONArray topicss_jsonArray = topicss_json
				.getJSONArray("topics");
		for (int i = 0; i < topicss_jsonArray.size(); i++) {
			JSONObject jsonObject = topicss_jsonArray.getJSONObject(i);
			String title = jsonObject.getString("title");
			Date created = DateUtil
					.string2Date(jsonObject.getString("created"));
			if (title.indexOf("室内活动报名帖") > 0) {
				if (DateUtil.isOneWeekend(new Date(), created)) {
					String alt = jsonObject.getString("alt");
					String id = jsonObject.getString("id");
					log.warn("本周报名帖地址为：" + alt);
					SysConstant.APPLY_URL = alt;
					comments_url = comments_url.replaceAll(":id", id);
				}
			}
		}

	}

	public static void getApplyMemberCountByJson() {
		String strJson_comments = HttpService.httpRequest(comments_url);
		net.sf.json.JSONObject comments_json = JSONObject
				.fromObject(strJson_comments);
		net.sf.json.JSONArray comments_jsonArray = comments_json
				.getJSONArray("comments");
		int member_count = comments_json.getInt("total");
		for (int i = 0; i < comments_jsonArray.size(); i++) {
			JSONObject jsonObject = comments_jsonArray.getJSONObject(i);
			String text = jsonObject.getString("text");
			text = BCConvert.qj2bj(text);
			if (text.indexOf("+") > 0) {
				int tmp_index = text.indexOf("+");
				String str_count = text.substring(tmp_index + 1, tmp_index + 2);
				int tmp_count = Integer.parseInt(str_count);
				member_count += tmp_count;
			}
		}

		log.warn("本周报名人数为：" + member_count);
		SysConstant.APPLY_MEMBER_COUNT = member_count;
	}

	public static void getApplyMemberCountByGson() {
		try {
			Comments comments = (Comments) GsonUtil.parseObject(comments_url,
					Comments.class);
			log.warn("gson convert Comments ");
			if (comments != null) {
				int member_count = comments.getTotal();
				List<Comment> comment = comments.getComments();
				if (comment != null && comment.size() > 0) {
					for (int i = 0; i < comment.size(); i++) {
						String text = comment.get(i).getText();
						text = BCConvert.qj2bj(text);
						if (text.indexOf("+") > 0) {
							int tmp_index = text.indexOf("+");
							String str_count = text.substring(tmp_index + 1,
									tmp_index + 2);
							int tmp_count = Integer.parseInt(str_count);
							member_count += tmp_count;
						}
					}
				}
				log.warn("本周报名人数为：" + member_count);
				SysConstant.APPLY_MEMBER_COUNT = member_count;
			}
		} catch (Exception e) {
			log.error("获取报名人数发生错误" + e);
		}
	}

	public static void getApplyURLByGson() {
		try {
			Topicss topicss = (Topicss) GsonUtil.parseObject(topicss_url,
					Topicss.class);
			log.warn("gson convert Topicss ");
			List<Topics> topics_list = topicss.getTopics();
			if (topics_list != null && topics_list.size() > 0) {
				for (int i = 0; i < topics_list.size(); i++) {
					Topics topics = topics_list.get(i);
					// 获取报名帖对象
					if (topics.getTitle().indexOf("室内活动报名帖") > 0) {
						// 盘点是否本周发布
						if (DateUtil.isOneWeekend(new Date(), topics
								.getCreated())) {
							log.warn("本周报名帖地址为：" + topics.getAlt());
							SysConstant.APPLY_URL = topics.getAlt();
							comments_url = comments_url.replaceAll(":id",
									topics.getId());
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("获取报名帖发生错误" + e);
			return;
		}
	}

	public static void main(String[] args) {
		comments_url = comments_url.replace(":id", "49822574");
		System.out.println(HttpService.httpRequest(comments_url));
	}
}
