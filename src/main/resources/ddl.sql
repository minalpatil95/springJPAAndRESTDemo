show databases;
create database springboot;
use springboot;
create table product(
                        id int NOT NULL PRIMARY KEY,
                        name varchar(20),
                        description varchar(20),
                        price decimal
);