package model;

public class UpdateClass <T> {
    String columnValue;
    T value;
    int id;

    public UpdateClass() {
    }
//
    public UpdateClass(String columnValue, T value, int id) {
        this.columnValue = columnValue;
        this.value = value;
        this.id = id;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
