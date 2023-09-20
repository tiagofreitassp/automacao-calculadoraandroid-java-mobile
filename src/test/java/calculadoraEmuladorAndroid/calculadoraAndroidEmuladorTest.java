package calculadoraEmuladorAndroid;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class calculadoraAndroidEmuladorTest extends BaseTest{
	calculadoraAndroidEmuladorPage page = new calculadoraAndroidEmuladorPage();

	@Before
	public void inicializarDriver() throws MalformedURLException {
		page.getDriver();
	}

	@Test
	public void test1_Soma() throws IOException, InterruptedException, InvalidFormatException {
		page.soma();
	}

	@Test
	public void test2_Subtracao() throws IOException, InterruptedException, InvalidFormatException {
		page.subtrair();
	}

	@Test
	public void test3_Multiplicacao() throws IOException, InterruptedException, InvalidFormatException {
		page.multiplicar();
	}

	@Test
	public void test4_Divisao() throws IOException, InterruptedException, InvalidFormatException {
		page.divisao();
	}
}