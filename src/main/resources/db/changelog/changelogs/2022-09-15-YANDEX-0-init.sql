--liquibase formatted sql
--changeset yerzhan:2022-09-15-YANDEX-01
--comment: add extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE EXTENSION IF NOT EXISTS citext;

--changeset yerzhan:2022-09-15-YANDEX-02
--comment: add item table
CREATE TABLE item
(
    id   TEXT,
    url VARCHAR(255), --CONSTRAINT CHECK ((type = "FOLDER" && ulr = null) || (type = "FILE" && ulr != null))
    size BIGINT CONSTRAINT non_negative_size CHECK (size >= 0),
    type VARCHAR(6) NOT NULL,
    update_date DATE NOT NULL,
    parent_id TEXT,
    PRIMARY KEY (id),
    CONSTRAINT fk_item_parent_id FOREIGN KEY (parent_id) REFERENCES item (id)
);
