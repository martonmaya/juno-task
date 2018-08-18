package juno.task;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juno.task.datasources.PostgresManager;
import juno.task.output.CSVOuptputGenerator;

public class Main {

	private static final String YELLOW = "\033[33m";
	private static final String RED = "\033[31m";
	private static final String END_COLOR = "\033[0m";
	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void main(String[] args) {

		if (args.length != 2) {
			printOutError("Input must contains 2 arguments: query and an output format" + NEW_LINE
					+ "Valid execution example: java -jar juno-0.0.1-SNAPSHOT.jar  \"select * from dogs\" \"name, age\"");

		}
		String query = args[0];
		String[] split = args[1].split(",");
		List<String> output = new ArrayList<String>();
		for (String v : split) {
			output.add(v.trim());
		}
		PostgresManager postgresManager = new PostgresManager();
		List<List<String>> result = null;
		try {
			printOut("Executing query " + query);
			result = postgresManager.query(query, output);
			printOut("Query execution finished succefully");
		} catch (ClassNotFoundException e) {
			// driver
			printOutException(e);
		} catch (SQLException e) {
			printOutException(e);
		}
		if (result != null) {
			printOut("Starting of output generator for result set " + result);
			CSVOuptputGenerator csvOuptputGenerator = new CSVOuptputGenerator();
			printOut("Output file generated successfully at " + PropertiesLoader.getInstance().getOutputFile());
			try {
				csvOuptputGenerator.generateOutputfile(output, result);
			} catch (IOException e) {
				printOutException(e);
			}
		} else {
			printOutError("No result was found for given query" + query);
		}
	}

	private static void printOutError(String string) {
		System.out.println(YELLOW + string + END_COLOR);
		System.exit(-1);
	}

	private static void printOut(String string) {
		System.out.println(string);
	}

	private static void printOutException(Exception e) {
		System.err.println(RED + e + END_COLOR);
		System.exit(-1);
	}
}