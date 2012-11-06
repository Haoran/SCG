// ** This file was generated with DemFGen (vers:4/15/2011)

package mmg.avatar;

import edu.neu.ccs.demeterf.lib.*;
import edu.neu.ccs.demeterf.lib.*;
import java.util.Random;
import java.lang.reflect.Method;
import scg.*;
import scg.protocol.*;
import mmg.*;





/** Representation of MMGAvatar */
public class MMGAvatar implements AvatarI{

    /** Construct a(n) MMGAvatar Instance */
    public MMGAvatar(){
    }
    /** Is the given object Equal to this MMGAvatar? */
    public boolean equals(Object o){
        if(!(o instanceof MMGAvatar))return false;
        if(o == this)return true;
        MMGAvatar oo = (MMGAvatar)o;
        return true;
    }
    /** Parse an instance of MMGAvatar from the given String */
    public static MMGAvatar parse(String inpt) throws mmg.avatar.ParseException{
        return new mmg.avatar.TheParser(new java.io.StringReader(inpt)).parse_MMGAvatar();
    }
    /** Parse an instance of MMGAvatar from the given Stream */
    public static MMGAvatar parse(java.io.InputStream inpt) throws mmg.avatar.ParseException{
        return new mmg.avatar.TheParser(inpt).parse_MMGAvatar();
    }
    /** Parse an instance of MMGAvatar from the given Reader */
    public static MMGAvatar parse(java.io.Reader inpt) throws mmg.avatar.ParseException{
        return new mmg.avatar.TheParser(inpt).parse_MMGAvatar();
    }

	
	private Config config;
	
	/** Constructor to be called during registration where you supply config */
	public MMGAvatar(Config cfg){
		config = cfg;
	}
	@Override
	/** Random oppose method - randomly agrees, refutes or strengthens */
	public List<OpposeAction> oppose(List<Claim> claimsToBeOpposed){
		return claimsToBeOpposed.map(new List.Map<Claim, OpposeAction>() {
			public OpposeAction map(Claim claim){
				Random rand = new Random();
				int randOppose = rand.nextInt(3);
				if(randOppose == 0) {
					return new Agreement();
				}else if(randOppose == 1){
					double q = claim.getQuality();
					SCGConfig scgCFG = config.getScgCfg();
					double minStrengthening = scgCFG.getMinStrengthening();
					return new Strengthening(ForAllExistsMax.getInstance().getStrengthenedClaimQuality(q, minStrengthening));
				}else{ 
					return new Refuting();
				}
            }
		});
	}
    
	@Override
	public List<Claim> propose(List<Claim> forbiddenClaims) {
		List<Claim> claims = List.create();
		SCGConfig scg_cfg = config.getScgCfg();
		int maxProposals = scg_cfg.getMaxProposals();
		
		for(int i=0;i<maxProposals;i++){
			Claim claim = generateRandomClaim();
			// Not required since there is a single claim this goes on forever
//			while(forbiddenClaims.contains(claim) || claims.contains(claim)){
//				claim = generateRandomClaim();
//			}
			claims = claims.append(claim);
		}
		return claims;
	}
	
	private Claim generateRandomClaim() {
		//Random r = new Random();
		return new Claim(MMGInstanceSet.getInstance(),ForAllExistsMax.getInstance(),0.61d,1);
	}

	@Override
	public InstanceI provide(Claim claimToBeProvided) {
		Random r = new Random();
		return new MMGInstance(r.nextDouble());
	}
	@Override
	public SolutionI solve(SolveRequest solveRequest) {
		Random r = new Random();
		//return new MMGSolution(r.nextDouble());
		return new MMGSolution(0.45);
	}

    /** DGP method from Class Display */
    public String display(){ return mmg.avatar.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return mmg.avatar.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return mmg.avatar.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return mmg.avatar.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return mmg.avatar.HashCode.HashCodeM(this); }

}


