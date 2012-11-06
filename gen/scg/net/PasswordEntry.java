// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.net;

import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of PasswordEntry */
public class PasswordEntry{
    protected String name;
    protected String passhash;

    /** Construct a(n) PasswordEntry Instance */
    public PasswordEntry(String name, String passhash){
        this.name = name;
        this.passhash = passhash;
    }
    /** Is the given object Equal to this PasswordEntry? */
    public boolean equals(Object o){
        if(!(o instanceof PasswordEntry))return false;
        if(o == this)return true;
        PasswordEntry oo = (PasswordEntry)o;
        return (((Object)name).equals(oo.name))&&(((Object)passhash).equals(oo.passhash));
    }
    /** Parse an instance of PasswordEntry from the given String */
    public static PasswordEntry parse(String inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(new java.io.StringReader(inpt)).parse_PasswordEntry();
    }
    /** Parse an instance of PasswordEntry from the given Stream */
    public static PasswordEntry parse(java.io.InputStream inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_PasswordEntry();
    }
    /** Parse an instance of PasswordEntry from the given Reader */
    public static PasswordEntry parse(java.io.Reader inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_PasswordEntry();
    }

    /** Field Class for PasswordEntry.name */
    public static class name extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for PasswordEntry.passhash */
    public static class passhash extends edu.neu.ccs.demeterf.Fields.any{}

    /** Add to the given Map */
    public Map<String,String> addTo(Map<String,String> m){
        return m.put(name,passhash);
    }

    /** DGP method from Class Display */
    public String display(){ return scg.net.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return scg.net.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return scg.net.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return scg.net.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return scg.net.HashCode.HashCodeM(this); }
    /** Setter for field PasswordEntry.name */
    public void setName(String _name){ name = _name; }
    /** Setter for field PasswordEntry.passhash */
    public void setPasshash(String _passhash){ passhash = _passhash; }
    /** Getter for field PasswordEntry.name */
    public String getName(){ return name; }
    /** Getter for field PasswordEntry.passhash */
    public String getPasshash(){ return passhash; }

}


