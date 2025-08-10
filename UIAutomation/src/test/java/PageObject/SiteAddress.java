package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteAddress {
	WebDriver driver;
	
	public SiteAddress(WebDriver driver){
		this.driver = driver;
	}
	// Lokátory pro elementy na stránce přihlášení
	private By siteAddress= By.xpath("//android.widget.EditText[@resource-id=\"com.jetpack.android:id/input\"]");
	private By continueButton= By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/bottom_button\"]");
	private By emailTextField = By.xpath("//android.widget.EditText[@resource-id=\"com.jetpack.android:id/input\"]");
	private By continueAfterEmail = By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/login_continue_button\"]");
	private By passwordTextField = By.xpath("//android.widget.EditText[@resource-id=\"com.jetpack.android:id/input\"]");
	private By continueAfterPassword = By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/bottom_button\"]");
	// Metody pro interakce s jednotlivými elementy na stránce
	UserTestData.UserData testUser = UserTestData.EXISTING_USER;

	
	
	public void siteAddress(String site) {
		driver.findElement(siteAddress).sendKeys(site);
	}
	public void continueButton () {
		driver.findElement(continueButton).click();
	}
	public void insertEmail (String email) {
		driver.findElement(emailTextField).sendKeys(email);
	}
	public void continueAfterEmail() {
		driver.findElement(continueAfterEmail).click();
	}
	public void insertPassword(String password) {
		driver.findElement(passwordTextField).sendKeys(password);
	}
	public void continueAfterPassword() {
		driver.findElement(continueAfterPassword).click();
	}
	
}
