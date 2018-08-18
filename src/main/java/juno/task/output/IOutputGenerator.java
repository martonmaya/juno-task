package juno.task.output;

import java.io.IOException;
import java.util.List;

public interface IOutputGenerator {

	public void generateOutputfile(List<String> output, List<List<String>> result) throws IOException;

}
