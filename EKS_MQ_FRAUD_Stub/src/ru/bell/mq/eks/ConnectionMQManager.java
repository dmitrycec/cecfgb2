/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.bell.mq.eks;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.common.CommonConstants;
import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Queue;

/**
 *
 * @author Администратор
 */
public class ConnectionMQManager {
    
    private QueueConnection con;
    private String queueReq;
    private String queueResp;
    private QueueReceiver receiver;
//    private QueueSession sessionSender;
//    private QueueSender sender;
    
    ConnectionMQManager(MQ_Properties prop) throws JMSException{
    	 EKS_Listener.logger.info("3333");
        MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
        EKS_Listener.logger.info("3333_2");
       // factory.setIntProperty(CommonConstants.WMQ_CONNECTION_MODE, CommonConstants.WMQ_CM_CLIENT);
        EKS_Listener.logger.info("3333_3");
        factory.setCCSID(1251);
        EKS_Listener.logger.info("333_4");
        factory.setChannel(prop.getCHANNEL());
        EKS_Listener.logger.info("3333_5");
 //     factory.setAppName("MQ");
        factory.setHostName(prop.getHOST_NAME());
        EKS_Listener.logger.info("3333_6");
        factory.setPort(prop.getPORT());
        EKS_Listener.logger.info("3333_7");
        factory.setQueueManager(prop.getQUEUE_MANAGER());
        EKS_Listener.logger.info("3333_8");
        con = factory.createQueueConnection();
        EKS_Listener.logger.info("3333_9");
        queueReq = prop.getQUEUE_REQ();
        queueResp = prop.getQUEUE_RESP();
       
    }

	public QueueConnection getCon() {
		return con;
	}
	
	public void start() throws JMSException{
		con.start();
	}
	
	public void stop() throws JMSException{
		con.stop();
	}
	
	public void createReciever() throws JMSException{
		
		MessageListener listener = new MsgListener(con, queueResp);
		
		QueueSession session = con.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		
		Queue queue = session.createQueue(queueReq);
		
		receiver = session.createReceiver(queue);
		
		receiver.setMessageListener(listener);
		EKS_Listener.logger.info("1111");
		
	}
	
	public void closeReciever() throws JMSException{
		receiver.close();
	}
/*	
	private void createSender() throws JMSException{
		sessionSender = con.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        Queue queue_sender = sessionSender.createQueue(queueResp);
        sender = sessionSender.createSender(queue_sender);
	}
*/	

    
}
