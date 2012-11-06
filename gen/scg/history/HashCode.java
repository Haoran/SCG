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



/** Computes a simple Hashcode */
public class HashCode extends edu.neu.ccs.demeterf.FC{
   /** Static stub method for calling hashCode */
   public static int HashCodeM(Object o){
      return new edu.neu.ccs.demeterf.Traversal(new HashCode(),edu.neu.ccs.demeterf.Control.builtins()).<Integer>traverse(o);
   }

   public int combine(byte _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(short _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(int _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(long _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(float _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(double _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(char _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(boolean _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(String _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(ident _h_)
   { return ((Object)_h_).hashCode(); }
   public int combine(verbatim _h_)
   { return ((Object)_h_).hashCode(); }

   public int combine(SmartHistory _h_, int loc, int player1, int player1Score, int player2, int player2Score)
   { return loc+(3*player1)+(5*player1Score)+(7*player2)+(9*player2Score); }
   public int combine(ClaimWithResponse _h_, int claim, int proposer, int opposer, int opposeAction, int responses, int winner, int pointsWon)
   { return claim+(3*proposer)+(5*opposer)+(7*opposeAction)+(9*responses)+(11*winner)+(13*pointsWon); }
   public int combine(AnnotatedResponse _h_, int provider, int pr)
   { return provider+(3*pr); }
   public int combine(RawHistory _h_, int entries, int player1, int player1Score, int player2, int player2Score)
   { return entries+(3*player1)+(5*player1Score)+(7*player2)+(9*player2Score); }
   public int combine(RHEntry _h_, int request, int reply, int teamName, int reputation)
   { return request+(3*reply)+(5*teamName)+(7*reputation); }
   public int combine(HistoryResponse _h_, int response)
   { return response; }
   public int combine(KickJustification _h_, int reason)
   { return reason; }
   public int combine(FullyQualifiedClassName _h_, int name, int rest)
   { return name+(3*rest); }
   public int combine(DSCOI _h_, int first, int rest)
   { return first+(3*rest); }
   public int combine(DSEOI _h_)
   { return 196022736; }
   public int combine(Claim _h_, int instanceSetWrapper, int protocolWrapper, int quality, int confidence)
   { return instanceSetWrapper+(3*protocolWrapper)+(5*quality)+(7*confidence); }
   public int combine(ProtocolSpec _h_, int steps)
   { return steps; }
   public int combine(Step _h_, int action, int role)
   { return action+(3*role); }
   public int combine(Alice _h_)
   { return 190051104; }
   public int combine(Bob _h_)
   { return 200895; }
   public int combine(ProvideAction _h_)
   { return -2088336315; }
   public int combine(SolveAction _h_, int stepNo)
   { return stepNo; }
   public int combine(Request _h_, int forbidden, int claimsToOppose, int protocolRequests)
   { return forbidden+(3*claimsToOppose)+(5*protocolRequests); }
   public int combine(ProvideRequest _h_, int claimToBeProvided)
   { return claimToBeProvided; }
   public int combine(SolveRequest _h_, int instanceWrapper, int claim)
   { return instanceWrapper+(3*claim); }
   public int combine(Response _h_, int proposed, int oppositions, int protocolResponses)
   { return proposed+(3*oppositions)+(5*protocolResponses); }
   public int combine(Agreement _h_)
   { return 349328830; }
   public int combine(Strengthening _h_, int newQuality)
   { return newQuality; }
   public int combine(Refuting _h_)
   { return -1929289488; }
   public int combine(ProvideResponse _h_, int instanceWrapper)
   { return instanceWrapper; }
   public int combine(SolveResponse _h_, int solutionWrapper)
   { return solutionWrapper; }
   public int combine(SCGConfig _h_, int domain, int protocols, int tournamentStyle, int turnDuration, int maxNumAvatars, int minStrengthening, int initialReputation, int maxReputation, int reputationFactor, int minProposals, int maxProposals, int numRounds, int proposedClaimMustBeNew, int minConfidence)
   { return domain+(3*protocols)+(5*tournamentStyle)+(7*turnDuration)+(9*maxNumAvatars)+(11*minStrengthening)+(13*initialReputation)+(15*maxReputation)+(17*reputationFactor)+(19*minProposals)+(21*maxProposals)+(23*numRounds)+(25*proposedClaimMustBeNew)+(27*minConfidence); }
   public int combine(FullRoundRobin _h_)
   { return -1005773215; }
   public int combine(KnockOut _h_)
   { return -958566930; }
   public int combine(SwissStyleTournament _h_)
   { return -90609505; }
   public int combine(Config _h_, int scgCfg, int domainConfigWrapper)
   { return scgCfg+(3*domainConfigWrapper); }
   public int combine(RED _h_)
   { return 243027; }
   public int combine(BLACK _h_)
   { return 189843357; }

   public int combine(RWrap _h_, int className, int wrappee)
   { return className+(3*wrappee); }
   public int combine(Cons _h_, int first, int rest)
   { return first+(3*rest); }
   public int combine(Empty _h_)
   { return 201244551; }
   public int combine(None _h_)
   { return 7301640; }
   public int combine(Some _h_, int just)
   { return just; }


}


