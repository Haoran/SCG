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





/** Representation of RefutationEvent */
public class RefutationEvent{
    protected boolean successful;
    protected double reputation;

    /** Construct a(n) RefutationEvent Instance */
    public RefutationEvent(boolean successful, double reputation){
        this.successful = successful;
        this.reputation = reputation;
    }
    /** Is the given object Equal to this RefutationEvent? */
    public boolean equals(Object o){
        if(!(o instanceof RefutationEvent))return false;
        if(o == this)return true;
        RefutationEvent oo = (RefutationEvent)o;
        return (((Object)successful).equals(oo.successful))&&(((Object)reputation).equals(oo.reputation));
    }
    /** Parse an instance of RefutationEvent from the given String */
    public static RefutationEvent parse(String inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(new java.io.StringReader(inpt)).parse_RefutationEvent();
    }
    /** Parse an instance of RefutationEvent from the given Stream */
    public static RefutationEvent parse(java.io.InputStream inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(inpt).parse_RefutationEvent();
    }
    /** Parse an instance of RefutationEvent from the given Reader */
    public static RefutationEvent parse(java.io.Reader inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(inpt).parse_RefutationEvent();
    }

    /** Field Class for RefutationEvent.successful */
    public static class successful extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RefutationEvent.reputation */
    public static class reputation extends edu.neu.ccs.demeterf.Fields.any{}


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
    /** Setter for field RefutationEvent.successful */
    public void setSuccessful(boolean _successful){ successful = _successful; }
    /** Setter for field RefutationEvent.reputation */
    public void setReputation(double _reputation){ reputation = _reputation; }
    /** Getter for field RefutationEvent.successful */
    public boolean getSuccessful(){ return successful; }
    /** Getter for field RefutationEvent.reputation */
    public double getReputation(){ return reputation; }

}


