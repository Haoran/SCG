// ** This file was generated with DemFGen (vers:4/15/2011)

package mmg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.*;





/** Representation of MMGInstance */
public class MMGInstance implements InstanceI{
    protected final double x;

    /** Construct a(n) MMGInstance Instance */
    public MMGInstance(double x){
        this.x = x;
    }
    /** Is the given object Equal to this MMGInstance? */
    public boolean equals(Object o){
        if(!(o instanceof MMGInstance))return false;
        if(o == this)return true;
        MMGInstance oo = (MMGInstance)o;
        return (((Object)x).equals(oo.x));
    }
    /** Parse an instance of MMGInstance from the given String */
    public static MMGInstance parse(String inpt) throws mmg.ParseException{
        return new mmg.TheParser(new java.io.StringReader(inpt)).parse_MMGInstance();
    }
    /** Parse an instance of MMGInstance from the given Stream */
    public static MMGInstance parse(java.io.InputStream inpt) throws mmg.ParseException{
        return new mmg.TheParser(inpt).parse_MMGInstance();
    }
    /** Parse an instance of MMGInstance from the given Reader */
    public static MMGInstance parse(java.io.Reader inpt) throws mmg.ParseException{
        return new mmg.TheParser(inpt).parse_MMGInstance();
    }

    /** Field Class for MMGInstance.x */
    public static class x extends edu.neu.ccs.demeterf.Fields.any{}
 
	public double quality(SolutionI solution) {
		MMGSolution mmgSolution = (MMGSolution) solution;
		double y = mmgSolution.y;
		double c =  x*y+(1-x)*(1-y*y);
		return c;
	}
    
	public boolean valid(SolutionI solution, Config config) {
		MMGSolution mmgSolution = (MMGSolution) solution;
		double y = mmgSolution.y;
		// double c = x*y+(1-x)*(1-y*y);
		
		// Is C between 0 and 1
		// boolean isValidC = c>=0 && c<=1;		
		boolean isValid =  y>=0 && y<=1;
		
		
		if(isValid)
			return true;
		else 
			return false;
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
    /** Getter for field MMGInstance.x */
    public double getX(){ return x; }

}


