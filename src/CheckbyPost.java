public class CheckbyPost extends PaymentMethod{
    
    private double value;
    private String employeeAddress;


    public CheckbyPost(String type, String employeeID, double value,
    String employeeAddress) {
        super(type, employeeID);
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
