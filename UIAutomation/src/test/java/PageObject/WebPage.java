package PageObject;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.appium.java_client.AppiumBy;



public class WebPage{
	WebDriver driver;

	public WebPage(WebDriver driver){
		this.driver = driver;
	}
	
	By blogButton = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.jetpack.android:id/page_item\"])[2]");
	By mediaButton = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]");
	By storageButton = By.xpath("//android.widget.Button[@resource-id=\"android:id/button3\"]");
	By add = By.xpath("//android.widget.Button[@content-desc=\"Add block\"]/android.view.ViewGroup/com.horcrux.svg.SvgView");
	By chooseImage = By.xpath("//android.widget.Button[@content-desc=\"Image block\"]/android.view.ViewGroup");
	By chooseGallery = By.xpath("//android.widget.Button[@content-desc=\"Gallery block\"]/android.view.ViewGroup");
	By chooseFromDevice = By.xpath("//android.widget.Button[@content-desc=\"Choose from device\"]");
	By allowPerr = By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/button\"]");
	By allowAll = By.xpath("(//android.widget.Button)[1]");
	By photo1 = By.xpath("(//android.widget.ImageView[@content-desc=\"Image Thumbnail\"])[1]");
	By confirmSelected = By.xpath("//android.widget.Button[@content-desc=\"Confirm\"]");
	By updateButton = By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/menu_primary_action\"]");
	By updateNowButton = By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/publish_button\"]");
	By moreBlogButton = By.xpath("(//android.widget.ImageButton[@content-desc=\"More\"])[2]");
	By viewBlog = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.jetpack.android:id/content\"])[1]");
	By returnButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	By returnToProfile = By.xpath("(//android.widget.Button)[1]");
	By moreRecentActivity = By.xpath("//android.widget.ImageView[@content-desc=\"Recent activity more\"]");
	By allActivity = By.xpath("//android.widget.TextView[@resource-id=\"com.jetpack.android:id/title\" and @text=\"All activity\"]");
	
	
	
	
	
	public void goToMySite() {
		driver.findElement(blogButton).click();
	}
	public void storageCancel() {
		driver.findElement(storageButton).click();
	}
	
	public void addItem() {
		driver.findElement(add).click();
	}
	public void chooseImage() {
		driver.findElement(chooseImage).click();
	}
	public void chooseGallery() {
		driver.findElement(chooseGallery).click();
	}
	
	public void chooseFromDevice() {
		driver.findElement(chooseFromDevice).click();
	}
	public void allowPermission() {
		driver.findElement(allowPerr).click();
	}
	public void choosePhotoForGallery() {
		for(int i =1; i<=5; i++){
			String dynamicXpath = "(//android.widget.ImageView[@content-desc='Image Thumbnail'])[" + i + "]";
			WebElement photo = driver.findElement(By.xpath(dynamicXpath));
			photo.click();
		}
	}
	public void choosePhoto() {
		driver.findElement(photo1).click();
	}
	public void confirmSelected() {
		driver.findElement(confirmSelected).click();
	}
	public void updateButton() {
		driver.findElement(updateButton).click();
	}
	public void updateSite() {
		driver.findElement(updateNowButton).click();
	}
	public void moreBlog() {
		driver.findElement(moreBlogButton).click();
	}
	public void viewBlog() {
		driver.findElement(viewBlog).click();
	}
	public void returnToMenu() {
		driver.findElement(returnButton).click();
		
	}
	public void returnToMyProfile() {
		driver.findElement(returnToProfile).click();
	}
	public void verifyUploadedPhoto() throws InterruptedException {
		Thread.sleep(10000);
		//scroll dolu dokuď nenajde element recent activity
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Recent activity\"));"));
		Thread.sleep(8000);
		driver.findElement(moreRecentActivity).click();
		driver.findElement(allActivity).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.jetpack.android:id/activity_content_container\"])[2]")).click();	
	
		//media
		String eventText = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'uploaded to Blog')]")).getText();
		String fileName = eventText.split("uploaded to Blog")[0].trim();
		String fileName1 = eventText.split(".jpg")[0].trim();
		System.out.println("Zjištěný název fotky z eventu: " + fileName);
		
		
		
		driver.findElement(By.xpath("(//android.widget.ImageButton)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageButton)[1]")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(0);"));
		
		//nasledna kontrola v media
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.jetpack.android:id/quick_link_item\" and @text=\"More\"]")).click();
		driver.findElement(mediaButton).click();
		String xpath = "//android.widget.ImageView[@content-desc=\"media preview, filename " + fileName + "\"]";
		driver.findElement(By.xpath(xpath)).click();
		
		driver.findElement(By.xpath("(//android.view.ViewGroup)[1]")).click();
		WebElement aboutText = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.jetpack.android:id/edit_title\"]"));
		String actualText = aboutText.getText().trim();
		System.out.println("Zjištěný název fotky z eventu: " + actualText);
		
		if (actualText.equals(fileName1)) {
		    System.out.println("Název se zhoduje");
		} else {
		    System.out.println("Název se neshoduje");
		}
		
		
	}

	}
