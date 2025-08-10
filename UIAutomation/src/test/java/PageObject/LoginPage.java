package PageObject;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	static WebDriver driver;
	
	public LoginPage(WebDriver driver){
		LoginPage.driver = driver;
	}
	// Lokátory pro elementy na stránce přihlášení
	private By addressButton = By.xpath("(//android.widget.Button)[2]");
	private By enterAddress = By.xpath("//android.widget.EditText[@resource-id=\"com.jetpack.android:id/input\"]");
	private By ContinueAfterEmail = By.xpath("//android.widget.Button[@text=\"Continue\"]");
	private By loginWithDifferentAccount = By.xpath("//android.widget.TextView[@text=\"Log in with a different account\"]");
	private By loginEmail = By.xpath("//android.widget.EditText");
	private By loginPassword = By.xpath("(//android.widget.EditText)[2]");
	private By loginContinueButton = By.xpath("//android.widget.Button[@text=\"Continue\"]");
	private By finalLoginButton = By.xpath("//android.widget.Button[@text=\"Log In\"]");
	private By approveButton = By.xpath("//android.widget.Button[@text=\"Approve\"]");
	private By saveAfterLoginButton = By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.Button");
	
	
	// Metody pro interakce s jednotlivými elementy na stránce
	UserTestData.UserData testUser = UserTestData.EXISTING_USER;

	public void secondOfAll() {
		driver.findElement(addressButton).click();
	}
	public void enterAddress(String address) {
		driver.findElement(enterAddress).sendKeys(address);
	}
	public void continueAfterEmail() {
		driver.findElement(ContinueAfterEmail).click();
	}
	public void loginWithDifferentAccount() {
		driver.findElement(loginWithDifferentAccount).click();
	}
	public void enterEmail(String email) {
		driver.findElement(loginEmail).sendKeys(email);
	}
	public void enterPassword(String password) {
		driver.findElement(loginPassword).sendKeys(password);
	}
	public void continueAfterLogin() {
		driver.findElement(loginContinueButton).click();
	}
	public void finishLogin() {
		driver.findElement(finalLoginButton).click();
	}
	public void approveAfterLogin() {
		driver.findElement(approveButton).click();
	}
	public void saveAfterLogin() {
		driver.findElement(saveAfterLoginButton).click();
	}
	
	// Validační hlášky
	
	public static boolean isValidationMessageVisible(String messageText) {
	    try {
	        WebElement element = driver.findElement(
	            By.xpath("//android.widget.TextView[@text='" + messageText + "']")
	        );
	        return element.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

}
