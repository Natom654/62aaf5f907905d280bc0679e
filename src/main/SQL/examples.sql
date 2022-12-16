SELECT * FROM city;

SELECT city.name, c.name
FROM city
JOIN city_country cc on city.id = cc."cityID"
JOIN country c on cc."countryID" = c.id;

SELECT city.name, sum(city.population) Sum_Population_City
FROM city
group by city.name;


SELECT c.name, sum(city.population) Sum_Population_Country
FROM city
         JOIN city_country cc on city.id = cc."cityID"
         JOIN country c on cc."countryID" = c.id
GROUP BY c.name;


SELECT c.name, AVG(city.population) Average_Population
FROM city
JOIN city_country cc on city.id = cc."cityID"
JOIN country c on cc."countryID" = c.id
GROUP BY c.name;

ALTER TABLE city ADD column data timestamp;

UPDATE city  SET population = 1152000
where city.name ='Odesa';
COMMIT ;
UPDATE city SET data = current_timestamp
WHERE city.name ='Odesa';
COMMIT;


UPDATE city  SET population = 10800000
    where city.name ='Lviv';
COMMIT ;
UPDATE city SET data = current_timestamp
WHERE city.name ='Lviv';
COMMIT;

DELETE FROM city
WHERE name ='Mexico' AND name ='NY';
COMMIT ;


SELECT c.name, count(city.name) Sum_City
FROM city
         JOIN city_country cc on city.id = cc."cityID"
         JOIN country c on cc."countryID" = c.id
GROUP BY c.name;





