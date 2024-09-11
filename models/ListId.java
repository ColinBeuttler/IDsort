package models;

public class ListId {

    // fields for id object
    int id;
    int listId;
    int name;

    // Constructor
    public ListId(int id, int listId, int name) {
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

    public int getName() {
        return this.name;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public void setName(int name) {
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