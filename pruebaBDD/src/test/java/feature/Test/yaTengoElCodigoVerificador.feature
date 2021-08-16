#Autor: Juan Carlos Rivano
#Automatizador: Juan Carlos Rivano
# modificación: Juan Carlos Rivano 13-08-2021

Feature: como cliente ya tengo codigo de verificación desde restablecer contrasena


  Background:
    Given  Ingreso a falabella
    And    Doy click opciones del usaurio
    And    Selecciono opcion Restablecer contrasena

    @regresion
  Scenario Outline: validador de contresena invalida

    Given   Presiono link ya tengo codigo verificador
    When    Ingreso rut que no cumple condiciones"<contrasena>"
    Then    Visualizo alertas de clave fuera de formato
    Examples:
      | contrasena |
      | $ #        |

  Scenario Outline: validador de contresena valida

    Given   Presiono link ya tengo codigo verificador
    When    Ingreso contraseña que cumple condiciones"<contrasena>"
    Then    Visualizo alertas de clave con formato correcto
    Examples:
      | contrasena |
      | Tc20marzo  |

  @regresion
  Scenario Outline: validador de correo no valido

    Given  Presiono link ya tengo codigo verificador
    When   Ingreso correo "<correo>"
    Then   Visualizo alerta de correo no valido
    Examples:
      | correo         |
      | correonovalido |

  @regresion
  Scenario Outline: validador Código verificador incorrecto

    Given   Presiono link ya tengo codigo verificador
    When    Ingreso correo "<correo>"
    And     Ingreso codigo verificador erroneo"<codigoVerificacion>"
    And     Ingreso contraseña que cumple condiciones"<contrasena>"
    And     Presiono crear nueva clave
    Then    Visualizo alerta de codigo verificacion erroneo
    Examples:
      | correo               | contrasena | codigoVerificacion |
      | juanrivano@gmail.com | Tc20marzo  | falso123           |


