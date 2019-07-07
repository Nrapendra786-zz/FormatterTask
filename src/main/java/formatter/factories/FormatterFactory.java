package formatter.factories;

import formatter.businesslogic.CenterFormatter;
import formatter.businesslogic.IFormatter;
import formatter.businesslogic.LeftFormatter;
import formatter.businesslogic.RightFormatter;
import formatter.enums.Positions;

/**
 * This is a factory class for Formatter
 */
public class FormatterFactory {

    /**
     * This method accept position as input parameter and return specified Formatter
     * @param position input parameter
     * @return IFormatter
     */
    public static IFormatter getInstance(Positions position){
        if(position == Positions.CENTER){
            return new CenterFormatter();
        } else if(position == Positions.LEFT){
            return new LeftFormatter();
        } else if(position == Positions.RIGHT){
            return new RightFormatter();
        }
        return null;
    }

}
