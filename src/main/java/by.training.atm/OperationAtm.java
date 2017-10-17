package by.training.atm;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class OperationAtm {

    Notes notes;

    public OperationAtm(Notes notes) {
        this.notes = notes;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Notes putMoney (Notes addMoney) throws TooMuchMoneyException {
        if (!isAdditionAllowed(notes.getTwenty(), addMoney.getTwenty())){
            throw new TooMuchMoneyException("Слишком много купюр номиналом 20!");
        }
        if (!isAdditionAllowed(notes.getTen(), addMoney.getTen())){
            throw new TooMuchMoneyException("Слишком много купюр номиналом 10!");
        }
        if (!isAdditionAllowed(notes.getFive(), addMoney.getFive())){
            throw new TooMuchMoneyException("Слишком много купюр номиналом 5!");
        }
        notes.addTwenty(addMoney.getTwenty());
        notes.addTen(addMoney.getTen());
        notes.addFive(addMoney.getFive());
        return notes;
    }

    private boolean isAdditionAllowed(int have, int add) {
        long sum = ((long)have) + add;
        return sum <= Integer.MAX_VALUE;
    }

    public Notes takeMoney(int moneyAmount) throws NotEnoughMoneyException {
        long balance = notes.getBalance();
        if (balance < moneyAmount){
            throw new NotEnoughMoneyException("Недостаточно средств в атм!");
        }
        if (moneyAmount % 5 != 0){
            throw new NotEnoughMoneyException("Сумма должна быть кратна 5!");
        }
        Notes result = new Notes(0, 0, 0);
        int need = moneyAmount / 20;
        if (notes.getTwenty() > 0 && need > 0){
            if (notes.getTwenty() >= need){
                result.setTwenty(need);
            } else {
                result.setTwenty(notes.getTwenty());
            }
            moneyAmount = moneyAmount - result.getTwenty() * 20;
        }
        need = moneyAmount / 10;
        if (moneyAmount > 0 && notes.getTen() > 0 && need > 0){
            if (notes.getTen() >= need){
                result.setTen(need);
            } else {
                result.setTen(notes.getTen());
            }
            moneyAmount = moneyAmount - result.getTen() * 10;
        }
        need = moneyAmount / 5;
        if (moneyAmount > 0 && notes.getFive() > 0 && need > 0){
            if (notes.getFive() >= need){
                result.setFive(need);
            } else {
                result.setFive(notes.getFive());
            }
            moneyAmount = moneyAmount - result.getFive() * 5;
        }
        if (moneyAmount > 0){
            throw new NotEnoughMoneyException("Недостаточно купюр в атм!");
        }
        notes.remTwenty(result.getTwenty());
        notes.remTen(result.getTen());
        notes.remFive(result.getFive());
        return result;
    }
}



