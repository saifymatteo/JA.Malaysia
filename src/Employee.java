public abstract class Employee {
    String name;
    double baseSalary;
    static int countID; // static to accumulate the number
    int employeeID;
    int employeeStatus;

    Employee manager;
    Accountant accountantSupport;

    int headCount = 0;
    double bonusBudget;
    double bonus;

    // Constructor
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        countID++;
        this.employeeID = countID;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee getManager() {
        return manager;
    }

    public boolean equals(Employee other) {
        return employeeID == other.getEmployeeID();
    }

    public String toString() {
        return employeeID + " " + name;
    }

    public abstract String employeeStatus();

    // Add-on
    public void setManager(Employee manager){
        this.manager = manager;
    }


    public Accountant getAccountantSupport() {
        return accountantSupport;
    }
}
