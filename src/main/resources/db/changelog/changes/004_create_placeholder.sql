--liquibase formatted sql
--changeset alex:004
create table placeholder
(
    id          bigserial    not null,
    key         varchar(255) not null,
    value       varchar(255) not null,
    description varchar(255),
    primary key (id)
);

INSERT INTO placeholder("key", "value", "description")
VALUES ('application.test', 'test', null);

SELECT setval('placeholder_id_seq', (SELECT max(id) FROM placeholder));
