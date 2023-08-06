package test;

import POM.CartPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PurchaseTest {
    private WebDriver driver;
    CartPage cartPage;

    @Before
    public void setUp() throws Exception {
        cartPage = new CartPage(driver);
        driver = cartPage.chromeDriverConnection();
        cartPage.visit("https://demoblaze.com/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        cartPage.addProducts();
        cartPage.placeOrder();
        assertTrue(cartPage.isSuccessPurchaseMessageDisplayed());
    }

}
