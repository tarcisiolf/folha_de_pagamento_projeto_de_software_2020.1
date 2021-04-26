package app;

import java.util.Scanner;
import java.util.Random;
import employees.Comissioned;
import employees.Employee;
import employees.Hourly;
import employees.Salaried;
import union.Syndicate;
import union.Taxes;
import workedhours.Timecard;


public class EmployessFunction {

    static Employee addEmployee() {

        Random random = new Random();
        Employee newEmployee = null;
        boolean filiated;
        int type = 0;
        Scanner input = new Scanner(System.in);
        String name = new String();
        String address = new String();
        int employeeID = 0;

        System.out.println("Digite o nome do novo empregado:");
        name = input.nextLine();

        System.out.println("Digite o endereco do novo empregado:");
        address = input.nextLine();

        System.out.println("O novo empregado he sindicalizado? Digite 'true' para sim ou 'false' para nao");
 		filiated = input.nextBoolean();

        System.out.println("Digite o tipo do empregado dentre as seguintes opções:\n '1 - Horista', ' 2 - Assalariado', '3 - Comissionado'");
        type = input.nextInt();
        
        switch (type) {

            case 1:
                System.out.println("Digite o salario hora desse empregado");
                double normalTaxe = input.nextDouble();

                newEmployee = new Hourly(name, address, filiated, normalTaxe);
                
                Timecard newTimecard = new Timecard();
                ((Hourly) newEmployee).setTimecard(newTimecard);

                employeeID = random.nextInt(100);
                newEmployee.setEmployeeID(employeeID);
                break;

            case 2:
                System.out.println("Digite o salario base desse empregado");
                double baseSalary = input.nextDouble();

                newEmployee = new Salaried(name, address, filiated, baseSalary);

                employeeID = random.nextInt(100);
                newEmployee.setEmployeeID(employeeID);
                break;

            case 3:
                System.out.println("Digite o salario base desse empregado");
                baseSalary = input.nextDouble();

                System.out.println("Digite a comissao desse empregado");
                double comission = input.nextDouble();

                newEmployee = new Comissioned(name, address, filiated, baseSalary, comission);

                employeeID = random.nextInt(100);
                newEmployee.setEmployeeID(employeeID);
                break;
        
            default:
                break;
        }

        if(filiated){
            System.out.println("Digite o id do sindicato:");
            int syndicateID = input.nextInt();
            System.out.println("Digite o valor da taxa mensal:");
            double monthlyTaxe = input.nextDouble();
            System.out.println("Digite o valor da taxa adicional:");
            double aditionalTaxe = input.nextDouble();
            input.nextLine();

            Syndicate newSyndicate = new Syndicate(syndicateID);
            Taxes newTaxe = new Taxes(monthlyTaxe, aditionalTaxe);

            newSyndicate.setTaxes(newTaxe);
            newEmployee.setSyndicate(newSyndicate);
        }

        else{
            newEmployee.setSyndicate(null);
        }
        
        return newEmployee;
    }
}
