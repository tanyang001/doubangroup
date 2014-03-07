package org.weixin.base.bean.response;
/**
 * 视频响应
 * @author kid
 *
 */
public class VideoMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	private Video Video; //视频

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

}
