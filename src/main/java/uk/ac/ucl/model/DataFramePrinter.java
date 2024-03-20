package uk.ac.ucl.model;

public class DataFramePrinter {
    public static void printDataFrame(DataFrame dataFrame) {
        // Print column names
        System.out.println("Column Names:");
        for (String columnName : dataFrame.getColumnNames()) {
            System.out.print(columnName + "\t");
        }
        System.out.println();

        // Print data
        int rowCount = dataFrame.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            for (String columnName : dataFrame.getColumnNames()) {
                System.out.print(dataFrame.getValue(columnName, row) + "\t");
            }
            System.out.println();
        }
    }
}
