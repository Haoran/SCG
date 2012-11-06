// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of SignUp */
public class SignUp extends Command{
    protected String name;
    protected String password;

    /** Construct a(n) SignUp Instance */
    public SignUp(String name, String password){
        this.name = name;
        this.password = password;
    }
    /** Is the given object Equal to this SignUp? */
    public boolean equals(Object o){
        if(!(o instanceof SignUp))return false;
        if(o == this)return true;
        SignUp oo = (SignUp)o;
        return (((Object)name).equals(oo.name))&&(((Object)password).equals(oo.password));
    }
    /** Parse an instance of SignUp from the given String */
    public static SignUp parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_SignUp();
    }
    /** Parse an instance of SignUp from the given Stream */
    public static SignUp parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SignUp();
    }
    /** Parse an instance of SignUp from the given Reader */
    public static SignUp parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SignUp();
    }

    /** Field Class for SignUp.name */
    public static class name extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SignUp.password */
    public static class password extends edu.neu.ccs.demeterf.Fields.any{}

    public String getFormat() {
        return "sign_up {name} {password}";
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
    /** Setter for field SignUp.name */
    public void setName(String _name){ name = _name; }
    /** Setter for field SignUp.password */
    public void setPassword(String _password){ password = _password; }
    /** Getter for field SignUp.name */
    public String getName(){ return name; }
    /** Getter for field SignUp.password */
    public String getPassword(){ return password; }

}


