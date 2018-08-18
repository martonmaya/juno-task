package juno.task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	private static PropertiesLoader instance = new PropertiesLoader();
	private String postgresDbName;
	private String postgresHost;
	private String postgresPort;
	private String postgresUser;
	private String postgresPassword;
	private String outputFile;
	private String postgresDriver;

	public static PropertiesLoader getInstance() {
		return instance;
	}

	private PropertiesLoader() {

		Properties prop = new Properties();
		InputStream input;
		try {
			try {
				input = new FileInputStream("./config.properties");
			} catch (Exception e) {
				// tests
				input = new FileInputStream("/opt/juno/config.properties");
			}
			prop.load(input);
			postgresDbName = prop.getProperty("postgres_db_name");
			postgresHost = prop.getProperty("postgres_host");
			postgresPort = prop.getProperty("postgres_port");
			postgresUser = prop.getProperty("postgres_user");
			postgresPassword = prop.getProperty("postgres_password");
			postgresDriver = "org.postgresql.Driver";

			outputFile = prop.getProperty("output_file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPostgresHost() {
		return postgresHost;
	}

	public String getPostgresDbName() {
		return postgresDbName;
	}

	public String getPostgresPort() {
		return postgresPort;
	}

	public String getPostgresUser() {
		return postgresUser;
	}

	public String getPostgresPassword() {
		return postgresPassword;
	}

	public String getPostgresDriver() {
		return postgresDriver;
	}

	public String getOutputFile() {
		return outputFile;
	}
}