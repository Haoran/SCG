// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import java.io.Serializable;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Config */
public class Config implements Serializable{
    protected SCGConfig scgCfg;
    transient protected RWrap<DomainConfigI> domainConfigWrapper;

    /** Construct a(n) Config Instance */
    public Config(SCGConfig scgCfg, RWrap<DomainConfigI> domainConfigWrapper){
        this.scgCfg = scgCfg;
        this.domainConfigWrapper = domainConfigWrapper;
    }
    /** Is the given object Equal to this Config? */
    public boolean equals(Object o){
        if(!(o instanceof Config))return false;
        if(o == this)return true;
        Config oo = (Config)o;
        return (((Object)scgCfg).equals(oo.scgCfg))&&(((Object)domainConfigWrapper).equals(oo.domainConfigWrapper));
    }
    /** Parse an instance of Config from the given String */
    public static Config parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Config();
    }
    /** Parse an instance of Config from the given Stream */
    public static Config parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Config();
    }
    /** Parse an instance of Config from the given Reader */
    public static Config parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Config();
    }

    /** Field Class for Config.scgCfg */
    public static class scgCfg extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Config.domainConfigWrapper */
    public static class domainConfigWrapper extends edu.neu.ccs.demeterf.Fields.any{}
 
	public Config(SCGConfig scgConfig, DomainConfigI domainConfig){
		this(scgConfig, new RWrap(domainConfig));
	}
	
	public DomainConfigI getDomainConfig(){
		return getDomainConfigWrapper().getWrapee();
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
    /** Setter for field Config.scgCfg */
    public void setScgCfg(SCGConfig _scgCfg){ scgCfg = _scgCfg; }
    /** Setter for field Config.domainConfigWrapper */
    public void setDomainConfigWrapper(RWrap<DomainConfigI> _domainConfigWrapper){ domainConfigWrapper = _domainConfigWrapper; }
    /** Getter for field Config.scgCfg */
    public SCGConfig getScgCfg(){ return scgCfg; }
    /** Getter for field Config.domainConfigWrapper */
    public RWrap<DomainConfigI> getDomainConfigWrapper(){ return domainConfigWrapper; }

}


