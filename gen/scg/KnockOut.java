// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of KnockOut */
public class KnockOut extends TournamentStyle{

    /** Construct a(n) KnockOut Instance */
    public KnockOut(){
    }
    /** Is the given object Equal to this KnockOut? */
    public boolean equals(Object o){
        if(!(o instanceof KnockOut))return false;
        if(o == this)return true;
        KnockOut oo = (KnockOut)o;
        return true;
    }
    /** Parse an instance of KnockOut from the given String */
    public static KnockOut parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_KnockOut();
    }
    /** Parse an instance of KnockOut from the given Stream */
    public static KnockOut parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_KnockOut();
    }
    /** Parse an instance of KnockOut from the given Reader */
    public static KnockOut parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_KnockOut();
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


