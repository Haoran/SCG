// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of SwissStyleTournament */
public class SwissStyleTournament extends TournamentStyle{

    /** Construct a(n) SwissStyleTournament Instance */
    public SwissStyleTournament(){
    }
    /** Is the given object Equal to this SwissStyleTournament? */
    public boolean equals(Object o){
        if(!(o instanceof SwissStyleTournament))return false;
        if(o == this)return true;
        SwissStyleTournament oo = (SwissStyleTournament)o;
        return true;
    }
    /** Parse an instance of SwissStyleTournament from the given String */
    public static SwissStyleTournament parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_SwissStyleTournament();
    }
    /** Parse an instance of SwissStyleTournament from the given Stream */
    public static SwissStyleTournament parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SwissStyleTournament();
    }
    /** Parse an instance of SwissStyleTournament from the given Reader */
    public static SwissStyleTournament parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SwissStyleTournament();
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


