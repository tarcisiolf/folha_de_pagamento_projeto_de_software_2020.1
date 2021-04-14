public class Salaried extends Employee{

    private double wage;

    public Salaried(String name, String address, boolean filiated,
    double wage) {
        super(name, address, filiated);
        this.wage = wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }
}
