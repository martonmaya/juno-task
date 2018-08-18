# juno-task

Java application that gets a query and an output format as an input

Please keep in mind the following:
1. Currently implementation support only PostgresDB as data source. [To add data source you should add implementation to IDataSourceManager]
2. Currently implementation support only CSV (with header) as output format. [To add output format add implementation to IOutputGenerator.]

To run this application you must have config file in the directory which you execute the jar from and contains the following properties:
1. create properties file named config.properties
2. add the following properties:
	2.1. postgres_user --> indicate your postgresDB user you ask to connect with
	2.2. postgres_password --> indicate your postgresDB user's password
	2.3. postgres_db_name --> indicate your postgresDB data base you ask to query
	2.4. postgres_host --> indicate your postgresDB host
	2.5. postgres_port --> indicate your postgresDB port
	2.6. output_file --> indicate the location you ask the output be generate at (for example: /opt/juno/output.csv)

Execution example:
java -jar juno-0.0.1-SNAPSHOT.jar "select * from dogs" "name, age"

Please notice that the project contains 2 tests. 
To execute successfully the attached tests following the instructions that been written inside the tests as comments.
