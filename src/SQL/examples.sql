SELECT * FROM country;

SELECT id, name, population FROM city;

SELECT * FROM city WHERE "country_ID" = 'Ukraine';

SELECT id, name, population FROM city WHERE population >= 1000000;

DELETE FROM country where mainland_id='Pangea';

ALTER TABLE mainland ADD column existing boolean NOT NULL default TRUE;

UPDATE mainland SET existing = FALSE WHERE name ='Pangea';

ALTER TABLE city ADD constraint check_positive CHECK ( population > 0 );