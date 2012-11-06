package scg.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import scg.HTML;
import scg.admin.Admin;
import scg.exception.AddTournamentException;
import scg.exception.MissingArgumentException;
import scg.exception.NoUserExistsException;
import scg.tournament.TournamentManager;
import scg.tournament.User;
import scg.tournament.Users;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;

/**
 * This class renders the administrator page.
 * The admin page is used to create new tournaments, approve users,
 * and delete users.  It is only reachable by the root user.
 * @author CS5500
 *
 */
public class AdminPage extends WebPage {
  public static final String PATH = "/admin";
  public static final String TITLE = "Admin";
  public static final String NEW_TOURNAMENT = "newTournament";
  private final static String NAME = "name";
  private final static String CONFIG = "config";
  private final static String RUNTIME = "runtime";
  public static final String APPROVE_USER = "approveUser";
  public static final String REMOVE_USER = "removeUser";
  public static final String EDIT_USER = "editUser";

  public AdminPage(TournamentManager manager, Users users, HTTPReq request) {
    super(manager, request, users);
  }

  @Override
  public HTTPResp getResponse() {
    try {
      StringBuilder builder = new StringBuilder();
      buildPageHead(builder, TITLE);
      if (_sessionExists) {
        if (_session.hasExpired()) {
          sessionExpired(builder);
        } else {
          if (_session.getUser().isRoot()) {
            builderAppendLn(builder, newTournamentForm());
            builderAppendLn(builder, userForm());
          } else {
            builderAppendLn(builder, divWrap("You shouldn't be here!", "error"));
            builderAppendLn(builder, "<script>setTimeout(\"window.location = '"
                + redirectURL(ServerStatus.PATH) + "?" + SESSION + "=" + _session.getKey()
                + "'\", 3000);</script>");
          }
        }
      } else {
        noSession(builder);
      }
      return HTML.okHTMLResp(HTML.htmlPage(TITLE, CSS, builder.toString()));
    } catch (Exception e) {
      return HTML.errHTMLResp("Exception", HTML.errorPage("<div style=\"text-align:left;\">" + e
          + "<br/>" + java.util.Arrays.toString(e.getStackTrace()) + "</div>"));
    }
  }

  private String newTournamentForm() {
    StringBuilder builder = new StringBuilder();
    String name = "";
    String theConfig = "";
    String runtime = "";
    if (_postArgs.containsKey(NEW_TOURNAMENT)) {
      try {
        name = getArgument(_postArgs, NAME);
        theConfig = getArgument(_postArgs, CONFIG);
        runtime = getArgument(_postArgs, RUNTIME);
      } catch (MissingArgumentException e1) {
        builderAppendLn(builder, divWrap("All of the fields were not included.", "error"));
      }
      try {
        int id = _manager.addTournament(name, theConfig, Admin.runtimeToDate(runtime));
        builderAppendLn(builder, divWrap(link(redirectURL(TournamentStatus.PATH) + "?" + SESSION
            + "=" + _session.getKey() + "&" + TOURNAMENT_ID + "=" + id, name)
            + " successfully scheduled.", "success"));
      } catch (AddTournamentException e) {
        builderAppendLn(builder, divWrap(e.getMessage(), "error"));
      } catch (scg.ParseException e) {
        builderAppendLn(builder, divWrap(e.getMessage(), "error"));
      } catch (NumberFormatException e) {
        builderAppendLn(builder, divWrap(runtime + " is not a valid runtime.", "error"));
      }
    }
    builderAppendLn(builder, "Add a tournament:<br />");
    builderAppendLn(builder, "<form name=\"" + NEW_TOURNAMENT + "\" action=\"" + _trimmedURL
        + "\" method=\"post\">");
    builderAppendLn(builder, "Name: <input type=\"text\" name=\"" + NAME + "\" value=\"" + name
        + "\" />");
    builderAppendLn(builder, "Runtime: <input type=\"text\" name=\"" + RUNTIME + "\" value=\""
        + runtime + "\"  /><br />");
    builderAppendLn(builder, "Playground Config:<br /><textarea name=\"" + CONFIG
        + "\" class=\"config\" cols=40 rows=6>" + theConfig + "</textarea><br />");
    builderAppendLn(builder,
        "<input type=\"hidden\" name=\"" + SESSION + "\" value=\"" + _session.getKey() + "\" />");
    builderAppendLn(builder, "<input type=\"submit\" name=\"" + NEW_TOURNAMENT
        + "\" value=\"Add\" />");
    builderAppendLn(builder, "</form>");
    return divWrap(builder.toString(), NEW_TOURNAMENT);
  }
  
