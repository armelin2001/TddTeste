package Steps;

import Base.BaseUtil;
import com.aventstack.extentreports.GherkinKeyword;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginStep extends BaseUtil {
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {

        System.out.println("Navigate Login Page");
        base.driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        LoginPage page = new LoginPage(base.driver);
        page.clickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() {
        try {
            scenarioDef.createNode(new GherkinKeyword("Then"),"I should see the userform page");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Its not displayed", base.driver.findElement(By.id("Initial")).isDisplayed(), true);
    }

    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) {
//      List<User> users;
//      users = table.asList(User.class);
        LoginPage page = new LoginPage(base.driver);
        //for(User user: table.){}
        page.login(table.cell(0, 1), table.cell(1, 1));
    }

    public void iEnterUserNameAndPassword(String userName, String password) {
        System.out.println("UserName is : " + userName);
        System.out.println("Password is : " + password);
    }

    public class User {
        public String userName;
        public String password;

        public User(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }
    }
}

