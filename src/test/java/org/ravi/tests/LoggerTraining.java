package org.ravi.tests;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerTraining {

		final static Logger log = LogManager.getLogger(LoggerTraining.class.getName());
		
		public static void main(String args[]) {
			
			//BasicConfigurator.configure();
			DOMConfigurator.configure("log4j.xml");
			
//			ConsoleAppender appender = new ConsoleAppender();
//			
//			FileAppender fappender = new FileAppender();
//			
//			appender.activateOptions();
//			PatternLayout layout =new PatternLayout();
//			layout.setConversionPattern("%-5p %C  %M %l [%t]: %m%n");
//			layout.activateOptions();
//       		appender.setLayout(layout);
//			log.addAppender(appender);
			//All -->TRACE-->DEBUG-->INFO-->WARN-->ERROR-->FATAL-->
			
			log.trace("T");
			log.debug("D");
			log.info("info");
			log.warn("W");
			log.fatal("F");
		}
		
}
