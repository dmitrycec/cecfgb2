package ru.st.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import ru.st.selenium.model.User;

public class LoginTest extends ru.st.selenium.pages.TestBase {

  //@BeforeMethod
  //public void mayBeLogout() {
    //if (app.getUserHelper().isNotLoggedIn()) {
     // return;
   // }
  //  app.getUserHelper().logout();
 // }
  
  @Test
  public void testLoginOK() throws Exception {
	  
	  
	  
    User user = new User().setOrg("������ ������������").setChoiseOrg(3).setLogin("�����������").setChoiseLogin(5).setPassword("jkl;");
    app.getUserHelper().loginAs(user);
  
   
    
   // assertTrue(app.getUserHelper().isLoggedInAs(user));
   // app.getNavigationHelper().openLink("����������� �����");
   //app.getSearchHelper().searchDoc("2131");
app.getNavigationHelper().openLink("���������� ���������/����� ��������");
app.getDocHelper().newInternalDoc("15","222222","54441");
  }

 // @Test
 // public void testLoginFailed() throws Exception {
  //  User user = new User().setLogin("admin").setPassword("wrong");
   // app.getUserHelper().loginAs(user);
   // // assertFalse(app.getUserHelper().isLoggedIn());
   // assertTrue(app.getUserHelper().isNotLoggedIn());
 // }

}
