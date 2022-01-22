public class SoftwareEngineer extends TechnicalEmployee {

    boolean codeAccess;

    public SoftwareEngineer(String name) {
        super(name);
        super.checkins = 0;
        codeAccess = false;
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public int getSuccessCheckIns() {
        return checkins;
    }

    public boolean checkInCode() {
        TechnicalLead manager = (TechnicalLead) getManager();
        if (manager.approveCheckIns(this)) {
            checkins++;
            return true;
        } else {
            codeAccess = false;
            return false;
        }
    }
}
