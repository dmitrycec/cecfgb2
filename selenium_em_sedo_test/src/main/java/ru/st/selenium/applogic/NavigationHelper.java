package ru.st.selenium.applogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



//import ru.st.selenium.pages.*;

public class NavigationHelper extends DriverBasedHelper{
	 public NavigationHelper(ApplicationManager manager) {
		    super(manager.getWebDriver());
		  }
	
		private WebElement linkOpen;
	 

		
	public void openLink(String link){
		String xpath = returnXpath(link);
		linkOpen = findWebElementByXpath(xpath);
		linkOpen.click();
	}	
	 


	  public WebElement findWebElementByXpath (String xpath ) { 
			return driver.findElement(By.xpath(xpath));
	  }	
	
	  
	  public String returnXpath(String text){
		  String xPath;
		  xPath ="";
		  if (text.equals("Расширенный поиск")) xPath= "//a[contains(text(),'Расширенный поиск')]";
		  if (text.equals("Внутренние документы/Новый документ")) xPath= "//a[contains(@href, '/document.card.php?category=4&DNSID=')]";
	  return xPath;
	  }
}
