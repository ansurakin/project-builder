--liquibase formatted sql
--changeset alex:000

-- ----------------------------
-- Sequence structure for code_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."code_id_seq";
CREATE SEQUENCE "public"."code_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 4
    CACHE 1;
SELECT setval('"public"."code_id_seq"', 4, true);

-- ----------------------------
-- Sequence structure for menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."menu_id_seq";
CREATE SEQUENCE "public"."menu_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;
SELECT setval('"public"."menu_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for menu_item_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."menu_item_id_seq";
CREATE SEQUENCE "public"."menu_item_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 8
    CACHE 1;
SELECT setval('"public"."menu_item_id_seq"', 8, true);

-- ----------------------------
-- Sequence structure for placeholder_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."placeholder_id_seq";
CREATE SEQUENCE "public"."placeholder_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 5
    CACHE 1;
SELECT setval('"public"."placeholder_id_seq"', 5, true);

-- ----------------------------
-- Sequence structure for url_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."url_id_seq";
CREATE SEQUENCE "public"."url_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 17
    CACHE 1;
SELECT setval('"public"."url_id_seq"', 17, true);

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS "public"."code";
CREATE TABLE "public"."code"
(
    "id"       int8 DEFAULT nextval('code_id_seq'::regclass) NOT NULL,
    "key"      varchar(255) COLLATE "default"                NOT NULL,
    "location" varchar(255) COLLATE "default"                NOT NULL,
    "text"     text COLLATE "default"                        NOT NULL
)
    WITH (OIDS= FALSE)
;

-- ----------------------------
-- Records of code
-- ----------------------------
INSERT INTO "public"."code"
VALUES ('3', 'pom.xml', 'pom.xml', '<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>${pom.groupId}</groupId>
    <artifactId>${pom.artifactId}</artifactId>
    <version>${pom.version}</version>
    <name>${pom.name}</name>
    <description>${pom.description}</description>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
');
INSERT INTO "public"."code"
VALUES ('4', 'Application.java', 'src/main/java/${packageDir}/Application.java', 'package ${packageName};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."menu";
CREATE TABLE "public"."menu"
(
    "id"           int8 DEFAULT nextval('menu_id_seq'::regclass) NOT NULL,
    "name"         varchar(255) COLLATE "default"                NOT NULL,
    "order_number" int8
)
    WITH (OIDS= FALSE)
;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO "public"."menu"
VALUES ('1', 'Главная', '1');
INSERT INTO "public"."menu"
VALUES ('2', 'Каталог', '2');

-- ----------------------------
-- Table structure for menu_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."menu_item";
CREATE TABLE "public"."menu_item"
(
    "id"           int8 DEFAULT nextval('menu_item_id_seq'::regclass) NOT NULL,
    "name"         varchar(255) COLLATE "default"                     NOT NULL,
    "icon"         varchar(255) COLLATE "default",
    "menu_id"      int8                                               NOT NULL,
    "url_id"       int8                                               NOT NULL,
    "order_number" int8
)
    WITH (OIDS= FALSE)
;

-- ----------------------------
-- Records of menu_item
-- ----------------------------
INSERT INTO "public"."menu_item"
VALUES ('1', 'Домой', 'fa fa-home', '1', '1', '1');
INSERT INTO "public"."menu_item"
VALUES ('2', 'Создать проект', null, '1', '8', '2');
INSERT INTO "public"."menu_item"
VALUES ('3', 'Url', null, '2', '3', '3');
INSERT INTO "public"."menu_item"
VALUES ('4', 'Code', null, '2', '9', '4');
INSERT INTO "public"."menu_item"
VALUES ('5', 'Placeholder', null, '2', '11', '5');
INSERT INTO "public"."menu_item"
VALUES ('6', 'Menu', null, '2', '15', '6');
INSERT INTO "public"."menu_item"
VALUES ('7', 'Menu Item', null, '2', '18', '7');

-- ----------------------------
-- Table structure for placeholder
-- ----------------------------
DROP TABLE IF EXISTS "public"."placeholder";
CREATE TABLE "public"."placeholder"
(
    "id"          int8 DEFAULT nextval('placeholder_id_seq'::regclass) NOT NULL,
    "key"         varchar(255) COLLATE "default"                       NOT NULL,
    "value"       varchar(255) COLLATE "default"                       NOT NULL,
    "description" varchar(255) COLLATE "default"
)
    WITH (OIDS= FALSE)
;

-- ----------------------------
-- Records of placeholder
-- ----------------------------
INSERT INTO "public"."placeholder"
VALUES ('1', 'application.test', 'test', null);

-- ----------------------------
-- Table structure for url
-- ----------------------------
DROP TABLE IF EXISTS "public"."url";
CREATE TABLE "public"."url"
(
    "id"   int8 DEFAULT nextval('url_id_seq'::regclass) NOT NULL,
    "url"  varchar(255) COLLATE "default"               NOT NULL,
    "page" varchar(255) COLLATE "default"               NOT NULL
)
    WITH (OIDS= FALSE)
;

-- ----------------------------
-- Records of url
-- ----------------------------
INSERT INTO "public"."url"
VALUES ('1', '/', '/index.xhtml');
INSERT INTO "public"."url"
VALUES ('2', '/page/test', '/page/test/helloworld.xhtml');
INSERT INTO "public"."url"
VALUES ('3', '/page/catalog/url/list', '/page/catalog/url/list.xhtml');
INSERT INTO "public"."url"
VALUES ('4', '/page/catalog/url/create', '/page/catalog/url/create.xhtml');
INSERT INTO "public"."url"
VALUES ('8', '/page/project/nameAndLocation', '/page/project/nameAndLocation.xhtml');
INSERT INTO "public"."url"
VALUES ('9', '/page/catalog/code/list', '/page/catalog/code/list.xhtml');
INSERT INTO "public"."url"
VALUES ('10', '/page/catalog/code/create', '/page/catalog/code/create.xhtml');
INSERT INTO "public"."url"
VALUES ('11', '/page/catalog/placeholder/list', '/page/catalog/placeholder/list.xhtml');
INSERT INTO "public"."url"
VALUES ('12', '/page/catalog/placeholder/create', '/page/catalog/placeholder/create.xhtml');
INSERT INTO "public"."url"
VALUES ('13', '/page/catalog/placeholder/list', '/page/catalog/placeholder/list.xhtml');
INSERT INTO "public"."url"
VALUES ('14', '/page/catalog/placeholder/create', '/page/catalog/placeholder/create.xhtml');
INSERT INTO "public"."url"
VALUES ('15', '/page/catalog/menu/list', '/page/catalog/menu/list.xhtml');
INSERT INTO "public"."url"
VALUES ('17', '/page/catalog/menu/create', '/page/catalog/menu/create.xhtml');
INSERT INTO "public"."url"
VALUES ('18', '/page/catalog/menuItem/list', '/page/catalog/menuItem/list.xhtml');
INSERT INTO "public"."url"
VALUES ('19', '/page/catalog/menuItem/create', '/page/catalog/menuItem/create.xhtml');

-- ----------------------------
-- Alter Sequences Owned By
-- ----------------------------
ALTER SEQUENCE "public"."code_id_seq" OWNED BY "code"."id";
ALTER SEQUENCE "public"."menu_id_seq" OWNED BY "menu"."id";
ALTER SEQUENCE "public"."menu_item_id_seq" OWNED BY "menu_item"."id";
ALTER SEQUENCE "public"."placeholder_id_seq" OWNED BY "placeholder"."id";
ALTER SEQUENCE "public"."url_id_seq" OWNED BY "url"."id";

-- ----------------------------
-- Primary Key structure for table code
-- ----------------------------
ALTER TABLE "public"."code"
    ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table menu
-- ----------------------------
ALTER TABLE "public"."menu"
    ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table menu_item
-- ----------------------------
ALTER TABLE "public"."menu_item"
    ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table placeholder
-- ----------------------------
ALTER TABLE "public"."placeholder"
    ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table url
-- ----------------------------
ALTER TABLE "public"."url"
    ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."menu_item"
-- ----------------------------
ALTER TABLE "public"."menu_item"
    ADD FOREIGN KEY ("menu_id") REFERENCES "public"."menu" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."menu_item"
    ADD FOREIGN KEY ("url_id") REFERENCES "public"."url" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
