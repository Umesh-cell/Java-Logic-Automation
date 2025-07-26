import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPusingTestNG {

    WebDriver driver;

    @BeforeMethod
    public void browser_open() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginData")
    public void login(String username, String password) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    @DataProvider (name = "loginData",parallel = true , indices = {0})
    public Object[][] loginData() {
        return new Object[][] {
                {"student", "Password123"},
                {"Students", "Password369"},
                {"Umesh" , "Umesh@13"}
        };
    }
}
