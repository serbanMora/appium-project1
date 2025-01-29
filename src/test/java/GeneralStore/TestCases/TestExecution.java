package GeneralStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GeneralStore.PageObject.CartPage;
import GeneralStore.PageObject.FormPage;
import GeneralStore.PageObject.ProductCatalogue;
import GeneralStore.Config.BaseTest;

public class TestExecution extends BaseTest {

	FormPage formPage;
	ProductCatalogue productCatalogue;
	CartPage cartPage;
	
	String name = "Serban Mora";
	String gender = "male";
	String country = "Argentina";
	
	@Test (dataProvider = "getData")
	public void formPage(String name, String gender, String country) {
		formPage = new FormPage(driver);
		formPage.setName(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
		formPage.submitForm();
	}

	@Test (dependsOnMethods = "formPage")
	public void productCatalogue() {
		productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addProductToCart("Air Jordan 4 Retro");
		productCatalogue.addProductToCart("PG 3");
		productCatalogue.goToCartPage();
	}
	
	@Test (dependsOnMethods = "productCatalogue")
	public void cartPage() {
		cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getPriceSum(), cartPage.getTotalSum());
		cartPage.submitOrder();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];
		
		data[0][0] = name;
		data[0][1] = gender;
		data[0][2] = country;
		
		return data;
	}
}