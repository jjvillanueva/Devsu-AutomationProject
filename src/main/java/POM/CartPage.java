package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Base {
    By homePageBtnLocator = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
    By carPageBtnLocator = By.linkText("Cart");
    By product1 = By.linkText("Samsung galaxy s6");
    By product2 = By.linkText("Nexus 6");
    By addToCardBtnLocator = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By placeOrderLocator = By.xpath("//div[@id='page-wrapper']/div/div[2]/button");
    By nameLocator = By.id("name");
    By countryLocator = By.id("country");
    By cityLocator = By.id("city");
    By creditCartLocator = By.id("card");
    By monthLocator = By.id("month");
    By yearLocator = By.id("year");
    By purchaseBtnLocator = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    By okBtnPurchaseLocator = By.xpath("/html/body/div[10]/div[7]/div/button");
    By SuccessPurchaseMessage = By.xpath("//*[contains(text(), 'Thank you for your purchase!')]");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addProducts() throws InterruptedException {
        try {
            click(product1);
            click(addToCardBtnLocator);
            Thread.sleep(1000);
            closeAlert();
            click(homePageBtnLocator);
            click(product2);
            click(addToCardBtnLocator);
            Thread.sleep(1000);
            closeAlert();
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }

    public void placeOrder() throws InterruptedException {
        click(carPageBtnLocator);
        click(placeOrderLocator);
        type("Juan", nameLocator);
        type("Dominican Republic", countryLocator);
        type("Santo Domingo", cityLocator);
        type("123456789", creditCartLocator);
        type("May", monthLocator);
        type("2002", yearLocator);
        click(purchaseBtnLocator);
        click(okBtnPurchaseLocator);
    }

    public Boolean isSuccessPurchaseMessageDisplayed() {
        String actualPurchaseMessage = getText(SuccessPurchaseMessage);
        String expectedPurchaseMessage = "Thank you for your purchase!";
        return actualPurchaseMessage.equals(expectedPurchaseMessage);
    }
}
