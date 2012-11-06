// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.history;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import scg.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.net.admin.RemotePlayerProxy;





/** Representation of ClaimWithResponse */
public class ClaimWithResponse{
    protected Claim claim;
    protected verbatim proposer;
    protected verbatim opposer;
    protected OpposeAction opposeAction;
    protected List<AnnotatedResponse> responses;
    protected verbatim winner;
    protected double pointsWon;

    /** Construct a(n) ClaimWithResponse Instance */
    public ClaimWithResponse(Claim claim, verbatim proposer, verbatim opposer, OpposeAction opposeAction, List<AnnotatedResponse> responses, verbatim winner, double pointsWon){
        this.claim = claim;
        this.proposer = proposer;
        this.opposer = opposer;
        this.opposeAction = opposeAction;
        this.responses = responses;
        this.winner = winner;
        this.pointsWon = pointsWon;
    }
    /** Is the given object Equal to this ClaimWithResponse? */
    public boolean equals(Object o){
        if(!(o instanceof ClaimWithResponse))return false;
        if(o == this)return true;
        ClaimWithResponse oo = (ClaimWithResponse)o;
        return (((Object)claim).equals(oo.claim))&&(((Object)proposer).equals(oo.proposer))&&(((Object)opposer).equals(oo.opposer))&&(((Object)opposeAction).equals(oo.opposeAction))&&(((Object)responses).equals(oo.responses))&&(((Object)winner).equals(oo.winner))&&(((Object)pointsWon).equals(oo.pointsWon));
    }
    /** Parse an instance of ClaimWithResponse from the given String */
    public static ClaimWithResponse parse(String inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(new java.io.StringReader(inpt)).parse_ClaimWithResponse();
    }
    /** Parse an instance of ClaimWithResponse from the given Stream */
    public static ClaimWithResponse parse(java.io.InputStream inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_ClaimWithResponse();
    }
    /** Parse an instance of ClaimWithResponse from the given Reader */
    public static ClaimWithResponse parse(java.io.Reader inpt) throws scg.history.ParseException{
        return new scg.history.TheParser(inpt).parse_ClaimWithResponse();
    }

    /** Field Class for ClaimWithResponse.claim */
    public static class claim extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for ClaimWithResponse.proposer */
    public static class proposer extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for ClaimWithResponse.opposer */
    public static class opposer extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for ClaimWithResponse.opposeAction */
    public static class opposeAction extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for ClaimWithResponse.responses */
    public static class responses extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for ClaimWithResponse.winner */
    public static class winner extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for ClaimWithResponse.pointsWon */
    public static class pointsWon extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field ClaimWithResponse.claim */
    public void setClaim(Claim _claim){ claim = _claim; }
    /** Setter for field ClaimWithResponse.proposer */
    public void setProposer(verbatim _proposer){ proposer = _proposer; }
    /** Setter for field ClaimWithResponse.opposer */
    public void setOpposer(verbatim _opposer){ opposer = _opposer; }
    /** Setter for field ClaimWithResponse.opposeAction */
    public void setOpposeAction(OpposeAction _opposeAction){ opposeAction = _opposeAction; }
    /** Setter for field ClaimWithResponse.responses */
    public void setResponses(List<AnnotatedResponse> _responses){ responses = _responses; }
    /** Setter for field ClaimWithResponse.winner */
    public void setWinner(verbatim _winner){ winner = _winner; }
    /** Setter for field ClaimWithResponse.pointsWon */
    public void setPointsWon(double _pointsWon){ pointsWon = _pointsWon; }
    /** Getter for field ClaimWithResponse.claim */
    public Claim getClaim(){ return claim; }
    /** Getter for field ClaimWithResponse.proposer */
    public verbatim getProposer(){ return proposer; }
    /** Getter for field ClaimWithResponse.opposer */
    public verbatim getOpposer(){ return opposer; }
    /** Getter for field ClaimWithResponse.opposeAction */
    public OpposeAction getOpposeAction(){ return opposeAction; }
    /** Getter for field ClaimWithResponse.responses */
    public List<AnnotatedResponse> getResponses(){ return responses; }
    /** Getter for field ClaimWithResponse.winner */
    public verbatim getWinner(){ return winner; }
    /** Getter for field ClaimWithResponse.pointsWon */
    public double getPointsWon(){ return pointsWon; }

}


