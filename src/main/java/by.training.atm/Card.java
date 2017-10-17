package by.training.atm;

/**
 * Created by Evgenia on 16.10.2017.
 */
public class Card {

    private int balance;

    public Card(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int addBalance(long i) throws TooMuchMoneyException {
        if (i + balance > Integer.MAX_VALUE){
            throw new TooMuchMoneyException("Превышен максимально допустимый баланс карты!");
        }
        this.balance += i;
        System.out.println("Ваш баланс " + balance);
        return balance;
    }

    public int remBalance(int i) throws NotEnoughMoneyException {
        if (balance - i < 0){
            throw new NotEnoughMoneyException("Недостаточно средств на карте!");
        }
        this.balance -= i;
        System.out.println("Ваш баланс " + balance);
        return balance;
    }
}
