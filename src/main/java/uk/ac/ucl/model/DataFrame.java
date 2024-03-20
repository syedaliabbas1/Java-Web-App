package uk.ac.ucl.model;
import java.util.ArrayList;
//Write a class DataFrame to hold a collection of Columns. It should have the
//following methods:
//1. addColumn
//2. getColumnNames (a list of names in the same order as they are stored in the frame).
//3. getRowCount (the number of rows in a column, all columns should have the same number
//of rows when the frame is fully loaded with data).
//4. getValue(columnName, row) to get a row value from a column.
//5. putValue(columnName, row, value) to put a value into a row in a column.
//6. addValue(columnName, value) to add a value to a column (at the end).
public class DataFrame {
    private ArrayList<Column> columns;
    public DataFrame(){
       this.columns = new ArrayList<>();
    }
    public void addColumn(Column column){
        columns.add(column);
    }
    public ArrayList<String> getColumnNames(){
        ArrayList<String> names = new ArrayList<>();
        for (Column column : columns){
            names.add(column.getName());
        }
        return names;
    }
    public int getRowCount(){
        /*int rowCount = columns.get(0).getSize();
        for (Column column : columns){
            if (column.getSize() != rowCount){
                throw new IllegalArgumentException("All columns must have the same number of rows");
            }
        }
        return rowCount;*/
        if (columns.isEmpty()) {
            return 0;
        }
        return columns.get(0).getSize(); // Assuming all columns have the same size
    }

    public String getValue(String columnName, int row){
        for (Column column : columns){
            if (column.getName().equals(columnName)){
                return column.getRowValue(row);
            }
        }
        throw new IllegalArgumentException("Column not found: " + columnName);
    }
    public void putValue(String columnName, int row, String value){
        for (Column column : columns){
            if (column.getName().equals(columnName)){
                column.setRowValue(row, value);
                return;
            }
        }
        throw new IllegalArgumentException("Column not found: " + columnName);
    }
    public void addValue(String columnName, String value){
        for (Column column : columns){
            if (column.getName().equals(columnName)){
                column.addRowValue(value);
                return;
            }
        }
        throw new IllegalArgumentException("Column not found: " + columnName);
    }
    public ArrayList<Column> getColumns(){
        return columns;
    }
    public ArrayList<String> getColumnValues(String columnName){
        for (Column column : columns){
            if (column.getName().equals(columnName)){
                return column.getRows();
            }
        }
        throw new IllegalArgumentException("Column not found: " + columnName);
    }
}
