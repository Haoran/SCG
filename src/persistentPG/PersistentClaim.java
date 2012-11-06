// ** This file was generated with DemFGen (vers:4/15/2011)

package persistentPG;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.*;
import scg.game.GamePlayer;
import scg.net.PasswordEntry;
import scg.net.PasswordFile;
import scg.net.PlayerSpec;
import scg.net.PlayersFile;
import scg.net.TeamFile;
import scg.net.TeamSpec;





/** Representation of PersistentClaim */
public class PersistentClaim{
    protected Claim claim;
    protected ident PlayerID;
    protected List<RefutationEvent> refutationEvents;

    /** Construct a(n) PersistentClaim Instance */
    public PersistentClaim(Claim claim, ident PlayerID, List<RefutationEvent> refutationEvents){
        this.claim = claim;
        this.PlayerID = PlayerID;
        this.refutationEvents = refutationEvents;
    }
    
    public int getRefutationLength(){
    	return refutationEvents.length();
    }
    
    
    public RefutationEvent getRefutationEvent(int i){
    	return getRefutationEvents().lookup(i);
    }
    
    public boolean refutationEventResult(RefutationEvent e){
    	return e.successful;
    }
    
    public double getClaimQuality(){
    	return claim.getQuality();
    }
    
    public RefutationEvent getIndexRefutationEvent(int i){
    	return refutationEvents.lookup(i);
    }
    
    /** Is the given object Equal to this PersistentClaim? */
    public boolean equals(Object o){
        if(!(o instanceof PersistentClaim))return false;
        if(o == this)return true;
        PersistentClaim oo = (PersistentClaim)o;
        return (((Object)claim).equals(oo.claim))&&(((Object)PlayerID).equals(oo.PlayerID))&&(((Object)refutationEvents).equals(oo.refutationEvents));
    }
    /** Parse an instance of PersistentClaim from the given String */
    public static PersistentClaim parse(String inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(new java.io.StringReader(inpt)).parse_PersistentClaim();
    }
    /** Parse an instance of PersistentClaim from the given Stream */
    public static PersistentClaim parse(java.io.InputStream inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(inpt).parse_PersistentClaim();
    }
    /** Parse an instance of PersistentClaim from the given Reader */
    public static PersistentClaim parse(java.io.Reader inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(inpt).parse_PersistentClaim();
    }

    /** Field Class for PersistentClaim.claim */
    public static class claim extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for PersistentClaim.PlayerID */
    public static class PlayerID extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for PersistentClaim.refutationEvents */
    public static class refutationEvents extends edu.neu.ccs.demeterf.Fields.any{}


    /** DGP method from Class Display */
    public String display(){ return persistentPG.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return persistentPG.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return persistentPG.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return persistentPG.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return persistentPG.HashCode.HashCodeM(this); }
    /** Setter for field PersistentClaim.claim */
    public void setClaim(Claim _claim){ claim = _claim; }
    /** Setter for field PersistentClaim.PlayerID */
    public void setPlayerID(ident _PlayerID){ PlayerID = _PlayerID; }
    /** Setter for field PersistentClaim.refutationEvents */
    public void setRefutationEvents(List<RefutationEvent> _refutationEvents){ refutationEvents = _refutationEvents; }
    /** Getter for field PersistentClaim.claim */
    public Claim getClaim(){ return claim; }
    /** Getter for field PersistentClaim.PlayerID */
    public ident getPlayerID(){ return PlayerID; }
    /** Getter for field PersistentClaim.refutationEvents */
    public List<RefutationEvent> getRefutationEvents(){ return refutationEvents; }

}


