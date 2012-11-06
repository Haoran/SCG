// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of RegisterPlayer */
public class RegisterPlayer extends Command{
    protected int id;
    protected String name;
    protected String password;

    /** Construct a(n) RegisterPlayer Instance */
    public RegisterPlayer(int id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
    /** Is the given object Equal to this RegisterPlayer? */
    public boolean equals(Object o){
        if(!(o instanceof RegisterPlayer))return false;
        if(o == this)return true;
        RegisterPlayer oo = (RegisterPlayer)o;
        return (((Object)id).equals(oo.id))&&(((Object)name).equals(oo.name))&&(((Object)password).equals(oo.password));
    }
    /** Parse an instance of RegisterPlayer from the given String */
    public static RegisterPlayer parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_RegisterPlayer();
    }
    /** Parse an instance of RegisterPlayer from the given Stream */
    public static RegisterPlayer parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_RegisterPlayer();
    }
    /** Parse an instance of RegisterPlayer from the given Reader */
    public static RegisterPlayer parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_RegisterPlayer();
    }

    /** Field Class for RegisterPlayer.id */
    public static class id extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RegisterPlayer.name */
    public static class name extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RegisterPlayer.password */
    public static class password extends edu.neu.ccs.demeterf.Fields.any{}

    public String getFormat() {
        return "register_player {tournament id} {name} {password}";
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
    /** Setter for field RegisterPlayer.id */
    public void setId(int _id){ id = _id; }
    /** Setter for field RegisterPlayer.name */
    public void setName(String _name){ name = _name; }
    /** Setter for field RegisterPlayer.password */
    public void setPassword(String _password){ password = _password; }
    /** Getter for field RegisterPlayer.id */
    public int getId(){ return id; }
    /** Getter for field RegisterPlayer.name */
    public String getName(){ return name; }
    /** Getter for field RegisterPlayer.password */
    public String getPassword(){ return password; }

}


