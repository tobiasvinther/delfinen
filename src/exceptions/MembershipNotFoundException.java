package exceptions;

public class MembershipNotFoundException extends RuntimeException{
    public MembershipNotFoundException() {
        super("Membership doesn't exist");
    }
}
