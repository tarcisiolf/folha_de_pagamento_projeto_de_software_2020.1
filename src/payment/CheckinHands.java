package payment;

public class CheckinHands extends PaymentMethod{

    private double value;

    public CheckinHands(String type, String employeeID, String name, String date, double value) {
        super(type, employeeID, name, date);
        this.value = value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
