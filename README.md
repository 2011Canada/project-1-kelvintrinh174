# Expense Reimbursement System

## Project Description

An expense Reimbursement System that allows employees to create new reimbursement requests and finance managers can review, approve or reject them.  

## Technologies Used

* Java 8
* Java Servlet
* Tomcat 9
* JDBC
* PostgreSQL 
* CSS3
* BootStrap
* HTML5
* Javascript ES6
* jQuery

## Features

* Users can login in the system and system can very authentication and/or authorization
* Employees can add new reimbursement requests
* Employees can view past requests and their status
* Finance managers can view all requests and approve or refuse them
* Finance managers can filter requests by requests status

## Getting Started
   
### Clone command:
```
git clone https://github.com/2011Canada/project-1-kelvintrinh174.git
```
### Requires JDK version 8, RDS on AWS, Tomcat Server

#### Step 1:
 * Start Tomcat server

#### Step 2:
 * Verify connection to PostgreSQL database(RDS Recommend) and run script files in SQLScript folder

#### Step 3:
 * Go to http://localhost:8080/reimbursementsystem/client/login.html in your browser

#### Step 4:
 * Login using one of the username and passwords provided in the database
## Usage

* Login as either an Employee or as a Manager
* Employee can make a reimbursement request
* Employee can view all past tickets
* Employee can logout
* Manager can view all tickets 
* Manager can approve/decline tickets
* Manager can filter by ticket status 
* Manager can logout


## License

This project uses the following license: [GNU GENERAL PUBLIC LICENSE](<https://www.gnu.org/licenses/gpl-3.0.en.html>).
