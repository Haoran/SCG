// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of DSEOI */
public class DSEOI extends DSLOI{

    /** Construct a(n) DSEOI Instance */
    public DSEOI(){
    }
    /** Is the given object Equal to this DSEOI? */
    public boolean equals(Object o){
        if(!(o instanceof DSEOI))return false;
        if(o == this)return true;
        DSEOI oo = (DSEOI)o;
        return true;
    }
    /** Parse an instance of DSEOI from the given String */
    public static DSEOI parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_DSEOI();
    }
    /** Parse an instance of DSEOI from the given Stream */
    public static DSEOI parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_DSEOI();
    }
    /** Parse an instance of DSEOI from the given Reader */
    public static DSEOI parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_DSEOI();
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


