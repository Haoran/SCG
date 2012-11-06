// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.net;

import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of TeamFile */
public class TeamFile{
    protected List<TeamSpec> teams;

    /** Construct a(n) TeamFile Instance */
    public TeamFile(List<TeamSpec> teams){
        this.teams = teams;
    }
    /** Is the given object Equal to this TeamFile? */
    public boolean equals(Object o){
        if(!(o instanceof TeamFile))return false;
        if(o == this)return true;
        TeamFile oo = (TeamFile)o;
        return (((Object)teams).equals(oo.teams));
    }
    /** Parse an instance of TeamFile from the given String */
    public static TeamFile parse(String inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(new java.io.StringReader(inpt)).parse_TeamFile();
    }
    /** Parse an instance of TeamFile from the given Stream */
    public static TeamFile parse(java.io.InputStream inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_TeamFile();
    }
    /** Parse an instance of TeamFile from the given Reader */
    public static TeamFile parse(java.io.Reader inpt) throws scg.net.ParseException{
        return new scg.net.TheParser(inpt).parse_TeamFile();
    }

    /** Field Class for TeamFile.teams */
    public static class teams extends edu.neu.ccs.demeterf.Fields.any{}

    /** Write out the Teams to a File */
    public void write(String file) throws IOException{
        PrintStream out = new PrintStream(new FileOutputStream(file));
        out.println(this.toString());
        out.close();
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
    /** Setter for field TeamFile.teams */
    public void setTeams(List<TeamSpec> _teams){ teams = _teams; }
    /** Getter for field TeamFile.teams */
    public List<TeamSpec> getTeams(){ return teams; }

}


