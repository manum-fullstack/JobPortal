CREATE DATABASE IF NOT EXISTS jobportal;
USE jobportal;

-- USERS TABLE
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(150),
    password_hash VARCHAR(255) NOT NULL,
    salt VARCHAR(255),
    role VARCHAR(20) DEFAULT 'USER'
);

-- JOBS TABLE
CREATE TABLE jobs (
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200),
    company VARCHAR(200),
    location VARCHAR(150),
    description TEXT,
    skills TEXT,
    posted_by INT,
    FOREIGN KEY (posted_by) REFERENCES users(user_id)
);

-- APPLICATIONS TABLE
CREATE TABLE applications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    job_id INT,
    status VARCHAR(50) DEFAULT 'Applied',
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (job_id) REFERENCES jobs(job_id)
);