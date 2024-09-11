package models;

public class ListId {

    // fields for id object
    int id;
    int listId;
    private String name;

    // Constructor
    public ListId(int id, int listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public int getListId() {
        return this.listId;
    }

    public String getName() {
        return this.name;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                " id: " + getId() +
                ", listId: " + getListId() +
                ", name: '" + "Item " + getName() + "'" +
                "}";
    }

}