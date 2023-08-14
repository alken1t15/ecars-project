create table country(
                        id serial primary key,
                        name varchar(255) not null
);
insert into country (name) VALUES ('UAE');
insert into country (name) VALUES ('USA');
insert into country (name) VALUES ('KZ');

create table city(
                     id serial primary key,
                     id_country int references country (id),
                     name varchar(255) not null
);

insert into city (id_country, name) VALUES (1,'Dubai');
insert into city (id_country, name) VALUES (3,'Astana');
insert into city (id_country, name) VALUES (2,'Chicago');
insert into city (id_country, name) VALUES (2,'Memphis');
insert into city (id_country, name) VALUES (2,'Detroit');

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
                      id_city int references city (id),
                      export_status varchar(255) not null,
                      description text,
                      img varchar(255),
                      is_new boolean,
                      mini_description varchar(255),
                      price decimal(5, 3),
                      img_big varchar(255),
                      price_old decimal(5, 3),
                  add_date timestamp
);


insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Land Cruiser 2017 ZX-G Frontier Face-Lifted Petrol 4.6L Sunroof 4WD',2017,18,'White','SUV/Crossover',15000,'Automatic','Gasoline',8,8,'Black',1,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Land Cruiser 2017 ZX-G Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod1.png',false,'2022 Land Cruiser, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',45.995,'main_car.png');



insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Land Cruiser GXR MID OPTION',2013,14,'White','Sedan',15000,'Automatic','Gasoline',8,8,'White',2,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Land Cruiser GXR MID OPTION.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod1.png',false,'2022 Land Cruiser, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',45.995,'main_car.png');


insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Corolla AED 1250 PM',2015,18,'White','Sedan',10500,'Automatic','Gasoline',8,8,'Black',3,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Land Cruiser 2017 ZX-G Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod4.png',false,'2022 Land Cruiser, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',45.303,'main_car.png');


insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Camry Sport V6',2023,14,'Black','Pick Up Truck',0,'Automatic','Gasoline',5,8,'Black',3,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Camry Sport V6 Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod5.png',true,'2023 Camry Sport V6, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',40.344,'main_car.png');



insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Highlander TOYOTA HIGHLADER XSE 2022 MODEL FULL OPTION 4x4',2022,14,'Blue','SUV/Crossover',10000,'Automatic','Gasoline',5,8,'Black',4,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Highlander TOYOTA HIGHLADER XSE 2022 MODEL FULL OPTION 4x4 Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod6.png',false,'Toyota Highlander TOYOTA HIGHLADER XSE 2022 MODEL FULL OPTION 4x4, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',42.366,'main_car.png');



insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Hiace',2016,14,'Blue','Pick Up Truck',12000,'Automatic','Gasoline',5,8,'Black',3,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Hiace Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod7.png',false,'Toyota Hiace, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',20.334,'main_car.png');


insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Tundra iFORCE 5.7LV8',2016,14,'Blue','Convertible',18000,'Automatic','Gasoline',5,8,'Black',5,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Tundra iFORCE 5.7LV8 Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod8.png',false,'Toyota Tundra iFORCE 5.7LV8, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',25.322,'main_car.png');



insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Hilux 2019 TOYOTA HILUX MANUAL 4X4',2018,14,'Blue','Convertible',13400,'Automatic','Gasoline',5,8,'Black',5,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Hilux 2019 TOYOTA HILUX MANUAL 4X4 Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod9.png',false,'Toyota Hilux 2019 TOYOTA HILUX MANUAL 4X4, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',26.362,'main_car.png');


insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Land Cruiser GXR 2016',2016,14,'Blue','Coupe',0,'Automatic','Gasoline',8,8,'Black',3,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Land Cruiser GXR 2016 Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod10.png',true,'Toyota Land Cruiser GXR 2016, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',29.361,'main_car.png');

insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big) values ('Toyota','Toyota Prado Black Edition 70th Anniversary 10/2021 Diesel 4WD Sunroof 2.8L',2021,14,'Red','Coupe',10500,'Automatic','Diesel',8,8,'Black',5,'Can be exported'
                                                                                                                                                                                                                ,'Toyota Land Cruiser GXR 2016 Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','prod11.png',false,'Toyota Land Cruiser GXR 2016, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',35.377,'main_car.png');



insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big,price_old) values ('Mitsubishi','2019 Mitsubishi Outlander Sport 2.0 SE',2021,14,'Red','Hatchback',27500,'Automatic','Petrol',8,8,'Black',5,'Can be exported'
                                                                                                                                                                                                                          ,'2019 Mitsubishi Outlander Sport 2.0 SE Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','car2.png',false,'2019 Mitsubishi Outlander Sport 2.0 SE, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',45.995,'main_car.png',51.495);


insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big,price_old) values ('BMW','2019 BMW 640 Gran Turismo i xDrive',2019,18,'Black','Hatchback',27057,'Automatic','Petrol',8,8,'Black',2,'Can be exported'
                                                                                                                                                                                                                          ,'2019 BMW 640 Gran Turismo i xDrive Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','car3.png',false,'2019 BMW 640 Gran Turismo i xDrive, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',45.505,'main_car.png',53.492);



insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big,price_old) values ('Subaru','2020 Subaru Ascent Touring 7-Passenger',2020,18,'Black','SUV/Crossover',22057,'Automatic','Petrol',8,8,'Black',2,'Can be exported'
                                                                                                                                                                                                                          ,'2020 Subaru Ascent Touring 7-Passenger Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','car4.png',false,'2020 Subaru Ascent Touring 7-Passenger, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',42.502,'main_car.png',54.491);



insert into cars (brand, model, year, wheels, color, vehicle_type, kilometers, gearbox, fuel, seats, cylinders, interior, id_city, export_status, description,img,is_new,mini_description,price,img_big,price_old) values ('Genesis','2021 Genesis GV80 2.5T',2021,18,'Black','Hatchback',29534,'Automatic','Petrol',8,8,'Black',2,'Can be exported'
                                                                                                                                                                                                                          ,'2021 Genesis GV80 2.5T Frontier Face-Lifted Petrol 4.6L Sunroof 4WD AT 7 Electric Leather Seats [RHD Japan Import] Premium Condition.
----------------------------------------------------------------------------------------------------------------------
Quis blandit turpis cursus in hac. In hendrerit gravida rutrum quisque. Pellentesque habitant morbi tristique senectus et. Eget gravida cum sociis natoque. Pharetra diam sit amet nisl suscipit adipiscing bibendum.

Porttitor massa id neque aliquam. In fermentum posuere urna nec. Rhoncus aenean vel elit scelerisque mauris pellentesque. Nullam ac tortor vitae purus faucibus ornare suspendisse sed nisi. Consequat id porta nibh venenatis cras sed.','car.png',false,'2021 Genesis GV80 2.5T, panoramic roof, black interior, LED headlights and automatic gearbox. A brand new car with GCC specifications.',43.564,'main_car.png',53.497);

create table img_cars(
                         id serial primary key,
                         id_cars int references cars (id),
                         img varchar(255)
);

insert into img_cars (id_cars, img) values (1,'01.png'), (1,'02.png'), (1,'03.png'), (1,'04.png'), (1,'05.png'),(1,'06.png'),(1,'07.png'),(1,'08.png');

create table features_category (
                                   id serial primary key ,
                                   id_cars int4 references cars(id),
                                   name varchar(255) not null
);


insert into features_category (id_cars, name) values (1,'Interior') , (1,'Exterior'),(1,'Security & Environment');

create table features_name (
                               id serial primary key ,
                               id_features_category int4 references features_category(id),
                               name varchar(255) NOT NULL
);

insert into features_name (id_features_category, name) VALUES (1,'Air conditioning'), (1,'Bluetooth system'),  (1,'Climate control'),  (1,'Cooled front seats'),(1,'Cruise control')
                                                            , (1,'Heated seats'),  (1,'Leather seats'),  (1,'Sunroof'),  (1,'Navigation system'),  (1,'Power locks'),  (1,'Power seats'), (1,'Power windows')
                                                            , (1,'Premium sound system'),  (1,'Tuner/radio'),  (1,'Rear camera');

insert into features_name (id_features_category, name) VALUES (2,'Fog lights'), (2,'Keyless go'), (2,'Performance tyres'), (2,'Premium paint');

insert into features_name (id_features_category, name) VALUES (3,'4WD'), (2,'ABS'), (3,'Adaptive lighting'), (3,'Airbags (front and side)'), (3,'Tinted windows'), (3,'All wheel drive'),
                                                              (3,'Adaptive cruise control'), (3,'Traction control'), (3,'Differential lock');

create table blog_page(
                          id serial primary key,
                          name_file varchar(255) not null
);


insert into blog_page (name_file) values ('article_blog_page');





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
