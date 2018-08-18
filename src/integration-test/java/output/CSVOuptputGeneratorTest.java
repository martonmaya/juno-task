package output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import juno.task.output.CSVOuptputGenerator;

public class CSVOuptputGeneratorTest {

	@Test
	public void test() throws IOException {
		CSVOuptputGenerator generator = new CSVOuptputGenerator();

		List<String> output = new ArrayList<String>();
		output.add("name");
		output.add("age");

		List<List<String>> result = new ArrayList<List<String>>();

		List<String> bond = new ArrayList<String>();
		bond.add("Bond");
		bond.add("10");
		result.add(bond);

		List<String> gurki = new ArrayList<String>();
		gurki.add("Gurki");
		gurki.add("8");
		result.add(gurki);
		
		generator.generateOutputfile(output, result);
	}
}