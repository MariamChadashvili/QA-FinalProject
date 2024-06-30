package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    // WebElements Locators
    private final By emailLocator = By.id("email");
    private final By passwordLocator = By.id("pass");
    private final By loginButtonLocator = By.id("send2");
    private final By loginErrorMessage = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public Boolean isLoginSuccesful(){
        try{
            WebElement errorMessage = driver.findElement(loginErrorMessage);
            System.out.println(errorMessage.isDisplayed());
            return errorMessage.isDisplayed();
        }
        catch (NoSuchElementException e){
            return true;
        }

    }

    // Actions
    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailLocator);
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys(password);
    }

    public void clickOnLogin() {
        driver.findElement(loginButtonLocator).click();
    }

    public StorePage login(String username, String password) {
        enterEmail(username);
        enterPassword(password);
        clickOnLogin();
        return new StorePage(driver);
    }
}
