public class TechnicalEmployee extends Employee {

    int checkins;

    public TechnicalEmployee(String name) {
        super(name, 75000);
        checkins++;
    }

    public String employeeStatus() {
        return employeeID + " " + super.name + " has " + checkins + " successful check ins";
    }
}
