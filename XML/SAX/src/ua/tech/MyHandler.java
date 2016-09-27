package ua.tech;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
private boolean isChild; //переменная с маленькой буква boolean скалярная, размещается на стеке
//поэтому автоматически инициализируется(по умолчанию false)
private boolean isSex;
  private boolean ismSex;  
  private boolean isFn;
  private String name=null;
    @Override
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
       System.out.println(sAXParseException);
       System.exit(-1);
    }

    @Override
    public void error(SAXParseException sAXParseException) throws SAXException {
      System.out.println(sAXParseException);
      System.exit(-1);
    }

    @Override
    public void warning(SAXParseException sAXParseException) throws SAXException {
      System.out.println(sAXParseException);
      System.exit(-1);
    }


    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
      if (qName.equals("child")){
          isChild=false;
          name=null;
          } 
      if (isChild){
            if (qName.equals("sex")){
                isSex=false;
                } 
            if(qName.equals("fn")){
                isFn=false;
                
                }
            if(ismSex){
              System.out.println(name);
              
            }
           
          }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
     //System.out.println(qName); имена всех найденых тегов
        if (qName.equals("child")){
            isChild=true;
            } 
        if (isChild){
              if (qName.equals("sex")){
                  isSex=true;
                  }
              if(qName.equals("fn")){
                  isFn=true;
                  }
            }
    }

    @Override
    public void characters(char[] ch, int start,
        int length) throws SAXException {
        if(isSex){
            if(String.valueOf(ch,start,length).equals("m")){
                ismSex=true;
                        
            }
          
            }
      if(isFn) {
            name=String.valueOf(ch,start,length);
         
          }
    }
}
