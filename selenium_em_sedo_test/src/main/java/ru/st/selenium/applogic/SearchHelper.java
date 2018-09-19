package ru.st.selenium.applogic;

public class SearchHelper extends DriverBasedHelper {
	
	  public SearchHelper(ApplicationManager manager) {
		    super(manager.getWebDriver());
		  }

	  public boolean searchDoc(String text) {
		
			     pages.userSearchPage.ensurePageLoaded()
		    		.setInNum(text)
		    		.searchClick();
		     return true;
		  }
	  
	  
}
