package scg.web;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import scg.Config;
import scg.Constants;
import scg.HTML;
import scg.exception.MissingArgumentException;
import scg.game.ActiveGame;
import scg.tournament.PlayerStatus;
import scg.tournament.TournamentManager;
import scg.tournament.TournamentSetup;
import scg.tournament.TournamentSetup.Status;
import scg.tournament.Users;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;
import edu.neu.ccs.demeterf.http.server.Server;

@Server
public class TournamentStatus extends WebPage {
  public final static String PATH = "/tournament";
  private static final String TITLE = "Tournament - ";
  protected static final String ENROLL = "enroll";
  private int tournament_id;

  public TournamentStatus(TournamentManager manager, Users users, HTTPReq request) {
	  
    super(manager, request, users);
  }

  @Override
  public HTTPResp getResponse() {
    String value = null;
    try {
      value = getArgument(_urlArgs, TOURNAMENT_ID);
      tournament_id = Integer.parseInt(value);
      if (tournament_id < 1) {
        return invalidIdErrorPage(false, value);
      }
    } catch (MissingArgumentException e) {
      return invalidIdErrorPage(false, null);
    } catch (NumberFormatException e) {
      return invalidIdErrorPage(false, value);
    }
    TournamentSetup tournament = _manager.getTournament(tournament_id);
    if (tournament == null) {
      return invalidIdErrorPage(true, value);
    }
    try {
      StringBuilder builder = new StringBuilder();
      buildPageHead(builder, TITLE + tournament.getName());
      if (_sessionExists) {

      } else {
        noSession(builder);
      }

      // Enroll or unenroll a given user
      if (_urlArgs.containsKey(ENROLL)) {
        value = _urlArgs.get(ENROLL);
        if (value.equals("1")) {
          if (tournament.getEnrolledPlayers().size() < tournament.getConfig().getScgCfg().getMaxNumAvatars()){
            _manager.enrollPlayer(tournament_id, _session.getUser().getName(), _session.getUser().getPasswordHash());
          }
        } else if (value.equals("0")) {
          _manager.unEnrollPlayer(tournament_id, _session.getUser().getName());
        }
      }
      
      // If the user is root, see if we have any unenroll entries
      if (_sessionExists && _session.getUser().isRoot()){
    	  for (String arg : _postArgs.keySet()){
    		  if (arg.startsWith("unenroll_chkbox_") && _postArgs.get(arg).equals("on")){
    			  _manager.unEnrollPlayer(tournament_id, arg.substring(16));
    		  }
    	  }
      }
      
      if (_sessionExists){
	      buildConfigSection(builder, tournament);

	      builder.append("<div style='width:600px;'>");
	      if (tournament.getStatus() == Status.ENROLLMENT
	    		  || tournament.getStatus() == Status.REGISTRATION) {
		      buildCurrentlyEnrolledUsersSection(builder, tournament);
		      buildEnrollmentSection(builder, tournament);
	      } else if (tournament.getStatus() == Status.RUNNING) {
	    	  buildTournamentStatusSection(builder, tournament);
	      } else if (tournament.getStatus() == Status.COMPLETE) {
	    	  buildFinishedtournamentStatusSection(builder, tournament);
	    	  buildTournamentHistorySection(builder, tournament);
	      }
	      builder.append("</div>");

	      builderAppendLn(builder, divWrap(refreshToggleLink(true), "refresh"));
      }
      
      return HTML.okHTMLResp(HTML.htmlRefreshPage(_refresh ? REFRESH_TIME : 0, TITLE + tournament.getName(), CSS, HTML
          .wrap(builder.toString(), "center")));
    } catch (Exception e) {
      return HTML.errHTMLResp("Exception", HTML.errorPage("<div style=\"text-align:left;\">" + e
          + "<br/>" + java.util.Arrays.toString(e.getStackTrace()) + "</div>"));
    }
  }

  private HTTPResp invalidIdErrorPage(boolean valid, String id) {
    String serverURL = _trimmedURL.replace(PATH, ServerStatus.PATH);
    String msg = null;
    if (id == null) {
      msg = "No tournament id was provided.";
    } else if (valid) {
      msg = "No tournament exists with id " + id;
    } else {
      msg = id + " is an invalid tournament id";
    }
    return HTML.errHTMLResp("Exception", HTML.errorPage("<div style=\"text-align:left;\">" + msg
        + "<br/>" + "<a href=\"" + serverURL + "\">Return to Main Server Page</a>" + "</div>"));
  }
  
