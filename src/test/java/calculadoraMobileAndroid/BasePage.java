package calculadoraMobileAndroid;

import java.net.MalformedURLException;
import java.time.Duration;

import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends MobileDriver{
    public WebDriverWait wait;

    public void clicar(By by) throws MalformedURLException {
        aguardarElemento(by);
        getDriver().findElement(by).click();
    }

    public void validarTexto(By by, String texto) throws MalformedURLException {
        aguardarElemento(by);
        Assert.assertEquals(texto, obterTexto(by));
    }

    public String obterTexto(By by) throws MalformedURLException {
        aguardarElemento(by);
        return getDriver().findElement(by).getText();
    }

    public void aguardarElemento(By by) {
        wait = new WebDriverWait(driver, Duration.ofMillis(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void botaoVoltarAndroid() throws MalformedURLException, InterruptedException {
        getDriver().pressKeyCode(AndroidKeyCode.BACK);
    }

    public void botaoHomeAndroid() throws InterruptedException, MalformedURLException {
        getDriver().pressKeyCode(AndroidKeyCode.HOME);
    }

    public void esperar(long temp) throws InterruptedException {
        Thread.sleep(temp);
    }
}
