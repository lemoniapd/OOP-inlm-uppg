package Sprint2;

public enum MembershipStatus {
    ACTIVE_MEMBERSHIP("aktiv medlem"),
    INACTIVE_MEMBERSHIP("före detta medlem"),
    NO_MEMBERSHIP("inte medlem");

    public final String membershipStatus;

    MembershipStatus(String s) {
        this.membershipStatus = s;
    }
}
