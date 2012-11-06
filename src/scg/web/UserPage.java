package scg.web;

import scg.HTML;
import scg.tournament.TournamentManager;
import scg.tournament.Users;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;

/**
 * Base web page class for SignIn and SignUp 
 * @author Patrick
 *
 */
public abstract class UserPage extends WebPage {
  public final static String LOGOUT = "logout";
  protected final static String PASSWORD = "password";
  protected final String _username;
  protected final String _password;
  protected boolean showStatus = true;

  protected UserPage(TournamentManager manager, Users users, HTTPReq request) {
    super(manager, request, users);
    _username = _postArgs.get(USER);
    _password = _postArgs.get(PASSWORD);
  }

  @Override
  public HTTPResp getResponse() {
    try {
      StringBuilder builder = new StringBuilder();
      buildPageHead(builder, getTitle(), false);

      StringBuilder innerBuilder = new StringBuilder();
      boolean showForm = true;

      if (_urlArgs.containsKey(LOGOUT)) {
        handleLogout(innerBuilder);
      }
      // attempt sign in
      if (!_postArgs.isEmpty()) {
        if (_username == null || _username.isEmpty() || _password == null || _password.isEmpty()) {
          builderAppendLn(innerBuilder, invalidSubmit("Username and password are required."));
        } else {
          showForm = handleSubmit(innerBuilder);
        }
      }

      // sign in form
      if (showForm) {
        preFormText(innerBuilder);
        builderAppendLn(innerBuilder, "<div class=\"form\">");
        builderAppendLn(innerBuilder, "<form name=\"signin\" action=\"" + _trimmedURL
            + "\" method=\"post\">");
        builderAppendLn(innerBuilder, "Username: <input type=\"text\" name=\"" + USER
            + "\" /><br />");
        builderAppendLn(innerBuilder, "Password: <input type=\"password\" name=\"" + PASSWORD
            + "\" /><br />");
        builderAppendLn(innerBuilder, "<input type=\"submit\" value=\"" + getSubmitText() + "\" />");
        builderAppendLn(innerBuilder, "</form>");
        builderAppendLn(innerBuilder, "</div>");
        postFormText(innerBuilder);
      }

      builderAppendLn(builder, divWrap(innerBuilder.toString(), getFormWrapperClass()));
      if (showStatus) {
        buildSideStatus(builder, _session);
      }
      return HTML.okHTMLResp(HTML.htmlPage(getTitle(), CSS, divWrap(builder.toString(), "content")));
    } catch (Exception e) {
      return HTML.errHTMLResp("Exception", HTML.errorPage("<div style=\"text-align:left;\">" + e
          + "<br/>" + java.util.Arrays.toString(e.getStackTrace()) + "</div>"));
    }
  }

  protected String invalidSubmit(String reason) {
    return "Sign " + (isSignIn() ? "in" : "up") + " was unsuccessful.<br />" + reason + "<br />";
  }

  /**
   * @return Title of the page
   */
  protected abstract String getTitle();

  /**
   * @return Text for the submit button
   */
  protected abstract String getSubmitText();

  /**
   * @return Text for the submit button
   */
  protected abstract String getFormWrapperClass();

  /**
   * 
   * @return True if SignIn page, False if SignUp page
   */
  protected abstract boolean isSignIn();

  /**
   * Perform the action required when a submission contains both a username and a password.
   * 
   * @param builder StringBuilder to append all display content to.
   * @return True if the normal entry form should be displayed.
   */
  protected abstract boolean handleSubmit(StringBuilder builder);

  /**
   * Hook to display text inside the form div, but before the form.
   * 
   * @param builder StringBuilder to append all display content to.
   */
  protected void preFormText(StringBuilder builder) {

  }

  /**
   * Hook to display text inside the form div, but after the form.
   * 
   * @param builder StringBuilder to append all display content to.
   */
  protected void postFormText(StringBuilder builder) {

  }

  /**
   * Logout the user.
   * 
   * @param builder StringBuilder to append all display content to.
   * @return True if the normal entry form should be displayed.
   */
  protected void handleLogout(StringBuilder builder) {
  }
}
