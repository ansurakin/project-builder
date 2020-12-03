--liquibase formatted sql
--changeset alex:006
create table menu
(
    id           bigserial    not null,
    name         varchar(255) not null,
    order_number BIGINT,
    primary key (id)
);

INSERT INTO menu("id", "name", order_number)
VALUES (1, 'Главная', 1);
INSERT INTO menu("id", "name", order_number)
VALUES (2, 'Каталог', 2);

SELECT setval('menu_id_seq', (SELECT max(id) FROM menu));
