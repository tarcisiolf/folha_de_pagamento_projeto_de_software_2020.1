public class CheckbyPost extends PaymentMethod{
    
    private double value;
    private String employeeAddress;
    private String employeeID;

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

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}
