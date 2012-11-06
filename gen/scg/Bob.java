// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Bob */
public class Bob implements Role{

    /** Construct a(n) Bob Instance */
    public Bob(){
    }
    /** Is the given object Equal to this Bob? */
    public boolean equals(Object o){
        if(!(o instanceof Bob))return false;
        if(o == this)return true;
        Bob oo = (Bob)o;
        return true;
    }
    /** Parse an instance of Bob from the given String */
    public static Bob parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Bob();
    }
    /** Parse an instance of Bob from the given Stream */
    public static Bob parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Bob();
    }
    /** Parse an instance of Bob from the given Reader */
    public static Bob parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Bob();
    }

 
  	public int ordingal(){
  		return Role.BOB;
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


