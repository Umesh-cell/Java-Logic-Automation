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

public class ListDropdownElements {
    public static void main(String[] args) {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.expandtesting.com/dropdown");
        driver.manage().window().maximize();
        WebElement dropdown= driver.findElement(By.xpath("//select[@name='country']"));
        Select sel = new Select(dropdown);
        List<WebElement> options = sel.getOptions();
        List<String> optionstext = new ArrayList<>();

       for(WebElement option:options){

           optionstext.add(option.getText().trim());
       }
System.out.println("Dropdown values");
       for(String values :optionstext){
           System.out.println(values);
        }

       Set<String> uniquenames = new HashSet<>(optionstext);
       System.out.println("Confirming all are uniquevalues "+uniquenames);


    }
}
