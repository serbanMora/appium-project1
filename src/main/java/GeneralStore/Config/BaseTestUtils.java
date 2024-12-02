package GeneralStore.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestUtils {
	
	public AppiumDriverLocalService service;

	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/GeneralStore/Config/data.properties");
		prop.load(fis);
		String mainjsPath = prop.getProperty("mainjsPath");
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(mainjsPath))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}
}
