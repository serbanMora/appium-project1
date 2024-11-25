package GeneralStore.PageObject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {

	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
}