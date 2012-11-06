// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.history;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import scg.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.net.admin.RemotePlayerProxy;





/** Representation of RawHistory */
public class RawHistory{
    protected List<RHEntry> entries;
    protected verbatim player1;
    protected double player1Score;
    protected verbatim player2;
    protected double player2Score;

    /** Construct a(n) RawHistory Instance */
    public RawHistory(List<RHEntry> entries, verbatim player1, double player1Score, verbatim player2, double player2Score){
        this.entries = entries;
        this.player1 = player1;
        this.player1Score = player1Score;
        this.player2 = player2;
        this.player2Score = player2Score;
    }
    /** Is the given object Equal to this RawHistory? */
    public boolean equals(Object o){
        if(!(o instanceof RawHistory))return false;
        if(o == this)return true;
        RawHistory oo = (RawHistory)o;
        return (((Object)entries).equals(oo.entries))&&(((Object)player1).equals(oo.player1))&&(((Object)player1Score).equals(oo.player1Score))&&(((Object)player2).equals(oo.player2))&&(((Object)player2Score).equals(oo.player2Score));
    }
    /** Parse an instance of RawHistory from the given String */
    public static RawHistory parse(String inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(new java.io.StringReader(inpt)).parse_RawHistory();
    }
    /** Parse an instance of RawHistory from the given Stream */
    public static RawHistory parse(java.io.InputStream inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_RawHistory();
    }
    /** Parse an instance of RawHistory from the given Reader */
    public static RawHistory parse(java.io.Reader inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_RawHistory();
    }

    /** Field Class for RawHistory.entries */
    public static class entries extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RawHistory.player1 */
    public static class player1 extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RawHistory.player1Score */
    public static class player1Score extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RawHistory.player2 */
    public static class player2 extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RawHistory.player2Score */
    public static class player2Score extends edu.neu.ccs.demeterf.Fields.any{}

	/**
	 * To record the raw history event in RawHistory Object
	 * @param request : Request sent to the player for this response
	 * @param reply : Response from the player
	 * @param teamName : Player name
	 * @param reputation : reputation of the player
	 */
	public void recordRawHistory(Request request, Reply reply, String teamName, Double reputation ){
		RHEntry entry = new RHEntry(request, reply,new verbatim(teamName), reputation);
		//List<RHEntry> entries = rawHistory.getEntries();
		entries = entries.append(entry);
		//rawHistory.setEntries(entries);
	}
	
	/**
	 * Generates raw history file for the RawHistory object populated by start method above.
	 * @param fileName : Name of the raw history file
	 * @throws IOException : If file could not be created.
	 */
	public void generateRawHistoryFile(RemotePlayerProxy alice, RemotePlayerProxy bob, String tournamentId, String fileName) throws IOException{
		try {			
	        Util.createFolder("", Constants.HISTORY_FILE_PREFIX);
	        Util.createFolder(Constants.HISTORY_FILE_PREFIX, Constants.RAW_HISTORY_FOLDER);
	        Util.createFolder(Constants.HISTORY_FILE_PREFIX+"/"+Constants.RAW_HISTORY_FOLDER, tournamentId);
	        
			String historyFileName = Constants.HISTORY_FILE_PREFIX+"/"+Constants.RAW_HISTORY_FOLDER+
				"/"+tournamentId+"/"+fileName + Constants.HISTORY_FILE_SUFFIX;
			File rawHistoryFile = new File(historyFileName);
			
			FileWriter writer = new FileWriter(rawHistoryFile);
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
    /** Setter for field RawHistory.entries */
    public void setEntries(List<RHEntry> _entries){ entries = _entries; }
    /** Setter for field RawHistory.player1 */
    public void setPlayer1(verbatim _player1){ player1 = _player1; }
    /** Setter for field RawHistory.player1Score */
    public void setPlayer1Score(double _player1Score){ player1Score = _player1Score; }
    /** Setter for field RawHistory.player2 */
    public void setPlayer2(verbatim _player2){ player2 = _player2; }
    /** Setter for field RawHistory.player2Score */
    public void setPlayer2Score(double _player2Score){ player2Score = _player2Score; }
    /** Getter for field RawHistory.entries */
    public List<RHEntry> getEntries(){ return entries; }
    /** Getter for field RawHistory.player1 */
    public verbatim getPlayer1(){ return player1; }
    /** Getter for field RawHistory.player1Score */
    public double getPlayer1Score(){ return player1Score; }
    /** Getter for field RawHistory.player2 */
    public verbatim getPlayer2(){ return player2; }
    /** Getter for field RawHistory.player2Score */
    public double getPlayer2Score(){ return player2Score; }

}


