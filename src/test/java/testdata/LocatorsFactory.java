package testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.StartupPage;

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
	By FacebookPageTitle = By.xpath("//title[@id='pageTitle']");
	By createNewAccount = By.xpath("//a[contains(text() , 'Create new account')]"); 
	
	By SignUpButton = By.xpath("//button[@name=\"websubmit\"]"); 
	By FirstNameTextField = By.xpath("//input[@name=\"firstname\"]"); 
	By newPassword = By.xpath("(//input[@type=\"password\"])[2]");
	By selectBirthDayMonth = By.xpath("//select[@name='birthday_month']");
	By selectBirthDayYear = By.xpath("//select[@name='birthday_year']");
	By selectMaleRadioButton = By.xpath("//label[contains(text() , 'Male')]");
	By selectFemaleRadioButton = By.xpath("//label[contains(text() , 'Female')]");
	By customRadioButton = By.xpath("//label[contains(text() , 'Custom')]");
	By selectYourPronounDropdown = By.xpath("//select[@name='preferred_pronoun']");
	By genderOptionalTextBox = By.xpath("//input[@name='custom_gender']");
	
	

	 
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
		WebElement passwordWebElement = driver.findElement(passwordTextbox);
        return passwordWebElement;
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
		WebElement emailTextFieldWebElement = driver.findElement(emailTextField);
        return emailTextFieldWebElement;
    }
	
	public WebElement getFacebookPageTitle(WebDriver driver) {
		WebElement FacebookPageTitleWebElement = driver.findElement(FacebookPageTitle);
        return FacebookPageTitleWebElement;
    }
	
	public WebElement getCreateNewAccount(WebDriver driver) {
		WebElement CreateNewAccountWebElement = driver.findElement(createNewAccount);
        return CreateNewAccountWebElement;
    }
	
	public WebElement signUpButton(WebDriver driver) {
		WebElement SignUpButtonWebElement = driver.findElement(SignUpButton);
        return SignUpButtonWebElement;
    }
	public WebElement firstNameTextField(WebDriver driver) {
		WebElement firstNameTextFieldWebElement = driver.findElement(FirstNameTextField);
        return firstNameTextFieldWebElement;
    }
	
	public WebElement newpasswordTextField(WebDriver driver) {
		WebElement newPasswordWebElement = driver.findElement(newPassword);
        return newPasswordWebElement;
    }
	
	public WebElement selectBirthDayMonth(WebDriver driver) {
		WebElement selectbirthdayMonthWebElement = driver.findElement(selectBirthDayMonth);
        return selectbirthdayMonthWebElement;
    }
	
	public WebElement selectBirthDayYear(WebDriver driver) {
		WebElement selectBirthDayYearWebElement = driver.findElement(selectBirthDayYear);
        return selectBirthDayYearWebElement;
    }
	
	public WebElement femaleRadioButton(WebDriver driver) {
		WebElement selectFemaleRadioButtonWebElement = driver.findElement(selectFemaleRadioButton);
        return selectFemaleRadioButtonWebElement;
    }
	
	public WebElement maleRadioButton(WebDriver driver) {
		WebElement selectMaleRadioButtonWebElement = driver.findElement(selectMaleRadioButton);
        return selectMaleRadioButtonWebElement;
    }
	
	public WebElement customRadioButton(WebDriver driver) {
		WebElement customRadioButtonWebElement = driver.findElement(customRadioButton);
        return customRadioButtonWebElement;
    }
	
	public WebElement selectYourPronounDropdown(WebDriver driver) {
		WebElement selectYourPronounDropdownWebElement = driver.findElement(selectYourPronounDropdown);
        return selectYourPronounDropdownWebElement;
    }
	
	public WebElement genderOptionalTextBox(WebDriver driver) {
		WebElement genderOptionalTextBoxWebElement = driver.findElement(genderOptionalTextBox);
        return genderOptionalTextBoxWebElement;
    }
	
}
