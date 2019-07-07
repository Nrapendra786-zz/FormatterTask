package formatter.enums;

/**
 * This enum is used to define position
 */
public enum Positions {
    LEFT("-l"),RIGHT("-r"),CENTER("-c");
    private String value;

    Positions(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
