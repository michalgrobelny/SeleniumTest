import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.io.File;

public class SimpleTest {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();

        Thread.sleep(2000);

        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        file.renameTo(new File("screenshot.png"));

        driver.quit();
    }
}
