package org.weixin.base.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.weixin.base.service.WxFilterService;
import org.weixin.base.tools.XmlBeanUtil;


public class WxBaseFilter implements Filter {
	private static WxFilterService service = null;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(final ServletRequest servletRequest,
			final ServletResponse servletResponse, final FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		if (request.getMethod().equals("POST")) {//只过滤post请求
			XmlBeanUtil beanUtil = XmlBeanUtil.getInstance();
			Map<String, String> map;
			try {
				map = beanUtil.xmlToMap(request.getInputStream());
				// 排重处理
				if (service.isRepeat(map,request)) { // 微信服务器排重处理
					PrintWriter writer = response.getWriter();
					writer.println("");// 发送空串,告诉微信服务器停止继续请求
					writer.flush();
					writer.close();
					writer = null;
				} else {
                    request.getSession().setAttribute("requestMap", map);
					chain.doFilter(request, response);
				}
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// TODO Auto-generated catch block
			}
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(final FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		service = WxFilterService.getInstance();
	}

}
