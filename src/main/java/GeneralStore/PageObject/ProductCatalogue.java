package GeneralStore.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions {

	AndroidDriver driver;

	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> productNames;

	public void addProductToCart(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		for (int i = 0; i < productNames.size(); i++) {
			String prodText = productNames.get(i).getText();

			while (prodText.equals(text)) {
				wait.until(ExpectedConditions.visibilityOf(addToCart.get(i)));
				addToCart.get(i).click();
				break;
			}
			if (!prodText.equals(text)) {
				scrollToText(text);
				if (prodText.equals(text)) {
					wait.until(ExpectedConditions.visibilityOf(addToCart.get(i)));
					addToCart.get(i).click();
				}
			}
		}
	}

	public CartPage goToCartPage() {
		cartButton.click();
		return new CartPage(driver);
	}
}
