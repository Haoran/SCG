// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of FullRoundRobin */
public class FullRoundRobin extends TournamentStyle{

    /** Construct a(n) FullRoundRobin Instance */
    public FullRoundRobin(){
    }
    /** Is the given object Equal to this FullRoundRobin? */
    public boolean equals(Object o){
        if(!(o instanceof FullRoundRobin))return false;
        if(o == this)return true;
        FullRoundRobin oo = (FullRoundRobin)o;
        return true;
    }
    /** Parse an instance of FullRoundRobin from the given String */
    public static FullRoundRobin parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_FullRoundRobin();
    }
    /** Parse an instance of FullRoundRobin from the given Stream */
    public static FullRoundRobin parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_FullRoundRobin();
    }
    /** Parse an instance of FullRoundRobin from the given Reader */
    public static FullRoundRobin parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_FullRoundRobin();
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


