// ** This file was generated with DemFGen (vers:4/15/2011)

package mmg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.*;





/** Representation of MMGConfig */
public class MMGConfig implements DomainConfigI{

    /** Construct a(n) MMGConfig Instance */
    public MMGConfig(){
    }
    /** Is the given object Equal to this MMGConfig? */
    public boolean equals(Object o){
        if(!(o instanceof MMGConfig))return false;
        if(o == this)return true;
        MMGConfig oo = (MMGConfig)o;
        return true;
    }
    /** Parse an instance of MMGConfig from the given String */
    public static MMGConfig parse(String inpt) throws mmg.ParseException{
        return new mmg.TheParser(new java.io.StringReader(inpt)).parse_MMGConfig();
    }
    /** Parse an instance of MMGConfig from the given Stream */
    public static MMGConfig parse(java.io.InputStream inpt) throws mmg.ParseException{
        return new mmg.TheParser(inpt).parse_MMGConfig();
    }
    /** Parse an instance of MMGConfig from the given Reader */
    public static MMGConfig parse(java.io.Reader inpt) throws mmg.ParseException{
        return new mmg.TheParser(inpt).parse_MMGConfig();
    }

 
private static MMGConfig DEFAULT_MMG_CONFIG;
	static{
			try{
			DEFAULT_MMG_CONFIG = MMGConfig.parse( 
				"mmg_config[\n" +
				"]"
			);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
 
	public static MMGConfig getDefaultDomainConfig(){
		return MMGConfig.DEFAULT_MMG_CONFIG;
	}
	
	public static Config getDefaultConfig(){
		return new Config(SCGConfig.getDefaultSCGConfig(), getDefaultDomainConfig());
	}


    /** DGP method from Class Display */
    public String display(){ return mmg.Display.DisplayM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return mmg.HashCode.HashCodeM(this); }
    /** DGP method from Class Print */
    public String print(){ return mmg.Print.PrintM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return mmg.PrintToString.PrintToStringM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return mmg.ToStr.ToStrM(this); }

}


