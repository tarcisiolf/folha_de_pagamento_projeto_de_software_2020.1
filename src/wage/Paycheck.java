package wage;

import employees.Employee;
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

    public double calcSalary(Employee employee, String employeeType, double baseSalary, 
    double comission, double sales, Timecard timecard, double normalTaxe, boolean filiated){

        double salary = 0.0f;
        double halfSalary = 0.0f;
        double salesSalary = 0.0f;
        double hours = 0.0f;
        double extraTime = 0.0f;
        double monthlyTaxe = 0.0f;
        double additionalTaxe = 0.0f;

        if(employeeType.intern() == "Comissioned".intern()){

            if(filiated){
                monthlyTaxe = employee.getSyndicate().getTaxes().getMonthlyTaxe();
                additionalTaxe = employee.getSyndicate().getTaxes().getAdditionalTaxe();

                double halfMonthlyTaxe = monthlyTaxe/2;
                double halfAdditionalTaxe = additionalTaxe/2;

                halfSalary = baseSalary/2;
                salesSalary = (comission * sales);
                salary = (halfSalary + salesSalary) - (halfMonthlyTaxe + halfAdditionalTaxe);
            }

            else{
                halfSalary = baseSalary/2;
                salesSalary = (comission * sales);
                salary = (halfSalary + salesSalary);
            }

        }

        else if(employeeType.intern() == "Salaried".intern()){
            
            if (filiated) {
                //System.out.println("Filiado");
                monthlyTaxe = employee.getSyndicate().getTaxes().getMonthlyTaxe();
                additionalTaxe = employee.getSyndicate().getTaxes().getAdditionalTaxe();

                salary = (baseSalary - monthlyTaxe - additionalTaxe);
            }

            else{
                //System.out.println("Não Filiado");
                salary = baseSalary;
            }
        }

        else if(employeeType.intern() == "Hourly".intern()){
            hours = timecard.getNumberHours();
            System.out.println("Horas trabalhadas "+hours);
            int hoursWeek = 40;

            //Hora extra
            if(hours > hoursWeek){
                System.out.println("Horas extra");
                if (filiated) {
                    monthlyTaxe = employee.getSyndicate().getTaxes().getMonthlyTaxe();
                    additionalTaxe = employee.getSyndicate().getTaxes().getAdditionalTaxe();
    
                    double oneQuarterMonthlyTaxe = monthlyTaxe/4;
                    double oneQuarterAdditionalTaxe = additionalTaxe/4; 

                    extraTime = (hours - hoursWeek);
                    salary = (hours*normalTaxe)+(extraTime*1.5*normalTaxe)-(oneQuarterMonthlyTaxe+oneQuarterAdditionalTaxe);
                }

                else{
                    extraTime = (hours - hoursWeek);
                    salary = (hours*normalTaxe)+(extraTime*1.5*normalTaxe);
                }  
            }

            //Sem hora extra
            else{
                System.out.println("Sem hora extra");
                if (filiated) {
                    monthlyTaxe = employee.getSyndicate().getTaxes().getMonthlyTaxe();
                    additionalTaxe = employee.getSyndicate().getTaxes().getAdditionalTaxe();
    
                    double oneQuarterMonthlyTaxe = monthlyTaxe/4;
                    double oneQuarterAdditionalTaxe = additionalTaxe/4; 

                    salary = (hours*normalTaxe)-(oneQuarterMonthlyTaxe+oneQuarterAdditionalTaxe);
                }

                else{
                    salary = (hours*normalTaxe);
                }  
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
