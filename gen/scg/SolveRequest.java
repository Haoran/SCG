// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of SolveRequest */
public class SolveRequest extends ProtocolRequest{
    protected RWrap<InstanceI> instanceWrapper;
    protected Option<Claim> claim;

    /** Construct a(n) SolveRequest Instance */
    public SolveRequest(RWrap<InstanceI> instanceWrapper, Option<Claim> claim){
        this.instanceWrapper = instanceWrapper;
        this.claim = claim;
    }
    /** Is the given object Equal to this SolveRequest? */
    public boolean equals(Object o){
        if(!(o instanceof SolveRequest))return false;
        if(o == this)return true;
        SolveRequest oo = (SolveRequest)o;
        return (((Object)instanceWrapper).equals(oo.instanceWrapper))&&(((Object)claim).equals(oo.claim));
    }
    /** Parse an instance of SolveRequest from the given String */
    public static SolveRequest parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_SolveRequest();
    }
    /** Parse an instance of SolveRequest from the given Stream */
    public static SolveRequest parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SolveRequest();
    }
    /** Parse an instance of SolveRequest from the given Reader */
    public static SolveRequest parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SolveRequest();
    }

    /** Field Class for SolveRequest.instanceWrapper */
    public static class instanceWrapper extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SolveRequest.claim */
    public static class claim extends edu.neu.ccs.demeterf.Fields.any{}
 
	public SolveRequest(InstanceI instance, Option<Claim> claim){
		this(new RWrap(instance), claim);
	}
	
	public InstanceI getInstance(){
		return getInstanceWrapper().getWrapee();
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
    /** Setter for field SolveRequest.instanceWrapper */
    public void setInstanceWrapper(RWrap<InstanceI> _instanceWrapper){ instanceWrapper = _instanceWrapper; }
    /** Setter for field SolveRequest.claim */
    public void setClaim(Option<Claim> _claim){ claim = _claim; }
    /** Getter for field SolveRequest.instanceWrapper */
    public RWrap<InstanceI> getInstanceWrapper(){ return instanceWrapper; }
    /** Getter for field SolveRequest.claim */
    public Option<Claim> getClaim(){ return claim; }

}


