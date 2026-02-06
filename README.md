HireHub – Job Portal Web Application

HireHub is a full-stack Job Portal web application built using Java, JSP, Servlets, and MySQL.
It allows users to register, login securely, browse jobs, and apply for positions, while admins can manage job postings and view applications.

This project focuses on real-world backend concepts like authentication, session management, role-based access, and secure password storage.


---

🚀 Features

👤 User

Signup & Login

Secure authentication using password hashing + salt

View available jobs

Apply for jobs

Prevent duplicate applications

Logout



---

🛠 Admin

Admin login

Post new jobs

Edit existing jobs

Delete jobs

View all applications

Add required skills to job postings



---

🔐 Password Security

Passwords are never stored in plain text.

During signup:

A unique salt is generated for each user

Password is hashed using the salt

Only the hashed password and salt are stored in the database


During login:

Entered password is hashed again using the stored salt

Hashes are compared for authentication


This approach improves security and protects user credentials even if the database is compromised.


---

🧰 Tech Stack

Java (Servlets + JSP)

JDBC

MySQL

HTML / CSS / JavaScript

Apache Tomcat

Git & GitHub



---

📂 Project Structure

JobPortal/
│
├── src/
│   ├── controller/
│   ├── dao/
│   ├── model/
│   └── util/
│
├── WebContent/
│   ├── css/
│   ├── images/
│   ├── WEB-INF/
│   └── *.jsp
│
├── screenshots/
├── database.sql
└── README.md


---

🗄 Database

MySQL is used as backend database.

Import database.sql included in this repo.

Tables:

users

jobs

applications



---

▶ How to Run

1. Clone repository:



git clone https://github.com/YOUR_USERNAME/JobPortal.git

2. Import project into Eclipse


3. Configure Tomcat server


4. Import database.sql into MySQL


5. Update DB credentials in DBUtil.java


6. Run project on server


7. Open in browser:



http://localhost:8080/JobPortal/login.jsp


---

🔑 Sample Roles

You can create accounts normally for users.

Admin role can be assigned manually in database:

UPDATE users SET role='ADMIN' WHERE username='admin';


---

📸 Screenshots

Screenshots are available inside /screenshots folder.


---

📚 What I Learned

JSP & Servlet workflow

MVC architecture

JDBC integration

Session handling

Role based access (Admin/User)

Password hashing with salt

CRUD operations

GitHub version control

Frontend styling



---

🌱 Future Improvements

Email OTP verification

Resume upload

Profile management

Job search & filters

Pagination

REST API integration



---

👨‍💻 Author

Manu M


---
