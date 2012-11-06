// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.history;

import edu.neu.ccs.demeterf.Fields;
import edu.neu.ccs.demeterf.lib.ident;
import edu.neu.ccs.demeterf.lib.verbatim;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import scg.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.net.admin.RemotePlayerProxy;



/** Computes a nested String representation with field names and values */
public class Display extends edu.neu.ccs.demeterf.FC{
   /** Static stub method for calling display */
   public static String DisplayM(Object o){
      return new edu.neu.ccs.demeterf.Traversal(new Display(),edu.neu.ccs.demeterf.Control.builtins()).<String>traverse(o,"   ");
   }

   public String combine(byte _h_){ return ": byte "+""+_h_; }
   public String combine(short _h_){ return ": short "+""+_h_; }
   public String combine(int _h_){ return ": int "+""+_h_; }
   public String combine(long _h_){ return ": long "+""+_h_; }
   public String combine(float _h_){ return ": float "+""+_h_; }
   public String combine(double _h_){ return ": double "+""+_h_; }
   public String combine(char _h_){ return ": char "+"\'"+escape(""+_h_)+"\'"; }
   public String combine(boolean _h_){ return ": boolean "+""+_h_; }
   public String combine(String _h_){ return ": String "+"\""+escape(""+_h_)+"\""; }
   public String combine(ident _h_){ return ": ident "+""+_h_; }
   public String combine(verbatim _h_){ return ": verbatim "+""+_h_; }


   public String update(Object o, Fields.any f, String d){ return d+"   "; }
   public static String escape(String s){
      char str[] = s.toCharArray();
      StringBuffer ret = new StringBuffer("");
      for(char c:str)ret.append(escape(c));
      return ret.toString();
   }
   public static String escape(char c){
      switch(c){
      case '\n':return "\\n";  case '\t':return "\\t";
      case '\b':return "\\b";  case '\r':return "\\r";
      case '\f':return "\\f";  case '\\':return "\\\\";
      case '\'':return "\\'"; case '\"':return "\\\"";
      default: return ""+c;
      }
   }