  private String userForm() {
    StringBuilder builder = new StringBuilder();
    builderAppendLn(builder, handleUserSubmission());
    builderAppendLn(builder, approveUserForm());
    builderAppendLn(builder, removeUserForm());
    return divWrap(builder.toString(), EDIT_USER);
  }

  private String approveUserForm() {
    StringBuilder builder = new StringBuilder();
    builderAppendLn(builder, "Users Awaiting Approval:<br />");
    List<User> needApproval = _users.getUnApprovedUsers();
    Collections.sort(needApproval);
    if (needApproval.isEmpty()) {
      builderAppendLn(builder, "All users have been approved.<br />");
    } else {
      builderAppendLn(builder, "<form name=\"" + APPROVE_USER + "\" action=\"" + _trimmedURL
          + "\" method=\"post\">");
      builderAppendLn(builder, "<table name=\"" + APPROVE_USER + "\">");
      for (User user : needApproval) {
        builderAppendLn(builder, "<tr><td>" + user.getName() + "</td>");
        builderAppendLn(builder, "<td><input type=\"checkbox\" name=\"" + user.getName()
            + "\" /></td></tr>");
      }
      builderAppendLn(builder, "</table>");

      builderAppendLn(builder, "<input type=\"hidden\" name=\"" + SESSION + "\" value=\""
          + _session.getKey() + "\" />");
      builderAppendLn(builder, "<input type=\"submit\" name=\"" + APPROVE_USER
          + "\" value=\"Approve Selected\" /><br />");
      builderAppendLn(builder, "<input type=\"submit\" name=\"" + REMOVE_USER
          + "\" value=\"Remove Selected\" />");
      builderAppendLn(builder, "</form>");
    }
    return builder.toString();
  }

  private String removeUserForm() {
    StringBuilder builder = new StringBuilder();
    builderAppendLn(builder, "Approved Users:<br />");
    List<User> approved = _users.getApprovedUsers();
    if (approved.size() <= 1) {//root is always approved
      builderAppendLn(builder, "No users have been approved.<br />");
    } else {
      builderAppendLn(builder, "<form name=\"" + REMOVE_USER + "\" action=\"" + _trimmedURL
          + "\" method=\"post\">");
      builderAppendLn(builder, "<table name=\"" + REMOVE_USER + "\">");
      for (User user : approved) {
        if (!user.isRoot()) {
          builderAppendLn(builder, "<tr><td>" + user.getName() + "</td>");
          builderAppendLn(builder, "<td><input type=\"checkbox\" name=\"" + user.getName()
              + "\" /></td></tr>");
        }
      }
      builderAppendLn(builder, "</table>");

      builderAppendLn(builder, "<input type=\"hidden\" name=\"" + SESSION + "\" value=\""
          + _session.getKey() + "\" />");
      builderAppendLn(builder, "<input type=\"submit\" name=\"" + REMOVE_USER
          + "\" value=\"Remove Selected\" />");
      builderAppendLn(builder, "</form>");
    }
    return builder.toString();
  }
  
  private String handleUserSubmission() {
    StringBuilder builder = new StringBuilder();
    if (_postArgs.containsKey(APPROVE_USER)) {
      int approved = 0;
      List<String> illegalUsers = new ArrayList<String>();
      for (String username : _postArgs.keySet()) {
        if (!username.equals(SESSION) && !username.equals(APPROVE_USER)) {
          try {
            _users.approveUser(username);
            approved++;
          } catch (NoUserExistsException e) {
            illegalUsers.add(username);
          }
        }
      }
      if (!illegalUsers.isEmpty()) {
        builderAppendLn(
            builder,
            divWrap("Could not approve the following users because they don't exist:<br />"
                + Arrays.toString(illegalUsers.toArray()), "error"));
      } else if (approved != 0) {
        builderAppendLn(
            builder,
            divWrap(approved + " user" + ((approved == 1) ? "" : "s") + " successfully approved.",
                "success"));
      }
    }
    if (_postArgs.containsKey(REMOVE_USER)) {
      int removed = 0;
      List<String> illegalUsers = new ArrayList<String>();
      for (String username : _postArgs.keySet()) {
        if (!username.equals(SESSION) && !username.equals(REMOVE_USER)) {
          try {
            _users.removeUser(username);
            removed++;
          } catch (NoUserExistsException e) {
            illegalUsers.add(username);
          }
        }
      }
      if (!illegalUsers.isEmpty()) {
        builderAppendLn(
            builder,
            divWrap(
                "Could not remove the following users because they don't exist:<br />"
                    + Arrays.toString(illegalUsers.toArray()), "error"));
      } else if (removed != 0) {
        builderAppendLn(
            builder,
            divWrap(removed + " user" + ((removed == 1) ? "" : "s") + " successfully removed.",
                "success"));
      }
    }
    return builder.toString();
  }
}
