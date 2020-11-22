# Getting Started
Приложение создаёт каркас проекта.

### Системные требования
* java 1.8 и выше
* maven
* postgresql

### Запуск проекта
Для запуска выполните следующее:
* Создайте базу данных project-builder.
Выполните SQL скрипт src\main\resources\db\changelog\changes\structure_and_data.sql 
или запустите команду 
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
