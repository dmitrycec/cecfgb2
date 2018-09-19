package ru.bell.mq.eks;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import org.jdom2.JDOMException;

import ru.bell.procdoc.Processing;

public class MsgListener implements MessageListener {
	
	private QueueSender sender;
	private QueueSession sessionSender;
	private QueueConnection con;
	private String queueResp;
	
	MsgListener(QueueConnection con, String queueResp){
		this.con = con;
		this.queueResp = queueResp;	
	}

	public void onMessage(Message requestMsg) {
		
		try {
			EKS_Listener.logger.info("11111111111111111");
			
			TextMessage txtMessageRq = (TextMessage) requestMsg;
			
			String response = null;
			
	        String correlationID = requestMsg.getJMSMessageID();	        
	        
	        response = new String(Processing.getResponse(txtMessageRq.getText()).getBytes("Cp1251"),"UTF-8");
	        		
			sessionSender = con.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			
			Queue queue_sender = sessionSender.createQueue(queueResp);
			
	        sender = sessionSender.createSender(queue_sender);
	        
	        TextMessage responseMsg = sessionSender.createTextMessage(response);
	        
	        responseMsg.setJMSCorrelationID(correlationID);

	        sender.send(responseMsg);
	        
	        sender.close();
	        
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
	}

}
