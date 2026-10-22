Préstamo de material del aula maker

¿Qué hace?
Permite ver los materiales del aula maker y enviar una solicitud de
préstamo.

Cómo arrancarlo
1. Abrir el proyecto en IntelliJ.
2. Ejecutar la clase principal de Spring Boot.
3. Entrar en http://localhost:8080/.

   Rutas
- / : catálogo de materiales.
- /materiales/PORTATIL : ficha de un portátil.
- /materiales/MICRO : ficha del kit de microcontrolador.
- /materiales/CAMARA : ficha de la cámara.
- /solicitud/nueva : formulario de préstamo.
- /solicitudes : recibe el formulario.
  Validaciones
- El nombre y el correo son obligatorios.
- El correo debe tener un formato válido.
- Hay que elegir un material del catálogo.
- Se pueden pedir entre 1 y 3 unidades.
- Las fechas no pueden ser anteriores a hoy.
- La devolución no puede ser antes de la recogida.
- El motivo debe tener entre 30 y 400 caracteres.
- Hay que aceptar las normas.

  Pruebas
1. Abrir el catálogo y entrar en un material.
2. Probar a enviar el formulario vacío.
3. Probar un correo incorrecto.
4. Probar unidades fuera del rango permitido.
5. Probar una devolución anterior a la recogida.
6. Enviar una solicitud correcta y comprobar el resultado.

   Notas
   Los materiales están guardados en un array. No se usa base de datos y
   las solicitudes no se guardan permanentemente.