create table cars (
  id serial primary key,
  brand varchar(255) not null,
  model varchar(255) not null,
  year int2 not null,
  wheels int2 not null ,
  color varchar(255) not null ,
  vehicle_type varchar(255) not null ,
  kilometers int4 not null default 0,
  gearbox varchar(255) not null ,
  fuel varchar(255) not null ,
  seats int2 not null ,
  cylinders int2 not null ,
  interior varchar(255) not null ,
  location varchar(255) not null ,
  export_status varchar(255) not null,
  description text

);

create table features_category (
    id serial primary key ,
    id_cars int4 references cars(id),
    name varchar(255) not null
);

create table features_name (
                                   id serial primary key ,
                                   id_features_category int4 references features_category(id),
                                   name varchar(255) NOT NULL
);

create  table  users (
    id serial primary key ,
    first_name varchar(255),
    last_name varchar(255),
    middle_name varchar(255),
    email varchar(255),
    password varchar(255),
    role varchar(255)
);

drop table users;