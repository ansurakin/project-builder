--liquibase formatted sql
--changeset alex:001.1

create table url
(
    id   bigserial    not null,
    url  varchar(255) not null,
    view varchar(255) not null,
    primary key (id)
);

INSERT INTO url(id, url, view)
VALUES (1, '/', '/index.xhtml');
INSERT INTO url(id, url, view)
VALUES (2, '/page/catalog/url/list', '/page/catalog/url/list.xhtml');
INSERT INTO url(id, url, view)
VALUES (3, '/page/test', '/page/test/helloworld.xhtml');

SELECT setval('url_id_seq', (SELECT max(id) FROM url));

--rollback DROP SEQUENCE url_id_seq;
--rollback DROP TABLE url;

