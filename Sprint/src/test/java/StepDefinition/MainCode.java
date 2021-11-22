package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class MainCode {
	WebDriver driver = null;	
    //first Scenario
	@Given("E-learning login page is launched")
	public void e_learning_login_page_is_launched() {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waits for 10 seconds until no action takes 
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
	}

	@When("User enters Username and Password")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox


	}
	@Then("^click login$")
	public void click_login() {
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button
	}

	@And("E-page is opened")
	public void e_page_is_opened() {
		String title = driver.getTitle();
		//stores the title of the page in the variable 'title'
		System.out.println(title);
		//prints the title in console
		Assert.assertEquals("My Organization - My education - My courses", title);
		//compares the title with predicted one

	}
	@Then("^close the Browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
		//browser is closed
	}
	
	
	
	
	//Second Scenario
	
	
	@Given("^user is logged in and naviated to home page$")
	public void user_is_logged_in_and_naviated_to_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser 			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waits for 10 seconds until no action takes 
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button

	}

	@Then("^click on the Personal Agenda$")
	public void click_on_the_personal_agenda() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Personal agenda')]")).click();
		//clicks on Personal Agenda
	}

	@And("^verify the page$")
	public void verify_the_page() throws Throwable {
		String actualUrl="http://elearningm1.upskills.in/main/calendar/agenda_js.php?type=personal"; 
		//actual url to verify the page
		String expectedUrl= driver.getCurrentUrl();
		//expected url to verify the page
		Assert.assertEquals(expectedUrl,actualUrl);
		//checks whether actual url equals expected url 

	}

	@Then("^Quit the browser$")
	public void quit_the_browser() throws Throwable {
		driver.close();
		//browser is closed

	}
	
	
	//3rd Scenario

	@Given("^User is logged in and directed to personal agenda page$")
	public void user_is_logged_in_and_directed_to_personal_agenda_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waits for 10 seconds until no action takes
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button
		driver.findElement(By.xpath("//a[contains(text(),'Personal agenda')]")).click();
		//clicks on Personal Agenda
	}

	@When("User Clicks on Red colured icon")
	public void user_clicks_on_red_colured_icon() throws InterruptedException {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
		//clicks on red colured icon
		Thread.sleep(3000);
		//waits for 3 seconds

	}

	@Then("Current running month is displayed")
	public void current_running_month_is_displayed() {
		boolean Element1 =  driver.findElement(By.xpath("//h2[contains(text(),'November 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element1);
		//Assertion gets successful when element is displayed


	}

	@And("Click on > button")
	public void click_on_button() {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/button[3]/span[1]")).click();
		//clicks on > button
	}
	@Then("^Succeeding month is displayed$")
	public void succeeding_month_is_displayed() throws InterruptedException {
		boolean Element2 =  driver.findElement(By.xpath("//h2[contains(text(),'December 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element2);
		//Assertion gets successful when element is displayed
		Thread.sleep(3000);
		//waits for 3 seconds
	}
	@And("^Click on today$")
	public void click_on_today(){
		driver.findElement(By.xpath("//button[contains(text(),'today')]")).click();
		//clicks on today icon
	}

	@Then("^again Current running month is displayed$")
	public void again_current_running_month_is_displayed() throws InterruptedException{
		boolean Element3 =  driver.findElement(By.xpath("//h2[contains(text(),'November 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element3);
		//Assertion gets successful when element is displayed
		Thread.sleep(3000);
		//waits for 3 seconds
	}
	@And("^Click on < button$")
	public void click_on_button11()  {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/button[2]/span[1]")).click();
		//clicks on < button	
	}

	@Then("^Preceeding month is displayed$")
	public void preceeding_month_is_displayed() throws InterruptedException {
		boolean Element4 =  driver.findElement(By.xpath("//h2[contains(text(),'October 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element4);
		//Assertion gets successful when element is displayed
		Thread.sleep(3000); 
		//waits for 3 seconds
	}
	@Then("^Close the  browser$")
	public void close_the_browser1()  {
		driver.close();
		//Browser is closed

	}
	
	
	
	//4th Scenario
	
	
	@Given("^User is Logged in and directed to Personal Agenda page$")
	public void user_is_logged_in_and_directed_to_personal_agenda_page1() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Launches chrome browser
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button
		driver.findElement(By.xpath("//a[contains(text(),'Personal agenda')]")).click();
		//clicks on Personal Agenda
	}

	@When("^User Clicks on red colured icon and clicks on week,today options$")
	public void user_clicks_on_red_colured_icon_and_clicks_on_weektoday_options() throws Throwable {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
		//clicks on red colured icon
		Thread.sleep(1000);
		//waits for 1 seconds
		driver.findElement(By.xpath("//button[contains(text(),'week')]")).click();
		//clicks on red week button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/button[3]/span[1]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'today')]")).click();
		//clicks on today button
		Thread.sleep(1000);
	}

	@Then("Current running week is displayed")
	public void current_running_week_is_displayed() throws InterruptedException {
		boolean Element4 =  driver.findElement(By.xpath("//h2[contains(text(),'22 – 28 Nov 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element4);
		//Assertion gets successful when element is displayed
		Thread.sleep(2000);
		//waits for 2 seconds
	}
	@And("click on > button")
	public void click_on_button1() {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/button[3]/span[1]")).click();
		//clicks on > button
	}

	@Then("^Succeeding week is displayed$")
	public void succeeding_week_is_displayed() throws Throwable {
		boolean Element =  driver.findElement(By.xpath("//h2[contains(text(),'29 Nov – 5 Dec 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element);
		//Assertion gets successful when element is displayed
		Thread.sleep(3000);
		//waits for 3 seconds
	}
	@And("^click on today$")
	public void click_on_today1() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'today')]")).click();
		//clicks on today button
		Thread.sleep(3000);
		//waits for 3 seconds		
	}

	@Then("^again Current running week is displayed$")
	public void again_current_running_week_is_displayed() throws Throwable {
		boolean Element =  driver.findElement(By.xpath("//h2[contains(text(),'22 – 28 Nov 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element);
		//Assertion gets successful when element is displayed
		Thread.sleep(3000);
		//waits for 3 seconds		
	}
	@And("^click on < button$")
	public void click_on_button111() throws Throwable {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/button[2]/span[1]")).click();
		//clicks on < button
	}

	@Then("^Preceeding week is displayed$")
	public void preceeding_week_is_displayed() throws Throwable {
		boolean Element =  driver.findElement(By.xpath("//h2[contains(text(),'15 – 21 Nov 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element);
		//Assertion gets successful when element is displayed
		Thread.sleep(3000);
		//waits for 3 seconds
	}

	@Then("^close the  browser$")
	public void close_the_browser11() throws Throwable {
		driver.close();
		//browser is closed
	}
	
	
	//5th Scenario
	
	
	
	@Given("^User is logged in and Directed to personal agenda Page$")
	public void user_is_logged_in_and_directed_to_personal_agenda_page0() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waits for 10 seconds until no action takes 
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button
		driver.findElement(By.xpath("//a[contains(text(),'Personal agenda')]")).click();
		//Launches chrome browser 
	}

	@When("^User Clicks on red colured icon and clicks on day option$")
	public void user_clicks_on_red_colured_icon_and_clicks_on_day_option() throws Throwable {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
		//clicks on red coloured
		Thread.sleep(1000);
		//waits for 1 second
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[2]/div[1]/button[3]")).click();
		//clicks on day button
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/button[3]/span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'today')]")).click();
		//clicks on today button
		Thread.sleep(1000);

	}

	@Then("^Current running day is displayed which is highlighted$")
	public void current_running_day_is_displayed_which_is_highlighted() throws Throwable {
		boolean Element5 =  driver.findElement(By.xpath("//h2[contains(text(),'22 November 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element5);
		//Assertion gets successful when element is displayed
		Thread.sleep(2000);
		//waits for 3 seconds
	}
	@And("click on > buttoN")
	public void click_on_butto_n9() throws Throwable {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/button[3]/span[1]")).click();
		//clicks on > button
		Thread.sleep(2000);
		//waits for 2 seconds
	}



	@Then("^Succeeding day is displayed$")
	public void succeeding_day_is_displayed() throws Throwable {
		boolean Element5 =  driver.findElement(By.xpath("//h2[contains(text(),'23 November 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element5);
		//Assertion gets successful when element is displayed
		Thread.sleep(2000);
		//waits for 2 seconds
	}
	@And("^click on todaY$")
	public void click_on_today8() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'today')]")).click();
		//clicks on today button
		Thread.sleep(2000);
		//waits for 2 seconds
	}
	@Then("^again Current running day is displayed$")
	public void again_current_running_day_is_displayed() throws Throwable {
		boolean Element5 =  driver.findElement(By.xpath("//h2[contains(text(),'22 November 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element5);
		//Assertion gets successful when element is displayed
		Thread.sleep(2000);
		//waits for 3 seconds
	}
	@Then("click on < buttoN")
	public void click_on_butto_n() throws InterruptedException {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/button[2]/span[1]")).click();
		//clicks on < button
		Thread.sleep(2000);
		//waits for 2 seconds
	}


	@Then("^Preceeding day is displayed$")
	public void preceeding_day_is_displayed() throws Throwable {
		boolean Element5 =  driver.findElement(By.xpath("//h2[contains(text(),'21 November 2021')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element5);
		//Assertion gets successful when element is displayed
		Thread.sleep(2000);
		//waits for 2 seconds
	}

	@Then("^close the  Browser$")
	public void close_the_browser111() throws Throwable {
		driver.close();
		//browser is closed
	}

    //6th Scenario
	
	
	@Given("^Login with credentials and click Red icon$")
	public void login_with_credentials_and_click_red_icon() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waits for 10 seconds until no action takes 
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button
		driver.findElement(By.xpath("//a[contains(text(),'Personal agenda')]")).click();
		//clicks on Personal Agenda
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
		//clicks on red colured icon
		Thread.sleep(1000);
		//waits for 1 second
	}

	@Then("^click on any date$")
	public void click_on_any_date() throws Throwable {
		driver.findElement(By.xpath("//body[1]/main[1]/section[1]/div[1]/div[2]/div[1]/section[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]")).click();
		Thread.sleep(3000);
		//waits for 3 seconds
	}
	@And("^give event details and click add$")
	public void give_event_details_and_click_add() throws Throwable {
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Selenium test");
		//fills the event text box
		Thread.sleep(3000);
		//waits for 3 seconds
		driver.findElement(By.xpath("//span[contains(text(),'Add')]")).click();
		//clicks on add button
	}

	@Then("^Verify event details$")
	public void verify_event_details() throws Throwable {
		boolean Element6 =  driver.findElement(By.xpath("//span[contains(text(),'Selenium test')]")).isDisplayed();
		//returns true or false whether it is displayed or not
		Assert.assertEquals(true, Element6);
		//Assertion gets successful when element is displayed
		Thread.sleep(2000);
		//waits for 3 seconds
	}
	@And("^quit this Browser$")
	public void quit_this_browser() throws Throwable {
		driver.close();
		//Browser is closed
	}
	
	//7th Scenario
	
	
	@Given("^Login with credentials and click Red__icon$")
	public void login_with_credentials_and_click_redicon() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waits for 10 seconds until no action takes 
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button
		driver.findElement(By.xpath("//a[contains(text(),'Personal agenda')]")).click();
		//clicks on Personal Agenda
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
		//clicks on red colured icon
		Thread.sleep(1000);
		//waits for 1 seconds
	}

	@When("^click on agenda_list$")
	public void click_on_agendalist() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Agenda list')]")).click();
		//clicks on agenda list
		Thread.sleep(1000);
		//waits for 1 second

	}

	@Then("^All saved events can be seen$")
	public void all_saved_events_can_be_seen() throws Throwable {
		Thread.sleep(7000);
		//waits for 7 seconds

	}
	@And("^you can close the window$")
	public void you_can_close_the_window() throws Throwable {
		driver.close();
		//browser is closed
	}
	
	
	//8th Scenario

	@Given("^login with credentials and reach personal agenda$")
	public void login_with_credentials_and_reach_personal_agenda() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waits for 10 seconds until no action takes 
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button
		driver.findElement(By.xpath("//a[contains(text(),'Personal agenda')]")).click();
		//clicks on Personal Agenda
		Thread.sleep(1000);
		//waits for 3 seconds
	}

	@Then("^click on Blue Coloured icon$")
	public void click_on_blue_coloured_icon() throws Throwable {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/a[2]/img[1]")).click();
		//clicks on blue coloured icon
	}

	@And("^Agenda list is displayed$")
	public void agenda_list_is_displayed() throws Throwable {
		Thread.sleep(3000);
		//waits for 3 seconds
	}

	@Then("^quit and close$")
	public void quit_and_close() throws Throwable {
		driver.close();
		//browser is closed
	}
	
	
	//9th Scenario
	
	
	
	@Given("^login with credentials and Reach personal agenda$")
	public void login_with_credentials_and_Reach_personal_agenda() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/redavid/OneDrive - Capgemini/Desktop/chrome driver/chromedriver.exe");
		driver= new ChromeDriver();
		//Launches chrome browser 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waits for 10 seconds until no action takes 
		driver.manage().window().maximize();
		//maximizes chrome browser
		driver.get("http://elearningm1.upskills.in/");
		//navigates to login page page of E-Learning site
		driver.findElement(By.id("login")).sendKeys("Deekshith");
		//fills username textbox as deekshith
		driver.findElement(By.name("password")).sendKeys("qwertyQ1@");
		//fills password textbox
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
		//clicks on login button
		driver.findElement(By.xpath("//a[contains(text(),'Personal agenda')]")).click();
		//clicks on Personal Agenda
		Thread.sleep(1000);
		//waits for 3 seconds
	}

	@Then("^click on Blue Coloured icon with dots$")
	public void click_on_blue_coloured_icon_with_dots() throws Throwable {
		driver.findElement(By.xpath("//body/main[@id='main']/section[@id='cm-content']/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/a[3]/img[1]")).click();
		//clicks on blue coloured icon with
	}

	@And("^sessions is displayed$")
	public void sessions_is_displayed() throws Throwable {
		Thread.sleep(3000);
		//waits for 3 seconds
	}

	@Then("^quit , close$")
	public void quit_close() throws Throwable {
		driver.close();
		//Browser is closed
	}



}

