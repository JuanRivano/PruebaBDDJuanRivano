package utilidades;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ClaseBase {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement buscarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    //click
    public void click(WebElement objeto) {
        if (visualizarObjeto(objeto, 20)) {
            objeto.click();
        }
    }


    public void click(WebElement objeto,int segundos) {
        if (visualizarObjeto(objeto, segundos)) {
            objeto.click();
        }
    }

    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public void agregarConbinacionTeclas(By localizador, Keys key){
        this.driver.findElement(localizador).sendKeys(key);
    }

    public String obtenerMensaje(WebElement elemento) {
        return (visualizarObjeto(elemento, 100)) ? elemento.getText() : "";
    }


    public void cargarPagina(String url){
        this.driver.get(url);
    }

    //espera fija
    public void esperarXsegundos(int miliSegundos) {
        try {
            Thread.sleep(miliSegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //espera explicita
    public WebElement esperarPorPresenciaElemento(By localizador){
        wait = new WebDriverWait(this.driver,20);

        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    //espera explicita
    public WebElement esperarPorElementoAClickear(By localizador){
        wait = new WebDriverWait(this.driver,20);

        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public WebDriver conexionDriver(String ruta, String property, String browser){
        switch(browser){
            case "chrome":
                System.setProperty(property,ruta);
                this.driver = new ChromeDriver();
                return driver;
            case "firefox":
                System.setProperty(property,ruta);
                this.driver = new FirefoxDriver();
                return driver;
            case "iexplorer":
                System.setProperty(property,ruta);
                this.driver = new InternetExplorerDriver();
                return driver;
            default:
                return driver;
        }
    }

    public void maximizarVentana(){
        this.driver.manage().window().maximize();
    }

    public void cerrarBrowser(){
        this.driver.close();
    }

    public int contarIframes(By localizador){ //tagName "iframe"
        List<WebElement> frames = this.driver.findElements(localizador);
        return frames.size();
    }

    public void irAframeByIndex(int index){
        this.driver.switchTo().frame(index);
    }

    public void irAframeByIDorName(String NameOrID){
        this.driver.switchTo().frame(NameOrID);
    }

    private  boolean visualizarObjeto(WebElement objeto, int segundos) {
        try {
            System.out.println("Buscamos el objeto:" + objeto + ", esperamos " + segundos + " segundos, hasta que aparezca.");
            WebDriverWait wait = new WebDriverWait(this.driver, (long)segundos);
            wait.until(ExpectedConditions.visibilityOf(objeto));
            System.out.println("Se encontró objeto:" + objeto + ", se retorna true.");
            return true;
        } catch (Exception var3) {
            System.out.println("No se encontró objeto:" + objeto + ", se retorna false.");
            return false;
        }
    }


}
