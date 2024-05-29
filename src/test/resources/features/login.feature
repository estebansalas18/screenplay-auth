Feature: Inicio de sesion con correo y contrasena

  Scenario: Verificar que el usuario pueda iniciar sesion con su correo y contrasena
    Given que el usuario accede a la pagina de inicio de sesion
    When ingresa su correo electronico y contrasena en el formulario de inicio de sesion
    Then si la informacion es valida, el sistema debe permitir al usuario acceder a su cuenta
    Then el sistema debe mostrar un mensaje que indique que el usuario ha iniciado sesion correctamente
    Then el usuario es redirigido a la pagina de inicio
  
  Scenario: Verificar que el usuario no pueda iniciar sesion con informacion invalida
    Given que el usuario accede a la pagina de inicio de sesion 
    When ingresa un correo electronico o contrasena incorrectos en el formulario de inicio de sesion
    Then si la informacion es invalida, el sistema no debe permitir al usuario acceder a su cuenta
    Then el sistema debe mostrar un mensaje que indique que la informacion ingresada es incorrecta
