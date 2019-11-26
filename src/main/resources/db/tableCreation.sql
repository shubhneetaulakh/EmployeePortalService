CREATE SCHEMA `employeedata` ;

CREATE TABLE `employeedata`.`employees` (
  `id` VARCHAR(36) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `department` VARCHAR(45) NULL,
  `dateofbirth` DATE NULL,
  PRIMARY KEY (`id`));
