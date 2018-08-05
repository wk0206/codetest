package test;

import org.apache.log4j.*;

public class log4jTest {
	public static void main(String[] args) {
		//private singleton sone = null, stwo = null;
		String log4jConfPath = "。。/log4j.properties";
		//private static Logger logger = Logger.getRootLogger();
		//BasicConfigurator.configure();
		Logger logger = Logger.getLogger(SingletonTest.class);
		PropertyConfigurator.configure("config/log4j.properties");
		
		String sone = new String("SSS");
		String stwo = new String("BBB");
		
		logger.info("getting singleton...");
		//sone = singleton.getInstance();
		logger.info("...got singleton: " + sone);
		logger.info("getting singleton...");
		//stwo = singleton.getInstance();
		logger.info("...got singleton: " + stwo);
		
	}
	
}
