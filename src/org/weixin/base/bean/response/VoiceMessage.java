package org.weixin.base.bean.response;

/**
 * 语音响应
 * 
 * @author kid
 * 
 */
public class VoiceMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	private Voice Voice; //语音

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}

}
