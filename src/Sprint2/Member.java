package Sprint2;

public class Member extends Person {
    private String dateOfLastPayment;

    private MembershipStatus membershipStatus;

    public Member(String name, String IDnr) {
        super(name, IDnr);
        this.dateOfLastPayment = dateOfLastPayment;
        this.membershipStatus = membershipStatus;
    }

    public String getDateOfLastPayment() {
        return dateOfLastPayment;
    }

    public void setDateOfLastPayment(String dateOfLastPayment) {
        this.dateOfLastPayment = dateOfLastPayment;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(MembershipStatus membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    @Override
    public String toString() {
        return "Medlem " + getName() + " har medlemsstatus "
                + getMembershipStatus().membershipStatus;
    }
}
