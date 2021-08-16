package pages.openFalabella;

import driverWeb.DriverContextWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static generic.genericos.*;
import static generic.genericos.waithElement;
import static properties.principalFalabella.*;

public class principalFalabellaPage {
    private WebDriver driver;

    public principalFalabellaPage() {
        DriverContextWeb.iniciarNavegador(URL_FALABELLA);
        this.driver = DriverContextWeb.getDriverWeb();
        PageFactory.initElements(this.driver, this);
        driverGenerico = this.driver;
    }

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]")
    private WebElement cerrarFrame;

    @FindBy(xpath = "//*[@id=\"testId-UserAction-userinfo\"]/div/div[1]/i")
    private WebElement menuUsuario;

    @FindBy(xpath = "//*[@id=\"testId-cc-login-form\"]/form/p/a")
    private WebElement btnRestablecerContrasena;

    @FindBy(id = "testId-Input-email")
    private WebElement inputCorreo;

    @FindBy(id = "testId-button-submit-email")
    private WebElement btnContinuarContrasena;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]/div[2]/div[2]/span/span")
    private WebElement mensajeCorreoNoRegistrado;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]/div[4]/span/span")
    private WebElement presionoBtnYaTengoCodigoVerificador;

    @FindBy(id = "testId-Input-password")
    private WebElement NuevaContrasenaInput;

    @FindBy(xpath = "//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[2]//span/span")
    private List<WebElement> validadores;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]/div[2]/div[2]/span/span")
    private WebElement mensajeCorreoErroneo;

    @FindBy(id = "testId-Input-temporaryPassword")
    private WebElement inputCodigoVerificador;

    @FindBy(id = "testId-button-submit-email")
    private WebElement btnCrear;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]/div[3]/div[2]/span/span")
    private WebElement mensajeCodigoVerificacion;

    public void quitarMensaje() {
        try {
            cerrarFrame.click();
            System.out.println("Se cierra mensaje desplegado en pantalla");
        } catch (WebDriverException e) {
            System.out.println("No existe Mensaje desplegado en pantalla");
        }
    }

    public void clickAccionesUsusario() {
        waithElement(menuUsuario);
        menuUsuario.click();
        System.out.println("Se realiza click en menu usuario");
    }

    public void clicOpcionRestablecerContrasena() {
        waithElement(btnRestablecerContrasena, 5);
        btnRestablecerContrasena.click();
        System.out.println("Se realiza click opcion Restablecer Contraseña");
    }

    public void ingresoCorreo(String correo) {
        waithElement(inputCorreo, 10);
        inputCorreo.sendKeys(correo);
        System.out.println("Se ingresa correo " + correo);
    }

    public void clickContinuarValidarMensaje() {
        waithElement(btnContinuarContrasena, 10);
        btnContinuarContrasena.click();
        waithElement(mensajeCorreoNoRegistrado, 20);
        String mensaje = mensajeCorreoNoRegistrado.getText();
        validadorMensajes(CONTRASENA_MENSAJE_NO_REGISTRADO, mensaje);
    }

    public void presionoBtnYaTengoCodigoVerificador() {
        waithElement(presionoBtnYaTengoCodigoVerificador);
        presionoBtnYaTengoCodigoVerificador.click();
        System.out.println("Se realiza click en link Ya tengo el código verificador");
    }

    public void ingresoContrasena(String nClave) {
        waithElement(NuevaContrasenaInput);
        NuevaContrasenaInput.sendKeys(nClave);
        System.out.println("Se ingresa nueva clave");
    }

    public void validadorDeNuevaClave(String contain) {
        try {
            for (WebElement e : validadores) {
                String mensaje = e.getText();
                System.out.println("validando mensaje " + mensaje);
                pruebaStatus("error en validacion de clave" + mensaje, e.getAttribute("class").contains(contain));
            }
        } catch (NoSuchElementException e) {
            System.out.println("No existe mensaje en pantalla");
        }
    }

    public void validarMensajeCorreoNoValido() {
        waithElement(mensajeCorreoErroneo, 10);
        validadorMensajes(MENSAJE_CORREO_NO_VALIDO, mensajeCorreoErroneo.getText());
    }


    public void codigoVerioficador(String arg0) {
        waithElement(inputCodigoVerificador);
        inputCodigoVerificador.sendKeys(arg0);
    }

    public void presionarBotonCrear() {
        waithElement(btnCrear, 10);
        btnCrear.click();
    }

    public void validarMensajeErrorCodigoVerificacion() {
        waithElement(mensajeCodigoVerificacion, 50);
        validadorMensajes(ERROR_CODIGO_VERIFICACION, mensajeCodigoVerificacion.getText());
    }

    public void closeNavegador() {
        driver.close();
    }
}

