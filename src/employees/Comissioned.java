public class Comissioned extends Employee{
    
    private double sales;

    public Comissioned(String name, String address, boolean filiated,
    double sales) {
        super(name, address, filiated);
        this.sales = sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getSales() {
        return sales;
    }
}
