create table "city"
(
    "cityID"    serial
        primary key,
    name        varchar(30) not null
        unique,
    population  integer     not null,
    "countryID" varchar(30) not null
);

alter table "city"
    owner to natom654;

create table "country"
(
    id           serial
        primary key,
    name  varchar(30) not null
        unique,
    population   integer     not null,
    "mainlandID" varchar(30) not null
);

alter table "country"
    owner to natom654;

create table "mainland"
(
    id   serial
        primary key,
    name varchar(30) not null
        unique
);

alter table "mainland"
    owner to natom654;

create table city_country
(
    id serial  primary key,
    "cityID"    integer                                                   not null
        constraint city_country_city_id_fk
            references city
            on update cascade on delete cascade,
    "countryID" integer                                                   not null
        constraint city_country_country_id_fk
            references "country"
            on update cascade on delete cascade
);

alter table city_country
    owner to natom654;

create table country_mainland
(
    id   serial primary key,
    "countryID"  integer                                                       not null
        constraint country_mainland_country_id_fk
            references "country"
            on update cascade on delete cascade,
    "mainlandID" integer                                                       not null
        constraint country_mainland_mainland_id_fk
            references "mainland"
            on update cascade on delete cascade
);

alter table country_mainland
    owner to natom654;