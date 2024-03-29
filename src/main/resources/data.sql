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

INSERT INTO lots (name, create_date_time, description, price, images)
VALUES ('chair', '2017-06-22 19:10:25-07', 'great chair to sit on', 333.23, '/images/chair.png'),
       ('post', '2016-06-22 19:10:25-07', 'great post to have your flag on', 345.23, '/images/post.png'),
       ('chair', '2017-06-22 19:10:25-07', 'great chair to sit on', 333.23, '/images/chair.png'),
       ('table', '2018-06-22 19:10:25-07', 'great to have a dinner on', 999.99, '/images/table.png'),
       ('post', '2016-06-22 19:10:25-07', 'great post to have your flag on', 345.23, '/images/post.png'),
       ('chair', '2017-06-22 19:10:25-07', 'great chair to sit on', 333.23, '/images/chair.png'),
       ('table', '2018-06-22 19:10:25-07', 'great to have a dinner on', 999.99, '/images/table.png')
;

INSERT INTO rents (date_start, date_end, user_id, lot_id)
VALUES ('2022-09-02T07:00:00', '2022-09-04T07:00:00', 100000, 100003);
