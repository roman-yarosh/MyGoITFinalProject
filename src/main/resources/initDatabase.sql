-- -----------------------------------------------------
-- Drop database if exist
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `goit_final_project`;

-- -----------------------------------------------------
-- Create database if not exists: goit_final_project;
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `goit_final_project`
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

-- -----------------------------------------------------
-- Use database: goit_final_project
-- -----------------------------------------------------
USE `goit_final_project`;

-- -----------------------------------------------------
-- Table: employees
-- stores information about employees.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`employees`;
CREATE TABLE `goit_final_project`.`employees` (
  `EMPLOYEE_ID`     INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `LOGIN`           VARCHAR(20)      NOT NULL,
  `PASSWORD`        VARCHAR(20)      NOT NULL,
  `NAME`            VARCHAR(20)      NOT NULL,
  `SURNAME`         VARCHAR(20)      NOT NULL,
  `MIDDLE_NAME`     VARCHAR(20),
  `EMAIL`           VARCHAR(50)      NOT NULL,
  `SALLARY_RATE`    DECIMAL          NOT NULL,
  `ROLE_ID`         INT              NOT NULL,
  `POSITION_ID`     INT              NOT NULL,
  `DEPARTMENT_ID`   INT              NOT NULL,
  `EVENT_ID`        INT,
  `STATUS_ID`       INT,
  `REGISTERED_DATE` DATETIME         NOT NULL,

  PRIMARY KEY (`EMPLOYEE_ID`) USING BTREE,
  UNIQUE KEY `UNI_LOGIN` (`LOGIN`),
  UNIQUE KEY `UNI_EMAIL` (`EMAIL`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: roles
-- stores information about user roles.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`roles`;
CREATE TABLE `goit_final_project`.`roles` (
  `ROLE_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME`    VARCHAR(255)     NOT NULL,

  PRIMARY KEY (`ROLE_ID`) USING BTREE,
  UNIQUE KEY `UNI_NAME` (`NAME`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: departments
-- stores information about departments.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`departments`;
CREATE TABLE `goit_final_project`.`departments` (
  `DEPARTMENT_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME`          VARCHAR(128)     NOT NULL,

  PRIMARY KEY (`DEPARTMENT_ID`) USING BTREE,
  UNIQUE KEY `UNI_NAME` (`NAME`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: positions
-- stores information about positions.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`positions`;
CREATE TABLE `goit_final_project`.`positions` (
  `POSITION_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME`        VARCHAR(128) NOT NULL,

  PRIMARY KEY (`POSITION_ID`) USING BTREE,
  UNIQUE KEY `UNI_NAME` (`NAME`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: events
-- stores information about events.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`events`;
CREATE TABLE `goit_final_project`.`events` (
  `EVENT_ID`            INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME`                VARCHAR(128)     NOT NULL,
  `TYPE`                VARCHAR(128)     NOT NULL,
  `START_DATETIME`      DATETIME         NOT NULL,
  `END_DATETIME`        DATETIME         NOT NULL,
  `CREATED_EMPLOYEE_ID` INT              NOT NULL,

  PRIMARY KEY (`EVENT_ID`) USING BTREE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: statuses
-- stores information about statuses.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`statuses`;
CREATE TABLE `goit_final_project`.`statuses` (
  `STATUS_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME`      VARCHAR(10)      NOT NULL,

  PRIMARY KEY (`STATUS_ID`) USING BTREE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: reports
-- stores information about report files.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`reports`;
CREATE TABLE `goit_final_project`.`reports` (
  `REPORT_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `PATH`      VARCHAR(255),
  `DATA`      BLOB,

  PRIMARY KEY (`REPORT_ID`) USING BTREE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_status
-- table for mapping employee and status.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`employee_status`;
CREATE TABLE `goit_final_project`.`employee_status` (
  `EMPLOYEE_ID`    INT(10) UNSIGNED NOT NULL,
  `STATUS_ID`      INT(10) UNSIGNED NOT NULL,
  `START_DATETIME` DATETIME         NOT NULL,
  `END_DATETIME`   DATETIME         NOT NULL,

  FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `goit_final_project`.`employees` (`EMPLOYEE_ID`),
  FOREIGN KEY (`STATUS_ID`) REFERENCES `goit_final_project`.`statuses` (`STATUS_ID`),

  UNIQUE (`STATUS_ID`, `EMPLOYEE_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_events
-- table for mapping employee and events.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`employee_events`;
CREATE TABLE `goit_final_project`.`employee_events` (
  `EMPLOYEE_ID` INT(10) UNSIGNED NOT NULL,
  `EVENT_ID`    INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `goit_final_project`.`employees` (`EMPLOYEE_ID`),
  FOREIGN KEY (`EVENT_ID`) REFERENCES `goit_final_project`.`events` (`EVENT_ID`),

  UNIQUE (`EVENT_ID`, `EMPLOYEE_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_reports
-- table for mapping employee and reports.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`employee_reports`;
CREATE TABLE `goit_final_project`.`employee_reports` (
  `EMPLOYEE_ID` INT(10) UNSIGNED NOT NULL,
  `REPORT_ID`   INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `goit_final_project`.`employees` (`EMPLOYEE_ID`),
  FOREIGN KEY (`REPORT_ID`) REFERENCES `goit_final_project`.`reports` (`REPORT_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_roles
-- table for mapping employee and role.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`employee_role`;
CREATE TABLE `goit_final_project`.`employee_role` (
  `EMPLOYEE_ID` INT(10) UNSIGNED NOT NULL,
  `ROLE_ID`     INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `goit_final_project`.`employees` (`EMPLOYEE_ID`),
  FOREIGN KEY (`ROLE_ID`) REFERENCES `goit_final_project`.`roles` (`ROLE_ID`),

  UNIQUE (`EMPLOYEE_ID`, `ROLE_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_departments
-- table for mapping employee and department.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`employee_department`;
CREATE TABLE `goit_final_project`.`employee_department` (
  `EMPLOYEE_ID`   INT(10) UNSIGNED NOT NULL,
  `DEPARTMENT_ID` INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `goit_final_project`.`employees` (`EMPLOYEE_ID`),
  FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `goit_final_project`.`departments` (`DEPARTMENT_ID`),

  UNIQUE (`EMPLOYEE_ID`, `DEPARTMENT_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_departments
-- table for mapping employee and position.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goit_final_project`.`employee_position`;
CREATE TABLE `goit_final_project`.`employee_position` (
  `EMPLOYEE_ID` INT(10) UNSIGNED NOT NULL,
  `POSITION_ID` INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `goit_final_project`.`employees` (`EMPLOYEE_ID`),
  FOREIGN KEY (`POSITION_ID`) REFERENCES `goit_final_project`.`positions` (`POSITION_ID`),

  UNIQUE (`EMPLOYEE_ID`, `POSITION_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;