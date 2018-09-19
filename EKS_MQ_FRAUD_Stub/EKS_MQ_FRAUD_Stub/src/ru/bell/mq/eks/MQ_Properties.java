package ru.bell.mq.eks;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class MQ_Properties {
	
	private String HOST_NAME = "localhost";
	private int PORT = 80;
	private String QUEUE_MANAGER = "by defolt";
	private String CHANNEL = "localhost";
	private String QUEUE_REQ = "localhost";
	private String QUEUE_RESP = "localhost";
	
	MQ_Properties() throws IOException{
		
        Properties props = new Properties();

			props.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("/mq_properties.ini")));

			HOST_NAME = props.getProperty("HOST_NAME");
			PORT = Integer.parseInt(props.getProperty("PORT"));
			QUEUE_MANAGER = props.getProperty("QUEUE_MANAGER");
			CHANNEL = props.getProperty("CHANNEL");
			QUEUE_REQ = props.getProperty("QUEUE_REQ");
			QUEUE_RESP = props.getProperty("QUEUE_RESP");
			
			EKS_Listener.logger.info("MQ_Properties:\r\n" + "HOST_NAME = " + HOST_NAME
					+ "\r\nPORT = " + PORT + "\r\nQUEUE_MANAGER = " + QUEUE_MANAGER
					+ "\r\nCHANNEL = " + CHANNEL + "\r\nQUEUE_REQ = " + QUEUE_REQ
					+ "\r\nQUEUE_RESP = " + QUEUE_RESP);

	}

	public String getHOST_NAME() {
		return HOST_NAME;
	}

	public int getPORT() {
		return PORT;
	}

	public String getQUEUE_MANAGER() {
		return QUEUE_MANAGER;
	}

	public String getCHANNEL() {
		return CHANNEL;
	}

	public String getQUEUE_REQ() {
		return QUEUE_REQ;
	}

	public String getQUEUE_RESP() {
		return QUEUE_RESP;
	}
	
	public void setHOST_NAME(String hOST_NAME) {
		HOST_NAME = hOST_NAME;
	}

	public void setPORT(int pORT) {
		PORT = pORT;
	}

	public void setQUEUE_MANAGER(String qUEUE_MANAGER) {
		QUEUE_MANAGER = qUEUE_MANAGER;
	}

	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}

	public void setQUEUE_REQ(String qUEUE_REQ) {
		QUEUE_REQ = qUEUE_REQ;
	}

	public void setQUEUE_RESP(String qUEUE_RESP) {
		QUEUE_RESP = qUEUE_RESP;
	}


}
