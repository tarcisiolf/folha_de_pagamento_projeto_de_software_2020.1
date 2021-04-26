import java.util.Scanner;
import java.util.Random;
import employees.Comissioned;
import employees.Employee;
import employees.Hourly;
import employees.Salaried;
import workedhours.Timecard;


public class EmployessFunction {

    static Employee addEmployee() {
        
        Employee newEmployee = null;
        boolean filiated;
        String type = new String();
        Scanner input = new Scanner(System.in);
        String name = new String();
        String address = new String();

        System.out.println("Digite o nome do novo empregado:");
        name = input.nextLine();

        System.out.println("Digite o endereco do novo empregado:");
        address = input.nextLine();

        System.out.println("O novo empregado he sindicalizado? Digite 'true' para sim ou 'false' para nao");
 		filiated = input.nextBoolean();

        System.out.println("Digite o tipo do empregado dentre as seguintes opções: 'Horista', 'Assalariado' ou 'Comissionado':");
        type = input.nextLine();
        
        
        if(type == "Horista"){
            System.out.println("Digite o salario hora desse empregado");
            double normalTaxe = input.nextDouble();
            newEmployee = new Hourly(name, address, filiated, normalTaxe);
            Timecard newTimecard = new Timecard();
            newEmployee.setTimecard(newTimecard);
        }
        
        else if(type == "Assalariado"){
            System.out.println("Digite o salario base desse empregado");
            double baseSalary = input.nextDouble();
            newEmployee = new Salaried(name, address, filiated, baseSalary);
        }

        else if(type == "Comissionado"){
            System.out.println("Digite o salario base desse empregado");
            double baseSalary = input.nextDouble();
            System.out.println("Digite a comissao desse empregado");
            double comission = input.nextDouble();
            newEmployee = new Comissioned(name, address, filiated, baseSalary, comission);
        }
        
        return newEmployee;
    }
}
