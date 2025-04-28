package web_tables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class HandleWebTable {
//               Assignment for Web table
//            1. Open the URL: https://rahulshettyacademy.com/AutomationPractice/
//            2. Scroll till the Webtable (Web Table Fixed Header) should be visible.
//            3. Print all the Headers. (Name, Poistion, City and Amount)
//            4. Also Print the Ben's data (Name, Position, City and Amount) below the header.
    public static void main(String[] args) throws InterruptedException {

        // Launch chrome browser.
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the site URL.
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        // Scroll to the Web Table section
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,700)");

        // Fetch and print all the table header elements.
        List<WebElement> tableHeaders = driver.findElements(By.xpath("//div[@class='tableFixHead']//table//thead//tr//th"));

        for (WebElement element  : tableHeaders) {
            System.out.print(element.getText()+"  ");
        }
        System.out.println("");



        // Fetching all rows of tables.
        List<WebElement> rows=driver.findElements(By.xpath("//div[@class='tableFixHead']//table//tbody//tr"));

        // Printing row of Ben's Data.
         for(int i = 1 ; i <= rows.size() ; i++){
              String name =  driver.findElement(By.xpath("//div[@class='tableFixHead']//table//tbody//tr["+i+"]//td[1]")).getText();
              if(name.equals("Ben")){
                  for(int j = 1 ; j <= 4 ; j++){
                      String cellData= driver.findElement(By.xpath("//div[@class='tableFixHead']//table//tbody//tr["+i+"]//td["+j+"]")).getText();
                      System.out.print(cellData+"  ");
                  }

                  System.out.println("");
              }
          }

        // Close browser.
        driver.quit();
    }

}
//
//    List<WebElement> ben_sData =  driver.findElements(By.xpath("//div[@class='tableFixHead']//table//tbody//tr[2]//td"));
//
////printing ben's data below headers
//        for (WebElement data : ben_sData) {
//                System.out.print(data.getText()+"  ");
//                }
