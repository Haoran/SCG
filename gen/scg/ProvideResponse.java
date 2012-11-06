// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of ProvideResponse */
public class ProvideResponse extends ProtocolResponse{
    protected RWrap<InstanceI> instanceWrapper;

    /** Construct a(n) ProvideResponse Instance */
    public ProvideResponse(RWrap<InstanceI> instanceWrapper){
        this.instanceWrapper = instanceWrapper;
    }
    /** Is the given object Equal to this ProvideResponse? */
    public boolean equals(Object o){
        if(!(o instanceof ProvideResponse))return false;
        if(o == this)return true;
        ProvideResponse oo = (ProvideResponse)o;
        return (((Object)instanceWrapper).equals(oo.instanceWrapper));
    }
    /** Parse an instance of ProvideResponse from the given String */
    public static ProvideResponse parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_ProvideResponse();
    }
    /** Parse an instance of ProvideResponse from the given Stream */
    public static ProvideResponse parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProvideResponse();
    }
    /** Parse an instance of ProvideResponse from the given Reader */
    public static ProvideResponse parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProvideResponse();
    }

    /** Field Class for ProvideResponse.instanceWrapper */
    public static class instanceWrapper extends edu.neu.ccs.demeterf.Fields.any{}

	public ProvideResponse(InstanceI instance){
		this(new RWrap(instance));
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
    /** Setter for field ProvideResponse.instanceWrapper */
    public void setInstanceWrapper(RWrap<InstanceI> _instanceWrapper){ instanceWrapper = _instanceWrapper; }
    /** Getter for field ProvideResponse.instanceWrapper */
    public RWrap<InstanceI> getInstanceWrapper(){ return instanceWrapper; }

}


