Feature: Registro de usuario en la plataforma

    Datos requeridos para el registro de usuario
    - Nombres
    - Apellidos
    - Tipo de documento
    - Numero de documento
    - Numero de telefono
    - Fecha de nacimiento
    - Pais
    - Departamento
    - Ciudad
    - Direccion
    - Email
    - Contraseña

  Scenario: Verificar que el usuario pueda registrarse
    Given que el usuario accede a la pagina de registro
    When ingresa todos los datos requeridos en el formulario de registro
    Then si la informacion es valida, el sistema debe permitir al usuario registrarse

  Scenario: Verificar que el usuario ingreso una identificacion mayor a 10 caracteres
    Given que el usuario accede a la pagina de registro 2
    When ingresa todos los datos requeridos en el formulario excepto un numero de identificacion valido 2
    Then el sistema no debe permitir al usuario registrarse 2
    Then el sistema debe mostrar un mensaje de error que indique no validar el registro con un numero de identificacion mayor a 10 caracteres 2

  Scenario: Verificar que el usuario no pueda registrarse con algun campo vacio
    Given que el usuario accede a la pagina de registro 3
    When ingresa todos los datos requeridos en el formulario de registro excepto uno 3
    Then el sistema no debe permitir al usuario registrarse 3
    Then el sistema debe mostrar un mensaje de error que indique que debe llenar todos los campos 3

  Scenario: Verificar que el usuario ingreso el nombre con caracteres especiales
    Given que el usuario accede a la pagina de registro 4
    When ingresa todos los datos requeridos en el formulario con un nombre con caracteres especiales 4
    Then el sistema no debe permitir al usuario registrarse 4
    Then el sistema debe mostrar un mensaje de error que indique ingresar el nombre sin caracteres especiales 4

  Scenario: Verificar que el usuario ingreso el apellido con caracteres especiales
    Given que el usuario accede a la pagina de registro 5
    When ingresa todos los datos requeridos en el formulario con un apellido con caracteres especiales 5
    Then el sistema no debe permitir al usuario registrarse 5
    Then el sistema debe mostrar un mensaje de error que indique ingresar el apellido sin caracteres especiales 5

  Scenario: Verificar que el usuario ingreso el email sin dominio
    Given que el usuario accede a la pagina de registro 6
    When ingresa todos los datos requeridos en el formulario excepto su email incluyendo @dominio.com 6
    Then el sistema no debe permitir al usuario registrarse 6
    Then el sistema debe mostrar un mensaje de error que indique ingresar el email con @dominio.com 6

  Scenario: Verificar que el usuario ingreso una fecha de nacimiento menor a 18 anios
    Given que el usuario accede a la pagina de registro 7
    When ingresa todos los datos requeridos en el formulario con una fecha de nacimiento menor a 18 anios 7
    Then el sistema no debe permitir al usuario registrarse 7
    Then el sistema debe mostrar un mensaje de error que indique no validar el registro con una fecha nacimiento menor a 18 anios 7
  
  Scenario: Verificar que el usuario ingreso una fecha de nacimiento valida
    Given que el usuario accede a la pagina de registro 8
    When ingresa todos los datos requeridos en el formulario con una fecha de nacimiento posterior a la fecha actual 8
    Then el sistema no debe permitir al usuario registrarse 8
    Then el sistema debe mostrar un mensaje de error que indique no validar el registro con una fecha nacimiento posterior a la fecha actual 8
    
  Scenario: Verificar que el usuario ingreso una contrasenia invalida
    Given que el usuario accede a la pagina de registro 9
    When ingresa todos los datos requeridos en el formulario correctamente excepto una contrasenia valida 9
    Then el sistema no debe permitir al usuario registrarse 9
    Then el sistema debe mostrar un mensaje que indique que la contrasenia no es valida 9

  Scenario: Verificar que el usuario ingreso contrasenias que no coinciden
    Given que el usuario accede a la pagina de registro 10
    When ingresa todos los datos requeridos en el formulario correctamente excepto contrasenias que coincidan 10
    Then el sistema no debe permitir al usuario registrarse 10
    Then el sistema debe mostrar un mensaje que indique que las contrasenias no coinciden 10