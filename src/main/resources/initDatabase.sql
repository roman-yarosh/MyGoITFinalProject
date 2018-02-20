-- Create database if not exists and use it: goit_final_project;
CREATE DATABASE IF NOT EXISTS goit_final_project
  CHARACTER SET utf8
  COLLATE utf8_general_ci;
USE goit_final_project;

-- Table: roles
-- stores information about user roles.
CREATE TABLE roles (
  id   INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: employees
-- stores information about employees.
CREATE TABLE employees (
  id              INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  login           VARCHAR(128) NOT NULL,
  password        VARCHAR(128) NOT NULL,
  primary_name    VARCHAR(128) NOT NULL,
  surname         VARCHAR(128) NOT NULL,
  middle_name     VARCHAR(128),
  sallary_rate    DECIMAL      NOT NULL,
  role_id         INT          NOT NULL,
  possition_id    INT          NOT NULL,
  department_id   INT          NOT NULL,
  event_id        INT,
  status_id       INT,
  registered_date DATETIME
)
  ENGINE = InnoDB;

-- Table: departments
-- stores information about departments.
CREATE TABLE departments (
  id   INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(128) NOT NULL
)
  ENGINE = InnoDB;

-- Table: positions
-- stores information about positions.
CREATE TABLE positions (
  id   INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(128) NOT NULL
)
  ENGINE = InnoDB;

-- Table: events
-- stores information about events.
CREATE TABLE events (
  id                  INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name                VARCHAR(128) NOT NULL,
  type                VARCHAR(128) NOT NULL,
  start_datetime      DATETIME     NOT NULL,
  end_datetime        DATETIME     NOT NULL,
  created_employee_id INT          NOT NULL
)
  ENGINE = InnoDB;

-- Table: statuses
-- stores information about statuses.
CREATE TABLE statuses (
  id   INT UNSIGNED NOT NULL PRIMARY KEY,
  name VARCHAR(128)
)
  ENGINE = InnoDB;

-- Table: reports
-- stores information about report files.
CREATE TABLE reports (
  id   INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  path VARCHAR(255),
  data BLOB
)
  ENGINE = FILES;

-- Table: status_employees
-- table for mapping statuses and employees.
CREATE TABLE status_employees (
  status_id      INT UNSIGNED NOT NULL,
  employee_id    INT UNSIGNED NOT NULL,
  start_datetime DATETIME     NOT NULL,
  end_datetime   DATETIME     NOT NULL,

  FOREIGN KEY (status_id) REFERENCES statuses (id),
  FOREIGN KEY (employee_id) REFERENCES employees (id),

  UNIQUE (status_id, employee_id)
)
  ENGINE = InnoDB;

-- Table: event_employees
-- table for mapping events and employees.
CREATE TABLE event_employees (
  event_id    INT UNSIGNED NOT NULL,
  employee_id INT UNSIGNED NOT NULL,

  FOREIGN KEY (event_id) REFERENCES events (id),
  FOREIGN KEY (employee_id) REFERENCES employees (id),

  UNIQUE (event_id, employee_id)
)
  ENGINE = InnoDB;

-- Table: report_employees
-- table for mapping reports and employees.
CREATE TABLE report_employees (
  report_id   INT UNSIGNED NOT NULL,
  employee_id INT UNSIGNED NOT NULL,

  FOREIGN KEY (report_id) REFERENCES reports (id),
  FOREIGN KEY (employee_id) REFERENCES employees (id),

  UNIQUE (report_id, employee_id)
)
  ENGINE = InnoDB;
