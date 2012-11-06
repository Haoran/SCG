// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of ProvideAction */
public class ProvideAction implements Action{

    /** Construct a(n) ProvideAction Instance */
    public ProvideAction(){
    }
    /** Is the given object Equal to this ProvideAction? */
    public boolean equals(Object o){
        if(!(o instanceof ProvideAction))return false;
        if(o == this)return true;
        ProvideAction oo = (ProvideAction)o;
        return true;
    }
    /** Parse an instance of ProvideAction from the given String */
    public static ProvideAction parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_ProvideAction();
    }
    /** Parse an instance of ProvideAction from the given Stream */
    public static ProvideAction parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProvideAction();
    }
    /** Parse an instance of ProvideAction from the given Reader */
    public static ProvideAction parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProvideAction();
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


