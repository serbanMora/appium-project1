package GeneralStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import GeneralStore.Config.BaseTest;
import GeneralStore.PageObject.CartPage;
import GeneralStore.PageObject.FormPage;
import GeneralStore.PageObject.ProductCatalogue;

public class TestExecution extends BaseTest {

	FormPage formPage;
	ProductCatalogue productCatalogue;
	CartPage cartPage;
	
	@Test(alwaysRun = true, enabled = true)
	public void formPage() {
		formPage = new FormPage(driver);
		formPage.setName("Serban Mora");
		formPage.setGender("male");
		formPage.setCountrySelection("Argentina");
		formPage.submitForm();
	}

	@Test(alwaysRun = true, dependsOnMethods = "formPage", enabled = true)
	public void productCatalogue() {
		productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addProductToCart("Air Jordan 4 Retro");
		productCatalogue.addProductToCart("PG 3");
		productCatalogue.goToCartPage();
	}
	
	@Test(alwaysRun = true, dependsOnMethods = "productCatalogue", enabled = true)
	public void cartPage() {
		cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getPriceSum(), cartPage.getTotalSum());
		cartPage.submitOrder();
	}
}