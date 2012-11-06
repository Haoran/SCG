package scg.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import scg.HTML;
import scg.Util;
import scg.exception.MissingArgumentException;
import scg.tournament.Session;
import scg.tournament.TournamentManager;
import scg.tournament.Users;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;

/**
 * Base class for all classes that produce a page of the website
 * 
 * @author Patrick
 * 
 */
public abstract class WebPage {
  protected static final String SESSION = "session";
  protected final static String USER = "user";
  protected static final String REFRESH = "refresh";
  protected static final String TOURNAMENT_ID = "tournament_id";
  protected static final String RESOURCE_REQUEST = "resource";
  protected static final String CONFIG_RESOURCE_REQUEST = "config";
  protected static final String AVATAR_RESOURCE_REQUEST = "avatar";
  protected static final String RAW_HISTORY_RESOURCE_REQUEST = "raw_history";
  protected static final String SMART_HISTORY_RESOURCE_REQUEST = "smart_history";
  protected static final String HISTORY_RESOURCE_REQUEST_FILE = "history_file";
  protected static final int REFRESH_TIME = 30;
  protected static final String CSS = "\n div{ padding:10px;display: block; }"
      + "\n table,td{ border:blue 1px solid;padding:5px; }"
      + "\n td,th{ border-spacing:5px; }"
      + "\n td.num{ text-align:center; }"
      + "\n th{ font-style:italic;border:solid navy 1px; padding:5px;}"
      + "\n .error{ color:red;text-align:center;margin-left: auto;width: 400px;margin-right: auto; }"
      + "\n .odd{ background-color:#D0D0D0; }"
      + "\n .current{ background-color:#40D040; }"
      + "\n .kicked{ background-color:#E04040; }"
      + "\n .time{ font-size:12px; float: right; }"
      + "\n .sidestatus{ position:absolute; top:0px; right:0px;  }"
      + "\n .sidenav{ position:absolute; top:0px; left:0px; font-size:12px;padding:20px;  }"
      + "\n .title{ font-size:32px;font-weight:bold;text-align:center;margin-left: auto;margin-right: auto; }"
      + "\n .signin, .signup, .logout, .refresh{ text-align:center;margin-left: auto;width: 400px;margin-right: auto;}"
      + "\n .preform{ text-align:center;margin-left: auto;width: 400px;margin-right: auto;}"
      + "\n .tournaments{ text-align:center;margin-left: auto;margin-right: auto;}"
      + "\n .user{ font-size:12px; float:right; }" + "\n .config{ width:550px;height:120px; }"
      + "\n .newTournament, .editUser{ float:left; }" + "\n .approveUser{ left; }"
      + "\n .center{ text-align:center; }";

  /**
   * The tournament manager of the server
   */
  protected final TournamentManager _manager;
  /**
   * The request sent to the server
   */
  protected final HTTPReq _request;
  /**
   * The collection of users for the server
   */
  protected final Users _users;
  /**
   * The arguments passed in by a GET request.
   */
  protected final Map<String, String> _urlArgs;
  /**
   * The arguments passed in by a POST request.
   */
  protected final Map<String, String> _postArgs;
  /**
   * The headers of the request
   */
  protected final Map<String, String> _headers;
  /**
   * True if the page should automatically refresh
   */
  protected final boolean _refresh;
  /**
   * The base address of the requested page
   */
  protected final String _trimmedURL;
  /**
   * The session for the logged in user. <code>null</code> if there is no session.
   */
  protected final Session _session;
  /**
   * True is there is a session instance
   */
  protected final boolean _sessionExists;

