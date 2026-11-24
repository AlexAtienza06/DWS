# Grupo Joven U4P3

Aplicación web desarrollada con Spring Boot para gestionar las actividades del Grupo Joven de una hermandad.

## Dominio y atributos

La aplicación permite registrar y consultar actividades.

La entidad `Actividad` contiene estos atributos:

- `id`: identificador automático.
- `nombre`: nombre de la actividad.
- `descripcion`: descripción opcional.
- `tipo`: tipo de actividad.
- `fecha`: fecha de realización.
- `hora`: hora de comienzo.
- `duracionMinutos`: duración en minutos.
- `asistencia`: número de asistentes.
- `coste`: coste en euros.
- `requiereInscripcion`: indica si necesita inscripción.
- `lugar`: lugar donde se realiza.

## Base de datos

Se utiliza MariaDB con una base de datos llamada `grupoJovenU4P3`.

La conexión se configura en `application.properties`:

- URL: `jdbc:mariadb://localhost:3306/grupoJovenU4P3`
- Usuario: `grupoJoven`
- Contraseña: la configurada localmente en MariaDB.

## Ejecución

1. Iniciar el servicio de MariaDB.
2. Comprobar que existe la base de datos y que la conexión está configurada correctamente.
3. Abrir el proyecto en IntelliJ IDEA.
4. Ejecutar `GrupoJovenU4P3Application`.
5. Acceder desde el navegador a:

   http://localhost:8080

## Estructura del proyecto

- `controller`: gestiona las peticiones del usuario.
- `dto`: recoge y valida los datos del formulario.
- `model`: contiene las entidades.
- `repository`: permite acceder a la base de datos.
- `service`: gestiona la lógica de la aplicación.
- `templates`: contiene las vistas HTML.
- `static`: contiene los archivos CSS.

Se separan las responsabilidades para mantener el código organizado y evitar que la presentación gestione directamente el acceso a los datos.

## Tecnologías utilizadas

- Java 23
- Spring Boot
- Spring MVC
- Thymeleaf
- Spring Data JPA
- Hibernate
- MariaDB
- Jakarta Validation
- Lombok

## Patrones de diseño

Se utiliza el patrón MVC para separar el modelo, las vistas y los controladores.

También se utiliza Repository para gestionar el acceso a los datos e inyección de dependencias mediante constructores.

## Ampliaciones

No se han realizado consultas personalizadas opcionales.