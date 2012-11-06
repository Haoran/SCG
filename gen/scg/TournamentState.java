// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of TournamentState */
public class TournamentState extends Command{

    /** Construct a(n) TournamentState Instance */
    public TournamentState(){
    }
    /** Is the given object Equal to this TournamentState? */
    public boolean equals(Object o){
        if(!(o instanceof TournamentState))return false;
        if(o == this)return true;
        TournamentState oo = (TournamentState)o;
        return true;
    }
    /** Parse an instance of TournamentState from the given String */
    public static TournamentState parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_TournamentState();
    }
    /** Parse an instance of TournamentState from the given Stream */
    public static TournamentState parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_TournamentState();
    }
    /** Parse an instance of TournamentState from the given Reader */
    public static TournamentState parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_TournamentState();
    }


    public String getFormat() {
        return "tournament_state";
    }

    /** DGP method from Class Display */
    public String display(){ return scg.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return scg.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return scg.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return scg.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return scg.HashCode.HashCodeM(this); }

}


