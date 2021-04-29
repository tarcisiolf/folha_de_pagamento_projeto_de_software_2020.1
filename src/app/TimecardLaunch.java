package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import employees.Hourly;
import workedhours.Timecard;
import employees.Employee;

public class TimecardLaunch {

    public static void setTimecard(ArrayList <Employee> employeesList) {

        Random random = new Random();
        Scanner input = new Scanner(System.in);
        double workedHoursNumber = 0.0f;
        int timecardNumber = 0;
        String name = new String();
        String timeIn = new String();
        String timeOut = new String();

        int indexOfEmployee = -1;

        System.out.println("Digite o nome do empregado onde serão anotadas as informações do cartão de ponto:");
        name = input.nextLine();
        
        System.out.println("Digite a hora de entrada no formato 00:00 :");
        timeIn = input.nextLine();

        System.out.println("Digite a hora de saída no formato 00:00 :");
        timeOut = input.nextLine();

        indexOfEmployee = EmployessFunction.getIndexList(employeesList, name);

        Employee employee = employeesList.get(indexOfEmployee);

        //System.out.println("Nome " + employee.getName());
        //System.out.println("Endereço " + employee.getAddress());

        Hourly hourlyEmployee = ((Hourly) employee);
        //System.out.println("Taxa Normal " + ((Hourly) employee).getNormalTaxe());

        if(hourlyEmployee.getTimecard() == null){

            Timecard newTimecard = new Timecard(0.0f);
            timecardNumber = random.nextInt(100);
            newTimecard.setTimecardNumber(timecardNumber);

            //System.out.println("N Horas "+newTimecard.getNumberHours());
            //System.out.println("Passei 1");
    
            //System.out.println("Time IN "+timeIn);
            //System.out.println("Time Out "+timeOut);
    
            newTimecard.setTimeIn(timeIn);
            newTimecard.setTimeOut(timeOut);

            //System.out.println("Passei 2");
    
            //System.out.println("Time In "+timeIn);
            //System.out.println("Time Out "+timeOut);

            workedHoursNumber = newTimecard.numberWorkedHours(timeIn, timeOut);
            System.out.println("Horas Trabalhadas "+workedHoursNumber);

            newTimecard.setNumberHours(workedHoursNumber);
            hourlyEmployee.setTimecard(newTimecard);
        }

        else{
            Timecard newTimecard = hourlyEmployee.getTimecard();
            
            newTimecard.setTimeIn(timeIn);
            newTimecard.setTimeOut(timeOut);
            workedHoursNumber = newTimecard.numberWorkedHours(timeIn, timeOut);
            System.out.println("Horas Trabalhadas "+workedHoursNumber);
            newTimecard.addWorkedHours(workedHoursNumber);
            hourlyEmployee.setTimecard(newTimecard);
        }
        
        employeesList.set(indexOfEmployee, hourlyEmployee);

        //Employee testEmployee = employeesList.get(indexOfEmployee);
        // System.out.println("Nome " + testEmployee.getName());
        // System.out.println("Endereço " + testEmployee.getAddress());
        // System.out.println("passei 1");
        // System.out.println("Horas trabalhadas " + ((Hourly) testEmployee).getTimecard().getNumberHours());
        // System.out.println("passei 2");
    }
}
