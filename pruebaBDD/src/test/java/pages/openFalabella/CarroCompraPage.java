package pages.openFalabella;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilidades.ClaseBase;

import java.util.List;

public class CarroCompraPage extends ClaseBase {
    public CarroCompraPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-testid=\"name\"]")
    private List<WebElement> compras;

    @FindBy(xpath = "//div[@datatestid=\"price-1\"]")
    private List<WebElement> montoProductos;

    @FindBy(xpath = "//div[contains(@class,\"product-count-value\")]")
    private List<WebElement> cantidadProductos;

    @FindBy(xpath = "//span[@data-testid=\"total-amount\"]")
    private List<WebElement> montoAPagar;

    public void buscarCompra(String elemento){
        Boolean encontado=false;
        for(WebElement compra:compras){
            if(compra.getText().equals(elemento)){
                encontado=true;
            }
        }
        Assert.assertTrue(encontado);
    }


    public int sumarProductos(){
        int totalAPagar=0;
        for (int i = 0; i < montoProductos.size(); i++) {
            System.out.println(cantidadProductos.get(i).getText());
            totalAPagar+=extraerPrecio(i)*Integer.parseInt(cantidadProductos.get(i).getText());
        }

        return totalAPagar;

    }

    private int extraerPrecio(int index){
        String montoSinFormato = montoProductos.get(index).getText();
        return Integer.parseInt(montoSinFormato.replaceAll("([a-zA-Z()$. ])", ""));

    }

    public int resumenDeLaCompra() {
        System.out.println(montoAPagar.get(0).getText());
        return Integer.parseInt(montoAPagar.get(0).getText().replaceAll("([a-zA-Z()$. ])", ""));

    }
}
