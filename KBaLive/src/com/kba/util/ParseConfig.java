package com.kba.util;

import java.net.URL;
import java.util.List;
import java.util.Vector;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.kba.dao.util.DbConnector;
import com.kba.dao.util.DbConnector.ConnectionInfo;

/**
 * 系统配置文件 单例 类：属性
 * 
 * @author zk
 * 时间：2019-1-15
 */
public class ParseConfig {

	// XML文档
	private Document document;
	// 静态实例
	private static ParseConfig parseConfig;

	private ParseConfig() throws KBaException {
		// 文件
		String fileName = "/com/kba/resource/kba_config.xml";
		SAXReader saxReader = new SAXReader();
		try {
			// 反射
			URL url = ParseConfig.class.getResource(fileName);
			this.document = saxReader.read(url);
		} catch (DocumentException e) {
			throw new KBaException(e);
		}
	}

	/**
	 * 延迟加载：需要的时候才创建 线程不安全
	 * 
	 * @return
	 * @throws EasyException
	 */
	public synchronized static ParseConfig getInstance() throws KBaException {
		if (parseConfig == null) {
			try {
				parseConfig = new ParseConfig();
			} catch (KBaException e) {
				throw new KBaException(e);
			}
		}
		return parseConfig;
	}

	/**
	 * 解析数据库配置信息
	 */
	public ConnectionInfo parseDbInfo() {
		DbConnector.ConnectionInfo connInfo = null;
		// 根元素
		Element rootEle = this.document.getRootElement();
		// db-config元素
		Element dbConfigEle = rootEle.element("db-config");
		if (dbConfigEle == null)
			return null;
		// DB信息封装
		connInfo = new DbConnector.ConnectionInfo();
		// 驱动类
		connInfo.driverClass = dbConfigEle.elementText("driver-name");
		// URL
		connInfo.url = dbConfigEle.elementText("url");
		connInfo.uname = dbConfigEle.elementText("user-name");
		connInfo.upwd = dbConfigEle.elementText("user-password");
		return connInfo;
	}

	/**
	 * sql语句文件所在路径
	 */
	@SuppressWarnings("unchecked")
	public List<String> parseSqlPath() {
		List<String> paths = new Vector<String>();
		// 根元素
		Element rootEle = this.document.getRootElement();
		// maps
		Element mapsEle = rootEle.element("maps");
		List<Element> pathEles = mapsEle.elements("path");
		for (Element path : pathEles) {
			paths.add(path.getText());
		}
		return paths;
	}

	/**
	 * 解析数据源
	 * @throws EasyException
	 */
	public String getDsType() throws KBaException {
		Element rootEle = this.document.getRootElement();
		Element dsEle = rootEle.element("datasource");
		if (dsEle == null)
			throw new KBaException("没有此元素");
		Element typeEle = dsEle.element("type");
		if (typeEle == null) {
			throw new KBaException("没有此元素");
		}
		return typeEle.getText();
	}
}
