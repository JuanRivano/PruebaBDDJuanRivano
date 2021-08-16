package generic;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import static properties.principalFalabella.TIEMPO_ESPERA;


public class genericos {

    public static WebDriver driverGenerico;
    public static String rutaProyecto = System.getProperty("user.dir");
    public static String rutaEvidencia = rutaProyecto + "\\src\\test\\Evidencia";


    /***IFRAME***/
    public static void vincularIframe(WebElement elemento, WebDriver driver) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(elemento);
    }

    public static void salirIframe(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static void validadorMensajes(String debeSer, String despliega) {
        assertEquals(debeSer, despliega);
    }

    public static void pruebaStatus(String mensaje, boolean status) {
        assertTrue(mensaje, status);
    }


    public static void waithElement(WebElement e, int time) {
        int iteracion = 0;
        boolean encontrado = false;
        while (iteracion < time) {
            try {
                e.isDisplayed();
                System.out.println("Elemento encontrado " + e);
                encontrado = true;
                break;
            } catch (NoSuchElementException N) {
                iteracion++;
            }
        }
        assertTrue("No se encuentra Elemento " + e, encontrado);
    }

    public static void waithElement(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driverGenerico, TIEMPO_ESPERA);
        wait.until(ExpectedConditions.visibilityOf(e));
    }



}


