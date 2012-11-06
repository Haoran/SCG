// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of ProvideRequest */
public class ProvideRequest extends ProtocolRequest{
    protected Claim claimToBeProvided;

    /** Construct a(n) ProvideRequest Instance */
    public ProvideRequest(Claim claimToBeProvided){
        this.claimToBeProvided = claimToBeProvided;
    }
    /** Is the given object Equal to this ProvideRequest? */
    public boolean equals(Object o){
        if(!(o instanceof ProvideRequest))return false;
        if(o == this)return true;
        ProvideRequest oo = (ProvideRequest)o;
        return (((Object)claimToBeProvided).equals(oo.claimToBeProvided));
    }
    /** Parse an instance of ProvideRequest from the given String */
    public static ProvideRequest parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_ProvideRequest();
    }
    /** Parse an instance of ProvideRequest from the given Stream */
    public static ProvideRequest parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProvideRequest();
    }
    /** Parse an instance of ProvideRequest from the given Reader */
    public static ProvideRequest parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProvideRequest();
    }

    /** Field Class for ProvideRequest.claimToBeProvided */
    public static class claimToBeProvided extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field ProvideRequest.claimToBeProvided */
    public void setClaimToBeProvided(Claim _claimToBeProvided){ claimToBeProvided = _claimToBeProvided; }
    /** Getter for field ProvideRequest.claimToBeProvided */
    public Claim getClaimToBeProvided(){ return claimToBeProvided; }

}


