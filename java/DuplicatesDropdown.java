import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesDropdown {

    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/dropdown");

        WebElement dropdownElement =driver.findElement(By.xpath("//select[@name='country']"));
        Select sel = new Select(dropdownElement);
        List<WebElement> options = sel.getOptions();
        List<String> optiontext = new ArrayList<>();

        for(WebElement option: options){
            optiontext.add(option.getText().trim());
        }

        Set<String> uniqueOptions = new HashSet<>(optiontext);

        if(optiontext.size() == uniqueOptions.size()) {

            System.out.println("dropdown values are UNIQUE");
        }
        else
        {
            System.out.println("not UNIQUE");
        }

    }


}


