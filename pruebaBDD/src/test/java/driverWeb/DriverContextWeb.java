package driverWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverContextWeb {
    public static WebDriver driverWeb;



    private static void configuracion(){
        String rutaProyecto =  System.getProperty("user.dir");
        String rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",rutaDriver);

    }

    public static void iniciarNavegador(String pagina){
        configuracion();
        driverWeb = new ChromeDriver();
        driverWeb.manage().window().maximize();
        driverWeb.get(pagina);
    }
    public static WebDriver getDriverWeb() {
        return driverWeb;

    }

}
