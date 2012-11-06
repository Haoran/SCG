package scg.web;

import scg.exception.GodException;
import scg.tournament.Session;
import scg.tournament.TournamentManager;
import scg.tournament.Users;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;

public class SignIn extends UserPage {
  public final static String PATH = "/signin";
  private final static String TITLE = "Sign In";

  protected SignIn(TournamentManager manager, Users users, HTTPReq request) {
    super(manager, users, request);
  }

  @Override
  protected String getTitle() {
    return TITLE;
  }

  @Override
  protected String getSubmitText() {
    return "Log In";
  }

  @Override
  protected boolean handleSubmit(StringBuilder builder) {
    try {
      Session s =_users.login(_username, _password);
      if (s.getUser().isRoot())
      {
    	  builderAppendLn(builder, "<span style='font-weight:strong;'>Admin sign in was successful.</span><br/>");
        String adminURL = redirectURL(AdminPage.PATH) + "?" + SESSION + "=" + s.getKey();
    	  builderAppendLn(builder, "Routing you to the " + link(adminURL, "admin page") + " in 3 seconds...<br/>");
    	  builderAppendLn(builder, "(or click " + link(redirectURL(ServerStatus.PATH) + "?" + SESSION + "=" + s.getKey(), "here") + " to go to the server status page.)");
    	  builderAppendLn(builder, "<script>setTimeout(\"window.location = '" 
    			  + adminURL + "'\", 3000);</script>");
      }
      else
      {
    	  builderAppendLn(builder, "<script>window.location = '" 
    			  + redirectURL(ServerStatus.PATH) + "?" + SESSION + "=" 
    			  + s.getKey() + "';</script>");
      }
      
      buildSideStatus(builder, s);
      showStatus = false;
      return false;
    } catch (GodException e) {
      builderAppendLn(builder, invalidSubmit(e.getMessage()));
      return true;
    }
  }

  @Override
  protected void postFormText(StringBuilder builder) {
    builderAppendLn(builder, "<div class=\"signup\">No account? "
        + link(redirectURL(SignUp.PATH), "Sign Up") + "</div>");
  }

  @Override
  protected boolean isSignIn() {
    return true;
  }

  @Override
  protected void handleLogout(StringBuilder builder) {
    if (_sessionExists) {
      _users.logout(_session);
    }
    buildSideStatus(builder, null);
    showStatus = false;
    builderAppendLn(builder, "<div class=\"logout\">You have been logged out.</div>");
  }

  @Override
  protected String getFormWrapperClass() {
    return "signin";
  }
}
