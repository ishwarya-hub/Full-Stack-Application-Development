-- ============================================================
--  Task 10 : Spring Boot CRUD Application — SQL Setup Script
--  Database : studentdb
--  Table    : students
-- ============================================================

-- Step 1: Create the database
CREATE DATABASE studentdb;
GO

-- Step 2: Use the database
USE studentdb;
GO

-- Step 3: Create the students table
CREATE TABLE students (
    id         INT IDENTITY(1,1) PRIMARY KEY,
    name       VARCHAR(50)  NOT NULL,
    department VARCHAR(50)  NOT NULL
);
GO

-- ============================================================
--  Sample Data (Optional — for testing without Postman)
-- ============================================================

INSERT INTO students (name, department) VALUES ('Arun', 'CSE');
INSERT INTO students (name, department) VALUES ('Priya', 'ECE');
INSERT INTO students (name, department) VALUES ('Ravi', 'IT');
GO

-- ============================================================
--  Verification Queries
-- ============================================================

-- View all students
SELECT * FROM students;

-- View one student by ID
SELECT * FROM students WHERE id = 1;

-- Update a student
UPDATE students SET name = 'Arun Kumar', department = 'IT' WHERE id = 1;

-- Delete a student
DELETE FROM students WHERE id = 1;

-- Count total students
SELECT COUNT(*) AS TotalStudents FROM students;

-- ============================================================
--  Cleanup (Run only if you want to reset)
-- ============================================================

-- DROP TABLE students;
-- DROP DATABASE studentdb;
