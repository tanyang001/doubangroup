package org.weixin.base.tools;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.weixin.base.bean.BeanDescription;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

/**
 * XML Bean操作类
 * 
 * @author kid
 * 
 */
public class XmlBeanUtil {
	private static XmlBeanUtil util = null;

	/**
	 * 私有构造
	 */
	private XmlBeanUtil() {
	}

	/**
	 * 单例实例化接口
	 * 
	 * @return
	 */
	public static XmlBeanUtil getInstance() {
		if (util == null) {
			util = new XmlBeanUtil();
		}
		return util;
	}

	/**
	 * bean转换xml
	 * 
	 * @param bean
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public synchronized String beanToXml(final Object bean) throws InstantiationException,
			IllegalAccessException {
        setAlias(bean);
		stream.alias("xml", bean.getClass());
		return stream.toXML(bean);
	}
    /**
     * 
     * @param bean
     */
    private void setAlias(final Object bean){
        Class<?> clazz=bean.getClass();
        Field[] field=clazz.getDeclaredFields();
        for (Field f : field) {
			Class<?> fieldClazz=f.getType();
            if (fieldClazz.isPrimitive()) continue;//基本数据类型
            if (fieldClazz.getName().startsWith("java.lang"))continue;//java.lang下的类类型
            if(fieldClazz.isAssignableFrom(List.class)){ //list类型
            	Type fc=f.getGenericType(); //获取list的Generic类型
            	if (null==fc) continue;
            	 if(fc instanceof ParameterizedType){//检查是否是泛型
                     ParameterizedType pt = (ParameterizedType) fc;  
                     Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0];
                     stream.alias(genericClazz.getAnnotation(BeanDescription.class).rename(), genericClazz);//设置别名
            	 }
            }
				
		}
    	
    }

	/**
	 * xml转换成bean
	 * 
	 * @param in
	 * @param bean
	 * @return
	 * @throws IllegalAccessException
	 * @throws DocumentException
	 * @throws IntrospectionException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */

	public Object xmlToBean(final InputStream in, final Object o)
			throws InstantiationException, IllegalAccessException,
			DocumentException, IntrospectionException,
			IllegalArgumentException, InvocationTargetException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (int i = 0; i < elementList.size(); i++) {
			PropertyDescriptor pd = new PropertyDescriptor(elementList.get(i)
					.getName(), o.getClass());// 内省获取对应的属性
			Method method = pd.getWriteMethod();
			String pdClazzName = pd.getPropertyType().getSimpleName();
			if (pdClazzName.equals("int") || pdClazzName.equals("Integer")) {// 转换常用各种类型
				method
						.invoke(o, Integer.parseInt(elementList.get(i)
								.getText()));
			} else if (pdClazzName.equals("double")
					|| pdClazzName.equals("Double")) {
				method.invoke(o, Double.parseDouble((elementList.get(i)
						.getText())));
			} else if (pdClazzName.equals("float")
					|| pdClazzName.equals("Float")) {
				method.invoke(o, Float
						.parseFloat((elementList.get(i).getText())));
			} else if (pdClazzName.equals("String")) {
				method.invoke(o, elementList.get(i).getText());
			}
		}
		return o;
	}

	/**
	 * xml转换map
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public Map<String, String> xmlToMap(InputStream in) throws IOException,
			DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (Element e : elementList) {
			map.put(e.getName(), e.getText());
		}
		in.close();
		in = null;
		return map;
	}
	/**
	 * map转换成bean
	 * @param map
	 * @param o
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	public Object mapToBean(final Map<String, String> map, final Object o)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, IntrospectionException {
		Set<Map.Entry<String, String>> set = map.entrySet();
		for (Iterator<Map.Entry<String, String>> it = set.iterator(); it
				.hasNext();) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it
					.next();
			PropertyDescriptor pd = new PropertyDescriptor(entry.getKey(), o
					.getClass());// 内省获取对应的属性
			Method method = pd.getWriteMethod();
			String pdClazzName = pd.getPropertyType().getSimpleName();
			if (pdClazzName.equals("int") || pdClazzName.equals("Integer")) {// 转换常用各种类型
				method.invoke(o, Integer.parseInt(entry.getValue()));
			} else if (pdClazzName.equals("double")
					|| pdClazzName.equals("Double")) {
				method.invoke(o, Double.parseDouble(entry.getValue()));
			} else if (pdClazzName.equals("float")
					|| pdClazzName.equals("Float")) {
				method.invoke(o, Float.parseFloat(entry.getValue()));
			} else if (pdClazzName.equals("String")) {
				method.invoke(o, entry.getValue());
			}
		}
		return o;
	}

	/**
	 * 重写xstream 实现cdata解析
	 */
	private static XStream stream = new XStream(new DomDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@Override
				public void setValue(final String text) {

					if (text != null && !"".equals(text)) {
						// 浮点型判断
						Pattern patternInt = Pattern
								.compile("[0-9]*(\\.?)[0-9]*");
						// 整型判断
						Pattern patternFloat = Pattern.compile("[0-9]+");
						// 如果是整数或浮点数 就不要加[CDATA[]了
						if (patternInt.matcher(text).matches()
								|| patternFloat.matcher(text).matches()) {
							cdata = false;
						} else {
							cdata = true;
						}
					}
					super.setValue(text);
				}

				@Override
				protected void writeText(final QuickWriter writer,
						final String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
