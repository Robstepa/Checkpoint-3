package model;

public class PublisherModel{

    private int id;
    private String name;

    public PublisherModel(String name){
        this.name = name;
    }

    public PublisherModel(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}