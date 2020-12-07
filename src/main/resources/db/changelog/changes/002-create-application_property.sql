--liquibase formatted sql
--changeset alex:002

CREATE TABLE application_property
(
    id          bigserial    NOT NULL,
    key         varchar(255) NOT NULL,
    value       varchar(255) NOT NULL,
    description varchar(255)
);

INSERT INTO application_property("id", "key", "value", "description")
VALUES (1, 'application.test', 'application test', 'тестовое значение');

SELECT setval('application_property_id_seq', (SELECT max(id) FROM application_property));