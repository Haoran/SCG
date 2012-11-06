// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.history;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import scg.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.net.admin.RemotePlayerProxy;





/** Representation of RHEntry */
public class RHEntry{
    protected Request request;
    protected Reply reply;
    protected verbatim teamName;
    protected double reputation;

    /** Construct a(n) RHEntry Instance */
    public RHEntry(Request request, Reply reply, verbatim teamName, double reputation){
        this.request = request;
        this.reply = reply;
        this.teamName = teamName;
        this.reputation = reputation;
    }
    /** Is the given object Equal to this RHEntry? */
    public boolean equals(Object o){
        if(!(o instanceof RHEntry))return false;
        if(o == this)return true;
        RHEntry oo = (RHEntry)o;
        return (((Object)request).equals(oo.request))&&(((Object)reply).equals(oo.reply))&&(((Object)teamName).equals(oo.teamName))&&(((Object)reputation).equals(oo.reputation));
    }
    /** Parse an instance of RHEntry from the given String */
    public static RHEntry parse(String inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(new java.io.StringReader(inpt)).parse_RHEntry();
    }
    /** Parse an instance of RHEntry from the given Stream */
    public static RHEntry parse(java.io.InputStream inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_RHEntry();
    }
    /** Parse an instance of RHEntry from the given Reader */
    public static RHEntry parse(java.io.Reader inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_RHEntry();
    }

    /** Field Class for RHEntry.request */
    public static class request extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RHEntry.reply */
    public static class reply extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RHEntry.teamName */
    public static class teamName extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for RHEntry.reputation */
    public static class reputation extends edu.neu.ccs.demeterf.Fields.any{}

    /** DGP method from Class Display */
    public String display(){ return scg.history.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return scg.history.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return scg.history.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return scg.history.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return scg.history.HashCode.HashCodeM(this); }
    /** Setter for field RHEntry.request */
    public void setRequest(Request _request){ request = _request; }
    /** Setter for field RHEntry.reply */
    public void setReply(Reply _reply){ reply = _reply; }
    /** Setter for field RHEntry.teamName */
    public void setTeamName(verbatim _teamName){ teamName = _teamName; }
    /** Setter for field RHEntry.reputation */
    public void setReputation(double _reputation){ reputation = _reputation; }
    /** Getter for field RHEntry.request */
    public Request getRequest(){ return request; }
    /** Getter for field RHEntry.reply */
    public Reply getReply(){ return reply; }
    /** Getter for field RHEntry.teamName */
    public verbatim getTeamName(){ return teamName; }
    /** Getter for field RHEntry.reputation */
    public double getReputation(){ return reputation; }

}


