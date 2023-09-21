import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import  org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args){
        System.setProperty("webdriver.crome.driver", "C:\\Users\\Asus\\IdeaProjects\\SUT_auto\\src\\main\\resources\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sut-stand-autotests.ks.web-bee.ru/");
        WebElement
    }
}
