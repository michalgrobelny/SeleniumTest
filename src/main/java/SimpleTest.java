import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

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

        System.out.println(System.getProperty("user.dir"));

        String screenshotPath = "screenshot.png"; // Save to current working directory
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);
        Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        driver.quit();
        System.exit(0);
    }
}
