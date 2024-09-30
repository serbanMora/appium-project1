package GeneralStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import GeneralStore.Config.BaseTest;
import GeneralStore.PageObject.CartPage;
import GeneralStore.PageObject.FormPage;
import GeneralStore.PageObject.ProductCatalogue;

public class TestExecution extends BaseTest {

	@Test(alwaysRun = true)
	public void FormPage_Test() {
		FormPage formPage = new FormPage(driver);
		formPage.setName("Serban Mora");
		formPage.setGender("male");
		formPage.setCountrySelection("Argentina");
		formPage.submitForm();
	}

	@Test(alwaysRun = true, dependsOnMethods = "FormPage_Test")
	public void productCatalogue() {
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addProductToCart("Air Jordan 4 Retro");
		productCatalogue.addProductToCart("PG 3");
		productCatalogue.goToCartPage();
	}
	
	@Test(alwaysRun = true, dependsOnMethods = "productCatalogue")
	public void cartPage() {
		CartPage cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getPriceSum(), cartPage.getTotalSum());
	}
}