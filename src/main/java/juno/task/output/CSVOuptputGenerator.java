package juno.task.output;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import juno.task.PropertiesLoader;

public class CSVOuptputGenerator implements IOutputGenerator {

	PropertiesLoader propertiesLoader = PropertiesLoader.getInstance();

	public void generateOutputfile(List<String> output, List<List<String>> result) throws IOException {
		CsvSchema.Builder schemaBuilder = CsvSchema.builder();
		for (String col : output) {
			schemaBuilder.addColumn(col);
		}
		CsvSchema schema = schemaBuilder.build().withLineSeparator("\r").withHeader();
		CsvMapper mapper = new CsvMapper();
		ObjectWriter writer = mapper.writerFor(List.class).with(schema);
		String outputFile = propertiesLoader.getOutputFile();
		File tempFile = new File(outputFile);
		writer.writeValues(tempFile).writeAll(result);
	}
}