package com.kba.util;

import org.apache.log4j.Logger;
/**
 * log工具
 * @author 钟强
 *
 */
public class Log {
    static Logger log = Logger.getLogger(Log.class.getName());
	
    public static void logDebug(String message) {
			log.debug(message);
	}
	public static void logInfo(String message) {
			log.info(message);
	}
}
