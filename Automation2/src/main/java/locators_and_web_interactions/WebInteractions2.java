package locators_and_web_interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebInteractions2 {

//
//    Question-2:
//            1. Launch chrome browser
//            2. Open  https://demo.guru99.com/test/newtours/register.php
//            3. Locate Country Dropdown and Select any country.
//            4. close the browser

    public static void main(String[] args) throws InterruptedException {

        // launching Chrome browser.
        ChromeDriver driver = new ChromeDriver();
        // maximizing browser window.
        driver.manage().window().maximize();

        //opening URL https://demo.guru99.com/test/newtours/register.php.
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        // selecting a country (India).
        WebElement country =  driver.findElement(By.xpath("//select[@name='country']"));
        // creating select object.
        Select selectCountry = new Select(country);
        // selecting option INDIA by Visible text.
        selectCountry.selectByVisibleText("INDIA");

        // putting a wait for 2 secs to see Option India is selected.
        Thread.sleep(2000);

        // closing the browser.
        driver.close();
    }
}
