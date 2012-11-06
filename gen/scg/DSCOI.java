// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of DSCOI */
public class DSCOI extends DSLOI{
    protected ident first;
    protected DSLOI rest;

    /** Construct a(n) DSCOI Instance */
    public DSCOI(ident first, DSLOI rest){
        this.first = first;
        this.rest = rest;
    }
    /** Is the given object Equal to this DSCOI? */
    public boolean equals(Object o){
        if(!(o instanceof DSCOI))return false;
        if(o == this)return true;
        DSCOI oo = (DSCOI)o;
        return (((Object)first).equals(oo.first))&&(((Object)rest).equals(oo.rest));
    }
    /** Parse an instance of DSCOI from the given String */
    public static DSCOI parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_DSCOI();
    }
    /** Parse an instance of DSCOI from the given Stream */
    public static DSCOI parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_DSCOI();
    }
    /** Parse an instance of DSCOI from the given Reader */
    public static DSCOI parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_DSCOI();
    }

    /** Field Class for DSCOI.first */
    public static class first extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for DSCOI.rest */
    public static class rest extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field DSCOI.first */
    public void setFirst(ident _first){ first = _first; }
    /** Setter for field DSCOI.rest */
    public void setRest(DSLOI _rest){ rest = _rest; }
    /** Getter for field DSCOI.first */
    public ident getFirst(){ return first; }
    /** Getter for field DSCOI.rest */
    public DSLOI getRest(){ return rest; }

}


