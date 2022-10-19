package Sprint2;

public enum MembershipStatus {
    ACTIVE_MEMBER ("Aktiv medlem. "),
    INACTIVE_MEMBER ("Före detta medlem. ");

    public final String membershipStatus;

    MembershipStatus(String s) {
        this.membershipStatus = s;
    }

}
