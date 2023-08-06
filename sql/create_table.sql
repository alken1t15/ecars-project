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
  description text,
  img varchar(255),
  is_new boolean,
  mini_description varchar(255),
  price decimal(5, 3),
  img_big varchar(255)
);


create table img_cars(
  id serial primary key,
  id_cars int references cars (id),
  img varchar(255)
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


insert into features_category (id_cars, name) values (1,'Interior') , (1,'Exterior'),(1,'Security & Environment');

insert into features_name (id_features_category, name) VALUES (1,'Air conditioning'), (1,'Bluetooth system'),  (1,'Climate control'),  (1,'Cooled front seats'),(1,'Cruise control')
        , (1,'Heated seats'),  (1,'Leather seats'),  (1,'Sunroof'),  (1,'Navigation system'),  (1,'Power locks'),  (1,'Power seats'), (1,'Power windows')
        , (1,'Premium sound system'),  (1,'Tuner/radio'),  (1,'Rear camera');


insert into features_name (id_features_category, name) VALUES (2,'Fog lights'), (2,'Keyless go'), (2,'Performance tyres'), (2,'Premium paint');

insert into features_name (id_features_category, name) VALUES (3,'4WD'), (2,'ABS'), (3,'Adaptive lighting'), (3,'Airbags (front and side)'), (3,'Tinted windows'), (3,'All wheel drive'),
                                                              (3,'Adaptive cruise control'), (3,'Traction control'), (3,'Differential lock');
create  table  users (
    id serial primary key ,
    first_name varchar(255),
    last_name varchar(255),
    middle_name varchar(255),
    email varchar(255),
    password varchar(255) ,
      role varchar(255)
);

drop table users;

insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, location, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Land Cruiser 2017 ZX-G Frontier Face-Lifted Petrol 4.6L Sunroof 4WD',2017,18,'White','SUV/Crossover',15000,'Automatic','Gasoline',8,8,'Black','Dubai','Can be exported'
,'Toyota Land Cruiser 2017 ZX-G Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod1.png',false,'2022 Land Cruiser, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',45.995,'main_car.png');


insert into img_cars (id_cars, img) values (1,'01.png'), (1,'02.png'), (1,'03.png'), (1,'04.png'), (1,'05.png'),(1,'06.png'),(1,'07.png'),(1,'08.png')


insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, location, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Land Cruiser GXR MID OPTION',2013,14,'White','SUV/Crossover',15000,'Automatic','Gasoline',8,8,'White','Astana','Can be exported'
                                                                                                                                                                                                                 ,'Toyota Land Cruiser GXR MID OPTION.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod1.png',false,'2022 Land Cruiser, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',45.995,'main_car.png');


