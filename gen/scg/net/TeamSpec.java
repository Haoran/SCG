// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.net;

import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of TeamSpec */
public class TeamSpec{
    protected String name;
    protected String passhash;
    protected List<String> players;

    /** Construct a(n) TeamSpec Instance */
    public TeamSpec(String name, String passhash, List<String> players){
        this.name = name;
        this.passhash = passhash;
        this.players = players;
    }
    /** Is the given object Equal to this TeamSpec? */
    public boolean equals(Object o){
        if(!(o instanceof TeamSpec))return false;
        if(o == this)return true;
        TeamSpec oo = (TeamSpec)o;
        return (((Object)name).equals(oo.name))&&(((Object)passhash).equals(oo.passhash))&&(((Object)players).equals(oo.players));
    }
    /** Parse an instance of TeamSpec from the given String */
    public static TeamSpec parse(String inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(new java.io.StringReader(inpt)).parse_TeamSpec();
    }
    /** Parse an instance of TeamSpec from the given Stream */
    public static TeamSpec parse(java.io.InputStream inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_TeamSpec();
    }
    /** Parse an instance of TeamSpec from the given Reader */
    public static TeamSpec parse(java.io.Reader inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_TeamSpec();
    }

    /** Field Class for TeamSpec.name */
    public static class name extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for TeamSpec.passhash */
    public static class passhash extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for TeamSpec.players */
    public static class players extends edu.neu.ccs.demeterf.Fields.any{}

    /** Create a Team Spec from a Few Strings. THe String <tt>members</tt> should
     *    be a semi-colon separated list of member names. */
    public static TeamSpec create(String name, String pass, String members){
        return new TeamSpec(name, scg.Util.encrypt(pass),
                            List.create(members.split(";")).map(new List.Map<String,String>(){
                                public String map(String s){ return s.trim(); }
                            }));
    }
    /** Returns a Predicate that compares another TeamSpec by name */
    public List.Pred<TeamSpec> sameNamePred(){ return new SameName(); }
    /** Predicate for TeamSpecs that compares Names */
    private class SameName extends List.Pred<TeamSpec>{
        public boolean huh(TeamSpec that)
        { return name.equals(that.name); }
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
    /** Setter for field TeamSpec.name */
    public void setName(String _name){ name = _name; }
    /** Setter for field TeamSpec.passhash */
    public void setPasshash(String _passhash){ passhash = _passhash; }
    /** Setter for field TeamSpec.players */
    public void setPlayers(List<String> _players){ players = _players; }
    /** Getter for field TeamSpec.name */
    public String getName(){ return name; }
    /** Getter for field TeamSpec.passhash */
    public String getPasshash(){ return passhash; }
    /** Getter for field TeamSpec.players */
    public List<String> getPlayers(){ return players; }

}


