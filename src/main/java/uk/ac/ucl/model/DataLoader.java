package uk.ac.ucl.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader {

    public DataFrame loadDataFrame(String filePath) throws IOException {
        DataFrame df = new DataFrame();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the first line (column names)
            String line = reader.readLine();
            if (line != null) {
                String[] columnNames = line.split(",");
                for (String name : columnNames) {
                    df.addColumn(new Column(name)); // Remove leading/trailing spaces
                }
            }

            // Read remaining lines (data)
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                /*if (values.length != df.getColumnNames().size()) {
                    throw new IOException("Invalid data line: Inconsistent number of values");
                }*/

                // Add data to each column
                for (int i = 0; i < values.length; i++) {
                    df.addValue(df.getColumnNames().get(i), values[i].trim()); // Remove leading/trailing spaces
                }
            }
        }
        return df;
    }
}
