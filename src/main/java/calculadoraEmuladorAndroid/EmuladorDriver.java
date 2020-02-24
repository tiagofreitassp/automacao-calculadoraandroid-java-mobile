package calculadoraEmuladorAndroid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EmuladorDriver {
	protected static AndroidDriver<MobileElement>driver;
	
	public AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
		if(driver == null) {
			criarDriverEmulador();
		}
		return driver;
	}
	
	@Before
	public void criarDriverEmulador() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void killDriver() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	public static void versaoApp() {
        System.out.println("<<< Tiago Freitas - Versão: 1.1.230220 >>>");
        System.out.println("<<< Versão da plataforma Android: 9.0(Pie) >>>");
    }
}
