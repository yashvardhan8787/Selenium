package locators_and_web_interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {
        // 1. Launch chrome browser
        //  2. Open  https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        // 3. Verify Orange HRM logo.
        // 4. Get Username and password and print into the console.
        //5. Add username and password what you have extracted from landing page.
         //6. Click on login
        //7. Wait for 5 Seconds And Logout.

         //   (locate element with different type of locators)
    public static void main(String[] args) throws InterruptedException{

        //launching the Chrome browser.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);

       //to verify that logo is visible.
        boolean isLogoVisible = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']//img")).isDisplayed();
        if(isLogoVisible){
            System.out.println("Logo is visible.");
        }else{
            System.out.println("Logo is not visible.");
        }

        // Getting Username and password and printing into the console.
        String username=driver.findElement(By.xpath("//div[contains(@class, 'orangehrm-demo-credentials')]//p[1]")).getText();
        String password=driver.findElement(By.xpath("//div[contains(@class, 'orangehrm-demo-credentials')]//p[2]")).getText();

        // formatting the username and password so can use it to log in.

        String []usernames=username.split(":");
        username= usernames[1].trim();

        String []passwords=password.split(":");
        password=passwords[1].trim();

        //printing username and password in console
        System.out.println("username :"+username);

        System.out.println("password :"+password);

        //Adding username and password to username field and password field.
        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("password")).sendKeys(password);

       //clicking log in button.

        driver.findElement(By.tagName("button")).click();
        // waiting for 5 seconds.
        Thread.sleep(5000);

        //logging out.
        //click on user icon to open dropdown list.
        driver.findElement(By.className("oxd-userdropdown-name")).click();
        Thread.sleep(2000);

        //select logout option.
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);
        //closing window.
        driver.close();
    }
}
