
/**
 * AcceptServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
    package ru.sbrf.ws.fraudmon.accept;

import java.io.File;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;

/**
     *  AcceptServiceSkeleton java skeleton for the axisService
     */
    public class AcceptServiceSkeleton implements AcceptServiceSkeletonInterface{
    	final static Logger logger = Logger.getLogger(AcceptServiceSkeleton.class);
    	
         
        /**
         * Auto generated method signature
         * 
                                     * @param request0 
             * @return response1 
         */
        
    	
    	SimpleDateFormat myformat = new SimpleDateFormat("mm:ss");
    	
    	
                 public org.apache.axiom.om.OMElement accept
                  (
                  org.apache.axiom.om.OMElement request0
                  )
            {
                	 String s = request0.toString();
                	 String fName = s.substring(s.indexOf("<File>")+6, s.indexOf("</File>"));
                	 String aCode = s.substring(s.indexOf("<ActionCode>")+12, s.indexOf("</ActionCode>"));
                	 String eDesk = s.substring(s.indexOf("<ErrorDescription>")+18, s.indexOf("</ErrorDescription>"));
                	 
                	 File file1 = new File("\\\\tv-fraud-8r2-36\\SRH_exchange\\"+fName.substring(0, fName.indexOf("."))+".request");
                		long difference = new Date().getTime() - new Date(file1.lastModified()).getTime(); 
                		Date fDate = new Date(difference);
                		
                	      
                	   
                	    
                	 logger.info(fName + "	" + "00:" + myformat.format(fDate) + "	"+fName.substring(36, fName.length() - 9) + "	" + aCode + "	" + eDesk);
                	 
                	 //logger.info(s);
                	 //logger.log(Level.INFO, "00:");
                	 //logger.info("1234");
                		//StartListener.logger.info("123");
                	 if (aCode.equals("ALLOW")){
                		 //logger.log(Level.INFO, "del");
                		 try {
							file1.delete();
							 File file2 = new File("\\\\tv-fraud-8r2-36\\SRH_exchange\\"+fName.substring(0, fName.indexOf("."))+".response");
							 file2.delete();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                	 }
                	 				return request0;
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#accept");
        }
     
    }
    