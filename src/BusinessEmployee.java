public class BusinessEmployee extends Employee {

    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public String employeeStatus() {
        return employeeID + " " + super.name + " with a budget of " + String.format("%.2f", bonusBudget);
    }
}
