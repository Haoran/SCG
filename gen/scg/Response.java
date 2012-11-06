// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Response */
public class Response{
    protected List<Claim> proposed;
    protected List<OpposeAction> oppositions;
    protected List<ProtocolResponse> protocolResponses;

    /** Construct a(n) Response Instance */
    public Response(List<Claim> proposed, List<OpposeAction> oppositions, List<ProtocolResponse> protocolResponses){
        this.proposed = proposed;
        this.oppositions = oppositions;
        this.protocolResponses = protocolResponses;
    }
    /** Is the given object Equal to this Response? */
    public boolean equals(Object o){
        if(!(o instanceof Response))return false;
        if(o == this)return true;
        Response oo = (Response)o;
        return (((Object)proposed).equals(oo.proposed))&&(((Object)oppositions).equals(oo.oppositions))&&(((Object)protocolResponses).equals(oo.protocolResponses));
    }
    /** Parse an instance of Response from the given String */
    public static Response parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Response();
    }
    /** Parse an instance of Response from the given Stream */
    public static Response parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Response();
    }
    /** Parse an instance of Response from the given Reader */
    public static Response parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Response();
    }

    /** Field Class for Response.proposed */
    public static class proposed extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Response.oppositions */
    public static class oppositions extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Response.protocolResponses */
    public static class protocolResponses extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field Response.proposed */
    public void setProposed(List<Claim> _proposed){ proposed = _proposed; }
    /** Setter for field Response.oppositions */
    public void setOppositions(List<OpposeAction> _oppositions){ oppositions = _oppositions; }
    /** Setter for field Response.protocolResponses */
    public void setProtocolResponses(List<ProtocolResponse> _protocolResponses){ protocolResponses = _protocolResponses; }
    /** Getter for field Response.proposed */
    public List<Claim> getProposed(){ return proposed; }
    /** Getter for field Response.oppositions */
    public List<OpposeAction> getOppositions(){ return oppositions; }
    /** Getter for field Response.protocolResponses */
    public List<ProtocolResponse> getProtocolResponses(){ return protocolResponses; }

}


