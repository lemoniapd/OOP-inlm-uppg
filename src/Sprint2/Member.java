package Sprint2;

public class Member extends Person {
    private String dateOfLastPayment;

    public Member(String name, String IDnr) {
        super(name, IDnr);
        this.dateOfLastPayment = dateOfLastPayment;
    }

    public String getDateOfLastPayment() {
        return dateOfLastPayment;
    }

    public void setDateOfLastPayment(String dateOfLastPayment) {
        this.dateOfLastPayment = dateOfLastPayment;
    }

    @Override
    public String toString() {
        return "Medlem " + getName() + " har medlemsstatus.";
    }
}
