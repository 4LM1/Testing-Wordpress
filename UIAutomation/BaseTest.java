package resources;

import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


import com.google.common.collect.ImmutableMap;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
        Map<String, String> env = new HashMap<>(System.getenv());
        env.put("ANDROID_HOME", "/Users/4lm1/Library/Android/sdk");
        env.put("ANDROID_SDK_ROOT", "/Users/4lm1/Library/Android/sdk");

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withEnvironment(env)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("NewOne");
        options.setApp("/Users/4lm1/eclipse-workspace/almitestappium/src/test/java/resources/jpandroid-26.0.apk");
        options.setAppPackage("com.jetpack.android");
        options.setAppActivity("org.wordpress.android.ui.accounts.LoginActivity");
        options.setAppWaitActivity("org.wordpress.android.*");
        options.setNoReset(false);
        options.setAutoGrantPermissions(true);
        options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(60));
        options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(60));
        
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void takeScreenshot(AndroidDriver driver, String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File("./screenshots/" + fileName + ".png");
            FileUtils.copyFile(srcFile, targetFile);
            System.out.println("Screenshot saved: " + targetFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public void takeScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File("./screenshots/" + fileName + ".png");
            FileUtils.copyFile(srcFile, targetFile);
            System.out.println("Screenshot saved: " + targetFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    // Automatically take screenshot if test fails

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String methodName = result.getMethod().getMethodName();
            String timestamp = new SimpleDateFormat("ddMMyyyy_HH:mm").format(new Date());
            takeScreenshot(driver, methodName + "_Error_" + timestamp);
        }
    }
    
    
    
    
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(), "duration", 2000));
	}
	
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
		
	}
	public void TearDown() {
		
		driver.quit();
		service.stop();
	}
	
}
