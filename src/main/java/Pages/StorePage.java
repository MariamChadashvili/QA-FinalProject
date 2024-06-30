package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StorePage {
    private final WebDriver driver;

    public StorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToWhatsNewPage() {
        WebElement whatsNewButton = driver.findElement(By.id("ui-id-3"));
        whatsNewButton.click();
    }

    public void addProductByIndex(int index) {
        String xpathExpression = String.format("(//li[@class='product-item'])[%d]", index);
        WebElement productElement = driver.findElement(By.xpath(xpathExpression));

        WebElement priceElement = productElement.findElement(By.xpath(".//span[@class='price']"));
        priceElement.click();
        WebElement addToCartButton = productElement.findElement(By.xpath(".//button[@title='Add to Cart']"));
        addToCartButton.click();
    }

    public void addProductByText(String text) {
        String xpathExpression = String.format("//a[@class='product-item-link' and contains(text(), '%s')]/ancestor::li[@class='product-item']", text);
        WebElement productElement = driver.findElement(By.xpath(xpathExpression));

        WebElement priceElement = productElement.findElement(By.xpath(".//span[@class='price']"));
        priceElement.click();
        WebElement addToCartButton = productElement.findElement(By.xpath(".//button[@title='Add to Cart']"));
        addToCartButton.click();
    }

    public int extractNumberFromElementText() {
        WebElement cartQuantityElement = driver.findElement(By.cssSelector("span.counter-number"));
        String cartQuantityText = cartQuantityElement.getText();
        return Integer.parseInt(cartQuantityText);
    }
}
