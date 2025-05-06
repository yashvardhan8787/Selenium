package HandlingFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleFrames {
//    #Frames
//
//1.Go to https://letcode.in/frame
//            2.enter last Name
//3.enter mail id
//4.enter first name
//
//*sequence should not be changed
//*use xpath for locator
//
//    Note : Submit assignment till 07/05/2025 EOD on yuvarajan.s@rishabhsoft.com

    public static void main(String[] args)  throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://letcode.in/frame");

        WebElement frame = driver.findElement(By.xpath("//iframe[@id='firstFr']"));
        driver.switchTo().frame(frame);
        //do work in firstFrame enter last Name
        driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("Singh");
        //innerFrame
        WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='innerframe']"));
        driver.switchTo().frame(innerFrame);
        //do work in firstFrame enter Email id
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("singhyashyashvardhan3@gmail.com");
        Thread.sleep(2000);
        //switch back to parent frame
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("yash vardhan ");

        Thread.sleep(2000);
        //enter first name
       driver.close();
    }
}
