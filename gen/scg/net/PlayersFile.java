// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.net;

import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of PlayersFile */
public class PlayersFile{
    protected List<PlayerSpec> players;

    /** Construct a(n) PlayersFile Instance */
    public PlayersFile(List<PlayerSpec> players){
        this.players = players;
    }
    /** Is the given object Equal to this PlayersFile? */
    public boolean equals(Object o){
        if(!(o instanceof PlayersFile))return false;
        if(o == this)return true;
        PlayersFile oo = (PlayersFile)o;
        return (((Object)players).equals(oo.players));
    }
    /** Parse an instance of PlayersFile from the given String */
    public static PlayersFile parse(String inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(new java.io.StringReader(inpt)).parse_PlayersFile();
    }
    /** Parse an instance of PlayersFile from the given Stream */
    public static PlayersFile parse(java.io.InputStream inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_PlayersFile();
    }
    /** Parse an instance of PlayersFile from the given Reader */
    public static PlayersFile parse(java.io.Reader inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_PlayersFile();
    }

    /** Field Class for PlayersFile.players */
    public static class players extends edu.neu.ccs.demeterf.Fields.any{}

    /** Get the List of PlayerSpecs */
    public List<PlayerSpec> getPlayerSpecs(){ return players; }

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
    /** Setter for field PlayersFile.players */
    public void setPlayers(List<PlayerSpec> _players){ players = _players; }
    /** Getter for field PlayersFile.players */
    public List<PlayerSpec> getPlayers(){ return players; }

}


