package workedhours;

public class Timecard {
    private int numberTimecard;
    private String checkInTime;
    private String exitTime;
    private double numberHours;

    public void setNumberTimecard(int numberTimecard) {
        this.numberTimecard = numberTimecard;
    }

    public int getNumberTimecard() {
        return numberTimecard;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setNumberHours(double time) {
        this.numberHours = time;
    }

    public double getNumberHours() {
        return numberHours;
    }
    
    public double numberHours(String checkInTime, String exitTime) {
        String[] parts1 = checkInTime.split(":");
        String[] parts2 = checkInTime.split(":");

        int hour1 = Integer.parseInt(parts1[0]);
        int min1 = Integer.parseInt(parts1[1]);

        int hour2 = Integer.parseInt(parts2[0]);
        int min2 = Integer.parseInt(parts2[1]);

        double hours = ((hour2 - hour1) - (min2 - min1)) / 60;

        return hours;
    }

}
