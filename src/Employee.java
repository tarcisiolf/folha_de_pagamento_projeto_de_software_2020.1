/**
 * Employee
 */

public class Employee {

    private String name;
    private String address;
    private boolean filiated;

    public Employee(String name, String address, boolean filiated)
    {
        this.name = name;
        this.address = address;
        this.filiated = filiated;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }

    public void setFiliated(boolean filiated) {
        this.filiated = filiated;
    }

    public boolean getFiliated() {
        return filiated;
    }    
}