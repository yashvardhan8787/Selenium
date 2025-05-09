package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
	
	private WebDriver driver;
	
	private By logo = By.xpath("//div[@class='orangehrm-login-branding']//img");
	private By username = By.name("username");
	private By password = By.name("password");
	private By loginButton =By.tagName("button");
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(this.username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	
	
	public void clickLoginButtton() {
		driver.findElement(loginButton).click();
	}
	
	
	public boolean isLogoDisplayed() {
		boolean res = driver.findElement(logo).isDisplayed();
		return res;
	}
		
}
