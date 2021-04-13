public class Deposity extends PaymentMethod{
    
    private double value;
    private String accountType;
    private String agency;
    private String accountNumber;

    public Deposity(String type, String employeeID, double value, 
    String accountType, String agency, String accountNumber) {
        super(type, employeeID);
        this.value = value;
        this.accountType = accountType;
        this.agency = agency;
        this.accountNumber = accountNumber; 
    }


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
}