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



/** Computes a String representation in CD Syntax */
public class Print extends edu.neu.ccs.demeterf.FC{
   /** Static stub method for calling print */
   public static String PrintM(Object o){
      return new edu.neu.ccs.demeterf.Traversal(new Print(),edu.neu.ccs.demeterf.Control.builtins()).<Print._LT>traverse(o).toString();
   }

   public _LT combine(byte _h_){ return empty.append(new _S(""+_h_)); }
   public _LT combine(short _h_){ return empty.append(new _S(""+_h_)); }
   public _LT combine(int _h_){ return empty.append(new _S(""+_h_)); }
   public _LT combine(long _h_){ return empty.append(new _S(""+_h_)); }
   public _LT combine(float _h_){ return empty.append(new _S(""+_h_)); }
   public _LT combine(double _h_){ return empty.append(new _S(""+_h_)); }
   public _LT combine(char _h_){ return empty.append(new _S("\'"+escape(""+_h_)+"\'")); }
   public _LT combine(boolean _h_){ return empty.append(new _S(""+_h_)); }
   public _LT combine(String _h_){ return empty.append(new _S("\""+escape(""+_h_)+"\"")); }
   public _LT combine(ident _h_){ return empty.append(new _S(""+_h_)); }
   public _LT combine(verbatim _h_){ return empty.append(new _S(""+_h_)); }

