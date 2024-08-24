The final project is created using spring boot, spring JPA, Lombok, MYSQL and JDBC. All the serivce, repository and main class are properly initialized and connected to the mysql database to perform crud operations. The database name can be configured according to the database you use.
To install and use the final project in your system,, the steps are as follows:
Create a spring initializr project in your preffered IDE, and import the following dependencies: Lombok,Spring Dev Tools, Spring JPA, J connector for MYSQL.
import the entity classes, service classes, repositor classes, and main classes.
configure the application.properties file to add the following details to it:spring.application.name=registration
spring.datasource.url=jdbc:mysql://localhost:3306/registration
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
You can modify the database and package name according to your own preference.
If everything is connected successfully and the main project file is run, it will create 2 tables named courses and student in your mysql connection(Note: the data for courses was added manually in order to reduce clutter in the main file, it can also be added inside the run file by creating its object and using set method to set its properties)
The app is now ready to use! 
