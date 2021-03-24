/**
 * Employee
 */

public class Employee {

    private String name;
    private String address;
    private double timeCard;

    // Método construtor
    public Employee() {
        
    }

    public Employee(String name, String address, double timeCard) {
        this.name = name;
        this.address = address;
        this.timeCard = timeCard;
    }

    public String printEmployeeInfo() {
        return  "Name: " + this.name + 
                "\nAdress: " + this.address + 
                "\nTime Card: " + this.timeCard;
    }

    public String printEmployeeInfo(Employee employee) {
        return  "Name: " + this.name + 
                "\nAdress: " + this.address + 
                "\nTime Card: " + this.timeCard +
                "\n ----------------------------------" +
                "\nName: " + employee.name + 
                "\nAdress: " + employee.address + 
                "\nTime Card: " + employee.timeCard;

    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setTimeCard(double timeCard) {
        
        if(timeCard <= 0){
            System.out.println("Valor incorreto");
        }
        
        else{
            this.timeCard = timeCard;
        }
        
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public double getTimeCard() {
        return timeCard;
    }
}