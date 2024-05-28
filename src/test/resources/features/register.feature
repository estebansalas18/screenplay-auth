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
    Then el sistema debe mostrar un mensaje que indique que el usuario se ha registrado correctamente
    Then el usuario es redirigido a la pagina de inicio



  