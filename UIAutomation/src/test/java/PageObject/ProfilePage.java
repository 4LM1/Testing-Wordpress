package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
	WebDriver driver;
	
	public ProfilePage(WebDriver driver){
		this.driver = driver;
	}
	// Lokátory pro elementy na stránce přihlášení
	private By chooseSite = By.xpath("(//android.widget.Button)[1]");
	private By noThanks = By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/quick_start_prompt_dialog_button_negative\"]");
	private By savePrivacyButton = By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.Button");
	private By moreButton = By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/quick_link_item\" and @text=\"More\"]");
	private By pagesButton = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]");
	
	
	
	// Metody pro interakce s jednotlivými elementy na stránce
	public void chooseSite() {
		driver.findElement(chooseSite).click();
	}
	public void buttonNo() {
		driver.findElement(noThanks).click();
	}
	public void privacySelectNo() {
		driver.findElement(savePrivacyButton).click();
	}
	public void moreButton() {
		driver.findElement(moreButton).click();
	}
	public void pagesButton() {
		driver.findElement(pagesButton).click();
	}
	
	
}
