package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.FaceBookL2Pages;
import pages.StartupPage;
import testBase.AppTestBase;

public class FaceBook_L2_AutomationTest extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	StartupPage startupPage;
	FaceBookL2Pages FaceBookPageInstance;

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
	
	@Test(priority = 1, groups = {"sanity"}, description="after Logged In, Validate the title of Facebook Home Page ")
	public void validateFacebookHomePage() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method validateTheFacebookHomePage() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "HomePage_Title");
		softAssert.assertEquals(FaceBookPageInstance.validateTheFacebookHomePage(), expectedData.get("pageTitle"), 
				"page title is not matching please check manually");
	}
	@Test(priority = 2, groups = {"sanity"}, description="ClickOn Profile Icon and Validate the Profile Name ")
	public void validateProfileName() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method clickOnProfileAndValidateProfileName() has to be implemented by the implementor
		String pages=FaceBookPageInstance.clickOnProfileAndValidateProfileName();
		softAssert.assertNotNull(pages);
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="ClickOn Profile Name and upload the profile Picture ")
	public void uploadProfilePicture() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method clickonProfileNameAndUploadProfilePhotos() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.clickonProfileNameAndUploadProfilePhotos();
		softAssert.assertNotNull(pages);

	}
	
	@Test(priority = 4, groups = {"sanity"}, description="clickOn Add Cover Photo and Upload a cover photo")
	public void uploadCoverPhoto() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method uploadCoverPhoto() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.uploadCoverPhoto();
		softAssert.assertNotNull(pages);

	}
	
	@Test(priority = 5, groups = {"sanity"}, description="click On Edit Profile And fill The Detail In Bio Section")
	public void clickOnEditProfileAddDetailsInBioSections() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method clickOnEditProfileAndfillTheDetailInBioSection() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.clickOnEditProfileAndfillTheDetailInBioSection();
		softAssert.assertNotNull(pages);
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="click On Posts and Go Into and Add Details In Add Bio")
	public void clicOnPostGoToIntoAddDetailsInAddBio() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method clicOnPostGoToIntoAddDetailsInAddBio() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.clicOnPostGoToIntoAddDetailsInAddBio();
		softAssert.assertNotNull(pages);
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="click On Posts and Go Into and Click On Edit Details Add WorkPlace")
	public void clicOnPostGoToIntoClickOnEditDetailsAddWorkPlace() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method clicOnPostGoToIntoClickOnEditDetailsAddWorkPlace() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.clicOnPostGoToIntoClickOnEditDetailsAddWorkPlace();
		softAssert.assertNotNull(pages);
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="click On Posts and GoTo Click On Edit Featured and Add One Featured Photos")
	public void clicOnPostGoToIntoClickOnEditFeaturedAddOneFeaturedPhotos() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method clicOnPostGoToIntoClickOnEditFeaturedAddOneFeaturedPhotos() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.clicOnPostGoToIntoClickOnEditFeaturedAddOneFeaturedPhotos();
		softAssert.assertNotNull(pages);
	}
	
	@Test(priority = 8, groups = {"sanity"}, description="go to About Click On Overview Add Workplace")
	public void gotoAboutClickOnOverviewAddWorkplace() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddWorkplace() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddWorkplace();
		softAssert.assertNotNull(pages);

	}
	
	@Test(priority = 9, groups = {"sanity"}, description="go to About and Click On Overview and Add Secondary High School")
	public void gotoAboutClickOnOverviewAddSecondaryHighSchool() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddSecondaryHighSchool() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddSecondaryHighSchool();
		softAssert.assertNotNull(pages);

	}
	
	@Test(priority = 10, groups = {"sanity"}, description="go to About and Click On Over view and Add University")
	public void gotoAboutClickOnOverviewAddUniversity() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddUniversity() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddUniversity();
		softAssert.assertNotNull(pages);

	}
	
	@Test(priority = 11, groups = {"sanity"}, description="go to About and Click On Overview and Add Current City")
	public void gotoAboutClickOnOverviewAddCurrentCity() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddCurrentCity() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddCurrentCity();
		softAssert.assertNotNull(pages);
	}
	
	@Test(priority = 12, groups = {"sanity"}, description="go to About and Click On Overview and Add HomeTown")
	public void gotoAboutClickOnOverviewAddHomeTown() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddHomeTown() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddHomeTown();
	    softAssert.assertNotNull(pages);
	}
	
	@Test(priority = 13, groups = {"sanity"}, description="go to About and Click On Overview and Add RelationShip Status")
	public void gotoAboutClickOnOverviewAddRelationShipStatus() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddRelationShipStatus() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddRelationShipStatus();
	    softAssert.assertNotNull(pages);

	}
	
	@Test(priority = 14, groups = {"sanity"}, description="go to About Click On Overview and Edit PhoneNumber")
	public void gotoAboutClickOnOverviewEditPhoneNumber() throws Exception {
		
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method gotoAboutClickOnOverviewEditPhoneNumber() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.gotoAboutClickOnOverviewEditPhoneNumber();
	    softAssert.assertNotNull(pages);

	}
	@Test(priority =15, groups = {"sanity"}, description="after log in Check notifications and mark them as read ")
	public void go_to_notification() throws Exception {	
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method Check_notifications () has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance. Check_notifications();
	    softAssert.assertNotNull(pages);

	}
	@Test(priority =17, groups = {"sanity"}, description=" Navigate to the marketplace and search for a specific item ")
	public void go_to_marketPlace () throws Exception {	
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method navigate_to_marketplace() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.navigate_to_marketplace();
	    softAssert.assertNotNull(pages);

	}

	@Test(priority =18, groups = {"sanity"}, description=" Like a post ")
	public void like_any_post() throws Exception {	
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method like_a_post() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.like_a_post();
	    softAssert.assertNotNull(pages);

	}
	@Test(priority =19, groups = {"sanity"}, description="after logged in, click on events and click on classic.")
	public void click_on_events() throws Exception {	
		FaceBookPageInstance = new FaceBookL2Pages(driver);
		//Note the below todo and method click_on_events_and_click_on_classic() has to be implemented by the implementor
		FaceBookL2Pages pages=FaceBookPageInstance.click_on_events_and_click_on_classic();
	    softAssert.assertNotNull(pages);

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
