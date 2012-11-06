// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.history;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import scg.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.net.admin.RemotePlayerProxy;





/** Representation of AnnotatedResponse */
public class AnnotatedResponse{
    protected verbatim provider;
    protected ProtocolResponse pr;

    /** Construct a(n) AnnotatedResponse Instance */
    public AnnotatedResponse(verbatim provider, ProtocolResponse pr){
        this.provider = provider;
        this.pr = pr;
    }
    /** Is the given object Equal to this AnnotatedResponse? */
    public boolean equals(Object o){
        if(!(o instanceof AnnotatedResponse))return false;
        if(o == this)return true;
        AnnotatedResponse oo = (AnnotatedResponse)o;
        return (((Object)provider).equals(oo.provider))&&(((Object)pr).equals(oo.pr));
    }
    /** Parse an instance of AnnotatedResponse from the given String */
    public static AnnotatedResponse parse(String inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(new java.io.StringReader(inpt)).parse_AnnotatedResponse();
    }
    /** Parse an instance of AnnotatedResponse from the given Stream */
    public static AnnotatedResponse parse(java.io.InputStream inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_AnnotatedResponse();
    }
    /** Parse an instance of AnnotatedResponse from the given Reader */
    public static AnnotatedResponse parse(java.io.Reader inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_AnnotatedResponse();
    }

    /** Field Class for AnnotatedResponse.provider */
    public static class provider extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for AnnotatedResponse.pr */
    public static class pr extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field AnnotatedResponse.provider */
    public void setProvider(verbatim _provider){ provider = _provider; }
    /** Setter for field AnnotatedResponse.pr */
    public void setPr(ProtocolResponse _pr){ pr = _pr; }
    /** Getter for field AnnotatedResponse.provider */
    public verbatim getProvider(){ return provider; }
    /** Getter for field AnnotatedResponse.pr */
    public ProtocolResponse getPr(){ return pr; }

}


