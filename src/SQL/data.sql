INSERT INTO city (name, population, "country_ID")
VALUES ('Odessa', 1000000, 'Ukraine'),
       ('Kyiv', 10000000, 'Ukraine'),
       ('New York', 8468000, 'USA'),
       ('Kanberra', 395000,'Australia'),
       ('Gdansk',747637, 'Poland');



INSERT INTO country (name, mainland_id)
VALUES ('Ukraine', 'Eurasia'),
       ('USA', 'North America'),
       ('Australia', 'Australia'),
       ('Poland', 'Eurasia'),
       ('Mexico', 'South America');

INSERT INTO mainland (name)
VALUES ('Eurasia'),
       ('Africa'),
       ('North America'),
       ('South America'),
       ('Australia'),
       ('Pangea');

