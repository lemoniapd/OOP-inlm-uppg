package Sprint2;

public enum MembershipStatus {
    ACTIVE_MEMBER (" aktiv medlem. "),
    INACTIVE_MEMBER (" före detta medlem. ");

    public final String membershipStatus;

    MembershipStatus(String s) {
        this.membershipStatus = s;
    }

}
