// ** This file was generated with DemFGen (vers:4/15/2011)

package mmg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.*;





/** Representation of MMGInstanceSet */
public class MMGInstanceSet implements InstanceSetI{

    /** Construct a(n) MMGInstanceSet Instance */
    public MMGInstanceSet(){
    }
    /** Is the given object Equal to this MMGInstanceSet? */
    public boolean equals(Object o){
        if(!(o instanceof MMGInstanceSet))return false;
        if(o == this)return true;
        MMGInstanceSet oo = (MMGInstanceSet)o;
        return true;
    }
    /** Parse an instance of MMGInstanceSet from the given String */
    public static MMGInstanceSet parse(String inpt) throws mmg.ParseException{
        return new mmg.TheParser(new java.io.StringReader(inpt)).parse_MMGInstanceSet();
    }
    /** Parse an instance of MMGInstanceSet from the given Stream */
    public static MMGInstanceSet parse(java.io.InputStream inpt) throws mmg.ParseException{
        return new mmg.TheParser(inpt).parse_MMGInstanceSet();
    }
    /** Parse an instance of MMGInstanceSet from the given Reader */
    public static MMGInstanceSet parse(java.io.Reader inpt) throws mmg.ParseException{
        return new mmg.TheParser(inpt).parse_MMGInstanceSet();
    }

 

	private static MMGInstanceSet instance = new MMGInstanceSet();
	
	public static MMGInstanceSet getInstance() {
		return instance;
	}
		
	public Option<String> belongsTo(InstanceI instance) {
    	MMGInstance mmgInstance = (MMGInstance) instance;
		double x = mmgInstance.x;
		boolean isValid =  x>=0 && x<=1;
		if(isValid)
			return Option.none();
		else 
			return Option.some("x not in [0,1]");
	}

	public Option<String> valid(Config config) {
		return Option.none();
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


