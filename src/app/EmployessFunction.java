package app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import employees.Comissioned;
import employees.Employee;
import employees.Hourly;
import employees.Salaried;
import payment.CheckbyPost;
import payment.CheckinHands;
import payment.Deposity;
import payment.PaymentMethod;
import union.Syndicate;
import union.Taxes;
import workedhours.Timecard;


public class EmployessFunction {

    static Employee addEmployee() {

        Random random = new Random();
        Employee newEmployee = null;
        PaymentMethod newPaymentMethod = null;
        boolean filiated;
        int type = 0;
        Scanner input = new Scanner(System.in);
        String name = new String();
        String address = new String();
        int employeeID = 0;
        int employeeSyndicateID = 0;
        int paymentMethod = 0;
        String data = new String();

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
                ((Hourly) newEmployee).setTimecard(null);

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
                ((Comissioned) newEmployee).setSales(null);

                employeeID = random.nextInt(100);
                newEmployee.setEmployeeID(employeeID);

                break;
        
            default:
                break;
        }

        if(filiated){
            int syndicateID = -1;
            System.out.println("Digite o valor da taxa mensal:");
            double monthlyTaxe = input.nextDouble();
            System.out.println("Digite o valor da taxa adicional:");
            double additionalTaxe = input.nextDouble();
            input.nextLine();
            
            Syndicate newSyndicate = new Syndicate(syndicateID);
            Taxes newTaxe = new Taxes(monthlyTaxe, additionalTaxe);
            employeeSyndicateID = random.nextInt(100);

            newSyndicate.setTaxes(newTaxe);
            newEmployee.setSyndicate(newSyndicate);
            newEmployee.setEmployeeSyndicateID(employeeSyndicateID);
        }

        else{
            newEmployee.setSyndicate(null);
        }

        System.out.println("Digite o Nº da opção do método de pagamento desejado dentre as seguintes opções:\n '1 - Cheque Correios', ' 2 - Cheque em Mãos', '3 - Depósito'");
        paymentMethod = input.nextInt();
        double value = 0.0f;

        switch (paymentMethod) {
            case 1:
                newPaymentMethod = new PaymentMethod("CheckbyPost", newEmployee.getEmployeeID(), newEmployee.getName());
                CheckbyPost newCheckbyPost = new CheckbyPost(newPaymentMethod.getType(), newPaymentMethod.getEmployeeID(), value, newEmployee.getAddress(), newEmployee.getName());
                newEmployee.setPaymentMethod(newCheckbyPost);
                break;
            
            case 2:
                newPaymentMethod = new PaymentMethod("CheckinHands", newEmployee.getEmployeeID(), newEmployee.getName());
                CheckinHands newCheckinHands = new CheckinHands(newPaymentMethod.getType(), newPaymentMethod.getEmployeeID(), newEmployee.getName(), value);
                newEmployee.setPaymentMethod(newCheckinHands);
                break;

            case 3:
                //Data vai receber o caracter " " enter 
                data = input.nextLine();
                newPaymentMethod = new PaymentMethod("Deposity", newEmployee.getEmployeeID(), newEmployee.getName());
                System.out.println("Digite o tipo da conta dentre as opções:\n 'Conta', 'Poupança'");
                String accountType = new String();
                accountType = input.nextLine();

                System.out.println("Digite o número da agência:");
                String agency = new String();
                agency = input.nextLine();

                System.out.println("Digite o número da conta:");
                String acconuntNumber = new String();
                acconuntNumber = input.nextLine();

                System.out.println("Digite o número do banco:");
                int bankNumber = -1;
                bankNumber = input.nextInt();

                Deposity newDeposity = new Deposity(newPaymentMethod.getType(), newPaymentMethod.getEmployeeID(), newEmployee.getName(), value, accountType, agency, acconuntNumber, bankNumber);
                newEmployee.setPaymentMethod(newDeposity);
                break;

            default:
                break;
        }
        
        //Teste

