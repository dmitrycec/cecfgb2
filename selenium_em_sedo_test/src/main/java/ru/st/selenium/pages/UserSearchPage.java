package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserSearchPage extends InternalPage {

	public UserSearchPage(PageManager pages) {
		super(pages);
	}
	
	@FindBy(xpath = "//input[@id='num']")
	private WebElement innum;
	

	@FindBy(id= "search_down")
	private WebElement seachButton;
	
  public UserSearchPage setInNum(String text) {
	  innum.sendKeys(text);
    return this;
  }

  public UserSearchPage searchClick() {
	  	  seachButton.click();
    return this;
  }
 
  public UserSearchPage ensurePageLoaded() {
    super.ensurePageLoaded();
   // wait.until(presenceOfElementLocated(By.xpath("//input[@id='num']")));
    return this;
  }
}
