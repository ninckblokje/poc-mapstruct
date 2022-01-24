package ninckblokje.poc.mapstruct.model;

public class Item {

    private String field;
    private boolean important;

    public Item() {}

    public Item(String field, boolean important) {
        this.field = field;
        this.important = important;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    @Override
    public String toString() {
        return "Item{" +
                "field='" + field + '\'' +
                ", important=" + important +
                '}';
    }
}