   public String combine(SmartHistory _h_, String loc, String player1, String player1Score, String player2, String player2Score, String _d_){
      return ": SmartHistory ("+"\n"+_d_+"<loc> "+loc+"\n"+_d_+"<player1> "+player1+"\n"+_d_+"<player1Score> "+player1Score+"\n"+_d_+"<player2> "+player2+"\n"+_d_+"<player2Score> "+player2Score+" )";
   }
   public String combine(ClaimWithResponse _h_, String claim, String proposer, String opposer, String opposeAction, String responses, String winner, String pointsWon, String _d_){
      return ": ClaimWithResponse ("+"\n"+_d_+"<claim> "+claim+"\n"+_d_+"<proposer> "+proposer+"\n"+_d_+"<opposer> "+opposer+"\n"+_d_+"<opposeAction> "+opposeAction+"\n"+_d_+"<responses> "+responses+"\n"+_d_+"<winner> "+winner+"\n"+_d_+"<pointsWon> "+pointsWon+" )";
   }
   public String combine(AnnotatedResponse _h_, String provider, String pr, String _d_){
      return ": AnnotatedResponse ("+"\n"+_d_+"<provider> "+provider+"\n"+_d_+"<pr> "+pr+" )";
   }
   public String combine(RawHistory _h_, String entries, String player1, String player1Score, String player2, String player2Score, String _d_){
      return ": RawHistory ("+"\n"+_d_+"<entries> "+entries+"\n"+_d_+"<player1> "+player1+"\n"+_d_+"<player1Score> "+player1Score+"\n"+_d_+"<player2> "+player2+"\n"+_d_+"<player2Score> "+player2Score+" )";
   }
   public String combine(RHEntry _h_, String request, String reply, String teamName, String reputation, String _d_){
      return ": RHEntry ("+"\n"+_d_+"<request> "+request+"\n"+_d_+"<reply> "+reply+"\n"+_d_+"<teamName> "+teamName+"\n"+_d_+"<reputation> "+reputation+" )";
   }
   public String combine(HistoryResponse _h_, String response, String _d_){
      return ": HistoryResponse ("+"\n"+_d_+"<response> "+response+" )";
   }
   public String combine(KickJustification _h_, String reason, String _d_){
      return ": KickJustification ("+"\n"+_d_+"<reason> "+reason+" )";
   }
   public String combine(FullyQualifiedClassName _h_, String name, String rest, String _d_){
      return ": FullyQualifiedClassName ("+"\n"+_d_+"<name> "+name+"\n"+_d_+"<rest> "+rest+" )";
   }
   public String combine(DSCOI _h_, String first, String rest, String _d_){
      return ": DSCOI ("+"\n"+_d_+"<first> "+first+"\n"+_d_+"<rest> "+rest+" )";
   }
   public String combine(DSEOI _h_, String _d_){
      return ": DSEOI ("+" )";
   }
   public String combine(Claim _h_, String instanceSetWrapper, String protocolWrapper, String quality, String confidence, String _d_){
      return ": Claim ("+"\n"+_d_+"<instanceSetWrapper> "+instanceSetWrapper+"\n"+_d_+"<protocolWrapper> "+protocolWrapper+"\n"+_d_+"<quality> "+quality+"\n"+_d_+"<confidence> "+confidence+" )";
   }
   public String combine(ProtocolSpec _h_, String steps, String _d_){
      return ": ProtocolSpec ("+"\n"+_d_+"<steps> "+steps+" )";
   }
   public String combine(Step _h_, String action, String role, String _d_){
      return ": Step ("+"\n"+_d_+"<action> "+action+"\n"+_d_+"<role> "+role+" )";
   }
   public String combine(Alice _h_, String _d_){
      return ": Alice ("+" )";
   }
   public String combine(Bob _h_, String _d_){
      return ": Bob ("+" )";
   }
   public String combine(ProvideAction _h_, String _d_){
      return ": ProvideAction ("+" )";
   }
   public String combine(SolveAction _h_, String stepNo, String _d_){
      return ": SolveAction ("+"\n"+_d_+"<stepNo> "+stepNo+" )";
   }
   public String combine(Request _h_, String forbidden, String claimsToOppose, String protocolRequests, String _d_){
      return ": Request ("+"\n"+_d_+"<forbidden> "+forbidden+"\n"+_d_+"<claimsToOppose> "+claimsToOppose+"\n"+_d_+"<protocolRequests> "+protocolRequests+" )";
   }
   public String combine(ProvideRequest _h_, String claimToBeProvided, String _d_){
      return ": ProvideRequest ("+"\n"+_d_+"<claimToBeProvided> "+claimToBeProvided+" )";
   }
   public String combine(SolveRequest _h_, String instanceWrapper, String claim, String _d_){
      return ": SolveRequest ("+"\n"+_d_+"<instanceWrapper> "+instanceWrapper+"\n"+_d_+"<claim> "+claim+" )";
   }
   public String combine(Response _h_, String proposed, String oppositions, String protocolResponses, String _d_){
      return ": Response ("+"\n"+_d_+"<proposed> "+proposed+"\n"+_d_+"<oppositions> "+oppositions+"\n"+_d_+"<protocolResponses> "+protocolResponses+" )";
   }
   public String combine(Agreement _h_, String _d_){
      return ": Agreement ("+" )";
   }
   public String combine(Strengthening _h_, String newQuality, String _d_){
      return ": Strengthening ("+"\n"+_d_+"<newQuality> "+newQuality+" )";
   }
   public String combine(Refuting _h_, String _d_){
      return ": Refuting ("+" )";
   }
   public String combine(ProvideResponse _h_, String instanceWrapper, String _d_){
      return ": ProvideResponse ("+"\n"+_d_+"<instanceWrapper> "+instanceWrapper+" )";
   }
   public String combine(SolveResponse _h_, String solutionWrapper, String _d_){
      return ": SolveResponse ("+"\n"+_d_+"<solutionWrapper> "+solutionWrapper+" )";
   }
   public String combine(SCGConfig _h_, String domain, String protocols, String tournamentStyle, String turnDuration, String maxNumAvatars, String minStrengthening, String initialReputation, String maxReputation, String reputationFactor, String minProposals, String maxProposals, String numRounds, String proposedClaimMustBeNew, String minConfidence, String _d_){
      return ": SCGConfig ("+"\n"+_d_+"<domain> "+domain+"\n"+_d_+"<protocols> "+protocols+"\n"+_d_+"<tournamentStyle> "+tournamentStyle+"\n"+_d_+"<turnDuration> "+turnDuration+"\n"+_d_+"<maxNumAvatars> "+maxNumAvatars+"\n"+_d_+"<minStrengthening> "+minStrengthening+"\n"+_d_+"<initialReputation> "+initialReputation+"\n"+_d_+"<maxReputation> "+maxReputation+"\n"+_d_+"<reputationFactor> "+reputationFactor+"\n"+_d_+"<minProposals> "+minProposals+"\n"+_d_+"<maxProposals> "+maxProposals+"\n"+_d_+"<numRounds> "+numRounds+"\n"+_d_+"<proposedClaimMustBeNew> "+proposedClaimMustBeNew+"\n"+_d_+"<minConfidence> "+minConfidence+" )";
   }
   public String combine(FullRoundRobin _h_, String _d_){
      return ": FullRoundRobin ("+" )";
   }
   public String combine(KnockOut _h_, String _d_){
      return ": KnockOut ("+" )";
   }
   public String combine(SwissStyleTournament _h_, String _d_){
      return ": SwissStyleTournament ("+" )";
   }
   public String combine(Config _h_, String scgCfg, String domainConfigWrapper, String _d_){
      return ": Config ("+"\n"+_d_+"<scgCfg> "+scgCfg+"\n"+_d_+"<domainConfigWrapper> "+domainConfigWrapper+" )";
   }
   public String combine(RED _h_, String _d_){
      return ": RED ("+" )";
   }
   public String combine(BLACK _h_, String _d_){
      return ": BLACK ("+" )";
   }

   public String combine(RWrap _h_, String className, String wrappee, String _d_){
      return ": RWrap ("+"\n"+_d_+"<className> "+className+"\n"+_d_+"<wrappee> "+wrappee+" )";
   }
   public String combine(Cons _h_, String first, String rest, String _d_){
      return ": Cons ("+"\n"+_d_+"<first> "+first+"\n"+_d_+"<rest> "+rest+" )";
   }
   public String combine(Empty _h_, String _d_){
      return ": Empty ("+" )";
   }
   public String combine(None _h_, String _d_){
      return ": None ("+" )";
   }
   public String combine(Some _h_, String just, String _d_){
      return ": Some ("+"\n"+_d_+"<just> "+just+" )";
   }


}


