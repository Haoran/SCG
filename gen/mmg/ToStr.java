// ** This file was generated with DemFGen (vers:4/15/2011)

package mmg;

import edu.neu.ccs.demeterf.Fields;
import edu.neu.ccs.demeterf.lib.ident;
import edu.neu.ccs.demeterf.lib.verbatim;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.*;



/** Computes a simple String representation */
public class ToStr extends edu.neu.ccs.demeterf.FC{
   /** Static stub method for calling toStr */
   public static String ToStrM(Object o){
      return new edu.neu.ccs.demeterf.Traversal(new ToStr(),edu.neu.ccs.demeterf.Control.builtins()).<String>traverse(o);
   }

   public String combine(byte _h_)
   { return ""+_h_; }
   public String combine(short _h_)
   { return ""+_h_; }
   public String combine(int _h_)
   { return ""+_h_; }
   public String combine(long _h_)
   { return ""+_h_; }
   public String combine(float _h_)
   { return ""+_h_; }
   public String combine(double _h_)
   { return ""+_h_; }
   public String combine(char _h_)
   { return "\'"+escape(""+_h_)+"\'"; }
   public String combine(boolean _h_)
   { return ""+_h_; }
   public String combine(String _h_)
   { return "\""+escape(""+_h_)+"\""; }
   public String combine(ident _h_)
   { return ""+_h_; }
   public String combine(verbatim _h_)
   { return ""+_h_; }

   public String combine(MMGInstance _h_, String x)
   { return "MMGInstance("+x+")"; }
   public String combine(MMGSolution _h_, String y)
   { return "MMGSolution("+y+")"; }
   public String combine(MMGInstanceSet _h_)
   { return "MMGInstanceSet("+")"; }
   public String combine(MMGDomain _h_)
   { return "MMGDomain("+")"; }
   public String combine(MMGConfig _h_)
   { return "MMGConfig("+")"; }
   public String combine(FullyQualifiedClassName _h_, String name, String rest)
   { return "FullyQualifiedClassName("+name+","+rest+")"; }
   public String combine(DSCOI _h_, String first, String rest)
   { return "DSCOI("+first+","+rest+")"; }
   public String combine(DSEOI _h_)
   { return "DSEOI("+")"; }
   public String combine(Claim _h_, String instanceSetWrapper, String protocolWrapper, String quality, String confidence)
   { return "Claim("+instanceSetWrapper+","+protocolWrapper+","+quality+","+confidence+")"; }
   public String combine(ProtocolSpec _h_, String steps)
   { return "ProtocolSpec("+steps+")"; }
   public String combine(Step _h_, String action, String role)
   { return "Step("+action+","+role+")"; }
   public String combine(Alice _h_)
   { return "Alice("+")"; }
   public String combine(Bob _h_)
   { return "Bob("+")"; }
   public String combine(ProvideAction _h_)
   { return "ProvideAction("+")"; }
   public String combine(SolveAction _h_, String stepNo)
   { return "SolveAction("+stepNo+")"; }
   public String combine(Request _h_, String forbidden, String claimsToOppose, String protocolRequests)
   { return "Request("+forbidden+","+claimsToOppose+","+protocolRequests+")"; }
   public String combine(ProvideRequest _h_, String claimToBeProvided)
   { return "ProvideRequest("+claimToBeProvided+")"; }
   public String combine(SolveRequest _h_, String instanceWrapper, String claim)
   { return "SolveRequest("+instanceWrapper+","+claim+")"; }
   public String combine(Response _h_, String proposed, String oppositions, String protocolResponses)
   { return "Response("+proposed+","+oppositions+","+protocolResponses+")"; }
   public String combine(Agreement _h_)
   { return "Agreement("+")"; }
   public String combine(Strengthening _h_, String newQuality)
   { return "Strengthening("+newQuality+")"; }
   public String combine(Refuting _h_)
   { return "Refuting("+")"; }
   public String combine(ProvideResponse _h_, String instanceWrapper)
   { return "ProvideResponse("+instanceWrapper+")"; }
   public String combine(SolveResponse _h_, String solutionWrapper)
   { return "SolveResponse("+solutionWrapper+")"; }
   public String combine(SCGConfig _h_, String domain, String protocols, String tournamentStyle, String turnDuration, String maxNumAvatars, String minStrengthening, String initialReputation, String maxReputation, String reputationFactor, String minProposals, String maxProposals, String numRounds, String proposedClaimMustBeNew, String minConfidence)
   { return "SCGConfig("+domain+","+protocols+","+tournamentStyle+","+turnDuration+","+maxNumAvatars+","+minStrengthening+","+initialReputation+","+maxReputation+","+reputationFactor+","+minProposals+","+maxProposals+","+numRounds+","+proposedClaimMustBeNew+","+minConfidence+")"; }
   public String combine(FullRoundRobin _h_)
   { return "FullRoundRobin("+")"; }
   public String combine(KnockOut _h_)
   { return "KnockOut("+")"; }
   public String combine(SwissStyleTournament _h_)
   { return "SwissStyleTournament("+")"; }
   public String combine(Config _h_, String scgCfg, String domainConfigWrapper)
   { return "Config("+scgCfg+","+domainConfigWrapper+")"; }
   public String combine(RED _h_)
   { return "RED("+")"; }
   public String combine(BLACK _h_)
   { return "BLACK("+")"; }
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

   public String combine(RWrap _h_, String className, String wrappee)
   { return "RWrap("+className+","+wrappee+")"; }
   public String combine(Cons _h_, String first, String rest)
   { return "Cons("+first+","+rest+")"; }
   public String combine(Empty _h_)
   { return "Empty("+")"; }
   public String combine(None _h_)
   { return "None("+")"; }
   public String combine(Some _h_, String just)
   { return "Some("+just+")"; }


}


