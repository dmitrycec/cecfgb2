package ua.tech;

import java.io.File;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class App1 {
    public App1() {
       SAXParserFactory f=SAXParserFactory.newInstance();
       SAXParser p;

        try {
            p = f.newSAXParser();
            p.parse(new File("C:\\work\\day2\\jdev\\XML\\DOM_XML\\p1.xml"),
                    new MyHandler());
            System.out.println("Valid");
        
        
        
        
        } catch (ParserConfigurationException e) {
            System.out.println(e);
                
        } catch (SAXException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        App1 app1 = new App1();
    }
}
