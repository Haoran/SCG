// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Request */
public class Request{
    protected List<Claim> forbidden;
    protected List<Claim> claimsToOppose;
    protected List<ProtocolRequest> protocolRequests;

    /** Construct a(n) Request Instance */
    public Request(List<Claim> forbidden, List<Claim> claimsToOppose, List<ProtocolRequest> protocolRequests){
        this.forbidden = forbidden;
        this.claimsToOppose = claimsToOppose;
        this.protocolRequests = protocolRequests;
    }
    /** Is the given object Equal to this Request? */
    public boolean equals(Object o){
        if(!(o instanceof Request))return false;
        if(o == this)return true;
        Request oo = (Request)o;
        return (((Object)forbidden).equals(oo.forbidden))&&(((Object)claimsToOppose).equals(oo.claimsToOppose))&&(((Object)protocolRequests).equals(oo.protocolRequests));
    }
    /** Parse an instance of Request from the given String */
    public static Request parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Request();
    }
    /** Parse an instance of Request from the given Stream */
    public static Request parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Request();
    }
    /** Parse an instance of Request from the given Reader */
    public static Request parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Request();
    }

    /** Field Class for Request.forbidden */
    public static class forbidden extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Request.claimsToOppose */
    public static class claimsToOppose extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Request.protocolRequests */
    public static class protocolRequests extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field Request.forbidden */
    public void setForbidden(List<Claim> _forbidden){ forbidden = _forbidden; }
    /** Setter for field Request.claimsToOppose */
    public void setClaimsToOppose(List<Claim> _claimsToOppose){ claimsToOppose = _claimsToOppose; }
    /** Setter for field Request.protocolRequests */
    public void setProtocolRequests(List<ProtocolRequest> _protocolRequests){ protocolRequests = _protocolRequests; }
    /** Getter for field Request.forbidden */
    public List<Claim> getForbidden(){ return forbidden; }
    /** Getter for field Request.claimsToOppose */
    public List<Claim> getClaimsToOppose(){ return claimsToOppose; }
    /** Getter for field Request.protocolRequests */
    public List<ProtocolRequest> getProtocolRequests(){ return protocolRequests; }

}


