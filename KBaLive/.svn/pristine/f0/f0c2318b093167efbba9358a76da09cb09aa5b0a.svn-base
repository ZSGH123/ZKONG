package com.kba.util.weibo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 解析微博配置信息
 * @author 钟强
 *
 */
public class WeiboConfig {
	public WeiboConfig(){}
	private static Properties props = new Properties(); 
	static{
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/kba/resource/config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据key获取相应的值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return props.getProperty(key);
	}

    public static void updateProperties(String key,String value) {    
            props.setProperty(key, value); 
    } 
    
	public static void main(String[] args){
		System.out.print(getValue("client_ID"));
	}
}

