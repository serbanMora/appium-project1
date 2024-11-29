package GeneralStore.Config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	static ExtentReports extent;

	public static ExtentReports getReporterObject()	{
	String path = System.getProperty("user.dir") + "/REPORTS/index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("GeneralStore  Automation Test Report");
	reporter.config().setDocumentTitle("GeneralStore Automation Test Report");
	reporter.config().setTheme(Theme.DARK);
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Automation Tester", "Serban Mora");
    extent.setSystemInfo("Test Cases", "<a href='https://docs.google.com/spreadsheets/d/1J8PG6RX7NOmLY7BsYBn9He6ZeVsJumMPcQ-YbOtwo8w/edit?pli=1&gid=0#gid=0' target='_blank'>Click here to view the test cases document</a>");
    extent.setSystemInfo("GitHub", "<a href='https://github.com/serbanMora' target='_blank'>Click here to view my GitHub projects</a>");
    return extent;
	}
}