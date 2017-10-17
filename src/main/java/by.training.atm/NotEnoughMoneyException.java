package by.training.atm;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException() {
        super();
    }


}
