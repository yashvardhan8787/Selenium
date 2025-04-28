package locators_and_web_interactions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebInteractions1 {
//    Web Interactions Assignment:
//    Question-1:
//
//            1. Launch chrome browser
//            2. Open  https://demoqa.com/checkbox
//            3. Go to Textbox and Fill all the required Details and Submit
//            4. Go to Checkbox and expand the Home then again expand any of the
//                option (from Desktop, Documents, Download) and click any one checkbox from two options.
//            5. Go to the Radio Button and select one Radio Button
//            6. Close the Browser
//
//            (locate element with different type of locators)
    public static void main(String[] args) throws InterruptedException{
        //Launching the Chrome browser.
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Opening URl.
        driver.get("https://demoqa.com/checkbox");

        //Going to text-box
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();

        //filling all the details required.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(By.cssSelector("input#userName")).sendKeys("Yash Vardhan Singh");

        driver.findElement(By.cssSelector("input#userEmail")).sendKeys("yash@gmail.com");

        driver.findElement(By.cssSelector("textarea#currentAddress")).sendKeys("gotri-vasna road bhayli , vadodara , Gujarat");

        driver.findElement(By.cssSelector("textarea#permanentAddress")).sendKeys("gotri-vasna road bhayli , vadodara , Gujarat");

        js.executeScript("window.scrollBy(0,350)", "");

        // clicking the submit button.
        driver.findElement(By.xpath("//div//button[text()='Submit']")).click();

        Thread.sleep(2000);

        //going to checkbox.
        js.executeScript("window.scrollBy(0,-350)", "");

        driver.findElement(By.xpath("//span[text()='Check Box']")).click();

        //to make check box options visible.
        js.executeScript("window.scrollBy(0,350)", "");

        //expanding home
        driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();

        //after expanding home expanding downloads
        driver.findElement(By.xpath("//div[@class='check-box-tree-wrapper']//li//ol//li[3]//span//button")).click();

        //after expanding selecting option word File doc.
        driver.findElement(By.xpath("//span[text()='Word File.doc']")).click();
        Thread.sleep(2000);

        //  Going to the Radio Button
        driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

        js.executeScript("window.scrollBy(0,50)", "");

        // selecting one radio button option (Impressive).
        driver.findElement(By.xpath("//label[text()='Impressive']")).click();

        Thread.sleep(1000);

        // Closing the Browser
        driver.close();

    }



}

