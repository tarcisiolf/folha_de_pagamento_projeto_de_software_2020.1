public class Hourly extends Employee{
    
    private double workedHours;

    public Hourly(String name, String address, boolean filiated,
    double workedHours) {
        super(name, address, filiated);
        this.workedHours = workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public double getWorkedHours() {
        return workedHours;
    }
}
