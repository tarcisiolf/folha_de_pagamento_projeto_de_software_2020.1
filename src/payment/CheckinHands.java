public class CheckinHands extends PaymentMethod{

    private double value;

    public CheckinHands(String type, String employeeID, double value) {
        super(type, employeeID);
        this.value = value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
