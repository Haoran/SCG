// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Refuting */
public class Refuting extends OpposeAction{

    /** Construct a(n) Refuting Instance */
    public Refuting(){
    }
    /** Is the given object Equal to this Refuting? */
    public boolean equals(Object o){
        if(!(o instanceof Refuting))return false;
        if(o == this)return true;
        Refuting oo = (Refuting)o;
        return true;
    }
    /** Parse an instance of Refuting from the given String */
    public static Refuting parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Refuting();
    }
    /** Parse an instance of Refuting from the given Stream */
    public static Refuting parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Refuting();
    }
    /** Parse an instance of Refuting from the given Reader */
    public static Refuting parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Refuting();
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


