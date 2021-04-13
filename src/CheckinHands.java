public class CheckinHands extends PaymentMethod{
    private double value;
    private String employeeID; 

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}
