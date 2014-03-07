package org.weixin.base.bean.response;

import java.util.List;

/**
 * 图文消息响应
 * 
 * @author kid
 * 
 */
public class NewsMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	// 图文消息个数，限制为10条以内
	private int ArticleCount;
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(final int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(final List<Article> articles) {
		Articles = articles;
	}

}
