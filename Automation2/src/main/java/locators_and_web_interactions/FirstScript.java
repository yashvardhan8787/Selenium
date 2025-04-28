package locators_and_web_interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstScript {
	public static void main(String []args)throws InterruptedException {
		EdgeDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);

		driver.findElement(By.id("email")).sendKeys("7309502541");

		Thread.sleep(2000);

		driver.findElement(By.name("pass")).sendKeys("8787021710");

		Thread.sleep(2000);

		driver.findElement(By.tagName("button")).click();
	}

}

//
//Locators:
//
//		Locators are used to identify an element with the help of locator types.
//
//		To Identify an element present on the webpage, we need to used 'findElement'/'findElements' method which is present in web driver.
//
//		findElement method identifies an element with the help of By class which contains Static methods.
//
//		All the static methods present in the By class are known as locator types.
//
//		------------------------------------------------------------------------------------------------------------------------------------
//
//		Tagname: Any keyword which is present immediately after the less than symbol is called as tagname.
//
//		ex. input,html,body,table,a, button etc.
//
//		Attribute: Any keyword which is present immediately after the tagname and having equal to symbol until the greater than symbol.
//
//		ex: attribute name= attribute value
//
//		Text: Any keyword which is present in between greater than symbol and less than symbol is call as text.
//
//		ex: >facebook<
//
//
//		Types of Locators:
//
//		1) Id
//
//		2) Name
//
//		3) Tagname
//
//		4) Linktext
//
//		5) Partial Linktext
//
//      6) ClassName
//public static void main(String[] args) throws InterruptedException {
//
//		WebDriver driver=new ChromeDriver();
//
//		driver.manage().window().maximize();
//
//		driver.get("https://www.facebook.com/");
//
//		Thread.sleep(2000);
//
//		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
//
//		Thread.sleep(2000);
//
//		driver.findElement(By.name("pass")).sendKeys("Test@123");
//
//		Thread.sleep(2000);
//
//		driver.findElement(By.id("email")).clear();
//
//		Thread.sleep(2000);
//
//		driver.findElement(By.id("email")).sendKeys("qwertyuio@gmail.com");
//
//		Thread.sleep(2000);
//
//		driver.findElement(By.tagName("button")).click();
//		}
//		Log in or sign up to view
//		See posts, photos and more on Facebook.
//
