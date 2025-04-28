package Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        //login
        driver.findElement(By.xpath("//div[@id='nav-link-accountList']")).click();
        //enter mobile or email
        driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys("7309502541");
        //click button
        driver.findElement(By.xpath("//span[@id='continue']//input")).click();
        //enter password
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("yash@7309");
        //click sign in
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

        //buying product
        //
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("headphones");
       //
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

           Thread.sleep(5000);
           JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("window.scrollBy(0,250)","");
           driver.findElement(By.xpath("//div[@role='listitem'][1]//button[text()='Add to cart']")).click();
           js.executeScript("window.scrollBy(0,-250)","");
           driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
           driver.findElement(By.xpath("//input[@value = 'Proceed to checkout']")).click();

           //loging out
           driver.navigate().back();

           WebElement profileOption = driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
           Actions act= new Actions(driver);
           act.moveToElement(profileOption).build().perform();

           driver.findElement(By.xpath("//a[@id='nav-item-signout']")).click();


        driver.quit();
}
}
