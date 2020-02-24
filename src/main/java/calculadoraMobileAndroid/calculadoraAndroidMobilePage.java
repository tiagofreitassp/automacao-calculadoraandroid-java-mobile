package calculadoraMobileAndroid;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

public class calculadoraAndroidMobilePage extends MobileDriver{
	BaseTest test = new BaseTest();
	BasePage page = new BasePage();
	
	private String btnZero = "com.android.calculator2:id/digit_0";
	private String btnUm = "com.android.calculator2:id/digit_1";
	private String btnDois = "com.android.calculator2:id/digit_2";
	private String btnTres = "com.android.calculator2:id/digit_3";
	private String btnQuatro = "com.android.calculator2:id/digit_4";
	private String btnCinco = "com.android.calculator2:id/digit_5";
	private String btnSeis = "com.android.calculator2:id/digit_6";
	private String btnSete = "com.android.calculator2:id/digit_7";
	private String btnOito = "com.android.calculator2:id/digit_8";
	private String btnNove = "com.android.calculator2:id/digit_9";
	private String btnDel = "com.android.calculator2:id/del";
	private String btnDivisao = "com.android.calculator2:id/op_div";
	private String btnMulti = "com.android.calculator2:id/op_mul";
	private String btnSubtracao = "com.android.calculator2:id/op_sub";
	private String btnSoma = "com.android.calculator2:id/op_add";
	private String btnIgual = "com.android.calculator2:id/eq";
	private String txtResultado = "com.android.calculator2:id/result";
	private String btnLimpar = "com.android.calculator2:id/clr";
	
	public void soma() throws IOException, InterruptedException, InvalidFormatException {
		test.criarPastaEvidencia("Calc Android - Soma");

		page.clicar(By.id(btnUm));
		page.clicar(By.id(btnNove));
		page.clicar(By.id(btnOito));
		page.clicar(By.id(btnOito));
		
		page.clicar(By.id(btnSoma));
		
		page.clicar(By.id(btnTres));
		page.clicar(By.id(btnUm));
		
		page.clicar(By.id(btnIgual));

		test.gerarScreenshots("Soma1");
		page.validarTexto(By.id(txtResultado), "2.019");
		test.gerarScreenshots("Soma2");

		page.esperar(1000);
		test.gerarEvidenciaNoWord("Validar soma","1","Realizar uma soma");
	}
	
	public void subtrair() throws IOException, InvalidFormatException, InterruptedException {
        test.criarPastaEvidencia("Calc Android - Subtração");

		page.clicar(By.id(btnDois));
		page.clicar(By.id(btnZero));
		page.clicar(By.id(btnUm));
		page.clicar(By.id(btnNove));
		
		page.clicar(By.id(btnSubtracao));
		
		page.clicar(By.id(btnUm));
		page.clicar(By.id(btnNove));
		page.clicar(By.id(btnOito));
		page.clicar(By.id(btnOito));
		
		page.clicar(By.id(btnIgual));

		test.gerarScreenshots("Subtração1");
		page.validarTexto(By.id(txtResultado), "31");
        test.gerarScreenshots("Subtração2");

        page.esperar(1000);
        test.gerarEvidenciaNoWord("Validar subtração","1","Realizar uma subtração");
	}
	
	public void multiplicar() throws IOException, InterruptedException, InvalidFormatException {
        test.criarPastaEvidencia("Calc Android - Multiplicação");

		page.clicar(By.id(btnUm));
		page.clicar(By.id(btnDois));
		page.clicar(By.id(btnTres));
		
		page.clicar(By.id(btnMulti));
		
		page.clicar(By.id(btnCinco));
		
		page.clicar(By.id(btnIgual));

		test.gerarScreenshots("Multiplicação1");
		page.validarTexto(By.id(txtResultado), "615");
        test.gerarScreenshots("Multiplicação2");

        page.esperar(1000);
        test.gerarEvidenciaNoWord("Validar multiplicação","1","Realizar uma multiplicação");
	}
	
	public void divisao() throws IOException, InterruptedException, InvalidFormatException {
        test.criarPastaEvidencia("Calc Android - Divisão");

		page.clicar(By.id(btnSete));
		page.clicar(By.id(btnSeis));
		
		page.clicar(By.id(btnDivisao));
		
		page.clicar(By.id(btnQuatro));
		
		page.clicar(By.id(btnIgual));

		test.gerarScreenshots("Divisão1");
		page.validarTexto(By.id(txtResultado), "19");
        test.gerarScreenshots("Divisão2");
		
		page.botaoHomeAndroid();

        page.esperar(1000);
        test.gerarEvidenciaNoWord("Validar divisão","1","Realizar uma divisão");
	}
}
