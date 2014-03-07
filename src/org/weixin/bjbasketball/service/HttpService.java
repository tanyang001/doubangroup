package org.weixin.bjbasketball.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;


public class HttpService {

    private final static Logger log = Logger.getLogger(HttpService.class);
    
    /**
     * @description: 发起http请求获取返回结果
     * @author: tanyang
     * @DATE: 2014-3-6 上午09:59:43
     * @param requestUrl 访问的URL
     * @return 结果值
     */
    public static String httpRequest(String requestUrl) {
        log.warn("发起http请求");
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url
                    .openConnection();

            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
        } catch (Exception e) {
            log.error("执行HTTP请求发生错误",e);
        }
        log.warn("请求返回的结果为：\n" + buffer.toString());
        log.warn("http请求结束");
        return buffer.toString();
    }
}
