--liquibase formatted sql
--changeset alex:006
create table menu
(
    id    bigserial    not null,
    label varchar(255) not null,
    primary key (id)
);

INSERT INTO menu("id", "label")
VALUES (1, 'Главная');
INSERT INTO menu("id", "label")
VALUES (2, 'Каталог');

SELECT setval('menu_id_seq', (SELECT max(id) FROM menu));
