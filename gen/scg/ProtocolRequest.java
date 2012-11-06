// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of ProtocolRequest */
public abstract class ProtocolRequest{

    /** Construct a(n) ProtocolRequest Instance */
    public ProtocolRequest(){
    }
    /** Parse an instance of ProtocolRequest from the given String */
    public static ProtocolRequest parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_ProtocolRequest();
    }
    /** Parse an instance of ProtocolRequest from the given Stream */
    public static ProtocolRequest parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProtocolRequest();
    }
    /** Parse an instance of ProtocolRequest from the given Reader */
    public static ProtocolRequest parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProtocolRequest();
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


