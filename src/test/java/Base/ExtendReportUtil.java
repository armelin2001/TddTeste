package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExtendReportUtil extends BaseUtil {
    String fileName = reportLocation + "extentreport.html";

    public void ExtendReport() {
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test report for Selenium");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test Report");
        extent.attachReporter(htmlReporter);
    }
    public void ExtendReportScreenshot() throws IOException {
        var src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(),new File(reportLocation+"screenshot.png").toPath());
        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
    }
    public void FlushReport(){
        extent.flush();
    }
}
