package Alerts_and_Popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleAlerts {
    //        #Alerts
//
//
//        1.Go to https://letcode.in/alert
//        2.click confirm alert
//        3.Get text and print the text
//        4.click prompt alert
//        5.pass name in text box and also validate the name in "Your name is section" under prompt alert
//        6.click sweet alert(modern alert) and print the text in it
//
//        Note : Submit assignment till 7/05/2025 EOD on yuvarajan.s@rishabhsoft.com
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Go to https://letcode.in/alert
        driver.get("https://letcode.in/alert");

        // click confirm alert
        driver.findElement(By.xpath("//button[@id='confirm']")).click();

        Alert  confirmAlert = driver.switchTo().alert();

        // Get text and print the text
        System.out.println(confirmAlert.getText());
        Thread.sleep(2000);
        // close the confirm alert prompt
        confirmAlert.accept();

        //click prompt alert .
        driver.findElement(By.xpath("//button[@id='prompt']")).click();
        Alert promptAlert = driver.switchTo().alert();
        String myName = "yash vardhan";
        //passing name in the text box
        promptAlert.sendKeys(myName);
        Thread.sleep(2000);
        //closing the prompt
        promptAlert.accept();
        // get the text from the name section.
        String nameSectionTxt = driver.findElement(By.xpath("//p[@id='myName']")).getText();
        // validate the name Entered is same as in the name section.
        String[] txt= nameSectionTxt.split(":");
        if(myName.equals(txt[1].trim())){
            System.out.println("yes , the name entered in prompt is same as in name section  ");
            System.out.println(myName+" "+txt[1]);
        }else{
            System.out.println("No , the name entered in prompt is not same as in name section ");
            System.out.println(myName+" "+txt[1]);
        }

        //click modern alert
        driver.findElement(By.xpath("//button[@id='modern']")).click();
        // get text in the modern alert
        String modernAlertTxt= driver.findElement(By.xpath("//div[@class='card']/div/p")).getText();
        //print the text in the modern alert
        System.out.println("text inside sweet alert : "+modernAlertTxt);
        Thread.sleep(2000);
        //close the modern alert by clicking cancel button
        driver.findElement(By.xpath("//button[@class='modal-close is-large']")).click();
        //close the driver.
        driver.close();
    }
}
