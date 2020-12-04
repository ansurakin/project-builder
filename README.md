# Getting Started
Приложение создаёт каркас проекта.

### Системные требования
* java 1.8 и выше
* maven
* postgresql

### Запуск проекта
Для запуска выполните следующее:
* Создайте базу данных project-builder.

* Настройка базы данных
Замените имя пользователя и пароль для базы данных на свои 
в файле application.properties
```
spring.datasource.username=postgres
spring.datasource.password=12345678
```
и в файле liquibase.properties
```
username=postgres
password=12345678
```
запустите команду (или выполните SQL скрипт src\main\resources\db\changelog\changes\initial-structure-and-data.sql)  
```
mvn liquibase:update
```
* Сборка проекта
```
mvn clean package
```
* Запуск проекта
```
java -jar project-builder.jar
```
* Откройте в браузере [http://localhost:8080](http://localhost:8080)
