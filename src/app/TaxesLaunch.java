package app;

import java.util.ArrayList;
import java.util.Scanner;

import employees.Employee;
import union.Syndicate;
import union.Taxes;

public class TaxesLaunch {

    public static void setServiceTaxe(ArrayList <Employee> employeesList) {
        Scanner input = new Scanner(System.in);
        String name = new String();
        double serviceTaxeValue = 0.0f;
        int indexOfEmployee = -1;

        System.out.println("Digite o nome do empregado a ser cobrado pela taxa de serviço adicional:");
        name = input.nextLine();

        System.out.println("Digite o valor da taxa de serviço adicional:");
        serviceTaxeValue = input.nextDouble();

        indexOfEmployee = EmployessFunction.getIndexList(employeesList, name);

        Employee employee = employeesList.get(indexOfEmployee);

        // System.out.println("Nome " + employee.getName());
        // System.out.println("Endereço " + employee.getAddress());

        Syndicate newSyndicate = employee.getSyndicate();

        // System.out.println("Syndicate ID " + newSyndicate.getSyndicateID());

        Taxes newTaxe = newSyndicate.getTaxes();

        // System.out.println("Taxa Adicional " + newTaxe.getAdditionalTaxe());
        // System.out.println("Taxa Mensal " + newTaxe.getMonthlyTaxe());

        newTaxe.setAdditionalTaxe(serviceTaxeValue);

        newSyndicate.setTaxes(newTaxe);
        employee.setSyndicate(newSyndicate);

        employeesList.set(indexOfEmployee, employee);

        // Employee testEmployee = employeesList.get(indexOfEmployee);
        // System.out.println("Nome " + testEmployee.getName());
        // System.out.println("Endereço " + testEmployee.getAddress());
        // System.out.println("passei 1");
        // System.out.println("Syndicate ID " + testEmployee.getSyndicate().getSyndicateID());
        // System.out.println("passei 2");
        // double aux = testEmployee.getSyndicate().getTaxes().getAdditionalTaxe();
        // System.out.println("Taxa Adicional "+ aux);
        // System.out.println("passei 3");
        // double aux2 = testEmployee.getSyndicate().getTaxes().getMonthlyTaxe();
        // System.out.println("Taxa Mensal "+ aux2);
    }
}
