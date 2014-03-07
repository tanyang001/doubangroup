package org.weixin.base.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * properties操作类
 * 
 * @author kid
 * 
 */
public class PropertiesUtil {
	/**
	 * 根据key获取properties value
	 * 
	 * @param filePath
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getValue(final String filePath, final String key)
			throws IOException {
		Properties pro = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		pro.load(in);
		in.close();
		in = null;
		return pro.getProperty(key, "");
	}

	/**
	 * 写入properties
	 * 
	 * @param filePath
	 * @param key
	 * @param value
	 */
	public static void writeValue(final String filePath, final String key,
			final String value) throws IOException {
		Properties pro = new Properties();
		InputStream in = new FileInputStream(new File(filePath));
		pro.load(in);
		OutputStream out = new FileOutputStream(new File(filePath));
		pro.setProperty(key, value);
		pro.store(out, "write value at" + key + ":" + value);
		pro = null;
		in.close();
		in = null;
		out.close();
		out = null;
	}
}
