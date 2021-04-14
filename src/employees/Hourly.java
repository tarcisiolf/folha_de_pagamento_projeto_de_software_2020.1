package employees;

import workedhours.Timecard;

public class Hourly extends Employee{
    
    private Timecard timecard;

    public Hourly(String name, String address, boolean filiated,
    Timecard timecard) {
        super(name, address, filiated);
        this.timecard = timecard;
    }

    public void setTimecard(Timecard timecard) {
        this.timecard = timecard;
    }

    public Timecard getTimecard() {
        return timecard;
    }
}
