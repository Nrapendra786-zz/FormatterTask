package formatter.enums;

/**
 * This enum is used to define numbers
 */
public enum Numbers {
    ZERO(0),ONE(1),TWO(2),THREE(3);

    private int value;

    Numbers(int value){
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
