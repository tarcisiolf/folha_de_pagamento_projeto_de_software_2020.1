package payment;

public class CheckbyPost extends PaymentMethod{
    
    private double value;
    private String employeeAddress;


    public CheckbyPost(String type, String employeeID, double value,
    String employeeAddress, String name, String date) {
        super(type, employeeID, name, date);
        this.value = value;
        this.employeeAddress = employeeAddress;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setEmployeeAddress(String employeeAddress){
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }
}
