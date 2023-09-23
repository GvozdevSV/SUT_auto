package common;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static common.config.PLATFORM_AND_BROWSER;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win32/chromedriver.exe");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;


        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
