<a href="https://github.com/despensa-app/despensa-rest-api/issues/2">
<div align="center">

![Milestone hacktoberfest][github-milestone-shield]

</div>
</a>

---

[![DeepSource][deepsource-issues-badge]][deepsource-project-url]
![Docker Pulls][docker-pull-shield]
![Docker Image Version][docker-version-shield]

# Despensa-app - REST API

📚 **Translations Readme**: [English](translations/README.en.md)

## Descripción

Despensa-app es una aplicación que te permite gestionar los productos que compras de forma habitual.

Este proyecto proporciona los recursos a consumir por el [proyecto web][github-project-web-url].

<details>
<summary>Características</summary>

- Ver/Crear/Modificar/Eliminar listas
- Listas públicas
- Listas por usuario (privadas)
- Agregar productos a la lista
- Filtrar productos
- Ver información de un producto
- Marcar productos de la lista
- Crear usuario
- Autenticación
- Autorización JWT
- Administración (Pendiente)

</details>

## Empezar a trabajar

- [Despliegue en local](#despliegue-en-local)
    - [Requisitos](#requisitos)
    - [Configurar base de datos](#configurar-base-de-datos)
    - [Compilar e iniciar el proyecto](#compilar-e-iniciar-el-proyecto)
- [Despliegue con docker](#despliegue-con-docker)
- [Trabajando en IntelliJ IDEA](#trabajando-en-intellij-idea)
- [Swagger](#swagger)
- [Usando postman](#usando-postman)

### Despliegue en local

#### Requisitos

* [Java 21][java-temurin-url]
* [MySQL 8][mysql-url]
* [Maven 3.9.7][maven-url] (Opcional)

#### Configurar base de datos

- Crear el esquema `despensa_app`.
- Establecer la contraseña del usuario `root` en la propiedad
  `spring.datasource.password` del archivo [application.properties](src/main/resources/application.properties).
- Ejecutar manualmente los siguientes scripts:
    - [schema.sql](src/main/resources/db/schema.sql)
    - [data.sql](src/main/resources/db/data.sql)

#### Compilar e iniciar el proyecto

Abrir una consola en la raíz del proyecto y ejecutar los siguientes comandos:

- `.\mvnw clean install`
- `.\mvnw spring-boot:run`

### Despliegue con docker

Con esta opción no necesitaremos instalar mysql y al iniciar siempre se ejecutarán los scripts (`schema.sql` y
`data.sql`), ya que la aplicación se iniciara con el perfil **dockerdev**.
MySQL utilizará el puerto `3307`.

**Iniciar imagen de docker hub**

```shell
docker compose -f compose.despensa-rest-api.yaml up -d
```

**Crear imagen e iniciar**

```shell
docker compose up --build -d
```

### Trabajando en IntelliJ IDEA

- [Community Edition](#community-edition)
- [Clonar proyecto](#clonar-proyecto)
- [Establecer la ruta local de maven](#establecer-la-ruta-local-de-maven)
- [Configuraciones de ejecución](#configuraciones-de-ejecución)
- [Habilitar EditorConfig](#habilitar-editorconfig)
- [Establecer opciones de guardado](#establecer-acciones-de-guardado)
- [spring-boot-devtools](#spring-boot-devtools)

#### Community Edition

Las siguientes indicaciones son para la versión Ultimate, pero en su mayoría también funcionan en la versión Community
Edition.

Hay publicada una [demostración de despliegue local con la versión Community Edition][github-discussion-url] en la
sección de discusiones del repositorio.

#### Clonar proyecto

> File > New > Project from Version Control

#### Establecer la ruta local de maven

(No es necesario si se pretende usar `mvnw`)

> File > Settings > Build, Execution, Deployment > Build Tools > Maven
> - maven home path

#### Configuraciones de ejecución

> Run > Run...

- `[clean,install]`: Compila el proyecto sin test.
- `[clean,install] Tests`: Compila ejecutando los test.
- `[spring-boot:run]`: Inicia el proyecto.
- `App`: Inicia el proyecto. (Versión **IDEA Ultimate**)
- `docker compose`: Crear una imagen e inicia el proyecto.
- `docker compose (despensa-rest-api)`: Inicia la imagen de docker hub.

#### Habilitar EditorConfig

Es necesario tener habilitado el soporte de EditorConfig:

> Settings > Editor > Code Style
> - Enable Editor Config Support

#### Establecer acciones de guardado

- Recomiendo tener activado las acciones de guardado: **Reformat code** y **Optimize imports**.

> Settings > Tools > Actions on save
>
> Tener habilitado EditorConfig.

#### Spring-boot-devtools

Activar la compilación automática del proyecto:

> Settings > Build, Execution, Development > Compiler
> - Build project automatically

### Swagger

Al iniciar la aplicación podemos acceder a la siguiente URL y probar los recursos disponibles:

- http://localhost:8080/swagger-ui/index.html?urls.primaryName=Public

### Usando postman

Como alternativa a swagger, puedes hacer un fork o visualizar la colección de recursos de la aplicación en siguiente
enlace:

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">][postman-url]

## Contribuir

Cualquier contribución que hagas será muy apreciada.

Antes de empezar a codificar, lea las [directrices de contribución](CONTRIBUTING.md).

## Agradecimientos

Gracias a [JetBrains](https://www.jetbrains.com/?from=SoftN%20CMS) por proporcionar una licencia para IntelliJ IDEA para
desarrollar este proyecto.

| JetBrains                                                                                             | IntelliJ IDEA                                                                                                      |
|-------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| ![JetBrains logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jetbrains.svg) | ![IntelliJ IDEA logo](https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg) |

## Licencia

[MIT license](LICENSE).


[deepsource-issues-badge]: https://app.deepsource.com/gh/despensa-app/despensa-rest-api.svg/?label=active+issues&show_trend=true&token=UvUyf5Wchx79wdiTOVRyO6RN

[deepsource-project-url]: https://app.deepsource.com/gh/despensa-app/despensa-rest-api/

[docker-pull-shield]: https://img.shields.io/docker/pulls/nmarulo/despensa-app?style=flat-square&link=https%3A%2F%2Fhub.docker.com%2Fr%2Fnmarulo%2Fdespensa-app

[docker-version-shield]: https://img.shields.io/docker/v/nmarulo/despensa-app?sort=date&style=flat-square&label=Docker%20versi%C3%B3n&link=https%3A%2F%2Fhub.docker.com%2Fr%2Fnmarulo%2Fdespensa-app%2Ftags

[github-milestone-shield]: https://img.shields.io/github/milestones/progress/despensa-app/despensa-rest-api/1?style=flat-square

[github-project-web-url]: https://github.com/despensa-app/despensa-web

[java-temurin-url]: https://adoptium.net/es/temurin/releases/?version=21

[mysql-url]: https://dev.mysql.com/downloads/mysql/

[maven-url]: https://dlcdn.apache.org/maven/maven-3/3.9.7/binaries/

[postman-url]: https://app.getpostman.com/run-collection/3462094-24c69e86-2ae0-42da-a1f0-55d411d60ad6?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D3462094-24c69e86-2ae0-42da-a1f0-55d411d60ad6%26entityType%3Dcollection%26workspaceId%3Dfaa3b08b-5495-45eb-a53f-5d832821e4f2#?env%5Bdespensa-app%20-%20local%5D=W3sia2V5IjoidXJsIiwidmFsdWUiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXBpIiwiZW5hYmxlZCI6dHJ1ZSwic2Vzc2lvblZhbHVlIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2FwaSIsInNlc3Npb25JbmRleCI6MH1d

[github-discussion-url]: https://github.com/despensa-app/despensa-rest-api/discussions/29
