DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM lots;
DELETE
FROM rents;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);

INSERT INTO lots (id, name, create_date_time, description, price, images)
VALUES (100002, 'post', '2016-06-22 19:10:25-07', 'great post to have your flag on', 345.23, 'image'),
       (100003, 'chair', '2017-06-22 19:10:25-07', 'great chair to sit on', 333.23, 'image'),
       (100004, 'table', '2018-06-22 19:10:25-07', 'great to have a dinner on', 999.99, 'image');
