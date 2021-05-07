package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PagePOM.LoginPage;
import io.cucumber.java.en.*;



public class LoginPOM {
	
	WebDriver driver = null;
	LoginPage  login; //02
	

	@Given("the browser is open")
	public void the_browser_is_open() {
		
		System.out.println("====================This test is with LoginPOM ==========================");
	    
	    System.setProperty("webdriver.chrome.driver", "C:/eclipse/Marcelo_Workspace/CucumberJava/src/test/resources/Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    
	}
	@And("user is on login page")
	public void user_is_on_login_page() {
		
		driver.navigate().to("https://example.testproject.io/web/");
		
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException  {
		
		//LoginPage  login = new LoginPage(driver);// this line was created to created this object  to call constructor under LoginPage 01 (was replaced to statement below 03 and above 02)
		login = new LoginPage(driver); //03
		login.enterUsername(username);
		login.enterPassword(password);

		Thread.sleep(1000);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		
		login.clickButton();
	}

	@Then("user is navegated to the homepage")
	public void user_is_navegated_to_the_homepage() {
		login.logoutIsDisplayed();
		driver.close();
		driver.quit();
	}
}
