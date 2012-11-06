package scg.exception;

public class UserNotApprovedException extends GodException {

  public UserNotApprovedException() {
    super("The administrator has not approved this account for access to the system.");
  }

}
