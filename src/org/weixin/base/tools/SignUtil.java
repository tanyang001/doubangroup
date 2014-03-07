package org.weixin.base.tools;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 
 * 请求校验类
 * 
 * @author kid
 * 
 */
public class SignUtil {

    private final static String TOKEN = "WechatCourse";
    
	/**
	 * 验证签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean checkSignature(final String signature,
			final String timestamp, final String nonce, final String echostr)
			throws IOException, NoSuchAlgorithmException {
	    String path = SignUtil.class.getClassLoader().getResource("/").getPath()+ "init.properties";
	    path = path.substring(1,path.length());
//		String token = PropertiesUtil.getValue(path, "token");
		String[] arr = new String[] { TOKEN, timestamp, nonce };
		Arrays.sort(arr);// 对三个参数进行字典排序
		StringBuilder content = new StringBuilder(3);
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;
		md = MessageDigest.getInstance("SHA-1");// 三个参数进行SHA-1加密
		byte[] digest = md.digest(content.toString().getBytes());
		tmpStr = byteToStr(digest);// 转换成字符串
		content = null;
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;// 如果比对SHA-1加密后的与signature对比,标识该请求来源与微信
	}

	/**
	 * 字节转换成字符串
	 * 
	 * @param digest
	 * @return
	 */
	private static String byteToStr(final byte[] digest) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(40);
		for (int i = 0; i < digest.length; i++) {
			sb.append(byteToHexStr(digest[i])); // 十六进制字节转换字符串
		}
		return sb.toString();
	}

	/**
	 * 将字节转换成十六进制字符串
	 * 
	 * @param b
	 * @return
	 */
	private static Object byteToHexStr(final byte b) {
		// TODO Auto-generated method stub
		char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = digit[(b >>> 4) & 0x0f];
		tempArr[1] = digit[b & 0x0f];
		return new String(tempArr);
	}
}
