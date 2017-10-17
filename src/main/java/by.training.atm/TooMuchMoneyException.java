package by.training.atm;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class TooMuchMoneyException extends Exception {

    public TooMuchMoneyException(String message) {
        super(message);
    }

    public TooMuchMoneyException() {
        super();
    }


}
