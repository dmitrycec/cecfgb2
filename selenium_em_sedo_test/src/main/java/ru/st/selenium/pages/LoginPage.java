package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AnyPage {
	
	public LoginPage(PageManager pages) {
		super(pages);	
	}


	private WebElement orgElement;
	private WebElement loginElement;

	  @FindBy(xpath = "//*[@id=\"organization_show\"]")
	  private WebElement org;		
	  @FindBy(xpath = "//*[@id=\"login_show\"]")
	  private WebElement login;		  
  @FindBy(id = "password_input")
  private WebElement passwordField;
  @FindBy(css = "input.btn_enter")
  private WebElement submitButton;

  
  public LoginPage setOrg(String text) {
   org.click();
	  String xpath = "//a[contains(text(),'"+text+"')]";
	  orgElement = findWebElementByXpath(xpath);
	  orgElement.click();
	    return this;
	  }
 
  public LoginPage setLogin(String text) {
	  login.click();
	  
	  String xpath = "//a[contains(text(),'"+text+"')]";
	  loginElement = findWebElementByXpath(xpath);
	  loginElement.click();
	    return this;
	  }
  
  
  public LoginPage setPasswordField(String text) {
    passwordField.sendKeys(text);
    return this;
  }

  
  public void clickSubmitButton() {
    submitButton.click();
  }

  public LoginPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password_input")));
    return this; 
  }
  
  
  
  public WebElement findWebElementByXpath (String xpath ) { 
		return driver.findElement(By.xpath(xpath));
  }
}
