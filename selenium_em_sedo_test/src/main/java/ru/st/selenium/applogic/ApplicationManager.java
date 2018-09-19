package ru.st.selenium.applogic;

import org.openqa.selenium.WebDriver;



import org.openqa.selenium.firefox.FirefoxDriver;

import ru.st.selenium.util.PropertyLoader;
import ru.st.selenium.util.Browser;
import ru.st.selenium.webdriver.WebDriverFactory;


public class ApplicationManager {

	private UserHelper userHelper; 
    private SearchHelper searchHelper;
	private NavigationHelper navHelper;
	private DocHelper docHelper;
	
	private WebDriver driver;
	private String baseUrl;
	private String tittle;
	
	public ApplicationManager() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
		
		Browser browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));
		
		//driver = WebDriverFactory.getInstance(gridHubUrl, browser, "", "");
		driver = new FirefoxDriver();
				driver.get(baseUrl);
		//tittle = driver.getTitle();
		userHelper = new UserHelper(this);
		searchHelper = new SearchHelper(this);
		navHelper = new NavigationHelper(this);
		docHelper = new DocHelper(this);
	}

	public DocHelper getDocHelper() {
		return docHelper;
	}


	public UserHelper getUserHelper() {
		return userHelper;
	}

	
	public NavigationHelper  getNavigationHelper() {
		return navHelper;
	}
	
	public SearchHelper getSearchHelper() {
		return searchHelper;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
}
