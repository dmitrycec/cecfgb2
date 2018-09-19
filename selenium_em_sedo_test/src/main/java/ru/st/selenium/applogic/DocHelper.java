package ru.st.selenium.applogic;

//import org.openqa.selenium.WebDriver;

//import ru.st.selenium.pages.*;
public class DocHelper extends DriverBasedHelper {

	public DocHelper(ApplicationManager manager) {
		 super(manager.getWebDriver());
	}
	
	//private DocInternal p;
	
	public void newInternalDoc(String Out_number, String Out_number_suffix, String short_content) {
		
		pages.docInternal
		.ensurePageLoaded()
		.setOut_number(Out_number)
		.setOut_number_suffix(Out_number_suffix)
		.setshort_content("545454");
	}

}
