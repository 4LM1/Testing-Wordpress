package almitesting.almitestappium;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;


import PageObject.FirstPage;
import PageObject.LoginPage;
import PageObject.ProfilePage;
import PageObject.SiteAddress;
import PageObject.UserTestData;
import PageObject.WebPage;

import resources.BaseTest;

public class WrongLoginValidations extends BaseTest{
	
	LoginPage loginPage;
	WebPage webPage;
	SiteAddress siteAddress;
	ProfilePage profilePage;
	FirstPage firstPage;

	
	@BeforeTest
	public void setUp() throws MalformedURLException, URISyntaxException {
	ConfigureAppium();
    loginPage = new LoginPage(driver);	
    webPage = new WebPage(driver);
	siteAddress = new SiteAddress(driver);
	profilePage = new ProfilePage(driver);
	firstPage = new FirstPage(driver);
		}
	
//Email Login Path
@Test
	public void EmailLoginWithIncorrectNameValidation () throws InterruptedException{
	UserTestData.UserData testUser = UserTestData.WRONGNAME_USER;
	firstPage.loginWithURL();
	loginPage.enterAddress(testUser.email);
	Assert.assertTrue(LoginPage.isValidationMessageVisible("User does not exist."));
	        
}

@Test
	public void EmailLoginWithIncorrectPasswordValidation () throws InterruptedException{
	UserTestData.UserData testUser = UserTestData.WRONGPASSWORD;
	firstPage.loginWithEmail();
	loginPage.enterEmail(testUser.email);
	loginPage.continueAfterEmail();
	loginPage.enterPassword(testUser.password);
	Assert.assertTrue(LoginPage.isValidationMessageVisible("It seems you entered an incorrect password."));
}
	
@Test
public void EmailLoginWithEmptyEmailValidation () throws InterruptedException{
	firstPage.loginWithEmail();
	loginPage.continueAfterEmail();
	Assert.assertTrue(LoginPage.isValidationMessageVisible("Please enter a username or email address."));
}

//@Test
	public void EmailLoginWithEmptyPasswordValidation () throws InterruptedException{
	UserTestData.UserData testUser = UserTestData.EXISTING_USER;
	firstPage.loginWithEmail();
	loginPage.enterEmail(testUser.email);
	loginPage.continueAfterEmail();
	loginPage.continueAfterLogin();
	Assert.assertTrue(LoginPage.isValidationMessageVisible("It seems you entered an incorrect password."));
}

//URL Login Path

@Test
public void URLLoginWithIncorrectSiteValidation () throws InterruptedException{
	UserTestData.UserData testUser = UserTestData.WRONGSITE;
	firstPage.loginWithURL();
	siteAddress.insertEmail(testUser.email);
	Assert.assertTrue(LoginPage.isValidationMessageVisible("Please enter a complete website address, like example.com."));
	}

@Test
public void URLLoginWithoutPasswordValidation () throws InterruptedException{
}

@Test
public void URLLoginIncorrectEmailValidation () throws InterruptedException{
}

@Test
public void URLLoginIncorrectPasswordValidation () throws InterruptedException{
}

@Test
public void URLLoginWithEmptySite_ValidationMessage () throws InterruptedException{

UserTestData.UserData testUser = UserTestData.EXISTING_USER;

firstPage.loginWithEmail();
loginPage.enterEmail(testUser.email);

siteAddress.siteAddress(testUser.site);
siteAddress.continueButton();
siteAddress.insertEmail(testUser.email);
siteAddress.continueAfterEmail();
siteAddress.insertPassword(testUser.password);
siteAddress.continueAfterPassword();

Assert.assertTrue(LoginPage.isValidationMessageVisible("It seems you entered an incorrect password. Want to get a "));

}

@Test
public void URLLoginWithEmptyEmail_ValidationMessage () throws InterruptedException{

UserTestData.UserData testUser = UserTestData.EXISTING_USER;

firstPage.loginWithURL();

siteAddress.siteAddress(testUser.site);
siteAddress.continueButton();
siteAddress.insertEmail(testUser.email);
siteAddress.continueAfterEmail();
siteAddress.insertPassword(testUser.password);
siteAddress.continueAfterPassword();

Assert.assertTrue(LoginPage.isValidationMessageVisible("It seems you entered an incorrect password. Want to get a "));

}




	
@Test

	public void AddPicture() throws InterruptedException {
	
	UserTestData.UserData testUser = UserTestData.EXISTING_USER;
	
	
	    firstPage.loginWithURL();
		siteAddress.siteAddress(testUser.site);
		siteAddress.continueButton();
		siteAddress.insertEmail(testUser.email);
		siteAddress.continueAfterEmail();
		siteAddress.insertPassword(testUser.password);
		siteAddress.continueAfterPassword();
		
		profilePage.chooseSite();
		profilePage.buttonNo();
		profilePage.privacySelectNo();
		profilePage.moreButton();
		profilePage.pagesButton();
		
		webPage.goToMySite();
		
		try {
			webPage.storageCancel();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		webPage.addItem();
		webPage.chooseImage();
		
		webPage.chooseFromDevice();
		webPage.allowPermission();
		webPage.choosePhoto();
		webPage.confirmSelected();
		webPage.updateButton();
		webPage.updateSite();
		
		try {
			webPage.returnToMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		webPage.returnToMyProfile();
		
		webPage.verifyUploadedPhoto();
		
		
		
	}


public void tearDown(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
       
    }

    if (driver != null) {
        driver.quit();
    }
	}
}

