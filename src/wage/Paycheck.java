package wage;

import workedhours.Timecard;

public class Paycheck {
    private String employeeType;
    private double baseSalary;
    private double comission;
    private Timecard timecard;
    private String paymentDate;
    private double sales;
    private double normalTaxe;
    private String paymentAgenda;

    public Paycheck(String employeeType, double baseSalary, String paymentAgenda) {
        this.employeeType = employeeType;
        this.baseSalary = baseSalary;
        this.paymentAgenda = paymentAgenda;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    public double getComission() {
        return comission;
    }

    public void setTimecard(Timecard timecard) {
        this.timecard = timecard;
    }

    public Timecard getTimecard() {
        return timecard;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getSales() {
        return sales;
    }

    public void setNormalTaxe(double normalTaxe) {
        this.normalTaxe = normalTaxe;
    }

    public double getNormalTaxe() {
        return normalTaxe;
    }

    public double calcSalary(String employeeType, double baseSalary, 
    double comission, double sales, Timecard timecard, double normalTaxe){

        double salary = 0.0;
        double halfSalary = 0.0;
        double salesSalary = 0.0;
        String hoursIn;
        String hoursOut;
        double hours = 0.0;
        double extraTime = 0.0;
        
        if(employeeType == "Comissioned"){
            halfSalary = baseSalary/2;
            salesSalary = (comission * sales);
            salary = (halfSalary + salesSalary);
        }

        else if(employeeType == "Salaried"){
            salary = baseSalary;
        }

        else if(employeeType == "Hourly"){
            hoursIn = timecard.getTimeIn();
            hoursOut = timecard.getTimeOut();
            hours = timecard.numberWorkedHours(hoursIn, hoursOut);

            if(hours > 8){
                extraTime = (hours - 8);
                salary = (8*normalTaxe)+(extraTime*1.5*normalTaxe);
            }
        }

        return salary;
    }

    public void setPaymentAgenda(String paymentAgenda) {
        this.paymentAgenda = paymentAgenda;
    }

    public String getPaymentAgenda() {
        return paymentAgenda;
    }
}
