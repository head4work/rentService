DROP TABLE IF EXISTS rents;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS lots;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL,
    enabled    BOOL                DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE lots
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                           NOT NULL,
    create_date_time TIMESTAMP           DEFAULT now() NOT NULL,
    description      TEXT                              NOT NULL,
    price            DECIMAL                           NOT NULL,
    images           VARCHAR


);

CREATE TABLE rents
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    date_start TIMESTAMP not null,
    date_end   TIMESTAMP not null,
    user_id    int       not null,
    lot_id     int       not null,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (lot_id) REFERENCES lots (id) ON DELETE CASCADE
);


