// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Alice */
public class Alice implements Role{

    /** Construct a(n) Alice Instance */
    public Alice(){
    }
    /** Is the given object Equal to this Alice? */
    public boolean equals(Object o){
        if(!(o instanceof Alice))return false;
        if(o == this)return true;
        Alice oo = (Alice)o;
        return true;
    }
    /** Parse an instance of Alice from the given String */
    public static Alice parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Alice();
    }
    /** Parse an instance of Alice from the given Stream */
    public static Alice parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Alice();
    }
    /** Parse an instance of Alice from the given Reader */
    public static Alice parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Alice();
    }

 
  	public int ordingal(){
  		return Role.ALICE;
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

}


