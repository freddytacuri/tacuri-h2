drop table if exists countries;
CREATE TABLE countries
(
    id   INT PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO countries (id, name)
VALUES (1, 'USA1');
INSERT INTO countries (id, name)
VALUES (2, 'France');
INSERT INTO countries (id, name)
VALUES (3, 'Brazil');
INSERT INTO countries (id, name)
VALUES (4, 'Italy');
INSERT INTO countries (id, name)
VALUES (5, 'Canada');