package ru.bell.procdoc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class Processing {
	
	private static String response = null;
	
	public static String getResponse(String request) throws JDOMException, IOException{
		
		XMLOutputter xmOut=new XMLOutputter();
	
		SAXBuilder builder = new SAXBuilder();
		
		Document reqDoc = builder.build(new ByteArrayInputStream(request.getBytes("UTF-8")));
		
		switch(reqDoc.getRootElement().toString()){
		
		case "[Element: <Properties/>]": 
			
			response = xmOut.outputString(SrvGetLegalAccountBalance.getLegalBalInqRs(reqDoc));
						
			break;
			
		case "[Element: <LegalOrgInfoRq/>]":
			
			
			response = xmOut.outputString(SrvGetLegalInfo.getLegalOrgInfoRs(reqDoc));
			
			break;
			
		default: 
			
			response = "";
			
			break;
		}	
		
		return response;
	}

}