   static _LT empty = new _LT();
   public  static class _LT{
     edu.neu.ccs.demeterf.lib.List<_T> l;
     public _LT(){ l = new edu.neu.ccs.demeterf.lib.Empty<_T>(); }
     public _LT(edu.neu.ccs.demeterf.lib.List<_T> ll){ l = ll; }
     public _LT push(_T t){ return new _LT(l.push(t)); }
     public _LT append(_T t){ return new _LT(l.append(t)); }
     public _LT append(_LT t){ return new _LT(l.append(t.l)); }
     public String toString(){ return l.fold(new _F(),""); }
     public _LT compress(){ return l.isEmpty()?this:compress(new _E(), l); }
     public static _LT compress(_S s, edu.neu.ccs.demeterf.lib.List<_T> r){
        if(r.isEmpty())return (s.isE())?empty:empty.push(s);
          _T top = r.top();
          if(top.isS())return compress(s.append((_S)top), r.pop());
          if(s.isE())return compress(s, r.pop()).push(top);
          return compress(new _E(), r.pop()).push(top).push(s);
     }
   }
   public static class _T{
     public boolean isS(){ return false; }
     public boolean isE(){ return false; }
   }
   public static class _P extends _T{ public static _P p = new _P(); }
   public static class _M extends _T{ public static _M m = new _M(); }
   public static class _N extends _T{ public static _N n = new _N(); }
   public static class _R extends _T{ public static _R r = new _R(); }
   public static class _S extends _T{
     public StringBuffer s;
     public _S(String ss){ s = new StringBuffer(ss); }
     public _S append(_S ss){ s.append(ss.s); return this; }
     public  boolean isS(){ return true; }
   }
   public static class _E extends _S{
     public _E(){ super("");}
     public  boolean isS(){ return true; }
   }
   public static class _F extends edu.neu.ccs.demeterf.lib.List.Fold<_T,String>{
     int idt = 0;
     public  String fold(_T t, String s){
        if(t == _P.p)plus();
        else if(t == _M.m)minus();
        else if(t == _R.r)s += "\r";
        else if(t == _N.n)s += "\n"+indent();
        else s += ((_S)t).s;
        return s;
     }
     void plus(){ idt++; }
     void minus(){ idt--; }
     String indent(){ return indent(idt); }
     static String indent(int i){ return (i <= 0)?"":"   "+indent(i-1); }
   }
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
   public _LT combine(SmartHistory _h_, _LT loc, _LT player1, _LT player1Score, _LT player2, _LT player2Score){
      return empty.append(loc).append(new _S(" ")).append(_N.n).append(player1).append(new _S(" ")).append(player1Score).append(_N.n).append(player2).append(new _S(" ")).append(player2Score).compress();
   }
   public _LT combine(ClaimWithResponse _h_, _LT claim, _LT proposer, _LT opposer, _LT opposeAction, _LT responses, _LT winner, _LT pointsWon){
      return empty.append(new _S("claim")).append(new _S(" ")).append(claim).append(new _S(" ")).append(_N.n).append(new _S("proposer")).append(new _S(" ")).append(proposer).append(new _S(" ")).append(_N.n).append(new _S("opposer")).append(new _S(" ")).append(opposer).append(new _S(" ")).append(_N.n).append(new _S("action")).append(new _S(" ")).append(opposeAction).append(new _S(" ")).append(_N.n).append(new _S("responses")).append(new _S(" ")).append(responses).append(new _S(" ")).append(new _S("winner")).append(new _S(" ")).append(winner).append(new _S(" ")).append(_N.n).append(new _S("pointsWon")).append(new _S(" ")).append(pointsWon).append(_N.n).append(_N.n).compress();
   }
   public _LT combine(AnnotatedResponse _h_, _LT provider, _LT pr){
      return empty.append(new _S("provider")).append(new _S(" ")).append(provider).append(new _S(" ")).append(new _S("pr")).append(new _S(" ")).append(pr).append(_N.n).compress();
   }
   public _LT combine(RawHistory _h_, _LT entries, _LT player1, _LT player1Score, _LT player2, _LT player2Score){
      return empty.append(entries).append(new _S(" ")).append(_N.n).append(player1).append(new _S(" ")).append(player1Score).append(_N.n).append(player2).append(new _S(" ")).append(player2Score).compress();
   }
   public _LT combine(RHEntry _h_, _LT request, _LT reply, _LT teamName, _LT reputation){
      return empty.append(new _S("request")).append(new _S(" ")).append(request).append(new _S(" ")).append(_N.n).append(new _S("reply")).append(new _S(" ")).append(reply).append(new _S(" ")).append(_N.n).append(new _S("teamName")).append(new _S(" ")).append(teamName).append(new _S(" ")).append(_N.n).append(new _S("reputation")).append(new _S(" ")).append(reputation).append(_N.n).append(_N.n).compress();
   }
   public _LT combine(HistoryResponse _h_, _LT response){
      return empty.append(response).compress();
   }
   public _LT combine(KickJustification _h_, _LT reason){
      return empty.append(reason).compress();
   }
   public _LT combine(FullyQualifiedClassName _h_, _LT name, _LT rest){
      return empty.append(name).append(rest).compress();
   }
   public _LT combine(DSCOI _h_, _LT first, _LT rest){
      return empty.append(new _S(".")).append(first).append(rest).compress();
   }
   public _LT combine(DSEOI _h_){
      return empty;
   }
   public _LT combine(Claim _h_, _LT instanceSetWrapper, _LT protocolWrapper, _LT quality, _LT confidence){
      return empty.append(instanceSetWrapper).append(protocolWrapper).append(quality).append(new _S(" ")).append(confidence).compress();
   }
   public _LT combine(ProtocolSpec _h_, _LT steps){
      return empty.append(steps).compress();
   }
   public _LT combine(Step _h_, _LT action, _LT role){
      return empty.append(action).append(new _S("from")).append(role).compress();
   }
   public _LT combine(Alice _h_){
      return empty.append(new _S("Alice")).compress();
   }
   public _LT combine(Bob _h_){
      return empty.append(new _S("Bob")).compress();
   }
   public _LT combine(ProvideAction _h_){
      return empty.append(new _S("instance")).compress();
   }
   public _LT combine(SolveAction _h_, _LT stepNo){
      return empty.append(new _S("solution")).append(new _S("of")).append(new _S(" ")).append(stepNo).compress();
   }
   public _LT combine(Request _h_, _LT forbidden, _LT claimsToOppose, _LT protocolRequests){
      return empty.append(new _S("propose")).append(new _S(" ")).append(forbidden).append(new _S(" ")).append(new _S("oppose")).append(new _S(" ")).append(claimsToOppose).append(new _S(" ")).append(new _S("protocolRequest")).append(new _S(" ")).append(protocolRequests).compress();
   }
   public _LT combine(ProvideRequest _h_, _LT claimToBeProvided){
      return empty.append(new _S("provide")).append(new _S(" ")).append(claimToBeProvided).compress();
   }
   public _LT combine(SolveRequest _h_, _LT instanceWrapper, _LT claim){
      return empty.append(new _S("solve")).append(new _S(" ")).append(instanceWrapper).append(claim).compress();
   }
   public _LT combine(Response _h_, _LT proposed, _LT oppositions, _LT protocolResponses){
      return empty.append(new _S("propose")).append(new _S(" ")).append(proposed).append(new _S(" ")).append(new _S("oppose")).append(new _S(" ")).append(oppositions).append(new _S(" ")).append(new _S("protocolResponse")).append(new _S(" ")).append(protocolResponses).compress();
   }
   public _LT combine(Agreement _h_){
      return empty.append(new _S("agree")).compress();
   }
   public _LT combine(Strengthening _h_, _LT newQuality){
      return empty.append(new _S("strengthening")).append(new _S(" ")).append(newQuality).compress();
   }
   public _LT combine(Refuting _h_){
      return empty.append(new _S("refuting")).compress();
   }
   public _LT combine(ProvideResponse _h_, _LT instanceWrapper){
      return empty.append(new _S("provide")).append(new _S(" ")).append(instanceWrapper).compress();
   }
   public _LT combine(SolveResponse _h_, _LT solutionWrapper){
      return empty.append(new _S("solve")).append(new _S(" ")).append(solutionWrapper).compress();
   }
   public _LT combine(SCGConfig _h_, _LT domain, _LT protocols, _LT tournamentStyle, _LT turnDuration, _LT maxNumAvatars, _LT minStrengthening, _LT initialReputation, _LT maxReputation, _LT reputationFactor, _LT minProposals, _LT maxProposals, _LT numRounds, _LT proposedClaimMustBeNew, _LT minConfidence){
      return empty.append(new _S("scg_config[")).append(_N.n).append(new _S("    ")).append(new _S("domain:")).append(new _S(" ")).append(domain).append(_N.n).append(new _S("    ")).append(new _S("protocols:")).append(new _S(" ")).append(protocols).append(_N.n).append(new _S("    ")).append(new _S("tournamentStyle:")).append(new _S(" ")).append(tournamentStyle).append(_N.n).append(new _S("    ")).append(new _S("turnDuration:")).append(new _S(" ")).append(turnDuration).append(_N.n).append(new _S("    ")).append(new _S("maxNumAvatars:")).append(new _S(" ")).append(maxNumAvatars).append(_N.n).append(new _S("    ")).append(new _S("minStrengthening:")).append(new _S(" ")).append(minStrengthening).append(_N.n).append(new _S("    ")).append(new _S("initialReputation:")).append(new _S(" ")).append(initialReputation).append(_N.n).append(new _S("    ")).append(new _S("maxReputation:")).append(new _S(" ")).append(maxReputation).append(_N.n).append(new _S("    ")).append(new _S("reputationFactor:")).append(new _S(" ")).append(reputationFactor).append(_N.n).append(new _S("    ")).append(new _S("minProposals:")).append(new _S(" ")).append(minProposals).append(_N.n).append(new _S("    ")).append(new _S("maxProposals:")).append(new _S(" ")).append(maxProposals).append(_N.n).append(new _S("    ")).append(new _S("numRounds:")).append(new _S(" ")).append(numRounds).append(_N.n).append(new _S("    ")).append(new _S("proposedClaimMustBeNew:")).append(new _S(" ")).append(proposedClaimMustBeNew).append(_N.n).append(new _S("    ")).append(new _S("minConfidence:")).append(new _S(" ")).append(minConfidence).append(_N.n).append(new _S("]")).compress();
   }
   public _LT combine(FullRoundRobin _h_){
      return empty.append(new _S("full")).append(new _S(" ")).append(new _S("round-robin")).compress();
   }
   public _LT combine(KnockOut _h_){
      return empty.append(new _S("knockout")).compress();
   }
   public _LT combine(SwissStyleTournament _h_){
      return empty.append(new _S("swiss")).compress();
   }
   public _LT combine(Config _h_, _LT scgCfg, _LT domainConfigWrapper){
      return empty.append(scgCfg).append(domainConfigWrapper).compress();
   }
   public _LT combine(RED _h_){
      return empty.append(new _S("red")).compress();
   }
   public _LT combine(BLACK _h_){
      return empty.append(new _S("black")).compress();
   }

   public _LT combine(RWrap _h_, _LT className, _LT wrappee){
      return empty.append(className).append(wrappee).compress();
   }
   public _LT combine(Cons _h_, _LT first, _LT rest){
      return empty.append(first).append(new _S(" ")).append(rest).compress();
   }
   public _LT combine(Empty _h_){
      return empty;
   }
   public _LT combine(None _h_){
      return empty;
   }
   public _LT combine(Some _h_, _LT just){
      return empty.append(just).compress();
   }


}


