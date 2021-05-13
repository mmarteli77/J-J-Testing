/*package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;



public class Login {
	
	WebDriver driver = null;

	

	@Given("the browser is open")
	public void the_browser_is_open() {
	    
	    System.setProperty("webdriver.chrome.driver", "C:/eclipse/Marcelo_Workspace/CucumberJava/src/test/resources/Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    
	}
	@And("user is on login page")
	public void user_is_on_login_page() {
		
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		
		driver.findElement(By.id("login")).click();
	}

	@Then("user is navegated to the homepage")
	public void user_is_navegated_to_the_homepage() {
		
		driver.findElement(By.id("logout")).click();
		driver.close();
	}
}
*/
