package uk.ac.ucl.model;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Model
{
  // The example code in this class should be replaced by your Model class code.
  // The data should be stored in a suitable data structure.
  private DataFrame dataFrame;

  public Model(String dataFilePath) throws IOException {
    DataLoader loader = new DataLoader();
    this.dataFrame = loader.loadDataFrame(dataFilePath);
  }

  public DataFrame getDataFrame() {
    return dataFrame;
  }

  // Use methods from DataFrame to access and manipulate data
  public ArrayList<String> getColumnNames() {
    return dataFrame.getColumnNames();
  }

  public String getValue(String columnName, int row) {
    return dataFrame.getValue(columnName, row);
  }

  public ArrayList<String> getColumnValues(String columnName) {
    return dataFrame.getColumnValues(columnName);
  }

  public List<String> getPatientNames()
  {
    return readFile("data/patients100.csv");
  }

  // This method illustrates how to read csv data from a file.
  // The data files are stored in the root directory of the project (the directory your project is in),
  // in the directory named data.
  public List<String> readFile(String fileName)
  {
    List<String> data = new ArrayList<>();

    try (Reader reader = new FileReader(fileName);
         CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT))
    {
      for (CSVRecord csvRecord : csvParser)
      {
        // The first row of the file contains the column headers, so is not actual data.
        data.add(csvRecord.get(0));
      }
    } catch (IOException e)
    {
      e.printStackTrace();
    }
    return data;
  }

  // This also returns dummy data. The real version should use the keyword parameter to search
  // the data and return a list of matching items.
    //System.out.println("Search keyword is: "+ keyword);
    //return List.of("Search keyword is: "+ keyword, "result1", "result2", "result3");


  public DataFrame searchFor(String searchString) {
    DataFrame filteredFrame = new DataFrame();
    for (Column column : dataFrame.getColumns()) {
      Column resultColumn = new Column(column.getName());
      for (int row = 0; row < column.getSize(); row++) {
        String cellValue = column.getRowValue(row);
        if (cellValue.contains(searchString)) {
          resultColumn.addRowValue(cellValue);


        }
      }
      if (!resultColumn.getRows().isEmpty()) {
        filteredFrame.addColumn(resultColumn);
      }
    }
    return filteredFrame;
  }
}




