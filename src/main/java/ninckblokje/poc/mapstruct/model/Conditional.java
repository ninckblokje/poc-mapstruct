package ninckblokje.poc.mapstruct.model;

public class Conditional {

    private String field;
    private boolean mapField;

    public Conditional() {}

    public Conditional(String field, boolean mapField) {
        this.field = field;
        this.mapField = mapField;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isMapField() {
        return mapField;
    }

    public void setMapField(boolean mapField) {
        this.mapField = mapField;
    }

    @Override
    public String toString() {
        return "ConditionalDTO{" +
                "field='" + field + '\'' +
                ", mapField=" + mapField +
                '}';
    }
}
