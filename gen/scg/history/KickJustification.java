// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.history;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import scg.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.net.admin.RemotePlayerProxy;





/** Representation of KickJustification */
public class KickJustification extends Reply{
    protected verbatim reason;

    /** Construct a(n) KickJustification Instance */
    public KickJustification(verbatim reason){
        this.reason = reason;
    }
    /** Is the given object Equal to this KickJustification? */
    public boolean equals(Object o){
        if(!(o instanceof KickJustification))return false;
        if(o == this)return true;
        KickJustification oo = (KickJustification)o;
        return (((Object)reason).equals(oo.reason));
    }
    /** Parse an instance of KickJustification from the given String */
    public static KickJustification parse(String inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(new java.io.StringReader(inpt)).parse_KickJustification();
    }
    /** Parse an instance of KickJustification from the given Stream */
    public static KickJustification parse(java.io.InputStream inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_KickJustification();
    }
    /** Parse an instance of KickJustification from the given Reader */
    public static KickJustification parse(java.io.Reader inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_KickJustification();
    }

    /** Field Class for KickJustification.reason */
    public static class reason extends edu.neu.ccs.demeterf.Fields.any{}

    /** DGP method from Class Display */
    public String display(){ return scg.history.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return scg.history.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return scg.history.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return scg.history.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return scg.history.HashCode.HashCodeM(this); }
    /** Setter for field KickJustification.reason */
    public void setReason(verbatim _reason){ reason = _reason; }
    /** Getter for field KickJustification.reason */
    public verbatim getReason(){ return reason; }

}


