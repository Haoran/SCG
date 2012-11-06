// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.history;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import scg.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.net.admin.RemotePlayerProxy;





/** Representation of SmartHistory */
public class SmartHistory{
    protected List<ClaimWithResponse> loc;
    protected verbatim player1;
    protected double player1Score;
    protected verbatim player2;
    protected double player2Score;

    /** Construct a(n) SmartHistory Instance */
    public SmartHistory(List<ClaimWithResponse> loc, verbatim player1, double player1Score, verbatim player2, double player2Score){
        this.loc = loc;
        this.player1 = player1;
        this.player1Score = player1Score;
        this.player2 = player2;
        this.player2Score = player2Score;
    }
    /** Is the given object Equal to this SmartHistory? */
    public boolean equals(Object o){
        if(!(o instanceof SmartHistory))return false;
        if(o == this)return true;
        SmartHistory oo = (SmartHistory)o;
        return (((Object)loc).equals(oo.loc))&&(((Object)player1).equals(oo.player1))&&(((Object)player1Score).equals(oo.player1Score))&&(((Object)player2).equals(oo.player2))&&(((Object)player2Score).equals(oo.player2Score));
    }
    /** Parse an instance of SmartHistory from the given String */
    public static SmartHistory parse(String inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(new java.io.StringReader(inpt)).parse_SmartHistory();
    }
    /** Parse an instance of SmartHistory from the given Stream */
    public static SmartHistory parse(java.io.InputStream inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_SmartHistory();
    }
    /** Parse an instance of SmartHistory from the given Reader */
    public static SmartHistory parse(java.io.Reader inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_SmartHistory();
    }

    /** Field Class for SmartHistory.loc */
    public static class loc extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SmartHistory.player1 */
    public static class player1 extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SmartHistory.player1Score */
    public static class player1Score extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SmartHistory.player2 */
    public static class player2 extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SmartHistory.player2Score */
    public static class player2Score extends edu.neu.ccs.demeterf.Fields.any{}

	/**
	 * To creates a ClaimWithResponse object for a new claim opposed.
	 * @param avatar : avatar who opposed the claim
	 * @param claim : Claim opposed
	 * @param opposeAction : action taken by avatar
	 */
	public void createClaimWithResponse(java.util.HashMap<Claim,Claim> newClaimOriginalClaim, RemotePlayerProxy avatar, Claim claim, OpposeAction opposeAction){
		ClaimWithResponse claimWithResponse = new ClaimWithResponse(claim, new verbatim(avatar.getOpponent().getName()), 
				new verbatim(avatar.getName()), opposeAction, List.<AnnotatedResponse>create(), new verbatim(""), 0.0);
		//List<ClaimWithResponse> loc = getLoc();
		loc = loc.append(claimWithResponse);
		newClaimOriginalClaim.put(claim, claim);
		//smartHistory.setLoc(loc);
	}

	/**
	 * Updates the ClaimWithResponse object for previously opposed claim
	 * @param claim : claim for which the ClaimWithResponse object is to be updated
	 * @param response : response that is to be added in the ClaimWithResponse object
	 * @param avatar : avatar whose opponent sent the response.
	 */
	public void updateClaimWithResponse(java.util.HashMap<Claim,Claim> newClaimOriginalClaim, Claim claim, ProtocolResponse response, RemotePlayerProxy avatar){
		if (newClaimOriginalClaim.containsKey(claim)){
			claim.getInstanceSet().toString();
			Claim originalClaim = newClaimOriginalClaim.get(claim);
			for(ClaimWithResponse claimWithResponse : loc){
				if(claimWithResponse.getClaim().equals(originalClaim)){
					AnnotatedResponse aResponse = new AnnotatedResponse(new verbatim(avatar.getOpponent().getName()), response);
					List<AnnotatedResponse> responses = claimWithResponse.getResponses();
					responses = responses.append(aResponse);
					claimWithResponse.setResponses(responses);
				}
			}
		}else{
			System.out.println("debug");
		}
	}
	
	/**
	 * Called once the protocol for the particular claim is complete.
	 * @param claim : Claim whose ClaimWithResponse object is complete.
	 * @param winner : teamName that won the claim
	 * @param pointsWon : points won in the claim
	 */
	public void endClaimWithResponse(java.util.HashMap<Claim,Claim> newClaimOriginalClaim, Claim claim, String winner, double pointsWon){
		if (newClaimOriginalClaim.containsKey(claim)){
			Claim originalClaim = newClaimOriginalClaim.get(claim);
			for(ClaimWithResponse claimWithResponse : loc){
				if(claimWithResponse.getClaim().equals(originalClaim)){
					claimWithResponse.setWinner(new verbatim(winner));
					claimWithResponse.setPointsWon(pointsWon);
				}
			}
			//newClaimOriginalClaim.remove(claim);
		}
	}

	/**
	 * Generates smart history file for the SmartHistory object populated by start method above.
	 * @param fileName : Name of the smart history file
	 * @throws IOException : If file could not be created.
	 */
	public void generateSmartHistoryFile(RemotePlayerProxy alice, RemotePlayerProxy bob, String tournamentId, String fileName) throws IOException{
		try {
			Util.createFolder("", Constants.HISTORY_FILE_PREFIX);
	        Util.createFolder(Constants.HISTORY_FILE_PREFIX, Constants.SMART_HISTORY_FOLDER);
	        Util.createFolder(Constants.HISTORY_FILE_PREFIX+"/"+Constants.SMART_HISTORY_FOLDER, tournamentId);
	        
			String historyFileName = Constants.HISTORY_FILE_PREFIX+"/"+Constants.SMART_HISTORY_FOLDER+
				"/"+tournamentId+"/"+fileName + Constants.HISTORY_FILE_SUFFIX;
			File smartHistoryFile = new File(historyFileName);
			FileWriter writer = new FileWriter(smartHistoryFile);
			writer.write(this.toString());
			writer.flush();
			//writer.write(alice.getName() + " : " + alice.getReputation() + "\n");
			//writer.write(bob.getName() + " : " + bob.getReputation());
			//writer.flush();
	        writer.close();
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

    /** DGP method from Class Display */
    public String display(){ return scg.history.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return scg.history.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return scg.history.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return scg.history.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return scg.history.HashCode.HashCodeM(this); }
    /** Setter for field SmartHistory.loc */
    public void setLoc(List<ClaimWithResponse> _loc){ loc = _loc; }
    /** Setter for field SmartHistory.player1 */
    public void setPlayer1(verbatim _player1){ player1 = _player1; }
    /** Setter for field SmartHistory.player1Score */
    public void setPlayer1Score(double _player1Score){ player1Score = _player1Score; }
    /** Setter for field SmartHistory.player2 */
    public void setPlayer2(verbatim _player2){ player2 = _player2; }
    /** Setter for field SmartHistory.player2Score */
    public void setPlayer2Score(double _player2Score){ player2Score = _player2Score; }
    /** Getter for field SmartHistory.loc */
    public List<ClaimWithResponse> getLoc(){ return loc; }
    /** Getter for field SmartHistory.player1 */
    public verbatim getPlayer1(){ return player1; }
    /** Getter for field SmartHistory.player1Score */
    public double getPlayer1Score(){ return player1Score; }
    /** Getter for field SmartHistory.player2 */
    public verbatim getPlayer2(){ return player2; }
    /** Getter for field SmartHistory.player2Score */
    public double getPlayer2Score(){ return player2Score; }

}


