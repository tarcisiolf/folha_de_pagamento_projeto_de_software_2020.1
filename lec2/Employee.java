/**
 * Employee
 */


public class Employee {

    String name;
    String address;
    double timeCard;

    // Método construtor
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
}