        // if (paymentMethod == 1) {
        //     PaymentMethod testPaymentMethod = newEmployee.getPaymentMethod();
        //     CheckbyPost testeCheckbyPost = ((CheckbyPost)testPaymentMethod);

        //     System.out.println("Tipo "+ testeCheckbyPost.getType());
        //     System.out.println("passei1");
        //     System.out.println("E ID "+ testeCheckbyPost.getEmployeeID());
        //     System.out.println("passei2");
        //     System.out.println("Valor "+ testeCheckbyPost.getValue());
        //     System.out.println("passei3");
        //     System.out.println("Endereço "+ testeCheckbyPost.getEmployeeAddress());
        //     System.out.println("passei4");
        //     System.out.println("Nome "+ testeCheckbyPost.getName());
        //     System.out.println("passei5");
        // }

        // else if(paymentMethod == 2){
        //     PaymentMethod testPaymentMethod = newEmployee.getPaymentMethod();
        //     CheckinHands testeCheckinHands = ((CheckinHands)testPaymentMethod);

        //     System.out.println("Tipo "+ testeCheckinHands.getType());
        //     System.out.println("passei1");
        //     System.out.println("E ID "+ testeCheckinHands.getEmployeeID());
        //     System.out.println("passei2");
        //     System.out.println("Valor "+ testeCheckinHands.getValue());
        //     System.out.println("passei3");
        //     System.out.println("Nome "+ testeCheckinHands.getName());
        //     System.out.println("passei4");
        // }

        // else if(paymentMethod == 3){
        //     PaymentMethod testPaymentMethod = newEmployee.getPaymentMethod();
        //     Deposity testeDeposity = ((Deposity)testPaymentMethod);

