# Despensa-app - REST API

[![Twitch nmarulo](https://img.shields.io/twitch/status/nmarulo?color=%23A970FF&label=twitch%20nmarulo&style=flat-square)](https://www.twitch.tv/nmarulo)
---

## Descripción

Despensa-app es una aplicación que te permite gestionar los productos que compras de forma habitual.

Este proyecto proporciona los recursos a consumir por el [proyecto web](https://github.com/despensa-app/despensa-web).

## Demostración

No disponible, por el momento.

## Despliegue local

- [Requisitos](#requisitos)
- [Empezar a trabajar](#empezar-a-trabajar)
    - [Crear base de datos](#create-database)
    - [Trabajando en IntelliJ IDEA](#working-ingellij)

### Requisitos

* [Java 17](https://jdk.java.net/archive/)
* [MySQL 8](https://dev.mysql.com/downloads/mysql/)
* [Maven 3.9.5](https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.zip) (Opcional)
* [Wildfly 30](https://github.com/wildfly/wildfly/releases/download/30.0.0.Final/wildfly-30.0.0.Final.zip) (Opcional)

### Empezar a trabajar

<a name="create-database"></a>
**Crear base de datos**

- Creamos el esquema `despensa_app`.
- Ejecutamos el script [database.sql](database.sql)

<a name="working-ingellij"></a>
**Trabajando en IntelliJ IDEA**

- [Clonar proyecto](#clonar-proyecto)
- [Configurar maven home path](#maven-home-path)
- [Compilar](#compile)
- [Ejecutar](#run)
- [Habilitar EditorConfig](#editor-config)
- [Establecer opciones de guardado](#on-save)
- [spring-boot-devtools](#spring-boot-devtools)

<a name="clonar-proyecto"></a>
Clonar proyecto:

> File > New > Project from Version Control

<a name="maven-home-path"></a>
Establecer la ruta local de maven: 

(No es necesario si se pretende usar `mvnw`)

> File > Settings > Build, Execution, Deployment > Build Tools > Maven
> - maven home path

<a name="compile"></a>
Compilar:

- `Run > Run...`
    - `[spring-boot:run]`: Inicia el proyecto.
    - `[clean,install]`: Compila el proyecto sin test.
    - `[clean,install] Tests`: Compila ejecutando los test.

<a name="run"></a>
Ejecutar aplicación:

- `Run > Run...`
    - `App`

  > Si el usuario y contraseña, de la base de datos, es distinto a `root`, modificar la información de conexión
  > del fichero `src/main/resources/application.properties`

<a name="editor-config"></a>
Habilitar EditorConfig

- Es necesario tener habilitado el soporte de EditorConfig:

  > Settings > Editor > Code Style
  > - Enable Editor Config Support

<a name="on-save"></a>
Establecer acciones de guardado

- Recomiendo tener activado las acciones de guardado:
    - Reformat code
    - Optimize imports

> Settings > Tools > Actions on save

> Tener habilitado EditorConfig.

<a name="spring-boot-devtools"></a>
Spring-boot-devtools

- Activar la compilación automática del proyecto:

> Settings > Build, Execution, Development > Compiler
> - Build project automatically

## Contribuir

Cualquier contribución que hagas será muy apreciada.

- Antes de empezar a codificar, lea las [directrices de contribución](CONTRIBUTING.md).

## Agradecimientos

Gracias a [JetBrains](https://www.jetbrains.com/?from=SoftN%20CMS) por proporcionar una licencia para IntelliJ para
desarrollar este proyecto.

| JetBrains                                                                                    | IntelliJ                                                                                  |
|----------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| ![jetbrains](https://github.com/despensa-app/despensa-rest-api/blob/master/img/jetbrains.svg "jetbrains") | ![intellij](https://github.com/despensa-app/despensa-rest-api/blob/master/img/intellij.svg "intellij") |

## Licencia

[MIT license](LICENSE).
