INSERT INTO City (name, population, "country_ID")
VALUES ('Odesa', 1000000, 'Ukraine'),
       ('Lviv', 10000000, 'Ukraine'),
       ('NY', 8468000, 'USA'),
       ('Kanbera', 395000,'Australia'),
       ('Gdanssk',747637, 'Poland'),
       ('Mexico', 8894193, 'Mexico');



INSERT INTO Country (name, mainland_id)
VALUES ('UKraine', 'Eurasia'),
       ('U S A', 'North America'),
       ('Astralia', 'Australia'),
       ('Polland', 'Eurasia'),
       ('Mehico', 'South America');

INSERT INTO Mainland (name)
VALUES ('Evrasia'),
       ('N America'),
       ('S America'),
       ('Astralia');

INSERT INTO city_country("cityID", "countryID")
VALUES (1,1),
       (2,1),
       (3,2),
       (4,3),
       (5,4),
      ( 6,5);

INSERT INTO country_mainland ("countryID", "mainlandID")
VALUES (1,1),
       (2,3),
       (3,5),
       (4,1),
       (5,4);