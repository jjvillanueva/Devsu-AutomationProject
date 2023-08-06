package POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    private boolean acceptNextAlert = true;
    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;

    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "driver/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void closeAlert() {

        try {
            Alert alert = driver.switchTo().alert();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
        } finally {
            acceptNextAlert = true;
        }
    }
}
