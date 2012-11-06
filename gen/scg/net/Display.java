// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.net;

import edu.neu.ccs.demeterf.Fields;
import edu.neu.ccs.demeterf.lib.ident;
import edu.neu.ccs.demeterf.lib.verbatim;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;



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


   public String combine(PlayerSpec _h_, String name, String address, String port, String _d_){
      return ": PlayerSpec ("+"\n"+_d_+"<name> "+name+"\n"+_d_+"<address> "+address+"\n"+_d_+"<port> "+port+" )";
   }
   public String combine(PlayersFile _h_, String players, String _d_){
      return ": PlayersFile ("+"\n"+_d_+"<players> "+players+" )";
   }
   public String combine(PasswordEntry _h_, String name, String passhash, String _d_){
      return ": PasswordEntry ("+"\n"+_d_+"<name> "+name+"\n"+_d_+"<passhash> "+passhash+" )";
   }
   public String combine(PasswordFile _h_, String passwds, String _d_){
      return ": PasswordFile ("+"\n"+_d_+"<passwds> "+passwds+" )";
   }
   public String combine(TeamSpec _h_, String name, String passhash, String players, String _d_){
      return ": TeamSpec ("+"\n"+_d_+"<name> "+name+"\n"+_d_+"<passhash> "+passhash+"\n"+_d_+"<players> "+players+" )";
   }
   public String combine(TeamFile _h_, String teams, String _d_){
      return ": TeamFile ("+"\n"+_d_+"<teams> "+teams+" )";
   }
   public String combine(RED _h_, String _d_){
      return ": RED ("+" )";
   }
   public String combine(BLACK _h_, String _d_){
      return ": BLACK ("+" )";
   }

   public String combine(Empty _h_, String _d_){
      return ": Empty ("+" )";
   }
   public String combine(Cons _h_, String first, String rest, String _d_){
      return ": Cons ("+"\n"+_d_+"<first> "+first+"\n"+_d_+"<rest> "+rest+" )";
   }


}


