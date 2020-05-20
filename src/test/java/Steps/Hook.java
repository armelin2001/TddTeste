package Steps;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {
    private final BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest(Scenario scenario) {
        scenarioDef = features.createNode(scenario.getName());
        System.out.println("Opening the browser : Firefox");
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        base.driver = new FirefoxDriver();
        base.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }

    @After
    public void tearDownTest() {
        System.out.println("Closing the browser : MOCK");
        base.driver.close();
    }

}
