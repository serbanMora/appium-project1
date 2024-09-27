package GeneralStore.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest extends BaseTestUtils {

	public static AppiumDriverLocalService service;
	public static AndroidDriver driver;
	private static String build;

	@BeforeClass(alwaysRun = true)
	public void configureAppiumTest() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Lynx User\\eclipse-workspace\\AppiumProject\\src\\main\\java\\GeneralStore\\Config\\data.properties");
		String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress")
				: prop.getProperty("port");
		prop.load(fis);
		// String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		build = prop.getProperty("build");

		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceNames"));
		options.setApp("C:\\Users\\Lynx User\\eclipse-workspace\\AppiumProject\\src\\main\\java\\resources\\" + build);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterClass(alwaysRun = true)
	public static void tearDown() {
		driver.quit();
		service.stop();
	}
}
