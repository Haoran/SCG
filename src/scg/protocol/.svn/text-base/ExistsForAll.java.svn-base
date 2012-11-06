package scg.protocol;

import scg.Claim;
import scg.InstanceI;
import scg.ProtocolI;
import scg.ProtocolSpec;
import scg.ProvideResponse;
import scg.Response;
import scg.SolutionI;
import scg.SolveResponse;
import scg.Step;
import edu.neu.ccs.demeterf.lib.*;

public class ExistsForAll implements ProtocolI{
	
	private static ProtocolSpec PROTOCOL_SPEC;
	static{
		try{
			PROTOCOL_SPEC = ProtocolSpec.parse( 
			"instance from Alice " +
			"solution of 0 from Bob "
			);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * @author: Rashmi, Anush
	
	public double getResult(Claim claim, List<Response> replies){
		double claimedQuality = claim.getQuality();
		if(replies.length() == 2){
			ProvideResponse provideResponse = (ProvideResponse)replies.lookup(0);
			
			InstanceI i = (InstanceI)provideResponse.getInstance();
			
			SolveResponse solveResponse = (SolveResponse)replies.lookup(1);
			SolutionI solution = solveResponse.getSolution();
			
			
			if(i.valid(solution)== 1){
				if(i.quality(solution) <= claimedQuality){
					return -1; //Refutation succeeds. Bob wins
				}
			}
		}
		return 0; //Draw
	}*/
	
	@Override
	/**
	 * @author Terminator 
	 * Implements the getResult method provided by AnushRashmi 
	 * as per the new getResult method of ProtocolI
	 */
	public double getResult(Claim claim, SolutionI[] solutions,
			InstanceI[] instances) {
		double claimedQuality = claim.getQuality();
		if(solutions.length == 1 && instances.length == 1){
			InstanceI i = instances[0];
			SolutionI solution = solutions[0];
			// Deleted valid check assuming that it is checked by the Admin
			if(i.quality(solution) <= claimedQuality){
				return -1; //Refutation succeeds. Bob wins
			}
			else{
				return 1; //Refutation fails. Alice wins
			}
		}
		return 0; //Draw
	}
	
	public ProtocolSpec getProtocolSpec(){
		return ExistsForAll.PROTOCOL_SPEC; 
	}
	
	private static ExistsForAll instance = new ExistsForAll();
    
	public ExistsForAll(){ }
    public static ExistsForAll getInstance() {
		return instance;
	}

    /** Parse an instance of ExistsForAll from the given String */
    public static ExistsForAll parse(String inpt) throws scg.ParseException{
        return instance;
    }
    /** Parse an instance of ExistsForAll from the given Stream */
    public static ExistsForAll parse(java.io.InputStream inpt) throws scg.ParseException{
        return instance;
    }
    /** Parse an instance of ExistsForAll from the given Reader */
    public static ExistsForAll parse(java.io.Reader inpt) throws scg.ParseException{
        return instance;
    }

    @Override
    public String toString() {
    	return "";
    }
    
 // return true iff the strengthenedClaim is stronger than the old claim
	public boolean strengthenP(Claim oldClaim, Claim strengthenedClaim){
		return strengthenedClaim.getQuality() < oldClaim.getQuality();
	}
	
	public double getStrengthenedClaimQuality(double quality, double minStrengthening) {
		return quality - minStrengthening;
	}
}