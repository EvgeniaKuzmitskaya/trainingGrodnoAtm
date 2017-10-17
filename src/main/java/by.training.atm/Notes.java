package by.training.atm;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class Notes {

    private int five;
    private int ten;
    private int twenty;

    public Notes(int five, int ten, int twenty) {
        this.five = five;
        this.ten = ten;
        this.twenty = twenty;
    }

    public int getFive() {
        return five;
    }

    public int getTen() {
        return ten;
    }

    public int getTwenty() {
        return twenty;
    }

    public long getBalance(){
        return ((long)five)*5+((long)ten)*10+((long)twenty)*20;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }


    public void addFive(int five) {
        System.out.println("Принято купюр номиналом 5: " + five);
        this.five += five;
    }

    public void addTen(int ten) {
        System.out.println("Принято купюр номиналом 10: " + ten);
        this.ten += ten;
    }

    public void addTwenty(int twenty) {
        System.out.println("Принято купюр номиналом 20: " + twenty);
        this.twenty += twenty;
    }

    public void remFive(int five){
        System.out.println("Выдано купюр номиналом 5: " + five);
        this.five-=five;
    }

    public void remTen(int ten){
        System.out.println("Выдано купюр номиналом 10: " + ten);
        this.ten-=ten;
    }

    public void remTwenty(int twenty){
        System.out.println("Выдано купюр номиналом 20: " + twenty);
        this.twenty-=twenty;
    }
}
