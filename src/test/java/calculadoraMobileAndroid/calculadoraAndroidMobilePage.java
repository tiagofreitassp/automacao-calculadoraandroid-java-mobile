package calculadoraMobileAndroid;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

public class calculadoraAndroidMobilePage extends MobileDriver{
	BaseTest test = new BaseTest();
	BasePage page = new BasePage();
	
	private String btnZero = "com.google.android.calculator:id/digit_0";
	private String btnUm = "com.google.android.calculator:id/digit_1";
	private String btnDois = "com.google.android.calculator:id/digit_2";
	private String btnTres = "com.google.android.calculator:id/digit_3";
	private String btnQuatro = "com.google.android.calculator:id/digit_4";
	private String btnCinco = "com.google.android.calculator:id/digit_5";
	private String btnSeis = "com.google.android.calculator:id/digit_6";
	private String btnSete = "com.google.android.calculator:id/digit_7";
	private String btnOito = "com.google.android.calculator:id/digit_8";
	private String btnNove = "com.google.android.calculator:id/digit_9";
	private String btnDel = "com.android.calculator2:id/del";
	private String btnDivisao = "com.google.android.calculator:id/op_div";
	private String btnMulti = "com.google.android.calculator:id/op_mul";
	private String btnSubtracao = "com.google.android.calculator:id/op_sub";
	private String btnSoma = "com.google.android.calculator:id/op_add";
	private String btnIgual = "com.google.android.calculator:id/eq";
	private String btnLimpar = "com.google.android.calculator:id/clr";
	private String btnVotar = "com.google.android.calculator:id/del";

	private String txtResultado = "com.google.android.calculator:id/result_final";
	private String txtImposDividirPorZero = "com.google.android.calculator:id/result_preview";
	
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
		page.validarTexto(By.id(txtResultado), "2019");
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
		page.validarTexto(By.id(txtResultado), "115");
        test.gerarScreenshots("Multiplicação2");

        page.esperar(1000);
        test.gerarEvidenciaNoWord("Validar multiplicação","1","Realizar uma multiplicação");
	}
	
	public void divisao() throws IOException, InterruptedException, InvalidFormatException {
        test.criarPastaEvidencia("Calc Android - Divisão");

		page.clicar(By.id(btnSete));
		page.clicar(By.id(btnSeis));
		
		page.clicar(By.id(btnDivisao));
		
		page.clicar(By.id(btnZero));
		
		page.clicar(By.id(btnIgual));

		test.gerarScreenshots("Divisão1");
		page.validarTexto(By.id(txtImposDividirPorZero), "Impos. dividir por 0");
        test.gerarScreenshots("Divisão2");

        page.clicar(By.id(btnVotar));

		page.clicar(By.id(btnQuatro));

		page.clicar(By.id(btnIgual));

		test.gerarScreenshots("Divisão3");
		page.validarTexto(By.id(txtResultado), "19");
		test.gerarScreenshots("Divisão4");

		page.botaoHomeAndroid();

        page.esperar(1000);
        test.gerarEvidenciaNoWord("Validar divisão","1","Realizar uma divisão");
	}
}
