package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsFactory extends StartupPage {
	//please write all the locators for facebook page only 
	
	By loginButton = By.xpath("//button[@name='login']"); 
	By EmailAddsPhoneNumberTextbox = By.xpath("//input[@placeholder='Email address or phone number']"); 
	By passwordTextbox = By.xpath("//input[@placeholder='Password']"); 
	By profileIconImage = By.xpath("(//div//div//span)[14]"); 
	By logoutButton = By.xpath("//span[contains(text (), 'Log out')]"); 
	By forgettenPasswordLink = By.xpath("//a[.='Forgotten password?']"); 
	By createNewAccountLink = By.xpath("//a[contains(text() , 'Create new account')]"); 
	By emailTextField = By.id("email"); 
	

	 
	public LocatorsFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	//Expected data will be fetch from config.json file,path of the json file is:FaceBook_Automation_Dummy/src/main/resources/config.json

	public WebElement getLoginButton(WebDriver driver) {
		WebElement loginButtonWebElement = driver.findElement(loginButton);
    return loginButtonWebElement;
}
	
	
	public WebElement getEmailAddsPhoneNumberTextfield(WebDriver driver) {
		WebElement EmailAddsPhoneNumberWebElement = driver.findElement(EmailAddsPhoneNumberTextbox);
        return EmailAddsPhoneNumberWebElement;
    }
	
	public WebElement getPasswordTextfield(WebDriver driver) {
		WebElement EmailAddsPhoneNumberWebElement = driver.findElement(passwordTextbox);
        return EmailAddsPhoneNumberWebElement;
    }
	
	public WebElement getLogOutButton(WebDriver driver) {
		WebElement logoutButtonWebElement = driver.findElement(logoutButton);
        return logoutButtonWebElement;
    }
	
	public WebElement forgettenPasswordLink(WebDriver driver) {
		WebElement forgettenPasswordLinkWebElement = driver.findElement(forgettenPasswordLink);
        return forgettenPasswordLinkWebElement;
    }
	
	public WebElement createNewAccountLink(WebDriver driver) {
		WebElement createNewAccountLinkWebElement = driver.findElement(createNewAccountLink);
        return createNewAccountLinkWebElement;
    }
	
	public WebElement emailTextField(WebDriver driver) {
		WebElement createNewAccountLinkWebElement = driver.findElement(emailTextField);
        return createNewAccountLinkWebElement;
    }
	
}