  private void buildConfigSection(StringBuilder builder, TournamentSetup tournament) {
	  Config cfg = tournament.getConfig();
	  builder.append("<div><table>");
	  
	  builder.append("<tr><td>Domain:</td>");
	  builder.append("<td>" + cfg.getScgCfg().getDomain() + "</td>");
	  builder.append("<td>Style:</td>");
	  builder.append("<td>" + cfg.getScgCfg().getTournamentStyle() + "</td></tr>");
	  
	  builder.append("<tr><td>Tournament Start:</td>");
	  builder.append("<td>" + DateFormat.getDateTimeInstance().format(tournament.getRunTime()) + "</td>");
	  builder.append("<td>Max Avatars:</td>");
	  builder.append("<td>" + cfg.getScgCfg().getMaxNumAvatars() + "</td></tr>");
	  
	  builder.append("<tr><td>Turn Duration:</td>");
	  builder.append("<td>" + cfg.getScgCfg().getTurnDuration() + "</td>");
	  builder.append("<td>Number of Rounds:</td>");
	  builder.append("<td>" + cfg.getScgCfg().getNumRounds() + "</td></tr>");
	  
	  builder.append("<tr><td colspan='2'>");
	  builder.append(link(redirectURL(TournamentResource.PATH) + "?" + RESOURCE_REQUEST + "=" 
			  + CONFIG_RESOURCE_REQUEST + "&" + SESSION + "=" + _session.getKey() + "&"
			  + TOURNAMENT_ID + "=" + tournament_id, "Download full config file"));
	  builder.append("</td>");
	  builder.append("<td colspan='2' style='text-align:center;'>Current Status:</td></tr>");
	  

    builder.append("<tr><td colspan='2'>");
    builder.append(link(redirectURL(TournamentResource.PATH) + "?" + RESOURCE_REQUEST + "=" 
        + AVATAR_RESOURCE_REQUEST + "&" + SESSION + "=" + _session.getKey() + "&"
        + TOURNAMENT_ID + "=" + tournament_id, "Download baby avatar"));
    builder.append("</td>");
	  builder.append("<td colspan='2' style='color:red;text-align:center;'>" + tournament.getStatus() + "</td></tr>");
	  
	  builder.append("</table></div>");
  }
  
  private void buildCurrentlyEnrolledUsersSection(StringBuilder builder, TournamentSetup tournament){
	  builder.append("<div style='float:left;'>");
	  builder.append("<form method='POST' action='" + TournamentStatus.PATH + "?" 
			  + SESSION + "=" + _session.getKey() + "&" + TOURNAMENT_ID + "=" + tournament_id + "'>");
	  builder.append("<table>");
	  builder.append("<tr><td style='font-weight:bold;' colspan='2'>Enrolled Users</td></tr>");
	  
	  if (tournament.getEnrolledPlayers().size() == 0){
		  builder.append("<tr><td>No players currently enrolled</td></tr>");
	  } else {
		  for (String player : tournament.getEnrolledPlayers().keySet()){
			  
			  builder.append("<tr>");
			  if (_session.getUser().isRoot()) {
				  builder.append("<td><input type='checkbox' name='unenroll_chkbox_" + _session.getUser().getName() + "'></td>");
			  }
			  
			  if (tournament.getRegisteredPlayers().containsKey(player)){
				  builder.append("<td style='font-weight:bold;'>" + player + "</td>");
			  }else{
				  builder.append("<td>" + player + "</td>");
			  }			  
			  builder.append("</tr>");
		  }
	  }
	  
	  if (_session.getUser().isRoot()) {
		  builder.append("<tr><td colspan='2'><input type='submit' value='Unenroll Selected'></td></tr>");
	  }

	  builder.append("</table></form>");
	  
	  builder.append("</div>");
  }
  
  private void buildEnrollmentSection(StringBuilder builder, TournamentSetup tournament){
	  if (tournament.getStatus() == Status.ENROLLMENT
			  || tournament.getStatus() == Status.REGISTRATION) {
		  builder.append("<div><form action='" + 
				  redirectURL(TournamentStatus.PATH) + "' method='GET'>");
		  
		  builder.append("<input type='HIDDEN' name='" + SESSION + "' value='" + _session.getKey() + "'/>");
		  builder.append("<input type='HIDDEN' name='" + TOURNAMENT_ID + "' value='" + tournament_id + "'/>");
		  
		  if (tournament.getEnrolledPlayers().containsKey(_session.getUser().getName())) {
			  builder.append("<span style='font-weight:bold;'>You are currently enrolled in the tournament</span><br/>");
			  builder.append("<input type='submit' value='Unenroll'/>");
			  builder.append("<input type='HIDDEN' name='enroll' value='0'/>");
		  } else if (tournament.getEnrolledPlayers().size() >= tournament.getConfig().getScgCfg().getMaxNumAvatars()){
			  builder.append("<span style='font-weight:bold;'>The tournament is full</span><br/>");
			  builder.append("<input disabled type='submit' value='Enroll'/>");
		  } else {
			  builder.append("<span style='font-weight:bold;'>Enroll in the tournament by clicking the button below</span><br/>");
			  builder.append("<input type='submit' value='Enroll'/>");
			  builder.append("<input type='HIDDEN' name='enroll' value='1'/>");
		  }
		  
		  builder.append("</form></div>");
	  } else {
		  builder.append("<div>");
		  
		  builder.append("The tournament is no longer allowing enrollment changes.<br/>");
		  if (tournament.getEnrolledPlayers().containsKey(_session.getUser().getName())) {
			  builder.append("<span style='font-weight:bold;'>You are currently enrolled in the tournament</span><br/>");
		  } else {
			  builder.append("<span style='font-weight:bold;'>You are not enrolled in the current tournament</span><br/>");
		  }
		  
		  builder.append("</div>");
	  }
  }
  
