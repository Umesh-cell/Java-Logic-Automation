import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ThreadSafety {

    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    WebDriver driver;

    public void setDriver(WebDriver driver) {
        tdriver.set(driver);
    }

    public WebDriver getDriver() {
        return tdriver.get();

    }

    @Test
    public void test_one () {


        setDriver(new ChromeDriver());
        getDriver().get("https://www.flipkart.com/");
        System.out.println(getDriver().getTitle());
        getDriver().quit();
    }
@Test
    public void test_two() {
        setDriver(new EdgeDriver());
        getDriver().get("https://www.amazon.in/");
        System.out.println(getDriver().getTitle());
        getDriver().quit();
}
@AfterMethod
    public void close() {
        tdriver.remove();
}
}
