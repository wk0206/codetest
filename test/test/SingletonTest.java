package test;


//import org.apache.logging.log4j;
//import org.apache.logging.log4j.*;
//import org.apache.logging.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;

import junit.framework.TestCase;

public class SingletonTest extends TestCase {
	
	private singleton sone = null, stwo = null;
	String log4jConfPath = "。。/log4j.properties";
	//private static Logger logger = Logger.getRootLogger();
	//BasicConfigurator.configure();
	
	//PropertyConfigurator.configure("config/log4j.properties");
	


	//PropertyConfigurator.configure(log4jConfPath);
	//logger.rootLogger=DEBUG;
	//# Set root logger level to DEBUG and its only appender to A1.
	//logger.rootLogger=DEBUG, A1

	///# A1 is set to be a ConsoleAppender.
	//log4j.appender.A1=org.apache.log4j.ConsoleAppender

	//# A1 uses PatternLayout.
	//log4j.appender.A1.layout=org.apache.log4j.PatternLayout
	//log4j.appender.A1.layout.ConversionPattern=%-4r [%t] %-5p %c %x - %m%n
	
	
	
	public SingletonTest(String name) {
		super(name);
	}

	public void setUp() {
//		Logger logger = Logger.getLogger(SingletonTest.class);
	//	PropertyConfigurator.configure("config/log4j.properties");
		Logger logger = Logger.getRootLogger();
		BasicConfigurator.configure();
		logger.info("getting singleton...");
		sone = singleton.getInstance();
		logger.info("...got singleton: " + sone);
		logger.info("getting singleton...");
		stwo = singleton.getInstance();
		logger.info("...got singleton: " + stwo);
	}

	public void testUnique() {
		Logger logger = Logger.getRootLogger();
		logger.info("checking singletons for equality");
		Assert.assertEquals(true, sone == stwo);
	}
	
//	public static void main(String[] args) {
//		
//		
//		
////		PropertyConfigurator.configure("config/log4j.properties");
////		
////		BasicConfigurator.configure();//默认配置   
////        PropertyConfigurator.configure("c:/log4j.properties");  
//        
//	}
}
