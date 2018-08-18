package juno.task.datasources;

import java.sql.SQLException;
import java.util.List;

public interface IDataSourceManager {

	public List<List<String>> query(String query, List<String> output) throws ClassNotFoundException, SQLException;
}
