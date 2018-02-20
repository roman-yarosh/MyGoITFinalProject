-- Create database if not exists and use it: goit_final_project;
CREATE DATABASE IF NOT EXISTS goit_final_project
  CHARACTER SET utf8
  COLLATE utf8_general_ci;
USE goit_final_project;

-- Table: roles
-- stores information about user roles.
CREATE TABLE roles (
  id   INT          NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;