package scg.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import scg.HTML;
import scg.tournament.SerializedTournamentSetup;
import scg.tournament.TournamentManager;
import scg.tournament.Users;
import scg.tournament.TournamentSetup.Status;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;
import edu.neu.ccs.demeterf.http.server.Server;

@Server
public class ServerStatus extends WebPage {
  public final static String PATH = "/status";
  private final static String TITLE = "Server Status";

  protected ServerStatus(TournamentManager manager, Users users, HTTPReq request) {
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
        	// If the user is root, see if we have any deletion entries
            if (_sessionExists && _session.getUser().isRoot()){
          	  for (String arg : _postArgs.keySet()){
          		  if (arg.startsWith("delete_tournament_chkbox_") && _postArgs.get(arg).equals("on")){
          			  _manager.deleteTournament(Integer.parseInt(arg.substring(25)));
          		  }
          	  }
            }
        	
          builderAppendLn(builder, divWrap(tournamentTable(), "tournaments"));
          builderAppendLn(builder, divWrap(refreshToggleLink(true), "refresh"));
        }
      } else {
        noSession(builder);
      }
      return HTML.okHTMLResp(HTML.htmlRefreshPage(_refresh ? REFRESH_TIME : 0, TITLE, CSS,
          builder.toString()));
    } catch (Exception e) {
      return HTML.errHTMLResp(
          "Exception",
          HTML.errorPage("<div style=\"text-align:left;\">" + e + "<br/>"
              + java.util.Arrays.toString(e.getStackTrace()) + "</div>"));
    }
  }

  private String tournamentTable() {
    StringBuilder builder = new StringBuilder();
    StringBuilder innerBuilder = new StringBuilder();
    if (_session.getUser().isRoot()) {
    	innerBuilder.append(HTML.wrap("", "td"));
	  }
    innerBuilder.append(HTML.wrap("ID", "td"));
    innerBuilder.append(HTML.wrap("NAME", "td"));
    innerBuilder.append(HTML.wrap("DOMAIN", "td"));
    innerBuilder.append(HTML.wrap("STATUS", "td"));
    innerBuilder.append(HTML.wrap("RUNTIME", "td"));
    builder.append(HTML.wrap(innerBuilder.toString(), "tr"));
    List<SerializedTournamentSetup> states = new ArrayList<SerializedTournamentSetup>(_manager.getState());
    Collections.sort(states);
    if (states.isEmpty()) {
      builder.append("<tr><td  colspan=\"5\">" + divWrap("No Tournaments", "center") + "</d></tr>");
    } else {
      for (SerializedTournamentSetup state : states) {
        innerBuilder = new StringBuilder();
        if (_session.getUser().isRoot()) {
        	if (state.getStatus() == Status.RUNNING){
        		innerBuilder.append("<td></td>");
        	} else {
        		innerBuilder.append("<td><input type='checkbox' name='delete_tournament_chkbox_" + Integer.toString(state.getId()) + "'></td>");
        	}
		  }
        innerBuilder.append(HTML.wrap(link(redirectURL(TournamentStatus.PATH) + "?" + SESSION + "=" + 
        		_session.getKey() + "&" + TOURNAMENT_ID + "=" + state.getId(), Integer.toString(state.getId())), "td"));
        
        innerBuilder.append(HTML.wrap(state.getName(), "td"));
        innerBuilder.append(HTML.wrap(state.getConfig().getScgCfg().getDomain().toString(),
            "td"));
        innerBuilder.append(HTML.wrap(state.getStatus().toString(), "td"));
        innerBuilder.append(HTML.wrap(DateFormat.getDateTimeInstance().format(state.getRunTime()),
            "td"));
        builder.append(HTML.wrap(innerBuilder.toString(), "tr"));
      }
      
      if (_session.getUser().isRoot()) {
		  builder.append("<tr><td colspan='6'><input type='submit' value='Delete Selected'></td></tr>");
	  }
    }
    
    return "<form action='" + this.PATH + "?" + SESSION + "=" + _session.getKey() 
    	+ "' method='POST'>" + HTML.wrap(builder.toString(), "table", "tournaments") + "</form>";
  }
}
