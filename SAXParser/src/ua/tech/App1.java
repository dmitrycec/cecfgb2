package ua.tech;

import java.io.File;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class App1 {
  static final String JAXP_SCHEMA_LANGUAGE =
  "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
  static final String W3C_XML_SCHEMA =
  "http://www.w3.org/2001/XMLSchema";
  static final String JAXP_SCHEMA_SOURCE =
  "http://java.sun.com/xml/jaxp/properties/schemaSource";
    public App1() {
  SAXParserFactory f=SAXParserFactory.newInstance();
  f.setValidating(true);
  f.setNamespaceAware(true);
  SAXParser p;

        try {
            p = f.newSAXParser();
            // переменные можно найти в J2EETutorial
            p.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            p.setProperty(JAXP_SCHEMA_SOURCE, new File("C:\\work\\day2\\jdev\\XMLSchema\\PersonSchema\\person.xsd"));
            p.parse(new File("C:\\work\\day2\\jdev\\XMLSchema\\PersonSchema\\p1.xml"), new MyHandler());
            System.out.println("Valid");
        } catch (ParserConfigurationException e) {
            System.out.println(e);
        } catch (SAXException e) {
            System.out.println(e);
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        App1 app1 = new App1();
    }
}
