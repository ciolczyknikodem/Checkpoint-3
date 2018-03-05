package model;

public class BookType {

    private int typeID;
    private String type;

    public BookType(String type, int typeID) {
        this.typeID = typeID;
        this.type = type;
    }

    public BookType(String type) {
        this.type = type;
    }
}
