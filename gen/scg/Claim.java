// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Claim */
public class Claim{
	transient protected RWrap<InstanceSetI> instanceSetWrapper;
	transient protected RWrap<ProtocolI> protocolWrapper;
    protected double quality;
    protected double confidence;

    /** Construct a(n) Claim Instance */
    public Claim(RWrap<InstanceSetI> instanceSetWrapper, RWrap<ProtocolI> protocolWrapper, double quality, double confidence){
        this.instanceSetWrapper = instanceSetWrapper;
        this.protocolWrapper = protocolWrapper;
        this.quality = quality;
        this.confidence = confidence;
    }
    /** Is the given object Equal to this Claim? */
    public boolean equals(Object o){
        if(!(o instanceof Claim))return false;
        if(o == this)return true;
        Claim oo = (Claim)o;
        return (((Object)instanceSetWrapper).equals(oo.instanceSetWrapper))&&(((Object)protocolWrapper).equals(oo.protocolWrapper))&&(((Object)quality).equals(oo.quality))&&(((Object)confidence).equals(oo.confidence));
    }
    /** Parse an instance of Claim from the given String */
    public static Claim parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Claim();
    }
    /** Parse an instance of Claim from the given Stream */
    public static Claim parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Claim();
    }
    /** Parse an instance of Claim from the given Reader */
    public static Claim parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Claim();
    }

    /** Field Class for Claim.instanceSetWrapper */
    public static class instanceSetWrapper extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Claim.protocolWrapper */
    public static class protocolWrapper extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Claim.quality */
    public static class quality extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Claim.confidence */
    public static class confidence extends edu.neu.ccs.demeterf.Fields.any{}
 
	public Claim(InstanceSetI instanceSet, ProtocolI protocol, double quality, double confidence){
		this(new RWrap(instanceSet), new RWrap(protocol), quality, confidence);
	}
	
	public ProtocolI getProtocol(){
		return getProtocolWrapper().getWrapee();
	}
	
	public InstanceSetI getInstanceSet(){
		return getInstanceSetWrapper().getWrapee();	
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
    /** Setter for field Claim.instanceSetWrapper */
    public void setInstanceSetWrapper(RWrap<InstanceSetI> _instanceSetWrapper){ instanceSetWrapper = _instanceSetWrapper; }
    /** Setter for field Claim.protocolWrapper */
    public void setProtocolWrapper(RWrap<ProtocolI> _protocolWrapper){ protocolWrapper = _protocolWrapper; }
    /** Setter for field Claim.quality */
    public void setQuality(double _quality){ quality = _quality; }
    /** Setter for field Claim.confidence */
    public void setConfidence(double _confidence){ confidence = _confidence; }
    /** Getter for field Claim.instanceSetWrapper */
    public RWrap<InstanceSetI> getInstanceSetWrapper(){ return instanceSetWrapper; }
    /** Getter for field Claim.protocolWrapper */
    public RWrap<ProtocolI> getProtocolWrapper(){ return protocolWrapper; }
    /** Getter for field Claim.quality */
    public double getQuality(){ return quality; }
    /** Getter for field Claim.confidence */
    public double getConfidence(){ return confidence; }

}


