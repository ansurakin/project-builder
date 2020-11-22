# Getting Started
Приложение создаёт каркас проекта.

### Запуск проекта
Для запуска выполните следующее:
* Создайте базу данных project-builder.
Выполните SQL скрипт src\main\resources\db\changelog\changes\structure_and_data.sql 
или запустите команду 
```
mvn liquibase:update
```
* Запустите проект
```
mvn spring-boot:run
```
* Откройте в браузере [http://localhost:8080](http://localhost:8080)
