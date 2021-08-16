package step;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.openFalabella.principalFalabellaPage;

public class restablecerContrasenaStep {

    private principalFalabellaPage pPageFalabella = new principalFalabellaPage();


    @Given("^Ingreso a falabella$")
    public void restablecerContrasenaStep() {
        pPageFalabella.quitarMensaje();
    }

    @And("^Doy click opciones del usaurio$")
    public void doyClickOpcionesDelUsaurio() {
        pPageFalabella.clickAccionesUsusario();
    }

    @When("^Selecciono opcion Restablecer contrasena$")
    public void seleccionoOpcionRestablecerContrasena() {
        pPageFalabella.clicOpcionRestablecerContrasena();
    }


    @And("^Ingreso correo no registrado \"([^\"]*)\"$")
    public void ingresoCorreoNoRegistrado(String arg0) throws Throwable {
        pPageFalabella.ingresoCorreo(arg0);

    }

    @Then("^Visualizo mensaje de error esperado$")
    public void visualizoMensajeDeErrorEsperado() {
        pPageFalabella.clickContinuarValidarMensaje();
    }

    @And("^Presiono link ya tengo codigo verificador$")
    public void presionoLinkYaTengoCodigoVerificador() {
        pPageFalabella.presionoBtnYaTengoCodigoVerificador();
    }


    @And("^Ingreso rut que no cumple condiciones\"([^\"]*)\"$")
    public void ingresoRutQueNoCumpleCondiciones(String arg0) throws Throwable {
        pPageFalabella.ingresoContrasena(arg0);
    }

    @Then("^Visualizo alertas de clave fuera de formato$")
    public void visualizoAlertasDeClaveFueraDeFormato() {
        pPageFalabella.validadorDeNuevaClave("failure");
    }

    @And("^Ingreso contraseña que cumple condiciones\"([^\"]*)\"$")
    public void ingresoContrasenaQueCumpleCondiciones(String arg0) throws Throwable {
        pPageFalabella.ingresoContrasena(arg0);
    }

    @Then("^Visualizo alertas de clave con formato correcto$")
    public void visualizoAlertasDeClaveConFormatoCorrecto() {
        pPageFalabella.validadorDeNuevaClave("success");
    }


    @And("^Ingreso correo \"([^\"]*)\"$")
    public void ingresoCorreo(String arg0) throws Throwable {
        pPageFalabella.ingresoCorreo(arg0);
    }

    @Then("^Visualizo alerta de correo no valido$")
    public void visualizoAlertaDeCorreoNoValido() {
        pPageFalabella.validarMensajeCorreoNoValido();
    }

    @And("^Ingreso codigo verificador erroneo\"([^\"]*)\"$")
    public void ingresoCodigoVerificadorErroneo(String arg0) throws Throwable {
        pPageFalabella.codigoVerioficador(arg0);
    }

    @And("^Presiono crear nueva clave$")
    public void presionoCrearNuevaClave() {
        pPageFalabella.presionarBotonCrear();
    }

    @Then("^Visualizo alerta de codigo verificacion erroneo$")
    public void visualizoAlertaDeCodigoVerificacionErroneo() {
        pPageFalabella.validarMensajeErrorCodigoVerificacion();
    }

    @After
    public void afterScenario() {
        pPageFalabella.closeNavegador();
    }
}
