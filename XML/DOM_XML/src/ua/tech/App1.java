package ua.tech;

import java.io.File;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

public class App1 {
    /**
     * @throws ParserConfigurationException
     */
    public App1() {
        //javax.xml.parsers.
        DocumentBuilderFactory factory=null;
        factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder doc;
            doc = factory.newDocumentBuilder();
           Document d= doc.parse(new File("C:\\work\\day2\\jdev\\XML\\DOM_XML\\p1.xml"));
        System.out.println("Valid");
        System.out.println(d.getDocumentElement());
        
        
        } catch (Exception pce) {
            // TODO: Add catch code
          System.out.println(pce);
        }
    }

    public static void main(String[] args) {
        App1 app1 = new App1();
    }
}
