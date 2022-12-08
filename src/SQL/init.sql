create table country
(
    id serial
        constraint country_pk primary key,
    name   varchar(30) not null unique,
    mainland_id varchar(30)
);

alter table country
    owner to natom654;

create table city
(
    id  serial
       constraint city_pk primary key,
    name  varchar (30) not null unique,
    population   integer,
    country_ID varchar (30)
);

create table mainland
(
    id   serial
        primary key,
    name varchar(30) not null
        unique
);

alter table mainland
    owner to natom654;

alter table city
    owner to natom654;

create sequence city_id_seq
    as integer;

alter sequence city_id_seq owner to natom654;

alter sequence city_id_seq owned by city.id;

