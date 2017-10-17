package by.training.atm;

import java.util.Scanner;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class Loader {
    public static void main(String[] args) {

        Notes notes = new Notes(0,0,0);
        OperationAtm operationAtm = new OperationAtm(notes);
        Card card = new Card(0);

        Scanner sc = new Scanner(System.in);

        int number;
        do {
            System.out.println("Сделайте ваш выбор:" +
                    "\n 1-пополнить ваш баланс; " +
                    "\n 2-снять деньги со счета; " +
                    "\n 3-посмотреть баланс на счету; " +
                    "\n 4-выход.");
            number = getUserInputPositiveInt(sc, false, false);
            int operation;
            switch (number) {
                case 1: {
                    Notes addNotes = new Notes(0, 0, 0);
                    System.out.println("Введите сумму на которую вы хотите пополнить ваш счет:");
                    System.out.println("Введите количество 20 долларовых купюр");
                    operation = getUserInputPositiveInt(sc, true, true);
                    if (operation >= 0){
                        addNotes.setTwenty(operation);
                        System.out.println("Введите количество 10 долларовых купюр");
                        operation = getUserInputPositiveInt(sc, true, true);
                        if (operation >= 0){
                            addNotes.setTen(operation);
                            System.out.println("Введите количество 5 долларовых купюр");
                            operation = getUserInputPositiveInt(sc, true, true);
                            if (operation >= 0){
                                addNotes.setFive(operation);
                                if (addNotes.getBalance() > 0){
                                    try {
                                        operationAtm.putMoney(addNotes);
                                        card.addBalance(addNotes.getBalance());
                                        System.out.println("Операция прошла успешно. Пополнено: "
                                                + addNotes.getBalance() + "$");
                                    } catch (TooMuchMoneyException e){
                                        System.out.println(e.getMessage());
                                    }
                                } else {
                                    System.out.println("Купюры не добавлены, операция отменена.");
                                }
                            }
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.println("Введите сумму которую вы хотите снять со счета:");
                    operation = getUserInputPositiveInt(sc, false, true);
                    if (operation > 0){
                          if (card.getBalance() >= operation){
                            try {
                                Notes money = operationAtm.takeMoney(operation);
                                System.out.println("Операция прошла успешно. Снято: " + money.getBalance() + "$");
                                card.remBalance(operation);
                            } catch (NotEnoughMoneyException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Недостаточно денег на счету!");
                        }
                    }
                    break;
                }
                case 3:
                    System.out.println("Ваш текущий баланс: " + card.getBalance());
                    break;
                case 4:
                    System.out.println("Спасибо за пользование нашей программой!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Команда не поддерживается.");
                    System.exit(0);
            }
        }while (number!=4);
    }

    private static int getUserInputPositiveInt(Scanner sc, boolean allowZero, boolean print){
        int i = 0;
        try {
            i = sc.nextInt();
        } catch (Exception e){
            if (print) {
                System.out.println("Допустимы только целые числа.");
            }
            return 0;
        }
        if (i < 0){
            if (print) {
                System.out.println("Число не должно быть отрицательным.");
            }
            return 0;
        }
        if (!allowZero && i == 0){
            if (print) {
                System.out.println("Число должно быть положительным.");
            }
        }
        return i;
    }
}













