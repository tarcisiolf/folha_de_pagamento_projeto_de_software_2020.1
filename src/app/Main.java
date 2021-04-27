package app;

import java.util.Scanner;
import java.util.ArrayList;
import employees.Employee;
import employees.Salaried;
import app.EmployessFunction;

public class Main {

    public static void main(String [] args) {
        int opition = -1;

        Scanner input = new Scanner(System.in);

        ArrayList<Employee> employeesList = new ArrayList<Employee>();

        while (opition != 0) {
            System.out.println("\n ---- Menu do Sistema da Folha de Pagamento ---- \n");
            System.out.println("Por favor, escolha uma opção: ");
            System.out.println("1 - Adicionar um novo empregado");
            System.out.println("2 - Informações dos empregados");
            System.out.println("0 - Fechar o menu.\n");
            System.out.print("  -> ");


            opition = input.nextInt();
            input.nextLine();

            switch (opition) {
                case 1:
                    Employee newEmployee = EmployessFunction.addEmployee();
                    employeesList.add(newEmployee);
                    break;
                
                case 2:
                    EmployessFunction.infoEmployee(employeesList);
                    break;
                default:
                    break;
            }            
        }
    }
}
