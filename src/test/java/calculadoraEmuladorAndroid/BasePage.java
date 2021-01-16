package calculadoraEmuladorAndroid;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidKeyCode;

public class BasePage extends EmuladorDriver{
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
        wait = new WebDriverWait(driver, 10);
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

    public String obterNomeSistemaOperacional(){
        String so = System.getProperty("os.name");
        return so;
    }

    public String obterUsuarioLogado(){
        String usuario = System.getProperty("user.name");
        return usuario;
    }

    public String obterNumeroIP() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        //System.out.println("Numero IP: "+ip);
        return ip;
    }

    public String obterNomaDaMaquina() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        //System.out.println("Nome da maquina: "+hostName);
        return hostName;
    }
}
