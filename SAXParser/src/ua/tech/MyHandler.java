package ua.tech;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
    public MyHandler() {
        super();
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
     System.out.println("Fatal "+e);
     System.exit(-1);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
      System.out.println("Error "+e);
      System.exit(-1);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
      System.out.println("Warning "+e);
      System.exit(-1);
    }
}
