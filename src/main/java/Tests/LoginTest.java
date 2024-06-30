package Tests;

import Commons.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public  void loginValid() {
        logger.info("Running Test 1");
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        LoginPage loginP = new LoginPage(driver);
        loginP.enterEmail("mariamchadashvili2002@gmail.com");
        loginP.enterPassword("ba*CzfXWXNdGS8E");
        loginP.clickOnLogin();
        Assert.assertTrue(loginP.isLoginSuccesful());
    }

    @Test
    public  void loginInvalid() {
        logger.warn("WARNING WARNING");
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        LoginPage loginP = new LoginPage(driver);
        loginP.enterEmail("mariamchadashvili2002@gmail.com");
        loginP.enterPassword("incorrect");
        loginP.clickOnLogin();
        Assert.assertTrue(loginP.isLoginSuccesful());
    }

}
