package real_estate_registry_with_thymeleaf.task.model;

public enum PropertyType {

    APARTMENT("APARTMENT"),

    HOUSE("HOUSE"),

    INDUSTRIAL("INDUSTRIAL"),

    COMMERCIAL("COMMERCIAL");

    private String value;

    PropertyType(String value) { this.value = value; }
}

