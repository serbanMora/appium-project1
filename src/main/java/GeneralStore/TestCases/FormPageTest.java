package GeneralStore.TestCases;

import org.testng.annotations.Test;

import GeneralStore.Config.BaseTest;
import GeneralStore.PageObject.FormPage;

public class FormPageTest extends BaseTest {

	@Test (alwaysRun = true)
	public void FormPage_Test() {

		FormPage formPage = new FormPage(driver);
		formPage.setName("Serban Mora");
		formPage.setGender("male");
		formPage.setCountrySelection("Austria");
		
	}
}