package uk.ac.ucl.model;
import java.util.ArrayList;
//Write a class Column, where a column has a name and an ArrayList of rows.
//Provide methods getName, getSize, getRowValue, setRowValue, and addRowValue (to add a new
//row). Determine what the parameters and return types should be. If you find additional methods
//are needed when answering later questions then add them, but only when you need them.
public class Column {
    private String name;
    private ArrayList<String> rows;

public Column(String name){
        this.name = name;
        this.rows = new ArrayList<String>();
    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return rows.size();
    }

    public String getRowValue(int index){
        if (index >= 0 && index < rows.size()) {
            return rows.get(index);
        } else {
            return null;

        }
    }


    public void setRowValue(int index, String value){
        if (index >= 0 && index < rows.size()) {
            rows.set(index, value);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);

        }
    }

    public void addRowValue(String value){
        rows.add(value);
    }

    public ArrayList<String> getRows(){
        return rows;
    }

}
