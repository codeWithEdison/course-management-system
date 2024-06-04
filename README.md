# Course Management System (CMS)

## Overview
This Course Management System (CMS) is a Java application built using the Model-View-Controller (MVC) architectural pattern.
It allows users to perform CRUD (Create, Read, Update, Delete) operations on courses stored in a MySQL database. The application provides a graphical user interface (GUI) for easy interaction.

## Features
1. **View Courses:** Display a list of all courses, including their names, assigned teachers, and categories.
2. **Add Course:** Add a new course to the system, specifying its name, assigned teacher, and category.
3. **Update Course:** Modify existing course details, such as name, assigned teacher, or category.
4. **Delete Course:** Remove a course from the system.

## Requirements
- Java Development Kit (JDK) 8 or higher
- MySQL database server

## Installation
1. **Clone the Repository:** Clone this repository to your local machine using Git:
   ```
   git clone https://github.com/codeWithEdison/Course-Management-sytem.git
   ```

2. **Import Database Schema:** Set up the MySQL database by executing the SQL script provided in the `schema.sql` file. This script will create the necessary tables (`Teacher` and `Course`) and insert sample data for testing.

3. **Configure Database Connection:** Update the database connection details in the `util.DatabaseConnection` class to match your MySQL server configuration (URL, username, and password).

4. **Compile the Code:** Compile the Java source files using the following command:
   ```
   javac *.java
   ```

5. **Run the Application:** Execute the main class `Main` to launch the application:
   ```
   java Main
   ```

## Usage
1. **View Courses:** Upon launching the application, you will see a table displaying all existing courses.
2. **Add Course:** Click the "Save" button to add a new course. Enter the course details in the provided fields and click "Save" again to confirm.
3. **Update Course:** Select a course from the table by clicking on its row. Modify the course details in the input fields, then click the "Update" button to save the changes.
4. **Delete Course:** Select a course from the table, then click the "Delete" button to remove it from the system.

## Troubleshooting
- **Database Connection Issues:** Ensure that the database connection details in `util.DatabaseConnection` are correct and that the MySQL server is running.
- **Compilation Errors:** Check for any compilation errors and resolve them by correcting the source code.

## License
This project is licensed under the [MIT License](LICENSE).

## Credits
- Developed by code with edison

## Support
For any inquiries or support requests, please contact edsnkvn@gmail.com.
