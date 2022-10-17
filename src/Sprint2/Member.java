package Sprint2;

import java.time.LocalDate;

public class Member extends Person {
    private LocalDate dateOfLastPayment;

    public Member(String name, String IDnr/*LocalDate dateOfLastPayment*/) {
        super(name, IDnr);
        //this.dateOfLastPayment = dateOfLastPayment;
    }

    public String getDateOfLastPayment() {
        return String.valueOf(dateOfLastPayment);
    }

    public void setDateOfLastPayment(String dateOfLastPayment) {
        this.dateOfLastPayment = LocalDate.parse(dateOfLastPayment);
    }

    @Override
    public String toString() {
        return "Medlem " + getName() + " har medlemsstatus.";
    }
}
