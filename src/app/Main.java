package app;

import java.util.Scanner;
import java.util.ArrayList;
import employees.Employee;
import employees.Comissioned;

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
            System.out.println("3 - Remover um empregado");
            System.out.println("4 - Lançar um cartão de ponto");
            System.out.println("5 - Lançar um resultado de venda");
            System.out.println("6 - Lançar uma taxa de serviço");
            System.out.println("7 - Editar dados de um funcionário");
            System.out.println("8 - Rodar a folha de pagamento");
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

                case 3:
                    EmployessFunction.removeEmployee(employeesList);
                    break;

                case  4:
                    TimecardLaunch.setTimecard(employeesList);
                    break;

                case 5:
                    SalesResult.addSale(employeesList);
                    break;
                    
                case 6:
                    TaxesLaunch.setServiceTaxe(employeesList);
                    break;
                
                case 7:
                    EmployessFunction.editEmployee(employeesList);
                    break;

                case 8:
                    
                    break;
                        
                default:
                    break;
            }            
        }
    }
}
