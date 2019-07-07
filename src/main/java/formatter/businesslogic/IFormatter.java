package formatter.businesslogic;

/**
 * Interface used in the process of formatting content
 */
public interface IFormatter {

    /**
     * This method is used to format content
     * @param noOfCharacters
     * @param inputContent
     * @return String
     */
    String format(int noOfCharacters,String inputContent);
}
