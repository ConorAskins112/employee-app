# employee-app
Employee app for Software Development tool Module
This is a Kotlin program that implements a simple Employee management system. It provides the following functionalities:

Add Employee: To add a new employee to the system.

List Employees: To list all the employees in the system.

Search Employee: To search for a specific employee based on their ID.

Pay Slip: To generate the payslip for a specific employee based on their ID.

Delete Employee: To delete a specific employee based on their ID.

Update Employee: To update an existing employee's information.

The program uses a class called EmployeeAPI to interact with the data store, which can be an in-memory database or a database on disk. The class provides the following methods:

create(employee: Employee): To create a new employee in the database.

findOne(employeeID: Int): To find a specific employee based on their ID.

findAll(): To find all the employees in the database.

delete(employee: Employee): To delete a specific employee from the database.

The Employee class represents the employee information, including their name, gender, ID, gross salary, and various deductions like PAYE and PRSI.

The program starts executing in the main function. It displays a menu to the user and calls different functions based on the user's input. The dummyData function is used to insert some test data into the database for testing purposes. The program uses the Kotlin Logging library for logging messages and the Kotlin Standard Library's readLine function to read user inputs from the console.
