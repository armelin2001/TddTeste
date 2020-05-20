package Base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;

public class BaseUtil {
    public WebDriver driver;
    public ExtentReports extent;
    public static ExtentTest scenarioDef;
    public static ExtentTest features;
    public static String reportLocation="/Users/mathe/report/";
}
