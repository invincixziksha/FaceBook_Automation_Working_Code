package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Facebook_L2_Pages extends StartupPage 
{
	By loginButton = By.xpath("//button[@name='login']"); 
	By emailAddsPhoneNumberTextbox = By.xpath("//input[@placeholder='Email address or phone number']"); 
	By passwordTextbox = By.xpath("//input[@placeholder='Password']"); 
	By createNewAccount = By.xpath("//a[contains(text(),'Create new account')]"); 
	By signUpButton = By.xpath("//button[@name=\"websubmit\"]"); 
	By nameFieldErorMessage = By.xpath("//div[@id='js_134']"); 
	By firstNameTextField = By.xpath("//input[@name=\"firstname\"]"); 
	By surNameTextField = By.xpath("//input[@name=\"lastname\"]"); 
	By mobileNumberAndPassword = By.xpath("//input[@name=\"reg_email__\"]"); 
	By newPassword = By.xpath("(//input[@type=\"password\"])[2]"); 
	By profile = By.xpath("(//span[.='Shibu Dharshan'])[1]"); 
	By profileName = By.xpath("//h1[contains(text(),'Shibu Dharshan')]"); 
	By updateProfilePicture = By.xpath("//div[@aria-label=\"Update profile picture\"]"); 
	By uploadPhoto = By.xpath("//span[contains(text(),'Upload Photo')]"); 
	By saveButton = By.xpath("(//span[.='Save'])[1]"); 
	By editProfileButton=By.xpath("//span[contains(text(),'Edit profile')]");
	By addButtonInsideBioSection=By.xpath("(//span[.='Add'])[3]");
	By describeWhoAreYouTextField=By.xpath("//textarea[@aria-label=\"Enter bio text\"]");
	By saveButtonPresentInsideTheBioSection=By.xpath("(//span[.='Save'])[2]");
	By xButton=By.xpath("//div[contains(@class,'x92rtbv x10l6tqk x1tk7jg1 x1vjfeg')]");
	By addBioButton=By.xpath("(//span[.='Add Bio'])[2]");
	By aboutSection=By.xpath("//span[.='About']");
	By workAndEducationSection=By.xpath("//span[.='Work and education']");
	By addUniversityIcon=By.xpath("//span[contains(text(),'Add university')]");
	By schoolTextField=By.xpath("//input[@aria-label=\"School\"]");
	By upperArrowButtonToHideTheYouMayKnowSection=By.xpath("//div[@data-pagelet='ProfileActions']//i");
	By addWorkplaceButton=By.xpath("//span[contains(text(),'Add a workplace')]");
	By companyTextField=By.xpath("//input[@aria-label=\"Company\"]");	
	By addCurrentCityButton=By.xpath("//span[.='Add current city']");
	By currentCityTextField=By.xpath("//input[@aria-label=\"Current town/city\"]");
	By addHomeTownButton=By.xpath("//span[.='Add home town']");
	By homeTownTextField=By.xpath("//input[@aria-label=\"Home town\"]");
	By cancelButton=By.xpath("(//div[@aria-label=\"Cancel\"])[1]");
	By addSecondarySchoolButton=By.xpath("//span[.='Add secondary school']");
	By schoolTextFieldPresentInsideSecondarySchoolTextField=By.xpath("//input[@aria-label=\"School\"]");
	By addRelationshipStatusButton=By.xpath("//span[.='Add a relationship status']");
	By stausDropdown=By.xpath("//span[contains(text(),'Status')]");
	By selectSingle=By.xpath("//span[contains(text(),'Single')]");
	By accountIcon=By.xpath("(//div[contains(@class,\"x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z\")])[1]");
	By leavePageButton=By.xpath("(//span[.='Leave Page'])[3]");
	By LogoutButton=By.xpath("//span[contains(text(),'Log out')]");
	By notificationLink =By.xpath("//a[@aria-label='Notifications']");

	public Facebook_L2_Pages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // Initialize Page Factory
	}

	/**@Test1
	 * about this method loginToFacebookByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill emailAddsPhoneNumberTextbox then enter data in passwordTextbox and click on login button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToFacebookByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.sendKeys(emailAddsPhoneNumberTextbox,expectedData.get("Username"));	
			commonEvents.sendKeys(passwordTextbox,expectedData.get("Password"));
			commonEvents.click(loginButton);

		}catch(Exception e) {
			throw e;
		}
		return true;
	}

	/**@Test2
	 * about this method afterLoggedinValidateTheTitleOfFacebookHomePage() 
	 * @param : null
	 * @description : print the title of the home page after logged in and verify the title of the home page
	 * @return : String
	 * @author : Yaksha
	 */
	public String afterLoggedinValidateTheTitleOfFacebookHomePage() throws Exception {
		try {
			commonEvents.click(notificationLink);
			commonEvents.click(notificationLink);
			String currentPageTitle	=  driver.getTitle();
			System.out.println("Title of the Home Page after logged in:" + currentPageTitle );
			return currentPageTitle;
		}catch(Exception e) {
			throw e;
		}
	}

	/**@Test3
	 * about this method clickonProfileIconAndValidateTheProfileName() 
	 * @param : null
	 * @description :click on the profile and validate the profile name
	 * @return : String
	 * @author : Yaksha
	 */
	public String clickonProfileAndValidateTheProfileName() throws Exception {
		try {
			commonEvents.click(profile);
			String profilename=commonEvents.getText(profileName);
			System.out.println("Profile name is :"+profilename);
			return profilename;
		}catch(Exception e) {
			throw e;
		}
	}

	/**@Test4
	 * about this method clickOnUpdateProfilePicture_and_UploadProfilePicture() 
	 * @param : String
	 * @description :click on update profile picture and click on upload photo and upload photo then click on save button
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnUpdateProfilePicture_and_UploadProfilePicture(String pathOfTheFile) throws Exception {
		try {
			commonEvents.jsClick(updateProfilePicture);
			Thread.sleep(3000);
			commonEvents.click(uploadPhoto);
			Thread.sleep(3000);
			//			set the path of the image as per your system
			String pathOftheFile="C:\\Users\\Surya Prakash\\Downloads\\uploadPhotos.jpg";
			Thread.sleep(3000);
			commonEvents.fileUpload(pathOftheFile);
			Thread.sleep(3000);
			commonEvents.click(saveButton);
			Thread.sleep(3000);

		}catch(Exception e) {
			throw e;
		}
		return true;
	}

	/**@Test5
	 * about this method clickOnEditProfileAndFillTheDetailInBioSection() 
	 * @param : Map<String, String> 
	 * @description :Click on edit profile then click on the add button inside the bio section and enter data in bio section then click on "X" button.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnEditProfileAndFillTheDetailInBioSection(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.jsClick(editProfileButton);
			Thread.sleep(3000);
			commonEvents.click(addButtonInsideBioSection);
			commonEvents.sendKeys(describeWhoAreYouTextField,expectedData.get("Bio_Section"));
			driver.navigate().refresh();
		}catch(Exception e) {
			throw e;
		}
		return true;
	}

	/**@Test6
	 * about this method clickOnPostsandGoToIntroSectionAndAddDetailsInAddBio() 
	 * @param : String
	 * @description :Click on edit profile then click on the add button inside the bio section and enter data in bio section then click on "X" button.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnPostsandGoToIntroSectionAndAddDetailsInAddBio(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.click(addBioButton);
			commonEvents.sendKeys(describeWhoAreYouTextField,expectedData.get("Bio_Section"));
		}catch(Exception e) {
			throw e;
		}
		return true;

	}

	/**@Test7
	 * about this method clickOnAboutAndGoIntoOverviewAndAddUniversity() 
	 * @param : Map<String, String>
	 * @description :Click on about section then go to overview section then click on addUniversityIcon then enter data in the school text field.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAboutAndGoIntoOverviewAndAddUniversity(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.click(aboutSection);
			commonEvents.jsClick(addUniversityIcon);
			commonEvents.sendKeys(schoolTextField,expectedData.get("university_name"));

		}catch(Exception e) {
			throw e;
		}
		return true;

	}


	/**@Test8
	 * about this method clickonAddWorkplaceAndAddCompanyName() 
	 * @param : Map<String, String>
	 * @description :Click on about section then go to overview section then click on addUniversityIcon then enter data in the school text field.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickonAddWorkplaceAndAddCompanyName(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.click(addWorkplaceButton);
			commonEvents.sendKeys(companyTextField,expectedData.get("Company_name_textfield"));
		}catch(Exception e) {
			throw e;
		}
		return true;

	}
	/**@Test9
	 * about this method clickOnAddHomeTownandAddHomeTown() 
	 * @param : Map<String, String>
	 * @description :Refresh the page and click on upper arrow button to hide the you may know section 
	 * 				then click on addHomeTownButton and fill data in the homeTownTextField. 
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAddHomeTownandAddHomeTown(Map<String, String> expectedData) throws Exception {
		try {
			driver.navigate().refresh();
			commonEvents.click(upperArrowButtonToHideTheYouMayKnowSection);
			commonEvents.click(addHomeTownButton);
			Thread.sleep(3000);
			commonEvents.sendKeys(homeTownTextField,expectedData.get("hometown_textfield"));
		}catch(Exception e) {
			throw e;
		}
		return true;

	}

	/**@Test10
	 * about this method clickOnAddCurrentCityandAddCurrentCity() 
	 * @param : Map<String, String>
	 * @description :Refresh the page and click on upper arrow button to hide the you may know section 
	 * 				then click on add current city and fill data in the current city text field. 
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAddCurrentCityandAddCurrentCity(Map<String, String> expectedData) throws Exception {
		try {
			driver.navigate().refresh();
			commonEvents.click(upperArrowButtonToHideTheYouMayKnowSection);
			commonEvents.click(addCurrentCityButton);
			Thread.sleep(3000);
			commonEvents.sendKeys(currentCityTextField,expectedData.get("current_city"));
		}catch(Exception e) {
			throw e;
		}
		return true;

	}

	/**@Test11
	 * about this method clickOnAddSecondarySchoolandAddSchool() 
	 * @param : Map<String, String>
	 * @description :Refresh the page and click on upper arrow button to hide the you may know section 
	 * 				then click on addSecondarySchoolButton and fill data in the schoolTextFieldPresentInsideSecondarySchoolTextField. 
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAddSecondarySchoolandAddSchool(Map<String, String> expectedData) throws Exception {
		try {
			driver.navigate().refresh();
			commonEvents.click(upperArrowButtonToHideTheYouMayKnowSection);
			commonEvents.click(addSecondarySchoolButton);
			Thread.sleep(3000);
			commonEvents.sendKeys(schoolTextFieldPresentInsideSecondarySchoolTextField,expectedData.get("Secondary_School"));
		}catch(Exception e) {
			throw e;
		}
		return true;

	}

	/**@Test12
	 * about this method clickOnAddRelationshipStatusandAddRelationshipStatusAsSingle() 
	 * @param : Map<String, String>
	 * @description :Refresh the page and click on upper arrow button to hide the you may know section 
	 * 				then click on addRelationshipStatusButton and Set the relationship status as single.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAddRelationshipStatusandAddRelationshipStatusAsSingle(Map<String, String> expectedData) throws Exception {
		try {
			driver.navigate().refresh();
			commonEvents.click(upperArrowButtonToHideTheYouMayKnowSection);
			commonEvents.click(addRelationshipStatusButton);
			Thread.sleep(3000);
			commonEvents.click(stausDropdown);
			commonEvents.click(selectSingle);
		}catch(Exception e) {
			throw e;
		}
		return true;

	}

	/**@Test13
	 * about this method gotoThePreviousPageAndClickOnAccount() 
	 * @param : null
	 * @description : going to the previous page then click on leave page button and click on Account icon which is present at the top right corner
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean gotoThePreviousPageAndClickOnAccount() throws Exception {
		try {
			driver.navigate().back();
			commonEvents.click(leavePageButton);
			commonEvents.jsClick(accountIcon);
		}catch(Exception e) {
			throw e;
		}
		return true;

	}
	/**@Test14
	 * about this method clickOnTheLogoutButton() 
	 * @param : null
	 * @description : Click on the logout button 
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickonTheLogoutButton() throws Exception {
		try {
			commonEvents.isDisplayed(LogoutButton);
			commonEvents.click(LogoutButton);
		}catch(Exception e) {
			throw e;
		}
		return true;

	}

}