# Проект "Vniia"


Для сборки и запуска проекта вам понадобятся:

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) версии 17 или выше
- [Gradle](https://gradle.org/install/) версии 7.4 или выше (или можно использовать `gradlew`, включенный в проект)

## Сборка проекта

Чтобы собрать проект, выполните следующую команду в корневой директории проекта:

```bash
./gradlew build
```

## Запуск приложения

Чтобы запустить проект, выполните следующую команду в корневой директории проекта:

```bash
./gradlew bootRun
```
После этого приложение будет доступно по адресу http://localhost:8080.

## База данных
Проект использует базу данных H2 по умолчанию. Вы можете настроить подключение к другой базе данных в файле application.properties или application.yml.

База данных H2 доступна по следующей ссылке: http://localhost:8080/h2-console. При использовании стандартных настроек, вы можете войти в консоль базы данных, оставив поля "JDBC URL" и "password" пустыми, а в поле "User Name" введите "sa".

## Инструкции по развертыванию
Склонируйте репозиторий проекта с помощью команды git clone.
Перейдите в корневую директорию проекта.
Убедитесь, что Java JDK и Gradle установлены на вашем компьютере.
Выполните сборку проекта с помощью команды ./gradlew build.
Запустите приложение с помощью команды ./gradlew bootRun.
Откройте браузер и перейдите по адресу http://localhost:8080 для доступа к приложению.
