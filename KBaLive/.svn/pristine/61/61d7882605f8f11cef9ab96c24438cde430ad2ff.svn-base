package com.kba.dao.util;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.kba.util.KBaException;
import com.kba.util.ParseConfig;

/**
 * 解析所有sql语句 
 * @author zk
 * 时间：2019-1-15
 */
public class ParseSqlStatement {

	// 缓存所有sql语句
	private Map<String, Map<String, String>> cacheSqls;

	private static ParseSqlStatement parseSqlStatement;

	private ParseSqlStatement() throws KBaException {
		// 实例缓存
		this.cacheSqls = new HashMap<String, Map<String, String>>();
		// 解析
		this.parseSqlStatement();
	}

	public synchronized static ParseSqlStatement getInstance() throws KBaException {
		if (parseSqlStatement == null) {
			parseSqlStatement = new ParseSqlStatement();
		}
		return parseSqlStatement;
	}

	/**
	 * 返回sql语句
	 * 
	 * @param ns
	 * @param id
	 * @return
	 */
	public String getSql(String ns, String id) {
		Map<String, String> map = this.cacheSqls.get(ns);
		return map.get(id);
	}

	/**
	 * xml--sql--cache
	 * 
	 * @throws EasyException
	 */
	private void parseSqlStatement() throws KBaException {
		// 文件路径
		List<String> filePaths = ParseConfig.getInstance().parseSqlPath();
		for (String filePath : filePaths) {
			// 文档
			Document document = this.getDocument(filePath);
			this.parseSqlStatement(document);
		}
	}

	/**
	 * 解析sql语句
	 * 
	 * @param document
	 * @throws EasyException
	 */
	@SuppressWarnings("unchecked")
	private void parseSqlStatement(Document document) throws KBaException {
		Element rootEle = document.getRootElement();
		// 根元素
		String nameSpace = rootEle.attributeValue("namespace");
		if (nameSpace == null)
			throw new KBaException("解析的文档的根元素没有namespace属性！");
		// sql语句
		Map<String, String> sqlMaps = new HashMap<String, String>();
		String key = null;
		String value = null;
		List<Element> sqlEles = rootEle.elements("sql");
		for (Element sqlEle : sqlEles) {
			key = sqlEle.attributeValue("id");
			if (key == null)
				throw new KBaException("没有指定sql id");
			value = sqlEle.getText();
			if (value == null)
				throw new KBaException("没有SQL语句");
			sqlMaps.put(key, value);
		}
		this.cacheSqls.put(nameSpace, sqlMaps);
	}

	/**
	 *
	 * @param xmlPath
	 * @return
	 * @throws EasyException
	 */
	private Document getDocument(String filePath) throws KBaException {
		Document document = null;
		SAXReader saxReader = new SAXReader();
		try {
			// 反射
			URL url = ParseSqlStatement.class.getResource(filePath);
			//System.out.println(url);
			document = saxReader.read(url);
		} catch (DocumentException e) {
			throw new KBaException(e);
		}
		return document;
	}
}
