
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;

import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.window;

public class FindMandatoryFields {

    public static void main (String[] args) {

        WebDriver driver;

        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/en-gb?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> elements = driver.findElements(By.xpath("//form[@id='form-register']//label"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for(WebElement element:elements)
        {
           String script = "return window.getComputedStyle(arguments[0],'::Before').getPropertyValue('content');";
           String content = js.executeScript(script,element).toString();
           System.out.println(content);

           if(content.contains("*")) {


               System.out.println(  element.getText() + "mandatory fields");
        }
            else {

            System.out.println(element.getText() + "Not a mandatory fields");

        }

        }
        }

    }