  private void buildTournamentStatusSection(StringBuilder builder, TournamentSetup tournament){
	  builder.append("<div style='float:left;'>");
	  builder.append("<span style='font-weight:bold;'>Player Scores</span><br/>");
	  builder.append("<table>");
	  builder.append("<tr style='font-weight:bold;'><td>Player</td><td>Score</td></tr>");
	  
	  scg.tournament.TournamentStatus status = tournament.getTournament().getTournamentStatus();
	  ArrayList<PlayerStatus> sorted = new ArrayList<PlayerStatus>(status.getRegisteredPlayers());
	  Collections.sort(sorted);
	  for(scg.tournament.PlayerStatus ps : sorted){
		  builder.append("<tr><td>");
		  builder.append(ps.getName() + "</td><td>" + ps.getScore() + "</td>");
		  builder.append("</td>");
	  }
	  
	  builder.append("</table>");
	  builder.append("</div>");
	  
	  builder.append("<div>");
	  builder.append("<span style='font-weight:bold;'>Active Games</span><br/>");
	  builder.append("<table>");
	  builder.append("<tr style='font-weight:bold;'><td>Round</td><td>Player 1</td><td>Player 2</td></tr>");
	  
	  for(ActiveGame ag : status.getActiveGames()){
		  builder.append("<tr><td>");
		  builder.append(ag.getRound() + "</td>");
		  builder.append("<td>" + ag.getP1().getName() + " (" + ag.getP1().getScore() + ")</td>");
		  builder.append("<td>" + ag.getP2().getName() + " (" + ag.getP2().getScore() + ")</td>");
		  builder.append("</tr>");
	  }
	  
	  builder.append("</table>");
	  builder.append("</div>");
  }
  
  private void buildFinishedtournamentStatusSection(StringBuilder builder, TournamentSetup tournament){
	  builder.append("<div style='float:left;'>");
	  builder.append("<span style='font-weight:bold;'>Player Scores</span><br/>");
	  builder.append("<table>");
	  builder.append("<tr style='font-weight:bold;'><td>Player</td><td>Score</td></tr>");
	  
    ArrayList<Map.Entry<String, Double>> scores = new ArrayList<Map.Entry<String, Double>>(
        tournament.getSerializedSetup().getFinalTournamentScores().entrySet());
    Collections.sort(scores, new Comparator<Map.Entry<String, Double>>() {
      public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
        return Double.compare(o2.getValue(), o1.getValue());
      }
    });
	  for(Map.Entry<String, Double> score : scores){
		  builder.append("<tr><td>");
		  builder.append(score.getKey() + "</td><td>" + score.getValue().toString() + "</td>");
		  builder.append("</td>");
	  }
	  
	  builder.append("</table>");
	  builder.append("</div>");
  }
  
  private void buildTournamentHistorySection(StringBuilder builder, TournamentSetup tournament){
	  builder.append("<div>");

	  builder.append("<span style='font-weight:bold;'>Game History</span><br/>");
	  
	  builder.append("<table>");
	  for (String fileName : getHistoryFileNames(tournament)){
		  builder.append("<tr><td>" + fileName + "</td>");
		  builder.append("<td>(");
		  builder.append(link(redirectURL(TournamentResource.PATH) + "?" + RESOURCE_REQUEST + "=" 
				  + RAW_HISTORY_RESOURCE_REQUEST + "&" + SESSION + "=" + _session.getKey() + "&"
				  + TOURNAMENT_ID + "=" + tournament_id + "&" + HISTORY_RESOURCE_REQUEST_FILE + "=" 
				  + fileName, "raw"));
		  builder.append(")</td><td>(");
		  builder.append(link(redirectURL(TournamentResource.PATH) + "?" + RESOURCE_REQUEST + "=" 
				  + SMART_HISTORY_RESOURCE_REQUEST + "&" + SESSION + "=" + _session.getKey() + "&"
				  + TOURNAMENT_ID + "=" + tournament_id + "&" + HISTORY_RESOURCE_REQUEST_FILE + "=" 
				  + fileName, "smart"));
		  builder.append(")</td></tr>");
	  }  

	  builder.append("</table>");
	  builder.append("</div>");
  }
  
  private ArrayList<String> getHistoryFileNames(TournamentSetup tournament){
	  try{
		  File historyDir = new File(Constants.MAIN_HISTORY_FOLDER + "/" + Constants.RAW_HISTORY_FOLDER + "/" + tournament.getTournamentId());
		  if (!historyDir.exists()){
			  historyDir = new File("bin/" + historyDir);
		  }
		  ArrayList<String> fileNames = new ArrayList<String>();
		  for (File file : historyDir.listFiles()){
			  fileNames.add(file.getName());
		  }
		  
		  return fileNames;
	  }catch(Exception ex){
		  System.err.println("Error getting history files for tournament " + tournament.getTournamentId() + ": " + ex.getMessage());
	  }

	  return new ArrayList<String>();
	  
  }
}
