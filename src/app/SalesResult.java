package app;

import java.util.ArrayList;
import java.util.Scanner;

import employees.Comissioned;
import employees.Employee;
import employees.Sales;

public class SalesResult {

    public static void addSale(ArrayList <Employee> employeesList) {
        Scanner input = new Scanner(System.in);
        String name = new String();
        double saleValue = 0.0f;
        int indexOfEmployee = -1;

        System.out.println("Digite o nome do empregado que realizou a venda:");
        name = input.nextLine();

        System.out.println("Digite o valor da venda:");
        saleValue = input.nextDouble();

        indexOfEmployee = EmployessFunction.getIndexList(employeesList, name);

        Employee employee = employeesList.get(indexOfEmployee);

        //System.out.println("Nome " + employee.getName());
        //System.out.println("Endereço " + employee.getAddress());

        Comissioned comissionedEmployee = new Comissioned(employee.getName(), employee.getAddress(), 
        employee.getFiliated(), ((Comissioned) employee).getBaseSalary(), ((Comissioned) employee).getComission());

        //System.out.println("Salário " + ((Comissioned) employee).getBaseSalary());
        //System.out.println("Comissão " + ((Comissioned) employee).getComission());

        if (comissionedEmployee.getSales() == null) {
            Sales newSale = new Sales(saleValue);
            comissionedEmployee.setSales(newSale);
        }

        else{
            Sales newSale = comissionedEmployee.getSales();
            newSale.addSale(saleValue);
            comissionedEmployee.setSales(newSale);
        }
        
        employeesList.set(indexOfEmployee, comissionedEmployee);

        // Employee testEmployee = employeesList.get(indexOfEmployee);
        // System.out.println("Nome " + testEmployee.getName());
        // System.out.println("Endereço " + testEmployee.getAddress());
        // System.out.println("passei 1");
        // System.out.println("Salário " + ((Comissioned) testEmployee).getBaseSalary());
        // System.out.println("Comissão " + ((Comissioned) testEmployee).getComission());
        // System.out.println("passei 2");
        // System.out.println("Valor da venda "+((Comissioned) testEmployee).getSales().getValue());
        // System.out.println("passei 3");
    }
}
