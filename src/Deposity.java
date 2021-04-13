public class Deposity extends Employee{
    private double value;
    private String accountType;
    private String agency;
    private String accountNumber;
    private String employeeID;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType(){
        return accountType;
    }

    public void setAgency(String agency){
        this.agency = agency;
    }

    public String getAgency() {
        return agency;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}
