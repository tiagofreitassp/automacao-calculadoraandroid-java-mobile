package calculadoraMobileAndroid;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver {
    protected static AndroidDriver driver;

    public AndroidDriver getDriver() throws MalformedURLException {
        if(driver == null) {
            criarDriverSmartphone();
        }
        return driver;
    }

	@Before
	public void criarDriverSmartphone() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Android");
		desiredCapabilities.setCapability("platformVersion", "7.0");
		desiredCapabilities.setCapability("DeviceId", "LGM2504SUKK7S4QC7H");
		desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		//desiredCapabilities.setCapability(MobileCapabilityType.APP, driverApp);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

    public void killDriver() {
        if(driver != null) {
            driver.quit();
        }
    }

    public static void versaoApp() {
        System.out.println("<<< Tiago Freitas - Versao: 1.0.250220 >>>");
        System.out.println("<<< Versao da plataforma Android: 9.0(Pie) >>>");
    }
}
