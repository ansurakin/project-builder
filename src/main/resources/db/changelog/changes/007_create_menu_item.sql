--liquibase formatted sql
--changeset alex:007
create table menu_item
(
    id           bigserial    not null,
    value        varchar(255) not null,
    icon         varchar(255),
    menu_id      BIGINT       not null,
    url_id       BIGINT       not null,
    order_number BIGINT,
    primary key (id),
    FOREIGN KEY ("menu_id") REFERENCES menu ("id") ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY ("url_id") REFERENCES url ("id") ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO "public"."menu_item" ("id", "value", "url", "icon", "menu_id", "order_number")
VALUES ('1', 'Домой', '/', 'fa fa-home', '1', 1);
INSERT INTO "public"."menu_item" ("id", "value", "url", "icon", "menu_id", "order_number")
VALUES ('2', 'Создать проект', '/page/project/nameAndLocation', NULL, '1', 2);
INSERT INTO "public"."menu_item" ("id", "value", "url", "icon", "menu_id", "order_number")
VALUES ('3', 'Url', '/page/catalog/url/list', NULL, '2', 3);
INSERT INTO "public"."menu_item" ("id", "value", "url", "icon", "menu_id", "order_number")
VALUES ('4', 'Code', '/page/catalog/code/list', NULL, '2', 4);
INSERT INTO "public"."menu_item" ("id", "value", "url", "icon", "menu_id", "order_number")
VALUES ('5', 'Placeholder', '/page/catalog/placeholder/list', NULL, '2', 5);


SELECT setval('menu_item_id_seq', (SELECT max(id) FROM menu_item));
