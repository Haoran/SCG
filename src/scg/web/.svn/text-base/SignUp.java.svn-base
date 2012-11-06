package scg.web;

import scg.exception.UserExistsException;
import scg.tournament.TournamentManager;
import scg.tournament.Users;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;

public class SignUp extends UserPage {
  public final static String PATH = "/signup";
  private final static String TITLE = "Sign Up";

  protected SignUp(TournamentManager manager, Users users, HTTPReq request) {
    super(manager, users, request);
  }

  @Override
  protected String getTitle() {
    return TITLE;
  }

  @Override
  protected String getSubmitText() {
    return "Submit Request";
  }

  @Override
  protected boolean handleSubmit(StringBuilder builder) {
    try {
      _users.signup(_username, _password);
      builderAppendLn(builder,
          "Sign up was successful. The account is now waiting for approval from the administrator.<br />");
      builderAppendLn(builder, "<div class=\"signin\">"
          + link(redirectURL(SignIn.PATH), "back to Sign In") + "</div>");
      return false;
    } catch (UserExistsException e) {
      builderAppendLn(builder, invalidSubmit("The username " + _username
          + " is already being used. Please try a different username."));
      return true;
    }
  }

  @Override
  protected boolean isSignIn() {
    return false;
  }

  @Override
  protected void preFormText(StringBuilder builder) {
    builderAppendLn(builder, "<div class=\"preform\">");
    builderAppendLn(builder, "If you'd like to get an SCG Court account,<br />");
    builderAppendLn(builder,
        "enter the user name and password you'd like to have in the system.<br />");
    builderAppendLn(builder, "The system admin will have to approve your signup request.<br />");
    builderAppendLn(builder, "</div>");
  }

  @Override
  protected String getFormWrapperClass() {
    return "signup";
  }
}
