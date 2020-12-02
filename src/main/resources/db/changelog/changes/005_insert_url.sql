--liquibase formatted sql
--changeset alex:005
INSERT INTO url(url, page)
VALUES ('/page/catalog/placeholder/list', '/page/catalog/placeholder/list.xhtml');
INSERT INTO url(url, page)
VALUES ('/page/catalog/placeholder/create', '/page/catalog/placeholder/create.xhtml');
INSERT INTO "public"."url" ("id", "url", "page")
VALUES ('15', '/page/catalog/menu/list', '/page/catalog/menu/list.xhtml');
INSERT INTO "public"."url" ("id", "url", "page")
VALUES ('17', '/page/catalog/menu/create', '/page/catalog/menu/create.xhtml');
