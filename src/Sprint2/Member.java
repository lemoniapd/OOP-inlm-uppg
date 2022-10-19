package Sprint2;

import java.time.LocalDate;

public class Member extends Person {
    private LocalDate dateOfLastPayment;
    private String membershipStatus;

    public Member(String name, String IDnr) {
        super(name, IDnr);
    }

    public LocalDate getDateOfLastPayment() {
        return this.dateOfLastPayment;
    }

    public void setDateOfLastPayment(String dateOfLastPayment) {
        this.dateOfLastPayment = LocalDate.parse(dateOfLastPayment);
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public String stringResult() {
        return getName() + " har medlemsstatus: " + this.membershipStatus;
    }
}
