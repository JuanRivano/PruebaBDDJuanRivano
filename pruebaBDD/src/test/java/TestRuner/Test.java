package TestRuner;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.openFalabella.*;
import utilidades.DataDriven;
import utilidades.PropertiesDriven;

import java.io.IOException;
import java.util.List;

public class Test {

    private WebDriver driver;
    private DataDriven data;
    private List<String> datosCP;
    private InicioFalabellaPage inicioFalabella;
    private passwordRecoverySearchPage passwordPage;
    private PropertiesDriven properties;
    private passwordRecoveryPage passwordRecovery;
    private ProductosPage productosPage;
    private ProductoPage productoPage;
    private CarroCompraPage carroCompraPage;

    @BeforeSuite
    public void inicioSuitDePruebas() {
        properties = new PropertiesDriven();
    }

    @BeforeClass
    public void preparacionClase() {
        data = new DataDriven();
        inicioFalabella = new InicioFalabellaPage(driver);
        inicioFalabella.conexionDriver(properties.obtenerProperty("rutaDriver"), properties.obtenerProperty("browserProperty"), properties.obtenerProperty("browser"));
        inicioFalabella.iniciarPageFactori(inicioFalabella.getDriver());
        passwordPage = new passwordRecoverySearchPage(inicioFalabella.getDriver());
        passwordRecovery = new passwordRecoveryPage(inicioFalabella.getDriver());
        productosPage = new ProductosPage(inicioFalabella.getDriver());
        productoPage = new ProductoPage(inicioFalabella.getDriver());
        carroCompraPage = new CarroCompraPage(inicioFalabella.getDriver());


    }

    @BeforeMethod
    public void preparacionTests() {
        String url = properties.obtenerProperty("url");
        inicioFalabella.cargarPagina(url);
        inicioFalabella.maximizarVentana();
    }


    @org.testng.annotations.Test
    public void CP001_validarElRestablecimientoClaveClienteCorreoNoValido() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP001_validarElRestablecimientoClaveClienteCorreoNoValido");
        inicioFalabella.quitarMensaje();
        inicioFalabella.clickAccionesUsusario();
        inicioFalabella.clicOpcionRestablecerContrasena();
        passwordPage.ingresoCorreo(datosCP.get(1));
        Assert.assertEquals(datosCP.get(2), passwordPage.clickContinuarValidarMensaje());
    }

    @org.testng.annotations.Test
    public void CP002_validadorDeContresenaInvalida() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP002_validadorDeContresenaInvalida");
        inicioFalabella.quitarMensaje();
        inicioFalabella.clickAccionesUsusario();
        inicioFalabella.clicOpcionRestablecerContrasena();
        passwordPage.presionoLinkYaTengoCodigoVerificador();
        passwordRecovery.ingresoContrasena(datosCP.get(1));
        passwordRecovery.validadorDeNuevaClave(datosCP.get(2));
    }

    @org.testng.annotations.Test
    public void CP003_validadorDeContresenaValida() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP003_validadorDeContresenaValida");
        inicioFalabella.quitarMensaje();
        inicioFalabella.clickAccionesUsusario();
        inicioFalabella.clicOpcionRestablecerContrasena();
        passwordPage.presionoLinkYaTengoCodigoVerificador();
        passwordRecovery.ingresoContrasena(datosCP.get(1));
        passwordRecovery.validadorDeNuevaClave(datosCP.get(2));
    }

    @org.testng.annotations.Test
    public void CP004_validadorDeCorreoNoValido() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP004_validadorDeCorreoNoValido");
        inicioFalabella.quitarMensaje();
        inicioFalabella.clickAccionesUsusario();
        inicioFalabella.clicOpcionRestablecerContrasena();
        passwordPage.presionoLinkYaTengoCodigoVerificador();
        passwordPage.ingresoCorreo(datosCP.get(1));
        Assert.assertEquals(datosCP.get(2), passwordPage.ObtenervalidarMensajeCorreoNoValido());

    }

    @org.testng.annotations.Test
    public void CP005_validadorCodigoVerificadorIncorrecto() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP005_validadorCodigoVerificadorIncorrecto");
        inicioFalabella.quitarMensaje();
        inicioFalabella.clickAccionesUsusario();
        inicioFalabella.clicOpcionRestablecerContrasena();
        passwordPage.presionoLinkYaTengoCodigoVerificador();
        passwordPage.ingresoCorreo(datosCP.get(1));
        passwordPage.codigoVerioficador(datosCP.get(3));
        passwordPage.ingresoContrasena(datosCP.get(2));
        passwordPage.presionarBotonCrear();
        Assert.assertEquals(datosCP.get(4), passwordPage.obtenerMensajeErrorCodigoVerificacion());

    }

    @org.testng.annotations.Test
    public void CP006_agregarIphone11aCarroCompras() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP006_agregarIphone11aCarroCompras");
        inicioFalabella.quitarMensaje();
        inicioFalabella.buscarProducto(datosCP.get(1));
        productosPage.clickProducto(datosCP.get(2));
        Assert.assertEquals(productoPage.agregarProductoAlCarro(), datosCP.get(3));
    }

    @org.testng.annotations.Test
    public void CP007_revisarElementosDelCarro() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP007_revisarElementosDelCarro");
        inicioFalabella.quitarMensaje();
        inicioFalabella.buscarProducto(datosCP.get(1));
        productosPage.clickProducto(datosCP.get(2));
        productoPage.agregarProductoAlCarro();
        productoPage.irAlCarroDeComprasCompras();
        carroCompraPage.buscarCompra(datosCP.get(2));

    }

    @org.testng.annotations.Test
    public void CP008_validarMontoTotalCarrito() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP007_revisarElementosDelCarro");
        inicioFalabella.quitarMensaje();
        inicioFalabella.buscarProducto(datosCP.get(1));
        productosPage.clickProducto(datosCP.get(2));
        productoPage.agregarProductoAlCarro();
        productoPage.irAlCarroDeComprasCompras();
        carroCompraPage.buscarCompra(datosCP.get(2));
        int TotalAPagarCalculado = carroCompraPage.sumarProductos();
        int TotalResumeCompra = carroCompraPage.resumenDeLaCompra();
        Assert.assertEquals(TotalAPagarCalculado, TotalResumeCompra);
    }
}
