package test;

import POM.SignInPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SignInTest {
    private WebDriver driver;
    SignInPage signInPage;

    @Before
    public void setUp() throws Exception {
        signInPage = new SignInPage(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.visit("https://demoblaze.com/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Test
    public void test() throws InterruptedException {
        signInPage.signIn();
        Thread.sleep(2000);
        assertTrue(signInPage.isHomePageStandardUserDisplayed());
    }
}
