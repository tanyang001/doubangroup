package org.weixin.base.bean.response;

/**
 * 音乐响应
 * 
 * @author kid
 * 
 */
public class MusicMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(final Music music) {
		Music = music;
	}
}
