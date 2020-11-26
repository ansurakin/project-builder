--liquibase formatted sql
--changeset alex:001

INSERT INTO url(url, page)
VALUES ('/page/project/nameAndLocation', '/page/project/nameAndLocation.xhtml');
