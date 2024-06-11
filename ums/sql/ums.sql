# drop database if exists ry;
# create database ry charset utf8mb4;
use ry;

create table if not exists ums_class
(
    id   int auto_increment primary key,
    name varchar(32) not null
);

create table if not exists  ums_student
(
    id       int auto_increment primary key,
    name     varchar(32) not null,
    age      smallint    not null,
    class_id int         not null,
    foreign key (class_id) references ums_class (id)
);

select *
from ums_class;

select *
from ums_student;
