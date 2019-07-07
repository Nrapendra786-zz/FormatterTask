package formatter;

import formatter.converters.UserInputConverter;
import formatter.enums.Positions;
import formatter.exceptions.CharactersCountLessThanOneException;
import formatter.factories.FormatterFactory;
import formatter.output.Display;
import formatter.businesslogic.IFormatter;
import formatter.models.UserInput;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This is the main class used to start the Application
 */
public class FormatterApp {

    private static  final Logger logger = Logger.getLogger(FormatterApp.class.getName());

    /**
     * This is the main method
     * @param args accept parameter provided by user
     */
    public static void main(String [] args){
       new FormatterApp().startApp(args);
    }

    /**
     * This method is used to startApp
     * @param args parameter provided by user
     */
    public void startApp(String [] args){
        try {
            UserInput userInput = new UserInputConverter().convertToUserInput(args);

            String inputContent = lines(userInput);
            int noOfCharacters = userInput.getNoOfCharacters();

            Positions position = userInput.getPosition();
            IFormatter formatter = FormatterFactory.getInstance(position);

            String formattedContent = formattedContent(position,formatter,noOfCharacters,inputContent);

            new Display().display(formattedContent);

        } catch (FileNotFoundException  | CharactersCountLessThanOneException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * This method is used to get formatted Content
     *
     * @param position define position of contents
     * @param formatter define type of formatter
     * @param noOfCharacters define no of characters
     * @param inputContent define no of characters
     * @return String
     */
    private String formattedContent(Positions position, IFormatter formatter, int noOfCharacters, String inputContent){
        String content = null;
        if(position == Positions.LEFT){

            content =  formatter.format(noOfCharacters,inputContent);

        } else if (position == Positions.RIGHT){

            content = formatter.format(noOfCharacters,inputContent);

        } else if(position == Positions.CENTER){

            content = formatter.format(noOfCharacters,inputContent);
        }
        return content;
    }

    /**
     * This method is used to read lines provided by user input
     * @param userInput
     * @return String
     */
    public String lines(UserInput userInput) {

        if(Objects.isNull(userInput)){
            return null;
        }

        InputStream inputStream = userInput.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        bufferedReader.lines().forEach(line -> {
            stringBuilder.append(line);
        });
        return stringBuilder.toString();
    }


}
