package formatter.businesslogic;

import formatter.constants.Message;

/**
 * This class is used for formatting content to Center
 */
public class CenterFormatter implements IFormatter {

    /**
     * This method is used for formatting content to center
     * @param noOfCharacters
     * @param inputContent
     * @return String
     */
    @Override
    public String format(int noOfCharacters, String inputContent) {
        StringBuilder stringBuilderTwo = new StringBuilder();

        char[] stringArray = inputContent.toCharArray();

        for(int i = 0 ; i < stringArray.length ; i = i +noOfCharacters){
            if( i <= stringArray.length - noOfCharacters) {

                String value = inputContent.substring(i,i + noOfCharacters);

                stringBuilderTwo.append(Message.CENTER_SPACE + value).append(Message.CHANGE_LINE);

            } else {
                int remainingCharacterLength = stringArray.length - i;

                int offset = stringArray.length - remainingCharacterLength;

                String value = inputContent.substring(offset);

                stringBuilderTwo.append(Message.CENTER_SPACE + value).append(Message.CHANGE_LINE);
            }
        }

        return stringBuilderTwo.toString();
    }
}
