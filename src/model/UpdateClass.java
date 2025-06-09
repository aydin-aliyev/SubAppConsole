package model;

public class UpdateClass <T> {
    T columnValue;
    T value;
    int id;

    public UpdateClass() {
    }
//
    public UpdateClass(T columnValue, T value, int id) {
        this.columnValue = columnValue;
        this.value = value;
        this.id = id;
    }

    public T getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(T columnValue) {
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
