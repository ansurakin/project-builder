--liquibase formatted sql
--changeset alex:003
INSERT INTO url(url, page)
VALUES ('/page/catalog/code/list', '/page/catalog/code/list.xhtml');
INSERT INTO url(url, page)
VALUES ('/page/catalog/code/create', '/page/catalog/code/create.xhtml');
