--liquibase formatted sql
--changeset alex:005
INSERT INTO url(url, page)
VALUES ('/page/catalog/placeholder/list', '/page/catalog/placeholder/list.xhtml');
INSERT INTO url(url, page)
VALUES ('/page/catalog/placeholder/create', '/page/catalog/placeholder/create.xhtml');
