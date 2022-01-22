public class Accountant extends BusinessEmployee {

    TechnicalLead teamSupport;

    public Accountant(String name) {
        super(name);
        super.bonusBudget = 0;
    }

    public TechnicalLead getTeamSupported() {
        return teamSupport;
    }

    public void supportTeam(TechnicalLead lead) {
        teamSupport = lead;
        for (int i = 0; i < lead.team.size(); i++) {
            bonusBudget += lead.team.get(i).getBaseSalary() * 1.1;
        }
    }

    public boolean approveBonus(double bonus) {
        if (bonus <= super.bonusBudget) {
            return true;
        } else if (teamSupport == null) {
            return false;
        } else {
            return false;
        }
    }

    public String employeeStatus() {
        return employeeID + " " + super.name + " with a budget of " + super.bonusBudget + " is supporting " + getTeamSupported();
    }
}
