// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of ApproveUser */
public class ApproveUser extends Command{
    protected String name;

    /** Construct a(n) ApproveUser Instance */
    public ApproveUser(String name){
        this.name = name;
    }
    /** Is the given object Equal to this ApproveUser? */
    public boolean equals(Object o){
        if(!(o instanceof ApproveUser))return false;
        if(o == this)return true;
        ApproveUser oo = (ApproveUser)o;
        return (((Object)name).equals(oo.name));
    }
    /** Parse an instance of ApproveUser from the given String */
    public static ApproveUser parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_ApproveUser();
    }
    /** Parse an instance of ApproveUser from the given Stream */
    public static ApproveUser parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ApproveUser();
    }
    /** Parse an instance of ApproveUser from the given Reader */
    public static ApproveUser parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ApproveUser();
    }

    /** Field Class for ApproveUser.name */
    public static class name extends edu.neu.ccs.demeterf.Fields.any{}

    public String getFormat() {
        return "approve_user {name}";
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
    /** Setter for field ApproveUser.name */
    public void setName(String _name){ name = _name; }
    /** Getter for field ApproveUser.name */
    public String getName(){ return name; }

}


