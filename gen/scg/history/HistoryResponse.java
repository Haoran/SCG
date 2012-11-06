// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.history;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import scg.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.net.admin.RemotePlayerProxy;





/** Representation of HistoryResponse */
public class HistoryResponse extends Reply{
    protected Response response;

    /** Construct a(n) HistoryResponse Instance */
    public HistoryResponse(Response response){
        this.response = response;
    }
    /** Is the given object Equal to this HistoryResponse? */
    public boolean equals(Object o){
        if(!(o instanceof HistoryResponse))return false;
        if(o == this)return true;
        HistoryResponse oo = (HistoryResponse)o;
        return (((Object)response).equals(oo.response));
    }
    /** Parse an instance of HistoryResponse from the given String */
    public static HistoryResponse parse(String inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(new java.io.StringReader(inpt)).parse_HistoryResponse();
    }
    /** Parse an instance of HistoryResponse from the given Stream */
    public static HistoryResponse parse(java.io.InputStream inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_HistoryResponse();
    }
    /** Parse an instance of HistoryResponse from the given Reader */
    public static HistoryResponse parse(java.io.Reader inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_HistoryResponse();
    }

    /** Field Class for HistoryResponse.response */
    public static class response extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field HistoryResponse.response */
    public void setResponse(Response _response){ response = _response; }
    /** Getter for field HistoryResponse.response */
    public Response getResponse(){ return response; }

}


