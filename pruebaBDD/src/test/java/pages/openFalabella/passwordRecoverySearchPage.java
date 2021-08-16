package pages.openFalabella;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilidades.ClaseBase;

public class passwordRecoverySearchPage extends ClaseBase {

    public passwordRecoverySearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /***OBJETOS:***/
    @FindBy(id = "testId-Input-email")
    private WebElement inputCorreo;

    @FindBy(id = "testId-button-submit-email")
    private WebElement btnContinuarContrasena;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]/div[2]/div[2]/span/span")
    private WebElement mensajeCorreoNoRegistrado;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]/div[4]/span/span")
    private WebElement presionoBtnYaTengoCodigoVerificador;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]/div[2]/div[2]/span/span")
    private WebElement mensajeCorreoErroneo;

    @FindBy(id = "testId-Input-temporaryPassword")
    private WebElement inputCodigoVerificador;

    @FindBy(id = "testId-Input-password")
    private WebElement NuevaContrasenaInput;

    @FindBy(id = "testId-button-submit-email")
    private WebElement btnCrear;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]/div[3]/div[2]/span/span")
    private WebElement mensajeCodigoVerificacion;


    public void ingresoCorreo(String correo) {
        agregarTexto(inputCorreo, correo);
        System.out.println("Se ingresa correo " + correo);
    }

    public String clickContinuarValidarMensaje() {
        click(btnContinuarContrasena);
        String mensaje = obtenerMensaje(mensajeCorreoNoRegistrado);
        return mensaje;
    }


    public void presionoLinkYaTengoCodigoVerificador() {
        click(presionoBtnYaTengoCodigoVerificador);
    }

    public String ObtenervalidarMensajeCorreoNoValido() {
        return obtenerMensaje(mensajeCorreoErroneo);
    }

    public void codigoVerioficador(String arg0) {
        agregarTexto(inputCodigoVerificador,arg0);
    }

    public void ingresoContrasena(String nClave) {
        agregarTexto(NuevaContrasenaInput,nClave);
    }

    public void presionarBotonCrear() {
        click(btnCrear);
    }

    public String obtenerMensajeErrorCodigoVerificacion() {
        return  obtenerMensaje(mensajeCodigoVerificacion);
    }

}
