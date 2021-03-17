public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Bruno", "Recife", 10.0);

        //System.out.println(employee1.printEmployeeInfo());
        //System.out.println("___________________________________________");

        Employee employee2 = new Employee("Maria", "Aracaju", 5.0);

        System.out.println(employee1.printEmployeeInfo(employee2));
    }
}
