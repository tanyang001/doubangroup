package org.weixin.base.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.weixin.base.bean.response.BaseMessage;
import org.weixin.base.service.IWxRequestService;
import org.weixin.base.service.WxBaseService;
import org.weixin.base.tools.PropertiesUtil;
import org.weixin.base.tools.SignUtil;


public class WxBaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IWxRequestService wxRequestService = null;

	public void destroy() {
	}

	/**
	 * 初次验证
	 */
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter out = response.getWriter();
		String signature = request.getParameter("signature"); // 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数
		String echostr = request.getParameter("echostr");// 随机字符串
		try {
			if (SignUtil.checkSignature(signature, timestamp, nonce, echostr)) {// 对参数进行验证
				out.println(echostr); // 喷出随机字符串,微信服务器需要
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
		out = null;
	}

	/**
	 * 所有的非验证请求
	 */
	public void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
        response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		WxBaseService baseService = new WxBaseService();
		BaseMessage responseObject = baseService.request(request,wxRequestService);// 接受请求,转发消息处理函数
		String xml = baseService.response(responseObject);// 返回处理结果
        System.out.println(xml);
		out.println(xml);
		out.flush();
		out.close();
		out = null;
		baseService = null;
	}

	/**
	 * 初始化资源
	 */
	public void init() throws ServletException {
		try {
//		    ServletContext context = this.getServletContext();
//		    String path = context.getRealPath("")+ File.separator + "WEB-INF" + File.separator + "classes" + File.separator + "init.properties";
//			wxRequestService = (IWxRequestService) Class.forName(
//					PropertiesUtil.getValue(path, "wxRequestService")) //获取自定义service类名
//					.newInstance();
		    
		  //获取自定义service类名
          wxRequestService = (IWxRequestService) Class.forName("org.weixin.bjbasketball.service.BasketballService").newInstance();
		    
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
