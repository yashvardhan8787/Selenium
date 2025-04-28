package keyboard_and_mouse_event;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class KeyboardEvents {

//            1. Open the URL: https://omayo.blogspot.com/
//            2. Hover the Mouse on "Blogs".
//            3. click on "SeleniumByArun" by using Mouse action.
//            4. Navigate back to the Main Window.(used driver.navigate().back())
//            5. Now Select "doc3" from the dropdown by using Keyboard actions.
//            6. Print the first and last value in the dropdown.
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // navigate to the site Url.
        driver.get("https://omayo.blogspot.com/");



        WebElement blogsMenu= driver.findElement(By.xpath("//span[@id='blogsmenu']"));
        Thread.sleep(200);

        Actions actions = new Actions(driver);

        // Hovering the mouse on blogs menu.
        actions.moveToElement(blogsMenu).build().perform();

        // Clicking option SeleniumByArun using mouse action.
        WebElement seleniumByArunLink = driver.findElement(By.linkText("SeleniumByArun"));
        actions.click(seleniumByArunLink).build().perform();

        // Navigating back to the main Page.
        driver.navigate().back();


        // Selecting option doc3 using keyboard actions.
        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='drop1']"));
        actions.click(dropDownElement).build().perform();

        for(int i = 0 ; i < 3; i++){
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        actions.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(1000);

        // printing first and last options from dropdown.
        Select dropDown= new Select(dropDownElement);
        List<WebElement> allOptions = dropDown.getOptions();
        System.out.println("First Option: "+allOptions.get(0).getText());
        System.out.println("Last Option: "+allOptions.get(allOptions.size()-1).getText());


        // closing browser.
        driver.quit();
    }
}
