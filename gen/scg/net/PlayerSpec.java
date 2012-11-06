// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.net;

import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of PlayerSpec */
public class PlayerSpec{
    protected String name;
    protected String address;
    protected int port;

    /** Construct a(n) PlayerSpec Instance */
    public PlayerSpec(String name, String address, int port){
        this.name = name;
        this.address = address;
        this.port = port;
    }
    /** Is the given object Equal to this PlayerSpec? */
    public boolean equals(Object o){
        if(!(o instanceof PlayerSpec))return false;
        if(o == this)return true;
        PlayerSpec oo = (PlayerSpec)o;
        return (((Object)name).equals(oo.name))&&(((Object)address).equals(oo.address))&&(((Object)port).equals(oo.port));
    }
    /** Parse an instance of PlayerSpec from the given String */
    public static PlayerSpec parse(String inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(new java.io.StringReader(inpt)).parse_PlayerSpec();
    }
    /** Parse an instance of PlayerSpec from the given Stream */
    public static PlayerSpec parse(java.io.InputStream inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_PlayerSpec();
    }
    /** Parse an instance of PlayerSpec from the given Reader */
    public static PlayerSpec parse(java.io.Reader inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_PlayerSpec();
    }

    /** Field Class for PlayerSpec.name */
    public static class name extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for PlayerSpec.address */
    public static class address extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for PlayerSpec.port */
    public static class port extends edu.neu.ccs.demeterf.Fields.any{}

    static final char SEP = ':';

    /** Create a PlayerSpec */
    public static PlayerSpec create(String n, String add, int p){
        return new PlayerSpec(n,add,p);
    }

    /** Change the Address of this Player */
    public PlayerSpec changeAddress(String add){ return create(name,add,port); }
    /** Tag Name */
    public PlayerSpec tagName(int n){ return create(name+SEP+n,address,port); }
    
    /** Returns a Predicate that compares another PlayerSpec by name */
    public List.Pred<PlayerSpec> sameNamePred(){ return new SameName(); }
    /** Predicate for PlayerSpecs that compares Names */
    private class SameName extends List.Pred<PlayerSpec>{
        public boolean huh(PlayerSpec that)
        { return name.equals(that.name); }
    }
    /** Returns a Predicate that compares names, ignoring a tag */
    public List.Pred<PlayerSpec> samePrefixPred(){ return new PrefixName(); }
    /** Predicate for PlayerSpecs that compares name prefixes */
    private class PrefixName extends List.Pred<PlayerSpec>{
        public boolean huh(PlayerSpec that){
            String n = that.name;
            int idx = n.lastIndexOf(SEP);
            if(idx >= 0)n = n.substring(0,idx);
            return name.equals(n);
        }
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
    /** Setter for field PlayerSpec.name */
    public void setName(String _name){ name = _name; }
    /** Setter for field PlayerSpec.address */
    public void setAddress(String _address){ address = _address; }
    /** Setter for field PlayerSpec.port */
    public void setPort(int _port){ port = _port; }
    /** Getter for field PlayerSpec.name */
    public String getName(){ return name; }
    /** Getter for field PlayerSpec.address */
    public String getAddress(){ return address; }
    /** Getter for field PlayerSpec.port */
    public int getPort(){ return port; }

}


