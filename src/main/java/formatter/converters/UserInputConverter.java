package formatter.converters;

import formatter.enums.Numbers;
import formatter.enums.Positions;
import formatter.exceptions.CharactersCountLessThanOneException;
import formatter.models.UserInput;
import formatter.constants.Message;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class is used for converting userinput
 */
public class UserInputConverter  {

    private Positions position = null;

    /**
     *  This method is used to fetch data from user input
     * @param args input parameters
     * @return UserInput
     * @throws FileNotFoundException
     * @throws CharactersCountLessThanOneException
     */
    public UserInput convertToUserInput(String [] args) throws FileNotFoundException, CharactersCountLessThanOneException {

        UserInput userInput = new UserInput();
        int noOfCharacters = Integer.parseInt(args[Numbers.ONE.getValue()]);
        String fileName = args[Numbers.TWO.getValue()];
        InputStream inputStream = inputStream(fileName);

        if(Objects.isNull(args) ||   args.length != Numbers.THREE.getValue()){
            throw new IllegalArgumentException(Message.INPUT_PARAMETER_CONDITIONS);
        }

        try {
            position = Arrays.asList(Positions.values()).stream().filter(positionValue ->
                positionValue.getValue().equals(args[Numbers.ZERO.getValue()])).findFirst().get();
        } catch(NoSuchElementException ex){
            throw  new NoSuchElementException(Message.POSITION_ARGUMENT_IS_INCORRECT);
        }

        if(noOfCharacters < Numbers.ONE.getValue()){
            throw new CharactersCountLessThanOneException(Message.CHARACTER_COUNT_MUST_BE_GREATER_THAN_ZERO);
        }

        if(Objects.isNull(inputStream)){
            throw new FileNotFoundException(fileName + Message.IS_NOT_FOUND);
        }

        userInput.setInputStream(inputStream);
        userInput.setNoOfCharacters(noOfCharacters);
        userInput.setPosition(position);

        return userInput;
    }

    /**
     * This method is used to read a file and convert the read data into an inputStream
     * @param fileName define the file name
     * @return inputStream
     */
    private InputStream inputStream(String fileName){
        InputStream inputStream = getClass().getResourceAsStream(Message.SLASH + fileName);
        return inputStream;
    }


}
