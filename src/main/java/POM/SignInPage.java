package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {

    By userLocator = By.id("loginusername");
    By passLocator = By.id("loginpassword");
    By logInMenuLocator = By.linkText("Log in");
    By logInBtnLocator = By.xpath("//div[@id='logInModal']/div/div/div[3]/button[2]");
    By homePageStandardUserLocator = By.linkText("Welcome standard_user");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn() throws InterruptedException {
        click(logInMenuLocator);
        Thread.sleep(1000);
        if (isDisplayed(userLocator)) {
            type("standard_user", userLocator);
            type("secret_sauce", passLocator);
            click(logInBtnLocator);
        } else {
            System.out.println("username textbox was not present");
        }

    }

    public Boolean isHomePageStandardUserDisplayed() {
        return isDisplayed(homePageStandardUserLocator);
    }
}
