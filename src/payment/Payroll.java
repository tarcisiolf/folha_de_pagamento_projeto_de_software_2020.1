package payment;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import employees.Employee;
import wage.Paycheck;

public class Payroll {
    
    private ArrayList<Employee> employessList;
    private Calendar date;

    public Payroll(ArrayList<Employee> employessList, Calendar date){
        this.employessList = employessList;
        this.date = date;
    }

    public void setEmployeesList(ArrayList<Employee> employessList){
        this.employessList = employessList;
    }

    public ArrayList<Employee> getEmployessList(){
        return employessList;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Calendar getDate(){
        return date;
    }

    public static void PaymentList(ArrayList<Employee> employessList, Calendar date) {
        
        String paymentAgenda = new String();
        Paycheck newPaycheck = null;

        for (Employee employee : employessList){
            
        }
    }
}
