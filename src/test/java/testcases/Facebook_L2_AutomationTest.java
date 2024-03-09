package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.Facebook_L2_Pages;
import pages.StartupPage;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class Facebook_L2_AutomationTest  extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	StartupPage startupPage;
	Facebook_L2_Pages FaceBookPageInstance;
	LocatorsFactory LocatorsFactoryInstance = new LocatorsFactory(driver);
	
	
	@Parameters({"browser", "environment"})
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readJson(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);
		
		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl, configData.get("url")+" might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}
	
	@Test(priority = 1, groups = {"sanity"}, description="login the facebook by given valid credetial")
	public void loginTheFacebookByGivenValidCredetial() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
		Assert.assertTrue(FaceBookPageInstance.loginToFacebookByGivenValidCredetial(expectedData1),"Login failed, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.accountIconIsPresent(driver).isDisplayed(), "accountIcon is not present, Please check manually");	
	}
	@Test(priority = 2, groups = {"sanity"}, description="after Logged In, Validate the title of Facebook Home Page")
	public void afterLoggedInValidateTheTitleOfFacebookHomePage() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
		Assert.assertEquals(FaceBookPageInstance.afterLoggedinValidateTheTitleOfFacebookHomePage(), expectedData.get("pageTitle_after_loggedin"));
		Assert.assertTrue(LocatorsFactoryInstance.accountIconIsPresent(driver).isDisplayed(), "accountIcon is not present, Please check manually");	
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="ClickOn Profile Icon and Validate the Profile Name")
	public void clickOnProfileAndValidateTheProfileName() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
		Assert.assertEquals(FaceBookPageInstance.clickonProfileAndValidateTheProfileName(), expectedData.get("ProfileName"));
		Assert.assertTrue(LocatorsFactoryInstance.editProfileButtonIsPresent(driver).isDisplayed(), "Edit profile button is not present, Please check manually");	
	}
	@Test(priority = 4, groups = {"sanity"}, description="Upload a profile Picture ")
	public void clickOnUpdateProfilePictureAndUploadProfilePicture() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
	    Assert.assertTrue(FaceBookPageInstance.clickOnUpdateProfilePicture_and_UploadProfilePicture(null),"Failed to Upload profile picture, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.editProfileButtonIsPresent(driver).isDisplayed(), "Edit profile button is not present, Please check manually");	
	}
	@Test(priority = 5, groups = {"sanity"}, description="click On Edit Profile And fill The Detail In Bio Section")
	public void clickOnEditProfileandillTheDetailInBioSection() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
	    Assert.assertTrue(FaceBookPageInstance.clickOnEditProfileAndFillTheDetailInBioSection(expectedData1),"Not able to add the bio section, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.addToStoryButtonIsPresent(driver).isDisplayed(), "addToStory Button button is not present, Please check manually");	
	}
	@Test(priority = 6, groups = {"sanity"}, description="click On Posts and Go to Intro Section and Add Details In Add Bio")
	public void clickOnPostsAndGoToIntroSectionAndAddDetailsInAddBio() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
	    Assert.assertTrue(FaceBookPageInstance.clickOnPostsandGoToIntroSectionAndAddDetailsInAddBio(expectedData1),"Not able to add the bio section, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.editDetailsFieldIsPresent(driver).isDisplayed(), "Edit details button is not present, Please check manually");	
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="click On About and Go Into overview and Education and add university")
	public void clickOnAboutAndGoIntoOverviewAndAddUniversity() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAboutAndGoIntoOverviewAndAddUniversity(expectedData1),"Not able to add the university, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.workAndEducationIconIsPresent(driver).isDisplayed(), "Work and Education button is not present, Please check manually");	
	}
	@Test(priority = 8, groups = {"sanity"}, description="Click on add a workplace and add company name")
	public void clickOnAddWorkplaceAndAddCompanyName() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickonAddWorkplaceAndAddCompanyName(expectedData1),"Not able to add the company name, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.companyTextFieldIsPresent(driver).isDisplayed(), "company TextField button is not present, Please check manually");	
	}
	@Test(priority = 9, groups = {"sanity"}, description="Click on add home town and add home town")
	public void clickOnAddHomeTownAndAddHomeTown() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAddHomeTownandAddHomeTown(expectedData1),"Not able to add the Home town, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.homeTownTextFieldIsPresent(driver).isDisplayed(), "HomeTown TextField button is not present, Please check manually");	
	}
	@Test(priority = 10, groups = {"sanity"}, description="Click on add a current city and add current city")
	public void clickOnAddCurrentCityAndAddCurrentCity() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAddCurrentCityandAddCurrentCity(expectedData1),"Not able to add the Current City, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.currentCityTextFieldIsPresent(driver).isDisplayed(), "HomeTown TextField button is not present, Please check manually");	
	}
	@Test(priority = 11, groups = {"sanity"}, description="Click on Add secondary school and add school")
	public void clickOnAddSecondarySchoolAndAddSchool() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAddSecondarySchoolandAddSchool(expectedData1),"Not able to add the School, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.schoolTextFieldPresentInsideSecondarySchoolTextFieldIsPresent(driver).isDisplayed(), "School TextField button is not present, Please check manually");	
	}
	@Test(priority = 12, groups = {"sanity"}, description="Click on add relationship status and add relationship status as single")
	public void clickOnAddRelationshipStatusAndAddRelationshipStatusAsSingle() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAddRelationshipStatusandAddRelationshipStatusAsSingle(expectedData1),"Not able to update the relationship status, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.workAndEducationIconIsPresent(driver).isDisplayed(), "Work and Education button is not present, Please check manually");	
	}
	@Test(priority = 13, groups = {"sanity"}, description="Go to the previous page and click on Account at the right top corner")
	public void goToThePreviousPageAndClickOnAccount() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
	    Assert.assertTrue(FaceBookPageInstance.gotoThePreviousPageAndClickOnAccount(),"Not able to click the Accout icon, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.logOutButtonIsPresent(driver).isDisplayed(), "LogOut button is not present, Please check manually");	
	}
	@Test(priority = 14, groups = {"sanity"}, description="After that click on logout button")
	public void clickOnLogoutButton() throws Exception {
		FaceBookPageInstance = new Facebook_L2_Pages(driver);
	    Assert.assertTrue(FaceBookPageInstance.clickonTheLogoutButton(),"logout failed, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.getEmailAddsPhoneNumberTextfield(driver).isDisplayed(), "Login button is not present, Please check manually");	
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}
	
	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}
}