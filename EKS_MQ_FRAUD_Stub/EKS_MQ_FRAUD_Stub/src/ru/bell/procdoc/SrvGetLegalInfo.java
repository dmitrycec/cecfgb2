package ru.bell.procdoc;

import org.jdom2.Document;
import org.jdom2.Element;

public class SrvGetLegalInfo {
	
	public static Document getLegalOrgInfoRs (Document reqDoc){
		
		Document respDoc = new Document(new Element("LegalBalInqRs"));
		Element rootRq = reqDoc.getRootElement();
		Element rootRs = respDoc.getRootElement();
		
		rootRs.addContent(rootRq.getChild("RqUID").clone());
		rootRs.addContent(rootRq.getChild("RqTm").clone());
		rootRs.addContent(rootRq.getChild("SPName").clone());
		
    	Element SystemId = rootRq.getChild("SystemId");
    	if(SystemId!=null)
    		rootRs.addContent(SystemId.clone());
    	
    	
    	
		return respDoc;

	}

}
