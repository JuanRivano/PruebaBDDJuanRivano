package pages.openFalabella;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilidades.ClaseBase;

import java.util.List;

public class ProductosPage extends ClaseBase {
    public ProductosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /***OBJETOS:***/
    @FindBy(xpath = "//a/span/b")
    private List<WebElement> productos;


    public void clickProducto(String productoAbuscar) {
        buscarProducto(productoAbuscar);
    }

    private void buscarProducto(String productoAbuscar) {
        for (WebElement producto : productos) {
            if (producto.getText().contains(productoAbuscar)) {
                click(producto);
                break;

            }
        }
    }

}
