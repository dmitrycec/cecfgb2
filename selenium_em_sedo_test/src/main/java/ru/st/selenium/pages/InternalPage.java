package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}
	 /* @FindBy(xpath = "//a[contains(text(),'Расширенный поиск')]")
	  private WebElement externSearchPage;
	  */
	  
  public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Расширенный поиск')]")));
    return this;
  }

 /*
 public UserSearchPage clickUserSearchPage() {
	 //externSearchPage.click();
	    return pages.userSearchPage;
  }*/


}