        //     System.out.println("Tipo "+ testeDeposity.getType());
        //     System.out.println("passei1");
        //     System.out.println("E ID "+ testeDeposity.getEmployeeID());
        //     System.out.println("passei2");
        //     System.out.println("Valor "+ testeDeposity.getValue());
        //     System.out.println("passei3");
        //     System.out.println("Nome "+ testeDeposity.getName());
        //     System.out.println("passei4");
        //     System.out.println("Tipo de conta "+ testeDeposity.getAccountType());
        //     System.out.println("passei5");
        //     System.out.println("Nº de Conta "+ testeDeposity.getAccountNumber());
        //     System.out.println("passei6");
        //     System.out.println("Nº Agência "+ testeDeposity.getAgency());
        //     System.out.println("passei7");
        //     System.out.println("Nº Banco "+ testeDeposity.getBankNumber());
        //     System.out.println("passei8");
        // }
        return newEmployee;
    }

    static void infoEmployee(ArrayList <Employee> employeesList){

        int i = 0;
        for (Employee employee: employeesList){  
            System.out.println("Empregado - " + i);
            System.out.println(employee.printEmployeeInfo(employee));
            i++;
        }
    }

    public static int getIndexList(ArrayList<Employee> employeesList, String employeeName){
        
        String name = new String();
        int indexOfEmployee = -1;
        
        int i = 0;

        for(Employee employee: employeesList){
            
            name = employee.getName();
            
            // Strings criadas de formas diferentes, método intern para resolver o problema de comparação
            //System.out.println(name);
            //System.out.println(name.length());
            //System.out.println(employeeName);
            //System.out.println(employeeName.length());

            if(employeeName.intern() == name.intern()){     
                indexOfEmployee = i;
                break;
            }

            i++;   
        }

        return indexOfEmployee;
    }

    public static void removeEmployee(ArrayList<Employee> employeesList){
 
        if(employeesList.isEmpty()){
            System.out.println("Lista de empregados vazia \n");
        }

        else{

            Scanner input = new Scanner(System.in);
            int indexOfEmployee = -1;
            String employeeName = new String();

            System.out.println("Digite o nome do empregado a ser removido:");
            employeeName = input.nextLine();
            
            System.out.println("Empregado a ser removido: "+employeeName);
            indexOfEmployee = getIndexList(employeesList, employeeName);

            if (indexOfEmployee == -1) {
                System.out.println("Empregado não encontrado \n");
            }

            else{
                employeesList.remove(indexOfEmployee);
                System.out.println("Empregado removido! \n");
            }

            return;    
        }
    }

    public static void editEmployee(ArrayList<Employee> employeesList){

        if(employeesList.isEmpty()){
            System.out.println("Lista de empregados vazia \n");
        }

    else{
            Scanner input = new Scanner(System.in);
            int indexOfEmployee = -1;
            String employeeName = new String();
            int edit = 0;
            Employee employee = null;
            String data = new String();

            System.out.println("Digite o nome do empregado onde os dados serão editados:");
            employeeName = input.nextLine();

            System.out.println("Digite o nº da opção do dado que será editado dentre a seguinte opções:\n1-Nome, 2-Endereço, 3-Tipo, 4-Método de Pagamento, 5-Sindicato, 6-Identificação no Sindicato e 7-Método de Pagamento");            
            edit = input.nextInt();
            // Data vai receber o caracter " " enter 
            data = input.nextLine();

            indexOfEmployee = getIndexList(employeesList, employeeName);

            switch (edit) {
                case 1:
                    System.out.println("Digite o nome do empregado:");
                    data = input.nextLine();

                    employee = employeesList.get(indexOfEmployee);
                    employee.setName(data);
                    employeesList.set(indexOfEmployee, employee);
                    break;
                
                case 2:
                    System.out.println("Digite o endereço do empregado:");
                    data = input.nextLine();

                    employee = employeesList.get(indexOfEmployee);
                    employee.setAddress(data);
                    employeesList.set(indexOfEmployee, employee);
                    break;

                case 3:
                    int type = -1;
                    System.out.println("Digite a opção de empregado:\n '1 - Horista', ' 2 - Assalariado', '3 - Comissionado'");
                    type = input.nextInt();

                    employee = employeesList.get(indexOfEmployee);

                    if (type == 1) {
                        System.out.println("Digite o salario hora desse empregado");
                        double normalTaxe = input.nextDouble();

                        Employee newHoruly = new Hourly(employee.getName(), employee.getAddress(), employee.getFiliated(), normalTaxe);

                        if (newHoruly.getFiliated()) {
                            Syndicate syndicate = employee.getSyndicate();
                            int employeeSyndicateID = employee.getEmployeeSyndicateID();
                            
                            newHoruly.setSyndicate(syndicate);
                            newHoruly.setEmployeeSyndicateID(employeeSyndicateID);
                        }

                        int employeeID = employee.getEmployeeID();
                        newHoruly.setEmployeeID(employeeID);
                        employeesList.set(indexOfEmployee, newHoruly);

                        // Employee testEmployee = employeesList.get(indexOfEmployee);
                        // System.out.println("Nome " + testEmployee.getName());
                        // System.out.println("Endereço " + testEmployee.getAddress());
                        // System.out.println("passei 1");
                        // System.out.println("Salario hora "+ ((Hourly)testEmployee).getNormalTaxe());
                        // System.out.println("passei2");
                        // // Sindicalizado
                        // System.out.println("Nº sindicato " + testEmployee.getEmployeeSyndicateID());
                        // System.out.println("passei3");
                        // System.out.println("Taxa Adicional " + testEmployee.getSyndicate().getTaxes().getAdditionalTaxe());
                        // System.out.println("passei4");
                        // System.out.println("Taxa Mensal " + testEmployee.getSyndicate().getTaxes().getMonthlyTaxe());
                        // System.out.println("passei5");
                    }

                    else if(type == 2){
                        System.out.println("Digite o salario base desse empregado");
                        double baseSalary = input.nextDouble();

                        Employee newSalaried = new Salaried(employee.getName(), employee.getAddress(), employee.getFiliated(), baseSalary);

                        if (newSalaried.getFiliated()) {
                            Syndicate syndicate = employee.getSyndicate();
                            int employeeSyndicateID = employee.getEmployeeSyndicateID();
                       
                            newSalaried.setSyndicate(syndicate);            
                            newSalaried.setEmployeeSyndicateID(employeeSyndicateID);
                        }

                        int employeeID = employee.getEmployeeID();
                        newSalaried.setEmployeeID(employeeID);
                        employeesList.set(indexOfEmployee, newSalaried);

                        // Employee testEmployee = employeesList.get(indexOfEmployee);
                        // System.out.println("Nome " + testEmployee.getName());
                        // System.out.println("Endereço " + testEmployee.getAddress());
                        // System.out.println("passei 1");
                        // System.out.println("Salario Base "+ ((Salaried)testEmployee).getBaseSalary());
                        // System.out.println("passei2");
                        // // Sindicalizado
                        // System.out.println("Nº sindicato " + testEmployee.getEmployeeSyndicateID());
                        // System.out.println("passei3");
                        // System.out.println("Taxa Adicional " + testEmployee.getSyndicate().getTaxes().getAdditionalTaxe());
                        // System.out.println("passei4");
                        // System.out.println("Taxa Mensal " + testEmployee.getSyndicate().getTaxes().getMonthlyTaxe());
                        // System.out.println("passei5");
                    }

                    else if(type == 3){
                        System.out.println("Digite o salario base desse empregado");
                        double baseSalary = input.nextDouble();
        
                        System.out.println("Digite a comissao desse empregado");
                        double comission = input.nextDouble();

                        Employee newComissioned = new Comissioned(employee.getName(), employee.getAddress(), employee.getFiliated(), baseSalary, comission);
                        ((Comissioned) newComissioned).setSales(null);

                        if (newComissioned.getFiliated()) {
                            Syndicate syndicate = employee.getSyndicate();
                            int employeeSyndicateID = employee.getEmployeeSyndicateID();
                                                       
                            newComissioned.setSyndicate(syndicate);
                            newComissioned.setEmployeeSyndicateID(employeeSyndicateID);
                        }

                        int employeeID = employee.getEmployeeID();
                        newComissioned.setEmployeeID(employeeID);
                        employeesList.set(indexOfEmployee, newComissioned);

                        // Employee testEmployee = employeesList.get(indexOfEmployee);
                        // System.out.println("Nome " + testEmployee.getName());
                        // System.out.println("Endereço " + testEmployee.getAddress());
                        // System.out.println("passei 1");
                        // System.out.println("Salario Base "+ ((Comissioned)testEmployee).getBaseSalary());
                        // System.out.println("passei2");
                        // System.out.println("Comissão "+ ((Comissioned)testEmployee).getComission());
                        // System.out.println("passei2");
                        // // Sindicalizado
                        // System.out.println("Nº sindicato " + testEmployee.getEmployeeSyndicateID());
                        // System.out.println("passei3");
                        // System.out.println("Taxa Adicional " + testEmployee.getSyndicate().getTaxes().getAdditionalTaxe());
                        // System.out.println("passei4");
                        // System.out.println("Taxa Mensal " + testEmployee.getSyndicate().getTaxes().getMonthlyTaxe());
                        // System.out.println("passei5");
                    }
                    break;

                case 4:
                    System.out.println("Digite o método de pagamento desejado dentre as opções:\n '1 - Cheuque Correios', ' 2 - Cheque em Mãos', '3 - Depósito'");
                    edit = input.nextInt();
                    // Data vai receber o caracter " " enter 
                    data = input.nextLine();

                    switch (edit) {
                        case 1:

                            break;

                        case 2:

                            break;

                        case 3:

                            break;

                        default:
                            break;
                    }
                    break;

                case 5:

                    break;

                case 6:

                    break;
                
                case 7:

                    break;

                default:
                    break;
            }
        }
           
    }
}

