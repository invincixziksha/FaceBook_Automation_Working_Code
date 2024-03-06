package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage extends StartupPage {
	//please write all the locators for facebook page only 

	By loginButton = By.xpath("//button[@name='login']"); 
	By EmailAddsPhoneNumberTextbox = By.xpath("//input[@placeholder='Email address or phone number']"); 
	By passwordTextbox = By.xpath("//input[@placeholder='Password']"); 
	By profileIconImage = By.xpath("(//div//div//span)[14]"); 
	By logoutButton = By.xpath("//span[contains(text (), 'Log out')]"); 
	By forgettenPasswordLink = By.xpath("//a[.='Forgotten password?']"); 
	By createNewAccountLink = By.xpath("//a[contains(text() , 'Create new account')]"); 
	By emailTextField = By.id("email"); 
	By errorMessage1 = By.xpath("//div[@id='email_container']//div[2]"); 
	By errorMessage2 = By.xpath("//div[@id='email_container']//div[2]/a"); 
	 
	 
	 
	 
	 
	public FaceBookPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // Initialize Page Factory
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * about this method validateFacebookTitleOfLoginPage() 
	 * @param : null
	 * @description : it is getting the page title and return the same,
	 * @return : title of string type
	 * @author : Yaksha
	 */
	public String validateFacebookTitleOfLoginPage() throws Exception {
		try {
			
		String currentPageTitle	=  driver.getTitle();
		System.out.println("Title of the Login Page : " + currentPageTitle );
		return currentPageTitle;
		}catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * about this method facebookLoginForm() 
	 * @param : Map<String, String> expectedData
	 * @description : it is fill the forms and click on  login button  ,
	 * @return : null
	 * @author : Yaksha
	 */
	public FaceBookPage facebookLoginForm(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.sendKeys(EmailAddsPhoneNumberTextbox,expectedData.get("emailAddsPhoneNumber"));	
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));
			commonEvents.click(loginButton);
			Thread.sleep(5000);
			commonEvents.click(profileIconImage);
			
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);
	}
	
	/**
	 * about this method verifyPresenceOfALlFields() 
	 * @param : null
	 * @description : it is verify all fields is present or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyPresenceOfALlFields() throws Exception {
		try {
			if(commonEvents.isDisplayed(EmailAddsPhoneNumberTextbox)&&
			commonEvents.isDisplayed(passwordTextbox)&&
			commonEvents.isDisplayed(forgettenPasswordLink)&&
			commonEvents.isDisplayed(createNewAccountLink)) {
			return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
		
	}
	
	/**
	 * about this method validateErrorMessage() 
	 * @param : null
	 * @description : get the error message and validate the error message ,
	 * @return : title of string type
	 * @author : Yaksha
	 */
	public String validateErrorMessage() throws Exception {
		try {
			commonEvents.click(loginButton);
			commonEvents.waitTillElementLocated(emailTextField, 60);
			String ErrorMessageValue =  commonEvents.getText(errorMessage1) + commonEvents.getText(errorMessage2);
			
			return ErrorMessageValue ;
			
		}catch(Exception e) {
			throw e;
		}
	}
}
