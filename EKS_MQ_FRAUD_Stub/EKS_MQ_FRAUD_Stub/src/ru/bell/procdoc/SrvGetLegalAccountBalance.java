package ru.bell.procdoc;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

public class SrvGetLegalAccountBalance {
	
	public static Document getLegalBalInqRs (Document reqDoc){
		
		Document respDoc = new Document(new Element("Properties"));
		Element rootRq = reqDoc.getRootElement();
		Element rootRs = respDoc.getRootElement();
		

    		
		return respDoc;
	}

}
