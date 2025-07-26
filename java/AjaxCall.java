import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjaxCall {


    public static void main (String[] args) {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='loadContent']")).click();
        WebDriverWait mywait =new WebDriverWait(driver , Duration.ofSeconds(10));
        WebElement innertext = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxContent']/h2")));
        //WebElement innertext =  driver.findElement(By.xpath("//div[@id='ajaxContent']/h2"));
        System.out.println(innertext.getText());


    }
}
