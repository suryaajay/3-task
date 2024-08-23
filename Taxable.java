import java.util.Scanner;
interface Taxable {
    double salesTax = 7.0;
    double incomeTax = 10.5;

    double calcTax();
}

class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
    
    @Override
    public double calcTax() {
        return salary * (incomeTax / 100);
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Income Tax: " + calcTax());
    }
}

class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return price * (salesTax / 100);
    }

    public void displayProductDetails() {
        System.out.println("Product ID: " + pid);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Sales Tax on Unit Price: " + calcTax());
    }
}

class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Information:");
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(empId, name, salary);
        employee.displayEmployeeDetails();

        System.out.println("\nEnter Product Information:");
        System.out.print("Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(pid, price, quantity);
        product.displayProductDetails();

        scanner.close();
    }
}

