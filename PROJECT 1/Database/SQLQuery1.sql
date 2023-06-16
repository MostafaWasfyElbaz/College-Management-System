create database Modern_Tech_Collage_DB

use Modern_Tech_Collage_DB

-- Create Instructor table
CREATE TABLE Instructor (
  Instructor_ID int PRIMARY KEY,
  F_Name VARCHAR(50) not null,
  L_Name VARCHAR(50) not null,
  Phone VARCHAR(50),
  D_Name  VARCHAR(50),
  FOREIGN KEY (D_Name) REFERENCES Department(D_Name)
);

-- Create Department table
CREATE TABLE Department (
  D_Name VARCHAR(50) primary key ,
  Location VARCHAR(50),
  Head_ID int,

);

-- Create Course table
CREATE TABLE Course (
  C_ID INT PRIMARY KEY,
  C_Name VARCHAR(50) not null,
  Duration INT not null,
  Instructor_ID int,
  FOREIGN KEY (Instructor_ID) REFERENCES Instructor(Instructor_ID)
);

-- Create Student table
CREATE TABLE Student (
  Student_ID INT PRIMARY KEY,
  F_Name VARCHAR(50) not null,
  L_Name VARCHAR(50) not null,
  Phone VARCHAR(50)
);

-- Create Enrollment table
CREATE TABLE Enrollment (
  Student_ID INT ,
  C_ID INT,
  FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID),
  FOREIGN KEY (C_ID) REFERENCES Course(C_ID)
);