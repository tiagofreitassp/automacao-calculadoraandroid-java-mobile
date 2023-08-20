package calculadoraEmuladorAndroid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EmuladorDriver {
	protected static AndroidDriver driver;
	
	public AndroidDriver getDriver() throws MalformedURLException {
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

		driver = new AndroidDriver(new URL("http://localhost:4723/"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
	}
	
	public void killDriver() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	public static void versaoApp() {
        System.out.println("<<< Tiago Freitas - Versao: 1.1.200823 >>>");
        System.out.println("<<< Versao da plataforma Android: 9.0(Pie) >>>");
    }
}
