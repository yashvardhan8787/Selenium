package tests;
import org.testng.annotations.Test;
import base.BaseTests;
import pages.LoginPage;


public class LoginTests extends BaseTests   {
	
    @Test
	public void testValidLogin() throws InterruptedException {
		
		LoginPage loginPage= new LoginPage(driver);

		loginPage.enterUsername("Admin");

		loginPage.enterPassword("admin123");
	
		loginPage.clickLoginButtton();

	}
	
}
