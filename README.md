"# FinalProject" 

Vacation Planner

As title states, this is a tool to help you plan a vacation. You can create iternaries to keep track of where you are going on your vacation whether it be one destination or multiple along your trip path.

Tested using Postman with Database creation from MySQL Workbench as a local host. Table should populate automatically when testing with JSON in Postman. 

This is just a final project and does not intend to have any contributions other than my own.

## Installation

Before you start, ensure you have the following software installed on your system:

- Java JDK (Version 11 or later)
- Maven
- MySQL (or any database that you plan to use)

1. **Clone the Repository**
   
   Clone this repository to your local machine using the following command in your terminal:

git clone git@github.com:thesaltysenor/FinalProjectOfficial.git


2. **Navigate to the Project Directory**

cd vacation-planner



3. **Configure the Database**

In the `src/main/resources/application.properties` file, update the following properties with your database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=vacation_planner
spring.datasource.password=vacation_planner


Make sure to replace `your_database`, `your_username`, and `your_password` with your actual MySQL database name, username, and password.

4. **Build the Project**

Now you can build the project using Maven. Run the following command:

mvn clean install


5. **Run the Application**

After the successful build, you can start the application with this command:

mvn spring-boot:run


Now, your application should be running on `http://localhost:8080`.

**NOTE**: These instructions are for a typical Java Spring Boot application and might need adjustments based on your specific project setup.