  /**
   * Initialize the web page
   * 
   * @param manager
   * @param request
   * @param users
   */
  protected WebPage(TournamentManager manager, HTTPReq request, Users users) {
    _manager = manager;
    _request = request;
    _users = users;
    _headers = _request.getHeaders().toJavaMap();
    try {
      _urlArgs = splitArgsURL(_request.getHead().getUrl().toString());
      _postArgs = splitArgs(_request.getBody().toString());
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    _refresh = _urlArgs.containsKey(REFRESH);
    _trimmedURL = _request.trimmedUrl();
    String sessionKey = _urlArgs.get(SESSION);
    if (sessionKey == null) {
      sessionKey = _postArgs.get(SESSION);
    }
    if (sessionKey == null) {
      _session = null;
    } else {
      _session = _users.getSession(sessionKey);
    }
    _sessionExists = _session != null;
  }

  private static Map<String, String> splitArgs(String s) throws UnsupportedEncodingException {
    Map<String, String> args = new HashMap<String, String>();
    if (s.contains("=")) {
      for (String piece : s.split("&")) {
        String[] kv = piece.split("=");
        if (kv.length > 0) {
          args.put(URLDecoder.decode(kv[0], "UTF-8"),
              (kv.length > 1) ? URLDecoder.decode(kv[1], "UTF-8") : "");
        }
      }
    }
    return args;
  }

  private static Map<String, String> splitArgsURL(String s) throws UnsupportedEncodingException {
    int question = s.indexOf('?');
    return splitArgs((question < 0) ? "" : s.substring(question + 1).trim());
  }

  public abstract HTTPResp getResponse();

  /**
   * Wrap the content in a div of the given class.
   * 
   * @param content
   * @param cssClass
   * @return
   */
  protected static String divWrap(String content, String cssClass) {
    return HTML.wrap(content, "div", cssClass);
  }

  /**
   * A refresh link for the given page. Does not retain any of the url arguments
   * 
   * @return
   */
  protected String refreshToggleLink() {
    return refreshToggleLink(false);
  }

  /**
   * A refresh link for the given page.
   * 
   * @param withArgs True if the url arguments should be retained
   * @return
   */
  protected String refreshToggleLink(boolean withArgs) {
    StringBuilder builder = new StringBuilder();
    builder.append("<a href=\"");
    builder.append(_trimmedURL);
    boolean needsAnd = false;
    if (!_refresh) {
      builder.append("?" + REFRESH + "=true");
      needsAnd = true;
    }
    if (withArgs) {
      boolean sessionAdded = false;
      for (Entry<String, String> e : _urlArgs.entrySet()) {
        if (!e.getKey().equals(REFRESH)) {
          builder.append((needsAnd ? "&" : "?"));
          builder.append(e.getKey() + "=" + e.getValue());
          needsAnd = true;
          if (e.getKey().equals(SESSION)) {
            sessionAdded = true;
          }
        }
      }
      if (!sessionAdded && _postArgs.containsKey(SESSION)) {
        builder.append((needsAnd ? "&" : "?") + SESSION + "=" + _session.getKey());
      }
    }
    builder.append("\">Refresh ");
    builder.append(_refresh ? "Off" : "On");
    builder.append("</a>");
    return builder.toString();
  }

  /**
   * Append content to the builder, followed by a new line character.
   * 
   * @param builder
   * @param content
   */
  protected static void builderAppendLn(StringBuilder builder, String content) {
    builder.append(content);
    builder.append("\n");
  }

  /**
   * Write the common sections that exist at the top of a page, with the status and navigation
   * sections
   * 
   * @param builder StringBuilder to append to
   * @param title Title of the web page
   */
  protected void buildPageHead(StringBuilder builder, String title) {
    buildPageHead(builder, title, true);
  }

  /**
   * Write the common sections that exist at the top of a page
   * 
   * @param builder StringBuilder to append to
   * @param title Title of the web page
   * @param withStatus True if the page should contain the status and navigation sections
   */
  protected void buildPageHead(StringBuilder builder, String title, boolean withStatus) {
    if (withStatus) {
      buildSideStatus(builder, _session);
      buildSideNav(builder, _session);
    }
    builderAppendLn(builder, divWrap(title, "title"));
  }

  /**
   * Write the status section based on the given session
   * 
   * @param builder
   * @param s
   */
  protected void buildSideStatus(StringBuilder builder, Session s) {
    builderAppendLn(builder, "<div class=\"sidestatus\">");
    if (s != null && !s.hasExpired()) {
      builderAppendLn(
          builder,
          divWrap(
              s.getUser().getName()
                  + " | "
                  + link(redirectURL(SignIn.PATH) + "?" + UserPage.LOGOUT + "=true&" + SESSION
                      + "=" + s.getKey(), "Sign Out"), USER));
    }
    builderAppendLn(builder, divWrap(Util.printDate(Util.now()), "time"));
    builderAppendLn(builder, "</div>");
  }

  /**
   * Write the navigation section based on the given session
   * 
   * @param builder
   * @param s
   */
  private void buildSideNav(StringBuilder builder, Session s) {
    if (s != null && !s.hasExpired()) {
      boolean needPipe = false;
      builderAppendLn(builder, "<div class=\"sidenav\">");
      if (s.getUser().isRoot() && !_trimmedURL.equals(AdminPage.PATH)) {
        builderAppendLn(builder,
            link(redirectURL(AdminPage.PATH) + "?" + SESSION + "=" + s.getKey(), "Admin Page"));
        needPipe = true;
      }
      if (!_trimmedURL.equals(ServerStatus.PATH)) {
        if (needPipe) {
          builder.append(" | ");
        }
        builderAppendLn(
            builder,
            link(redirectURL(ServerStatus.PATH) + "?" + SESSION + "=" + s.getKey(), "Server Status"));
      }
      builderAppendLn(builder, "</div>");
    }
  }

  /**
   * Write a message for when no session exists
   * 
   * @param builder
   */
  protected void noSession(StringBuilder builder) {
    requiresSignIn(builder, "You must sign-in before you can access this page.");
  }

  /**
   * Write a message for when a session has expired
   * 
   * @param builder
   */
  protected void sessionExpired(StringBuilder builder) {
    requiresSignIn(builder, "Your session has expired. You must sign-in again.");
  }

  /**
   * Write a message indicating that the current page requires a user session
   * 
   * @param builder
   * @param msg Message to appear before the sign in link
   */
  private void requiresSignIn(StringBuilder builder, String msg) {
    builderAppendLn(builder,
        divWrap(msg + "<br />" + link(redirectURL(SignIn.PATH), "Sign In"), "error"));
  }

  /**
   * Produce a url that points to the given destination
   * 
   * @param destinationPath
   * @return
   */
  protected String redirectURL(String destinationPath) {
    return _trimmedURL.substring(0, _trimmedURL.lastIndexOf("/")) + destinationPath;
  }

  /**
   * Produce a link
   * 
   * @param url
   * @param text
   * @return
   */
  protected static String link(String url, String text) {
    return "<a href=\"" + url + "\">" + text + "</a>";
  }

  /**
   * Get the value of an argument
   * 
   * @param map The map to look in
   * @param key The key to look up
   * @return The value in the map for the given key
   * @throws MissingArgumentException When a key does not have a value in the map
   */
  protected static String getArgument(Map<String, String> map, String key)
      throws MissingArgumentException {
    String valueString = map.get(key);
    if (valueString == null) {
      throw new MissingArgumentException(key);
    }
    return valueString;
  }
}