package pages.openFalabella;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilidades.ClaseBase;


public class ProductoPage extends ClaseBase {
    public ProductoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /***OBJETOS:***/
    @FindBy(xpath = "//div[@id=\"buttonForCustomers\"]/button")
    private WebElement agregarAlCarrito;

    @FindBy(id = "testId-Operator-Liberado")
    private WebElement btnLiberado;

    @FindBy(xpath = "//div/button[contains(@class,'button button-primary button-primary-medium')]")
    private WebElement eligeTusOpcionesBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div/div/div/div[1]/span/span")
    private WebElement productoAgergarAlCarroMensaje;

    @FindBy(id = "linkButton")
    private WebElement irAlCarroDeCompras;


    public String agregarProductoAlCarro() {
        click(agregarAlCarrito);
        Assert.assertFalse(eligeTusOpcionesBtn.isEnabled());
        click(btnLiberado);
        Assert.assertTrue(eligeTusOpcionesBtn.isEnabled());
        click(eligeTusOpcionesBtn);
        do {
            System.out.println("cargando pagina");
        } while (obtenerMensaje(productoAgergarAlCarroMensaje).equals("Selecciona tus opciones para agregar el producto al carro"));
        return obtenerMensaje(productoAgergarAlCarroMensaje);
    }

    public void irAlCarroDeComprasCompras() {
        click(irAlCarroDeCompras);

    }
}
