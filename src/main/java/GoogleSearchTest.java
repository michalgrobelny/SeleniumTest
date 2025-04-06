import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Jenkins Selenium Test");
        searchBox.sendKeys(Keys.RETURN);

        Thread.sleep(2000); // Wait for results

        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        file.renameTo(new File("screenshot.png"));

        driver.quit();
    }
}
