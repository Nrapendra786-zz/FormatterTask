package formatter.models;

import formatter.enums.Positions;
import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

/**
 * This is the model class used for the purpose of taking taking input
 */
public class UserInput {

    /**
     * define position
     */
    @Setter
    @Getter
    private Positions position;

    /**
     * define noOfCharacters
     */
    @Setter
    @Getter
    private int noOfCharacters;

    /**
     * define inputStream
     */
    @Setter
    @Getter
    private InputStream inputStream;
}
