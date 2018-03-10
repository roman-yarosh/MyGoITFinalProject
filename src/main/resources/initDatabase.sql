-- -----------------------------------------------------
-- Drop database if exist
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS goit_final_project;

-- -----------------------------------------------------
-- Create database if not exists: goit_final_project;
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS goit_final_project
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

-- -----------------------------------------------------
-- Use database: goit_final_project
-- -----------------------------------------------------
USE goit_final_project;

-- -----------------------------------------------------
-- Table: employees
-- stores information about employees.
-- -----------------------------------------------------
DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
  EMPLOYEE_ID     INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
--  LOGIN           VARCHAR(20)      NOT NULL,
--  PASSWORD        VARCHAR(20)      NOT NULL,
  NAME            VARCHAR(20)      NOT NULL,
  SURNAME         VARCHAR(20)      NOT NULL,
  MIDDLE_NAME     VARCHAR(20),
  EMAIL           VARCHAR(50)      NOT NULL,
--  SALLARY_RATE    DECIMAL          NOT NULL,
  ROLE_ID         INT              NOT NULL,
  POSITION_ID     INT              NOT NULL,
  DEPARTMENT_ID   INT              NOT NULL,
  EVENT_ID        INT,
  STATUS_ID       INT,
  REGISTERED_DATE DATETIME         NOT NULL,

  PRIMARY KEY (EMPLOYEE_ID) USING BTREE,
  UNIQUE KEY UNI_LOGIN (LOGIN),
  UNIQUE KEY UNI_EMAIL (EMAIL)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: roles
-- stores information about user roles.
-- -----------------------------------------------------
DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  ROLE_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  NAME    VARCHAR(255)     NOT NULL,

  PRIMARY KEY (ROLE_ID) USING BTREE,
  UNIQUE KEY UNI_NAME (NAME)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: users
-- stores information about users.
-- -----------------------------------------------------
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  USER_ID  INT          NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(255) NOT NULL,
  PASSWORD VARCHAR(255) NOT NULL,

  PRIMARY KEY (USER_ID) USING BTREE,
  UNIQUE KEY UNI_USERNAME (USERNAME)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: departments
-- stores information about departments.
-- -----------------------------------------------------
DROP TABLE IF EXISTS departments;
CREATE TABLE departments (
  DEPARTMENT_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  NAME          VARCHAR(128)     NOT NULL,

  PRIMARY KEY (DEPARTMENT_ID) USING BTREE,
  UNIQUE KEY UNI_NAME (NAME)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: positions
-- stores information about positions.
-- -----------------------------------------------------
DROP TABLE IF EXISTS positions;
CREATE TABLE positions (
  POSITION_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  NAME        VARCHAR(128) NOT NULL,

  PRIMARY KEY (POSITION_ID) USING BTREE,
  UNIQUE KEY UNI_NAME (NAME)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: events
-- stores information about events.
-- -----------------------------------------------------
DROP TABLE IF EXISTS events;
CREATE TABLE events (
  EVENT_ID            INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  NAME                VARCHAR(128)     NOT NULL,
  TYPE                VARCHAR(128)     NOT NULL,
  START_DATETIME      DATETIME         NOT NULL,
  END_DATETIME        DATETIME         NOT NULL,
  CREATED_EMPLOYEE_ID INT              NOT NULL,

  PRIMARY KEY (EVENT_ID) USING BTREE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: statuses
-- stores information about statuses.
-- -----------------------------------------------------
DROP TABLE IF EXISTS statuses;
CREATE TABLE statuses (
  STATUS_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  TYPE      VARCHAR(10)      NOT NULL,

  PRIMARY KEY (STATUS_ID) USING BTREE,
  UNIQUE KEY UNI_TYPE (TYPE)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_status
-- table for mapping employee and status.
-- !!! Statuses will be one to many not many to many, so this table is not need
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS employee_status;
-- CREATE TABLE employee_status (
--  EMPLOYEE_ID    INT(10) UNSIGNED NOT NULL,
--  STATUS_ID      INT(10) UNSIGNED NOT NULL,
--  START_DATETIME DATETIME         NOT NULL,
--  END_DATETIME   DATETIME         NOT NULL,

--  FOREIGN KEY (EMPLOYEE_ID) REFERENCES employees (EMPLOYEE_ID),
--  FOREIGN KEY (STATUS_ID) REFERENCES statuses (STATUS_ID),

--  UNIQUE (STATUS_ID, EMPLOYEE_ID)
-- )
--  ENGINE = InnoDB
--  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_events
-- table for mapping employee and events.
-- -----------------------------------------------------

DROP TABLE IF EXISTS employee_events;
CREATE TABLE employee_events (
  EMPLOYEE_ID INT(10) UNSIGNED NOT NULL,
  EVENT_ID    INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (EMPLOYEE_ID) REFERENCES employees (EMPLOYEE_ID),
  FOREIGN KEY (EVENT_ID) REFERENCES events (EVENT_ID),

  UNIQUE (EVENT_ID, EMPLOYEE_ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: user_roles
-- table for mapping user and role.
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles (
  USER_ID     INT(10) UNSIGNED NOT NULL,
  ROLE_ID     INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (USER_ID) REFERENCES users (USER_ID),
  FOREIGN KEY (ROLE_ID) REFERENCES roles (ROLE_ID),

  UNIQUE (USER_ID, ROLE_ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_departments
-- table for mapping employee and department.
-- -----------------------------------------------------
DROP TABLE IF EXISTS employee_department;
CREATE TABLE employee_department (
  EMPLOYEE_ID   INT(10) UNSIGNED NOT NULL,
  DEPARTMENT_ID INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (EMPLOYEE_ID) REFERENCES employees (EMPLOYEE_ID),
  FOREIGN KEY (DEPARTMENT_ID) REFERENCES departments (DEPARTMENT_ID),

  UNIQUE (EMPLOYEE_ID, DEPARTMENT_ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_departments
-- table for mapping employee and position.
-- -----------------------------------------------------
DROP TABLE IF EXISTS employee_position;
CREATE TABLE employee_position (
  EMPLOYEE_ID INT(10) UNSIGNED NOT NULL,
  POSITION_ID INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (EMPLOYEE_ID) REFERENCES employees (EMPLOYEE_ID),
  FOREIGN KEY (POSITION_ID) REFERENCES positions (POSITION_ID),

  UNIQUE (EMPLOYEE_ID, POSITION_ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table: employee_salary_from_month
-- table for employee salary from one month
-- -----------------------------------------------------
CREATE TABLE employee_salary_from_month (
  EMPLOYEE_ID INT(10) UNSIGNED NOT NULL,
  MONTH       INT              NOT NULL,
  YAER        INT              NOT NULL,
--  SALARY_DATE DATE             NOT NULL,
  SALARY_SUM  DECIMAL          NOT NULL,

  FOREIGN KEY (EMPLOYEE_ID) REFERENCES employees (EMPLOYEE_ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;