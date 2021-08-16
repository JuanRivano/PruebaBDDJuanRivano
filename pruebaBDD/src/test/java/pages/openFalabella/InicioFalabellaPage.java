package pages.openFalabella;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilidades.ClaseBase;



public class InicioFalabellaPage extends ClaseBase {

    public InicioFalabellaPage(WebDriver driver) {
        super(driver);

    }

    public void iniciarPageFactori(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    /***OBJETOS:***/
    @FindBy(xpath = "//div[@class=\"dy-lb-close\"]")
    private WebElement cerrarFrame;


    @FindBy(id = "acc-alert-close")
    private WebElement cerrarMensaje;


    @FindBy(xpath = "//*[@id=\"testId-UserAction-userinfo\"]/div/div[1]/i")
    private WebElement menuUsuario;

    @FindBy(xpath = "//*[@id=\"testId-cc-login-form\"]/form/p/a")
    private WebElement btnRestablecerContrasena;

    @FindBy(id ="testId-SearchBar-Input")
    private WebElement barraBuscar;

    @FindBy(xpath = "//button[@class=\"SearchBar-module_searchBtnIcon__VR3f5\"]")
    private WebElement btnBuscar;

    public void quitarMensaje() {
        try {
            click(cerrarFrame,2);
            System.out.println("Se cierra mensaje desplegado en pantalla");
        } catch (WebDriverException e) {
            System.out.println("No existe Mensaje desplegado en pantalla");
            try{
                click(cerrarMensaje,2);
            }catch (WebDriverException f){
                System.out.println("No existe Mensaje desplegado en pantalla");
            }
        }
    }

    public void clickAccionesUsusario() {
        click(menuUsuario);
        System.out.println("Se realiza click en menu usuario");
    }

    public void clicOpcionRestablecerContrasena() {
        click(btnRestablecerContrasena);
        System.out.println("Se realiza click opcion Restablecer Contrasena");
    }


    public void buscarProducto(String producto) {
        agregarTexto(barraBuscar,producto);
        click(btnBuscar);
    }
}
