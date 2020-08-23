package com.techunity.qa.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLogs {

	public static Logger log = Logger.getLogger(TestLogs.class.getName());
	
	public static void main(String[] args) {
	
		PropertyConfigurator.configure("./src/main/java/com/techunity/qa/config/log4j.properties");

	}

}
