package employees;

public class Comissioned extends Employee{
    
    private Sales sale;

    public Comissioned(String name, String address, boolean filiated,
    Sales sale) {
        super(name, address, filiated);
        this.sale = sale;
    }

    public void setSales(Sales sale) {
        this.sale = sale;
    }

    public Sales getSales() {
        return sale;
    }
}
