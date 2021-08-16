#Autor: Juan Carlos Rivano
#Automatizador: Juan Carlos Rivano
# modificación: Juan Carlos Rivano 13-08-2021

Feature: Como cliente quiero restablecer contrasena en modulo principal Falabella

  Scenario Outline: Validar el restablecimiento clave cliente correo no valido
    Given Ingreso a falabella
    And   Doy click opciones del usaurio
    When  Selecciono opcion Restablecer contrasena
    And   Ingreso correo no registrado "<correo>"
    Then  Visualizo mensaje de error esperado
    Examples:
      | correo                |
      | juanrivanos@gmail.com |


