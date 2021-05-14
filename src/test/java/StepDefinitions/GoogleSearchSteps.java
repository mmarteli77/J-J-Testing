package StepDefinitions;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;




public class GoogleSearchSteps {
	
	WebDriver driver = null;


	@Given("browser is open")
	public void browser_is_open()  {
		System.out.println("inside the step browser is open");
		System.setProperty("webdriver.chrome.driver","https://github.com/mmarteli77/J-J-Testing/tree/master_automation/src/test/resources/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() throws Exception {
		System.out.println("inside the step user is on");
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(1000);
		
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws Exception {
		System.out.println("inside the step user enters the text");
		driver.findElement(By.name("q")).sendKeys("automation step by step");
		Thread.sleep(2000);
	}

	@And("hits enter")
	public void hits_enter() {
		System.out.println("inside the step user hits enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navegated to search results")
	public void user_is_navegated_to_search_results() {
		System.out.println("inside the step result is displyed");
		
		
		driver.getPageSource().contains("Online Courses");
				
		
		driver.close();
		
	}

}
