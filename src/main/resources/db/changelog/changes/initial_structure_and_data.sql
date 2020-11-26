--liquibase formatted sql
--changeset alex:000

create table url
(
    id   bigserial    not null,
    url  varchar(255) not null,
    page varchar(255) not null,
    primary key (id)
);

INSERT INTO url(url, page)
VALUES ('/', '/index.xhtml');
INSERT INTO url(url, page)
VALUES ('/page/test', '/page/test/helloworld.xhtml');
INSERT INTO url(url, page)
VALUES ('/page/catalog/url/list', '/page/catalog/url/list.xhtml');
INSERT INTO url(url, page)
VALUES ('/page/catalog/url/create', '/page/catalog/url/create.xhtml');


SELECT setval('url_id_seq', (SELECT max(id) FROM url));

--rollback DROP SEQUENCE url_id_seq;
--rollback DROP TABLE url;
