package datasources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import juno.task.datasources.PostgresManager;

public class PostgresManagerTest {

	/*
	 * To run successfully this test create table name "dogs"
	 * that contains at least the columns: name and age
	 * 
	 * insert 2 rows with following values: 
	 * name=Bond, age=10
	 * name=Gurki, age=8
	 * 
	 */
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM dogs";
		PostgresManager postgresManager = new PostgresManager();
		List<String> output = new ArrayList<String>();
		output.add("name");
		output.add("age");
		List<List<String>> result = postgresManager.query(query, output);

		List<String> bond = result.get(0);
		String bondName = bond.get(0);
		Assert.assertEquals(bondName, "Bond");
		String bondAge = bond.get(1);
		Assert.assertEquals(bondAge, "10");

		List<String> gurki = result.get(1);
		String gurkiName = gurki.get(0);
		Assert.assertEquals(gurkiName, "Gurki");
		String gurkiAge = gurki.get(1);
		Assert.assertEquals(gurkiAge, "8");

		System.out.println(result);
	}
}