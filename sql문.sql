create database ssafydb;
use ssafydb;

CREATE TABLE `ssafydb`.`productdb` (
	`id` VARCHAR(30) NOT NULL,
    `name` VARCHAR(30) NULL,
    `quantity` VARCHAR(30) NULL,
    `price` INT NULL,
    primary key(`id`));
    
select * from productdb;