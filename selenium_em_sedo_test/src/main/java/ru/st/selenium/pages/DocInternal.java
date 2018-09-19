package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DocInternal extends AnyPage {

	public DocInternal (PageManager pages) {
		super(pages);
	}
	
	private Select out_number;
	
	
	
	@FindBy(xpath = "//input[@name='out_number_suffix[0]']")
	private WebElement out_number_suffix;
	
	@FindBy(xpath = "//textarea[@id='short_content']")
	private WebElement short_content;
	

	
public DocInternal ensurePageLoaded() {
  super.ensurePageLoaded();
 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='out_number_suffix[0]']")));
  return this;
}	



public DocInternal setOut_number(String text) {
	out_number = new Select(findWebElementByXpath("//select[@name='out_number[0]']"));
	out_number.selectByVisibleText(text);
	return this;
}

public DocInternal setOut_number_suffix(String text) {
	
	out_number_suffix.sendKeys(text);

	return this;
}



public DocInternal setshort_content(String text) {
	short_content.sendKeys(text);

    return this;
  }

public WebElement findWebElementByXpath (String xpath ) { 
		return driver.findElement(By.xpath(xpath));
}
}
