# Sboj.gb
**Sboj.gb** is an application for job offers. We have been tasked to implement this application for an unusually low price, by an unusually rich client. There are several requirements to follow in the implementation.
## 1.Database Requirements
The **Database** of the **Sboj.gb** application needs to support **2 entities**:
### User
* Has an **Username**
* Has a **Password**
* Has an **Email**
### Job Application
* Has a **Sector**
* Has a **Profession**
* Has a **Salary**
* Has a **Description**

## Functional Requirements
The Functionality Requirements describe the functionality that the Application must support.
The application should provide **Guest** (not logged in) users with the functionality to login, register and view the Index page.
The application should provide **Users** (logged in) with the functionality to logout, create a Job, view details about a Job, delete a Job, and view all Jobs (Home page).
The application should provide functionality for adding jobs with only 5 sectors – “Medicine”, “Car”, “Food”, “Domestic”, “Security”.
The application should store its data into a MySQL database, using Hibernate native.
## Security Requirements
The Security Requirements are mainly access requirements. Configurations about which users can access specific functionalities and pages.
* Guest (not logged in) users can access Index page.
* Guest (not logged in) users can access Login page.
* Guest (not logged in) users can access Register page.
* Users (logged in) can access Home page.
* Users (logged in) can access Job Details page.
* Users (logged in) can access Job Delete page.
* Users (logged in) can access Add Job page.
* Users (logged in) can access Logout functionality.
