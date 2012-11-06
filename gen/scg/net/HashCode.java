// ** This file was generated with DemFGen (vers:4/15/2011)

package scg.net;

import edu.neu.ccs.demeterf.Fields;
import edu.neu.ccs.demeterf.lib.ident;
import edu.neu.ccs.demeterf.lib.verbatim;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import edu.neu.ccs.demeterf.lib.*;



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

   public int combine(PlayerSpec _h_, int name, int address, int port)
   { return name+(3*address)+(5*port); }
   public int combine(PlayersFile _h_, int players)
   { return players; }
   public int combine(PasswordEntry _h_, int name, int passhash)
   { return name+(3*passhash); }
   public int combine(PasswordFile _h_, int passwds)
   { return passwds; }
   public int combine(TeamSpec _h_, int name, int passhash, int players)
   { return name+(3*passhash)+(5*players); }
   public int combine(TeamFile _h_, int teams)
   { return teams; }
   public int combine(RED _h_)
   { return 243027; }
   public int combine(BLACK _h_)
   { return 189843357; }

   public int combine(Empty _h_)
   { return 201244551; }
   public int combine(Cons _h_, int first, int rest)
   { return first+(3*rest); }


}


