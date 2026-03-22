-- ============================================================
-- Task 13: Employee REST API - SQL Server Setup Script
-- Server: localhost\SQLEXPRESS
-- Run this in SSMS Query Window
-- ============================================================

-- Step 1: Create the database
CREATE DATABASE employee;
GO

-- Step 2: Switch to the new database
USE employee;
GO

-- Step 3: Create the employees table
CREATE TABLE employees (
    id         BIGINT        IDENTITY(1,1) PRIMARY KEY,
    name       VARCHAR(100)  NOT NULL,
    email      VARCHAR(150)  UNIQUE NOT NULL,
    salary     DECIMAL(10,2) NOT NULL,
    department VARCHAR(100)  NOT NULL
);
GO

-- Step 4: Verify the table was created
SELECT TABLE_NAME
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_CATALOG = 'employee';
GO

-- Step 5: Optional - Insert sample test data
INSERT INTO employees (name, email, salary, department)
VALUES
    ('John Smith',    'john.smith@gmail.com',    50000.00, 'IT'),
    ('Sarah Johnson', 'sarah.johnson@gmail.com', 65000.00, 'HR'),
    ('Mike Wilson',   'mike.wilson@gmail.com',   72000.00, 'Finance');
GO

-- Step 6: Verify sample data
SELECT * FROM employees;
GO
