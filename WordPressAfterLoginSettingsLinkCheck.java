import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WordPressAfterLoginSettingsLinkCheck {
    @Test
    public void checkSettingsLinkAfterLogin() {
        //define apk file location
        File appDir = new File("/Users/Inexis/IdeaProjects/AppiumDemo/Apps");
        File app = new File(appDir, "org.wordpress.android-5.6-APK4Fun.com.apk");

        //define capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("deviceName", "Android_Emulator");
        capabilities.setCapability("app", app.getAbsolutePath());

        //define Selenium Grid URL
        URL seleniumGridUrl = null;
        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //start up an AppiumDriver session
        AppiumDriver adrv = new AndroidDriver(seleniumGridUrl, capabilities);
        adrv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //perform the test steps
        adrv.findElement(By.id("org.wordpress.android:id/nux_username")).sendKeys("shaamildev@gmai.com");
        adrv.findElement(By.id("org.wordpress.android:id/nux_password")).sendKeys("automation36");
        adrv.findElement(By.id("org.wordpress.android:id/nux_sign_in_button")).click();
        Assert.assertEquals(adrv.findElement(By.id("org.wordpress.android:id/bottomLink_Settings")).getText(), "Settings");
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
      //close the WebDriver session
        adrv.quit();
    }

}
