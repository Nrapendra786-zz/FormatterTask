package formatter.exceptions;

/**
 * This Exception define a case when character count is less than one
 */
public class CharactersCountLessThanOneException extends Exception {

    public CharactersCountLessThanOneException(String msg){
        super(msg);
    }
}
