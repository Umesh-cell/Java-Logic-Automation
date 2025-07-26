import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ListWithCondition {

    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.expandtesting.com/dropdown");
        driver.manage().window().maximize();
        WebElement dropdown = driver.findElement(By.xpath("//select[@name='country']"));
        Select sel = new Select(dropdown);
        List<WebElement> options = sel.getOptions();

        for (WebElement option : options) {
            String text = option.getText().trim();
            if (text.startsWith("B")) {
                System.out.println(text);
            }
        }
    }
}