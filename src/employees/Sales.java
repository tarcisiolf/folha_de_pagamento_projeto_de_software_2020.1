package employees;

public class Sales {

    private double value;
    private String date;


    public Sales(double value, String date) {
        this.value = value;
        this.date = date;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }


}
