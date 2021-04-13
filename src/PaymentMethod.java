public class PaymentMethod {
    private String type;
    private String employeeID;

    public PaymentMethod(String type, String employeeID) {
        this.type = type;
        this.employeeID = employeeID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}
