package model;

public class TypeBookModel{

    private int id;
    private String type;

    public TypeBookModel(String type){
        this.type = type;
    }

    public TypeBookModel(int id, String type){
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}