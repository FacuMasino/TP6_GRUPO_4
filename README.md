# TP6_GRUPO_4

## Dependencias

### MySQL Connector

El archivo que contiene la ruta de MySQL Connector no está siendo versionado para que no haya que configurar la ubicación del mismo cada vez que otro contribuidor la cambia.
Es necesario crear en el directorio raíz un archivo llamado `.classpath` que contenga el siguiente código reemplazando `/tu/ruta/al/archivo.jar` por la ubicación correspondiente.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8"/>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="lib" path="jgoodies-forms-1.8.0.jar" sourcepath="jgoodies-forms-1.8.0-sources.jar"/>
	<classpathentry kind="lib" path="miglayout15-swing.jar" sourcepath="miglayout-src.zip"/>
	<classpathentry kind="lib" path="tu/ruta/al/archivo.jar"/>
	<classpathentry kind="output" path="bin"/>
</classpath>
```

Podés dejar tu ruta acá abajo anotada para futura referencia:

- Maxi: `/Users/mrmalvicino/eclipse-workspace/mysql-connector-j-9.0.0/mysql-connector-j-9.0.0.jar`

### Propiedades de conexión

Asímismo, es necesario configurar las credenciales de acceso a la base de datos.
Para ello, se debe crear un archivo llamado `config.properties` en el directorio raíz del proyecto con el siguiente código, reemplazando `tupassword` por la contraseña de la base de datos.

```properties
# Dirección del host de la base de datos
db.host=jdbc:mysql://localhost:3306/

# Usuario de la base de datos
db.user=root

# Contraseña del usuario
db.pass=tupassword

# Nombre de la base de datos
db.name=bdPersonas
```
