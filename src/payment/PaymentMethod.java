package payment;

public class PaymentMethod {
    private String type;
    private String employeeID;
    private String name;

    public PaymentMethod(String type, String employeeID, String name) {
        this.type = type;
        this.employeeID = employeeID;
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
