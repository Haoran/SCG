// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Agreement */
public class Agreement extends OpposeAction{

    /** Construct a(n) Agreement Instance */
    public Agreement(){
    }
    /** Is the given object Equal to this Agreement? */
    public boolean equals(Object o){
        if(!(o instanceof Agreement))return false;
        if(o == this)return true;
        Agreement oo = (Agreement)o;
        return true;
    }
    /** Parse an instance of Agreement from the given String */
    public static Agreement parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Agreement();
    }
    /** Parse an instance of Agreement from the given Stream */
    public static Agreement parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Agreement();
    }
    /** Parse an instance of Agreement from the given Reader */
    public static Agreement parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Agreement();
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


