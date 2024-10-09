# TP6_GRUPO_4

El archivo que contiene la ruta del MySQL Connector no está siendo versionado para que no haya que configurar la ubicación del mismo cada vez que se hace pull.

Si el repositorio está siendo clonado o descargado por primera vez, es necesario crear (en la raiz del directorio) un archivo llamado .classpath que contenga el siguiente código.

Luego, se puede o bien configurar la ruta con la interfaz de eclipse o bien reemplazar la línea que contiene la ruta del conector por la ubicación correspondiente.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8"/>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="lib" path="jgoodies-forms-1.8.0.jar" sourcepath="jgoodies-forms-1.8.0-sources.jar"/>
	<classpathentry kind="lib" path="miglayout15-swing.jar" sourcepath="miglayout-src.zip"/>
	<classpathentry kind="lib" path="aca/va/tu/ruta/al/archivo/mysqlconnector.jar"/>
	<classpathentry kind="output" path="bin"/>
</classpath>
```

Podés dejar tu ruta acá abajo para futura referencia:

- Maxi: `/Users/mrmalvicino/eclipse-workspace/mysql-connector-j-9.0.0/mysql-connector-j-9.0.0.jar`