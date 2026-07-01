package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
//	private static Logger logger;
	
	private LoggerUtility() {
		
	}

	
	public static Logger getLoger(Class<?> clazz) {
		Logger logger=null; // make thread safe
		if(logger ==null) {
		logger = LogManager.getLogger(clazz);
		}
		return logger;
		
	}
}
