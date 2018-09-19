package ru.bell.mq.eks;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.servlet.ServletContextEvent;


public class EKS_Listener implements javax.servlet.ServletContextListener {
	
	final static Logger logger = Logger.getLogger(EKS_Listener.class.getName());
	
	public static ConnectionMQManager connectMQ;

	public void contextDestroyed(ServletContextEvent arg0) {

		try {
			connectMQ.closeReciever();
			connectMQ.stop();
		} catch (JMSException e) {
			logger.log(Level.FINE, e.getMessage());
		}
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
			
		try {
			MQ_Properties prop = new MQ_Properties();
			EKS_Listener.logger.info("111");
			connectMQ = new ConnectionMQManager(prop);
			EKS_Listener.logger.info("2");
			
			connectMQ.createReciever();
			EKS_Listener.logger.info("3");
			connectMQ.start();
			EKS_Listener.logger.info("2");
			
			
			
		} catch (JMSException | IOException e) {
			logger.log(Level.FINE, e.getMessage());
		}
		
		
	}

}
