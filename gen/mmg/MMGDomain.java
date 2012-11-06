// ** This file was generated with DemFGen (vers:4/15/2011)

package mmg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.*;





/** Representation of MMGDomain */
public class MMGDomain implements DomainI{

    /** Construct a(n) MMGDomain Instance */
    public MMGDomain(){
    }
    /** Is the given object Equal to this MMGDomain? */
    public boolean equals(Object o){
        if(!(o instanceof MMGDomain))return false;
        if(o == this)return true;
        MMGDomain oo = (MMGDomain)o;
        return true;
    }
    /** Parse an instance of MMGDomain from the given String */
    public static MMGDomain parse(String inpt) throws mmg.ParseException{
        return new mmg.TheParser(new java.io.StringReader(inpt)).parse_MMGDomain();
    }
    /** Parse an instance of MMGDomain from the given Stream */
    public static MMGDomain parse(java.io.InputStream inpt) throws mmg.ParseException{
        return new mmg.TheParser(inpt).parse_MMGDomain();
    }
    /** Parse an instance of MMGDomain from the given Reader */
    public static MMGDomain parse(java.io.Reader inpt) throws mmg.ParseException{
        return new mmg.TheParser(inpt).parse_MMGDomain();
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


