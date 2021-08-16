package pages.openFalabella;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilidades.ClaseBase;
import java.util.List;



public class passwordRecoveryPage extends ClaseBase {

    public passwordRecoveryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "testId-Input-password")
    private WebElement NuevaContrasenaInput;


    @FindBy(xpath = "//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[2]//span/span")
    private List<WebElement> validadores;


    @FindBy(id = "testId-Input-email")
    private WebElement inputCorreo;



    public void ingresoContrasena(String nClave) {
        agregarTexto(NuevaContrasenaInput,nClave);
    }

    public void validadorDeNuevaClave(String contain) {
        try {
            for (WebElement e : validadores) {
                String mensaje = e.getText();
                System.out.println("validando mensaje " + mensaje);
                Assert.assertTrue( e.getAttribute("class").contains(contain),"error en validacion de clave" + mensaje);
            }
        } catch (NoSuchElementException e) {
            System.out.println("No existe mensaje en pantalla");
        }
    }

    public void ingresoCorreo(String correo) {
        agregarTexto(inputCorreo,correo);

    }
}
