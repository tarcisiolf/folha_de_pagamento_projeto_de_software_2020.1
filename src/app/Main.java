package app;

import java.util.Scanner;
import java.util.ArrayList;
import employees.Employee;
import employees.Salaried;


public class Main {

    public static void main(String [] args) {
        int opition = -1;

        Scanner input = new Scanner(System.in);

        ArrayList<Employee> employeesList = new ArrayList<Employee>();

        while (opition != 0) {
            System.out.println("\n ---- Menu do Sistema da Folha de Pagamento ---- \n");
            System.out.println("Por favor, escolha uma opção: ");
            System.out.println("1 - Adicionar um novo empregado");
            System.out.println("0 - Fechar o menu.\n");
            System.out.print("  -> ");


            opition = input.nextInt();
            input.nextLine();

            switch (opition) {
                case 1:
                    Employee newEmployee = EmployessFunction.addEmployee();
                    employeesList.add(newEmployee);
                    System.out.println("\n");
                    System.out.print(newEmployee.getName());
                    System.out.println("\n");
                    System.out.print(newEmployee.getAddress());
                    System.out.println("\n");
                    System.out.print(newEmployee.getFiliated());
                    System.out.println("\n");
                    System.out.print(newEmployee.getEmployeeID());
                    System.out.println("\n");
                    System.out.print(((Salaried) newEmployee).getBaseSalary());
                    System.out.println("\n");
                    System.out.print(newEmployee);
                    System.out.println("\n");
                    System.out.print(employeesList);
                    System.out.println("\n");
                    break;
            
                default:
                    break;
            }
        }

    }
}
