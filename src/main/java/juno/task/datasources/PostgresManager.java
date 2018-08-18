package juno.task.datasources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import juno.task.PropertiesLoader;

public class PostgresManager implements IDataSourceManager {

	PropertiesLoader propertiesLoader = PropertiesLoader.getInstance();

	public List<List<String>> query(String query, List<String> output) throws ClassNotFoundException, SQLException {
		List<List<String>> result = new ArrayList<List<String>>();
		String driver = propertiesLoader.getPostgresDriver();
		Class.forName(driver);
		String dbName = propertiesLoader.getPostgresDbName();
		String host = propertiesLoader.getPostgresHost();
		String port = propertiesLoader.getPostgresPort();
		String user = propertiesLoader.getPostgresUser();
		String password = propertiesLoader.getPostgresPassword();
		Connection c = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + dbName, user,
				password);
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			List<String> row = new ArrayList<String>();
			for (String v : output) {
				String string = rs.getString(v);
				row.add(string);
			}
			result.add(row);
		}
		return result;
	}
}