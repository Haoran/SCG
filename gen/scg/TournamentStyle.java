// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of TournamentStyle */
public abstract class TournamentStyle{

    /** Construct a(n) TournamentStyle Instance */
    public TournamentStyle(){
    }
    /** Parse an instance of TournamentStyle from the given String */
    public static TournamentStyle parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_TournamentStyle();
    }
    /** Parse an instance of TournamentStyle from the given Stream */
    public static TournamentStyle parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_TournamentStyle();
    }
    /** Parse an instance of TournamentStyle from the given Reader */
    public static TournamentStyle parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_TournamentStyle();
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


