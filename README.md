# Java_EE-Login_App
Developed a Login web-app which validates your username and password from a MySQL Database and redirects accordingly

* Java, Servlets, JavaServerPages (JSP), JDBC, Javascript, CSS3, BootStrap.
* It validates the username and password entered against a mySQL database to check if the credentials exist in the database.
* If exists, it will redirect you to the 'Success' page and creates a session with you 'name' from the DB.
* Otherwise it will redirect you to the 'Failure' page and creates a session with the name 'User'.
* During Login, if the 'username' & 'password' fields are left empty, Javascript will prompt the user by displaying an error message.
* The SQL script to create a database and add dummy values has been provided in the project.
