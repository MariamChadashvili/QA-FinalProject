package Tests;

import Commons.BaseTest;
import Pages.LoginPage;
import Pages.StorePage;
import org.testng.annotations.Test;


public class AddToCart  extends BaseTest {

    @Test
    public void checkCart() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login");
        Thread.sleep(2000);
        LoginPage loginP = new LoginPage(driver);

        StorePage storeP =  loginP.login("mariamchadashvili2002@gmail.com","ba*CzfXWXNdGS8E");

        storeP.goToWhatsNewPage();
        Thread.sleep(1000);

        storeP.addProductByIndex(2);
        Thread.sleep(1000);
        storeP.addProductByText("Summit Watch");
        Thread.sleep(1000);
        System.out.println(storeP.extractNumberFromElementText());
    }

}
