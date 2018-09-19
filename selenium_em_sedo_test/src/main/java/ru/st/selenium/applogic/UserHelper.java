package ru.st.selenium.applogic;


import ru.st.selenium.model.User;

public class UserHelper extends DriverBasedHelper {

  public UserHelper(ApplicationManager manager) {
    super(manager.getWebDriver());
  }


  public void loginAs(User user) {
    pages.loginPage.ensurePageLoaded()
      .setOrg(user.getOrg())
            .setLogin(user.getLogin())
      .setPasswordField(user.getPassword())
      .clickSubmitButton();
  }

  



  public boolean isLoggedIn() {
    return pages.internalPage.ensurePageLoaded()
    		.waitPageLoaded();
  }

 
  public boolean isLoggedInAs(User user) {
    return isLoggedIn();
        //&& getLoggedUser().getLogin().equals(user.getLogin());
  }

  
  public boolean isNotLoggedIn() {
    return pages.internalPage.waitPageLoaded();
  }
  
 // private User getLoggedUser() {
   // UserProfilePage userProfile = pages.internalPage.ensurePageLoaded()
     // .clickUserProfilePage()
     // .ensurePageLoaded();
  //  return new User()
     // .setLogin(userProfile.getUsername())
     // .setEmail(userProfile.getEmail())
     // .setRole(userProfile.getRole());
 // }

}
