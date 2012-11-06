// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.net;

import edu.neu.ccs.demeterf.Fields;
import edu.neu.ccs.demeterf.lib.ident;
import edu.neu.ccs.demeterf.lib.verbatim;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;



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

   public String combine(PlayerSpec _h_, String name, String address, String port)
   { return "PlayerSpec("+name+","+address+","+port+")"; }
   public String combine(PlayersFile _h_, String players)
   { return "PlayersFile("+players+")"; }
   public String combine(PasswordEntry _h_, String name, String passhash)
   { return "PasswordEntry("+name+","+passhash+")"; }
   public String combine(PasswordFile _h_, String passwds)
   { return "PasswordFile("+passwds+")"; }
   public String combine(TeamSpec _h_, String name, String passhash, String players)
   { return "TeamSpec("+name+","+passhash+","+players+")"; }
   public String combine(TeamFile _h_, String teams)
   { return "TeamFile("+teams+")"; }
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

   public String combine(Empty _h_)
   { return "Empty("+")"; }
   public String combine(Cons _h_, String first, String rest)
   { return "Cons("+first+","+rest+")"; }


}


