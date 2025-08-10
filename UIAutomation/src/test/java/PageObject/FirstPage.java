package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;

public class FirstPage {
	WebDriver driver;
	
	public FirstPage(WebDriver driver){
		this.driver = driver;
		
	}
	//private By firstButton = 
		//	By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/"
				//	+ "android.view.View/android.view.View[3]/android.widget.Button");

	
	private By secondButton = 
			By.xpath("//androidx.compose.ui.platform."
					+ "ComposeView/android.view.View/android.view."
					+ "View/android.view.View[4]/android.widget.Button");
	
	
	public void loginWithEmail() {
		driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiSelector().className(\"android.widget.Button\").instance(0)")
			).click();
		//driver.findElement().click();
	}
	
	
	
	public void loginWithURL() {
		driver.findElement(secondButton).click();
	}
	
}
