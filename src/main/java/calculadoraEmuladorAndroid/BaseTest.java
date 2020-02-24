package calculadoraEmuladorAndroid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest extends EmuladorDriver{
    private static String nomePasta;
    private File pastaEvidencias;

	@After
    public void tearDown() throws MalformedURLException {
        killDriver();
    }

    @AfterClass
    public static void versionApp() throws MalformedURLException {
        versaoApp();
    }

    public void criarPastaEvidencia(String nPasta) throws InterruptedException {
        Date dataAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        nomePasta = sdf.format(dataAtual);

        pastaEvidencias = new File("./screenshots/"+nPasta+" "+nomePasta);
        pastaEvidencias.mkdir();
    }

    public void gerarScreenshots(String nomeImagem) {
        try {

            TakesScreenshot ts = (TakesScreenshot)driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            org.apache.commons.io.FileUtils.copyFile(source, new File(pastaEvidencias+"\\"+nomeImagem+".png"));

            System.out.println("Screenshot capturado de "+nomeImagem+"!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void gerarEvidenciaNoWord(String cenario, String id, String titulo) throws IOException, InvalidFormatException, IOException {
        XWPFDocument doc = new XWPFDocument(new FileInputStream(new File("Template.docx")));
        XWPFParagraph par = doc.createParagraph();
        XWPFRun run1 = par.createRun();
        XWPFRun run2 = par.createRun();
        XWPFRun run3 = par.createRun();

        run1.setText("ID" + String.valueOf(id) + "-");
        run1.setText(cenario);
        run1.setFontSize(11);
        run1.setColor("595959");
        run1.setFontFamily("Calibri Light");

        run2.addBreak();
        run2.addBreak();
        run2.setText("3. EVIDÊNCIAS DOS CASOS DE TESTE");
        run2.setBold(true);
        run2.setFontSize(11);
        run2.setColor("595959");
        run2.setFontFamily("Calibri Light");

        String[] paths = pastaEvidencias.list();

        for (String path : paths) {
            String imagem = pastaEvidencias + "\\" + path;
            FileInputStream is = new FileInputStream(imagem);

            run3.addBreak();
            run3.setText(imagem);
            run3.setFontSize(11);
            run3.setColor("595959");
            run3.setFontFamily("Calibri Light");
            run3.addBreak();
            run3.addPicture(is, Document.PICTURE_TYPE_PNG, imagem, Units.toEMU(313), Units.toEMU(513));
            run3.addBreak();
            is.close();

            String documento = pastaEvidencias + "\\" + "ID - " + id + " - " + titulo +".doc";
            FileOutputStream fos = new FileOutputStream(documento);
            doc.write(fos);
            fos.close();
        }
    }
}
