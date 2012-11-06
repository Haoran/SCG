package scg.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import scg.Constants;
import scg.HTML;
import scg.exception.MissingArgumentException;
import scg.tournament.TournamentManager;
import scg.tournament.TournamentSetup;
import scg.tournament.Users;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;

public class TournamentResource extends WebPage {

	private int tournament_id;
	public final static String PATH = "/tournament_details";

  public TournamentResource(TournamentManager manager, Users users, HTTPReq request) {
	  
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
    
    try{
    	StringBuilder builder = new StringBuilder();
    	
    	try {
    	  value = getArgument(_urlArgs, RESOURCE_REQUEST);
        if (value.equals(CONFIG_RESOURCE_REQUEST)) {
          builder.append(tournament.getConfig().print());
        } else if (value.equals(AVATAR_RESOURCE_REQUEST)) {
          //TODO:Avatar request needs to be implemented
          builder.append("Avatar request needs to be implemented");
        } else if (value.equals(RAW_HISTORY_RESOURCE_REQUEST)){
        	String fileName = getArgument(_urlArgs, HISTORY_RESOURCE_REQUEST_FILE);
        	builder.append(getFileContents(Constants.MAIN_HISTORY_FOLDER + "/" + Constants.RAW_HISTORY_FOLDER + "/" + tournament.getTournamentId() + "/" + fileName));
        } else if (value.equals(SMART_HISTORY_RESOURCE_REQUEST)){
        	String fileName = getArgument(_urlArgs, HISTORY_RESOURCE_REQUEST_FILE);
        	builder.append(getFileContents(Constants.MAIN_HISTORY_FOLDER + "/" + Constants.SMART_HISTORY_FOLDER + "/" + tournament.getTournamentId() + "/" + fileName));
        }
          //builder.append("Invalid resource request.");
    	} catch (MissingArgumentException e) {
        builder.append(e.getMessage());
      }
    	
    	return HTML.okTextResp(builder.toString());
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
    
    private String getFileContents(String path){
    	try {
    		
	    	File f = new File(path);
	    	StringBuilder contents = new StringBuilder();
	    	if (!f.exists()){
	    		f = new File("bin/" + path);
	    	}
	    	if (f.exists()){
	    		BufferedReader input =  new BufferedReader(new FileReader(f));
	    		String line = null;
	    		while (( line = input.readLine()) != null){
	    	          contents.append(line);
	    	          contents.append(System.getProperty("line.separator"));
	    	        }
	    		input.close();
	    		return contents.toString();
	    	}
    	} catch (Exception ex) {
    		System.err.println(ex.getMessage());
    	}
    	
    	return "";
    }
}
