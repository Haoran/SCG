// ** This file was generated with DemFGen (vers:4/15/2011)

package persistentPG;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import scg.*;
import scg.game.GamePlayer;
import scg.net.PasswordEntry;
import scg.net.PasswordFile;
import scg.net.PlayerSpec;
import scg.net.PlayersFile;
import scg.net.TeamFile;
import scg.net.TeamSpec;





/** Representation of PersistentPlayground */
public class PersistentPlayground{
    protected Config config;
    protected List<PlayerSpec> enrolledPlayers;
    protected List<PersistentClaim> persistentClaims;

    /** Construct a(n) PersistentPlayground Instance */
    public PersistentPlayground(Config config, List<PlayerSpec> enrolledPlayers, List<PersistentClaim> persistentClaims){
        this.config = config;
        this.enrolledPlayers = enrolledPlayers;
        this.persistentClaims = persistentClaims;
    }
    /** Is the given object Equal to this PersistentPlayground? */
    public boolean equals(Object o){
        if(!(o instanceof PersistentPlayground))return false;
        if(o == this)return true;
        PersistentPlayground oo = (PersistentPlayground)o;
        return (((Object)config).equals(oo.config))&&(((Object)enrolledPlayers).equals(oo.enrolledPlayers))&&(((Object)persistentClaims).equals(oo.persistentClaims));
    }
    /** Parse an instance of PersistentPlayground from the given String */
    public static PersistentPlayground parse(String inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(new java.io.StringReader(inpt)).parse_PersistentPlayground();
    }
    /** Parse an instance of PersistentPlayground from the given Stream */
    public static PersistentPlayground parse(java.io.InputStream inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(inpt).parse_PersistentPlayground();
    }
    /** Parse an instance of PersistentPlayground from the given Reader */
    public static PersistentPlayground parse(java.io.Reader inpt) throws persistentPG.ParseException{
        return new persistentPG.TheParser(inpt).parse_PersistentPlayground();
    }

    /** Field Class for PersistentPlayground.config */
    public static class config extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for PersistentPlayground.enrolledPlayers */
    public static class enrolledPlayers extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for PersistentPlayground.persistentClaims */
    public static class persistentClaims extends edu.neu.ccs.demeterf.Fields.any{}

    //checks the playground of tournament and playground of persistent 
  	//playground. If same, returns true.
  	public boolean checkPlayground(Config tournamentConfig){
  		File persistentPlaygroundFile = new File("persistentPlaygroundFileName");
  		long size = persistentPlaygroundFile.length();
  		boolean check = config.equals(tournamentConfig) || size ==0;
  		return  check;
  	}
  	
  	public int getNumberofPersistentClaims(){
  		return persistentClaims.length();
  	}
  	
  	public PersistentClaim getPersistentClaim(int i){
  		return getPersistentClaims().lookup(i);
  	}
  	
	public static List<Claim> getwelfareSet(PersistentPlayground ppg){
		java.util.List<Claim> w = new ArrayList();
		for(int i =0; i <ppg.getNumberofPersistentClaims();i++){
			if(isWelfareClaim(ppg.getPersistentClaims().lookup(i))){
				w.add(ppg.getPersistentClaims().lookup(i).claim);
				} 
		}
		w = removeDuplicate(w);
		List<Claim> claims = List.<Claim> create(w);
		return claims;
	}
	
	public static boolean isWelfareClaim(PersistentClaim pc){
		   int d = 0, r = 0;
		   for(int i=0;i<pc.getRefutationLength();i++){
			   if(pc.refutationEventResult(pc.getRefutationEvent(i))){
				   r++;
			   }
			   d++;
		   }
		   if(d/(d+r)>0.99){
			   return true;
		   }
		   return false;	
	}

    public   static   java.util.List  removeDuplicate(java.util.List list)  {
        for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {
            for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {
                 if  (list.get(j).equals(list.get(i)))  {
                    list.remove(j);
                  } 
              } 
            } 
          return list;
      } 
    
    /** DGP method from Class Display */
    public String display(){ return persistentPG.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return persistentPG.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return persistentPG.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return persistentPG.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return persistentPG.HashCode.HashCodeM(this); }
    /** Setter for field PersistentPlayground.config */
    public void setConfig(Config _config){ config = _config; }
    /** Setter for field PersistentPlayground.enrolledPlayers */
    public void setEnrolledPlayers(List<PlayerSpec> _enrolledPlayers){ enrolledPlayers = _enrolledPlayers; }
    /** Setter for field PersistentPlayground.persistentClaims */
    public void setPersistentClaims(List<PersistentClaim> _persistentClaims){ persistentClaims = _persistentClaims; }
    /** Getter for field PersistentPlayground.config */
    public Config getConfig(){ return config; }
    /** Getter for field PersistentPlayground.enrolledPlayers */
    public List<PlayerSpec> getEnrolledPlayers(){ return enrolledPlayers; }
    /** Getter for field PersistentPlayground.persistentClaims */
    public List<PersistentClaim> getPersistentClaims(){ return persistentClaims; }

}


