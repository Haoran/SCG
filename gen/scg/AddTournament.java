// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;





/** Representation of AddTournament */
public class AddTournament extends Command{
    protected String name;
    protected Config config;
    protected int time;

    /** Construct a(n) AddTournament Instance */
    public AddTournament(String name, Config config, int time){
        this.name = name;
        this.config = config;
        this.time = time;
    }
    /** Is the given object Equal to this AddTournament? */
    public boolean equals(Object o){
        if(!(o instanceof AddTournament))return false;
        if(o == this)return true;
        AddTournament oo = (AddTournament)o;
        return (((Object)name).equals(oo.name))&&(((Object)config).equals(oo.config))&&(((Object)time).equals(oo.time));
    }
    /** Parse an instance of AddTournament from the given String */
    public static AddTournament parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_AddTournament();
    }
    /** Parse an instance of AddTournament from the given Stream */
    public static AddTournament parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_AddTournament();
    }
    /** Parse an instance of AddTournament from the given Reader */
    public static AddTournament parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_AddTournament();
    }

    /** Field Class for AddTournament.name */
    public static class name extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for AddTournament.config */
    public static class config extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for AddTournament.time */
    public static class time extends edu.neu.ccs.demeterf.Fields.any{}

    public String getFormat() {
        return "add_tournament {tournament name} {config} {start delay (mins)}";
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
    /** Setter for field AddTournament.name */
    public void setName(String _name){ name = _name; }
    /** Setter for field AddTournament.config */
    public void setConfig(Config _config){ config = _config; }
    /** Setter for field AddTournament.time */
    public void setTime(int _time){ time = _time; }
    /** Getter for field AddTournament.name */
    public String getName(){ return name; }
    /** Getter for field AddTournament.config */
    public Config getConfig(){ return config; }
    /** Getter for field AddTournament.time */
    public int getTime(){ return time; }

}


