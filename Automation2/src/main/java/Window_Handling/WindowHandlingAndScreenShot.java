package Window_Handling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Set;

public class WindowHandlingAndScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target URL
        driver.get("https://letcode.in/window");

        // Create screenshots directory if it doesn't exist
       try{
           File screenshotDir = new File(System.getProperty("user.dir") + "\\screenshots");
           if (!screenshotDir.exists()) {
               screenshotDir.mkdir();
           }


        // Take full page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(screenshotDir + "\\fullpageScreenshot.png");
        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Take screenshot of the Home button
        WebElement homeButton = driver.findElement(By.id("home"));
        File homeBtnScreenshot = homeButton.getScreenshotAs(OutputType.FILE);
        File targetBtnFile = new File(screenshotDir + "\\homeButtonScreenshot.png");
        Files.copy(homeBtnScreenshot.toPath(), targetBtnFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Click on the Home button
        homeButton.click();
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        // Switch to newly opened tab
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Print the URL of the new window
        System.out.println("Child window URL: " + driver.getCurrentUrl());

        // Close the child window
        driver.close();

        // Switch back to parent window
        driver.switchTo().window(parentWindow);

        // Click on the Multiple Windows button
        driver.findElement(By.id("multi")).click();

        // Get all window handles and print titles
        Set<String> multipleWindows = driver.getWindowHandles();

        for (String window : multipleWindows) {
            driver.switchTo().window(window);
            System.out.println("Page Title: " + driver.getTitle());
        }

        // Close all windows
        driver.quit();
    }
}
