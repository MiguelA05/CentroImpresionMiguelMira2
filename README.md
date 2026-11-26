# Centro de impresión · JavaFX

Aplicación académica de escritorio para consultar impresoras, ver sus detalles y gestionar impresiones. Las vistas se definen en FXML y la aplicación arranca desde [Aplicacion.java](src/co/uniquindio/pg2/CentroImpresionMiguelMira/Aplicacion.java).

## Abrir en Eclipse

1. Importa la raíz como proyecto Eclipse existente. Usa el árbol `src/` indicado en [.classpath](.classpath).
2. Configura el JDK y la biblioteca JavaFX que requiere ese classpath. La configuración original también referencia complementos de Eclipse.
3. Ejecuta `co.uniquindio.pg2.CentroImpresionMiguelMira.Aplicacion` como aplicación Java. Abre la vista de impresoras y consulta el detalle de un elemento disponible.

El repositorio incluye una copia anidada del proyecto, clases ya compiladas en `bin/` y datos serializados en `centroImpresion.ser`. Para experimentar con persistencia, trabaja sobre una copia de esos datos.
