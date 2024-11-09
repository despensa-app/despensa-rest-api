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

## Description

Despensa-app is an app that allows you to manage those products that you often buy.

This project provides with the needed resources for [web project][github-project-web-url].

<details>
<summary> Features </summary>

- View/Create/Update/Delete lists
- Public lists
- Lists by user (private)
- Add products to the list
- Filter products
- View product information
- Tick off products on a list
- Create a user
- Authentication
- JWT Authorization
- Management (Pending)
- Containerization with docker
- Database versioning with Flyway

</details>

## Getting Started

- [Local Deployment](#local-deployment)
    - [Requirements](#requirements)
    - [Configure Database](#configure-database)
    - [Compile and Start the Project](#compile-and-start-the-project)
- [Deployment with Docker](#deployment-with-docker)
- [Working in IntelliJ IDEA](#working-in-intellij-idea)
- [Swagger](#swagger)
- [Using Postman](#using-postman)

### Local deployment

#### Requirements

* [Java 21][java-temurin-url]
* [MySQL 8][mysql-url]
* [Maven 3.9.7][maven-url] (Optional)

#### Configure database

- Create the `despensa_app` schema.
- Set the password for the `root` user in the `spring.datasource.password`
  property of the [application.properties](../src/main/resources/application.properties) file.

#### Compile and start the project

Open a terminal in the root of the project and run the following commands:

- `.\mvnw clean install`
- `.\mvnw spring-boot:run`

### Deployment with docker

With this option, we won't need to install MySQL. The application will start with the **dockerdev** profile.
MySQL will use port `3307`.

**Start Docker Hub image**

```shell
docker compose -f compose.despensa-rest-api.yaml up -d
```

**Create image and start**

```shell
docker compose up --build -d
```

### Working in IntelliJ IDEA

- [Community Edition](#community-edition)
- [Clone project](#clone-project)
- [Set local Maven path](#set-local-maven-path)
- [Run configurations](#run-configurations)
- [Enable EditorConfig](#enable-editorconfig)
- [Set save options](#set-save-options)
- [spring-boot-devtools](#spring-boot-devtools)

#### Community Edition

The following instructions are for the Ultimate version, although most of them work with the Community Edition as well.

You can find a [demo of local deployment with the Community Edition][github-discussion-url] available in the
discussions section of this repository.

#### Clone project

> File > New > Project from Version Control

#### Set local Maven path

(Not necessary if you intend to use `mvnw`)

> File > Settings > Build, Execution, Deployment > Build Tools > Maven
> - maven home path

#### Run configurations

> Run > Run...

- `[clean,install]`: Compile the project without test.
- `[clean,install] Tests`: Compile running the test.
- `[spring-boot:run]`: Start the project.
- `App`: Start the project. (**IDEA Ultimate** version)
- `docker compose`: Create an image and start the project.
- `docker compose (despensa-rest-api)`: Start the docker hub image.

#### Enable EditorConfig

EditorConfig support needs to be enabled:

> Settings > Editor > Code Style
> - Enable Editor Config Support

#### Set save options

I recommend enabling the save actions: **Reformat code** and **Optimize imports**.

> Settings > Tools > Actions on save
>
> EditorConfig needs to be enabled.

#### Spring-boot-devtools

Enable automatic project compilation:

> Settings > Build, Execution, Development > Compiler
> - Build project automatically

### Swagger

When starting the application, we can access the following URL and test the available resources:

- http://localhost:8080/swagger-ui/index.html?urls.primaryName=Public

### Using postman

As an alternative to Swagger, you can fork or view the application's resource collection at the following link:

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">][postman-url]

## Contributions

Any contribution you make will be greatly appreciated.

Before you start coding, please read the [contribution guidelines](../CONTRIBUTING.md).

## Acknowledgements

Thanks to [JetBrains](https://www.jetbrains.com/?from=SoftN%20CMS) for providing a license for IntelliJ IDEA
to develop this project.

| JetBrains                                                                                             | IntelliJ IDEA                                                                                                      |
|-------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| ![JetBrains logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jetbrains.svg) | ![IntelliJ IDEA logo](https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg) |

## License

[MIT license](../LICENSE).


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
