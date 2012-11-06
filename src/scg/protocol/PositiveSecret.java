
package scg.protocol;

import scg.Claim;
import scg.InstanceI;
import scg.ProtocolI;
import scg.ProtocolSpec;
import scg.ProvideResponse;
import scg.Response;
import scg.SolutionI;
import scg.SolveResponse;
import edu.neu.ccs.demeterf.lib.*;

public class PositiveSecret implements ProtocolI{

	private static ProtocolSpec PROTOCOL_SPEC;
	static{
		try{
			PROTOCOL_SPEC = ProtocolSpec.parse( 
			"instance from Bob " +
			"solution of 0 from Bob " +
			"solution of 0 from Alice "
			);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * @author: Rashmi, Anush
	
	public double getResult(Claim claim, List<Response> replies){
		if(replies.length() == 3){
			ProvideResponse provideResponse = (ProvideResponse)replies.lookup(0);
			
			InstanceI i = (InstanceI)provideResponse.getInstance();
			
			SolveResponse bobsolveResponse = (SolveResponse)replies.lookup(1);
			SolutionI bobSolution = bobsolveResponse.getSolution();
			
			
			SolveResponse alicesolveResponse = (SolveResponse)replies.lookup(2);
			SolutionI aliceSolution = alicesolveResponse.getSolution();
						
			if(i.valid(bobSolution) ==0 && i.valid(aliceSolution) == 0) return 0; 
			if(i.valid(bobSolution) ==0 ) return 1;
			if(i.valid(aliceSolution) ==0 ) return -1;
			if(i.quality(aliceSolution) >= (i.quality(bobSolution) * claim.getQuality()))
				return 1; //Alice win
			else
				return -1; //Bob win
		}
		return 0; // Draw
	}*/
	
	@Override
	/**
	 * @author Terminator 
	 * Implements the getResult method provided by AnushRashmi 
	 * as per the new getResult method of ProtocolI
	 */
	public double getResult(Claim claim, SolutionI[] solutions,
			InstanceI[] instances) {
		if(solutions.length == 2 && instances.length == 1){
			InstanceI i = instances[0];
			SolutionI bobSolution = solutions[0];
			SolutionI aliceSolution = solutions[1];
//			Deleted valid check assuming that it is checked by the Admin
			if(i.quality(aliceSolution) >= (i.quality(bobSolution) * claim.getQuality()))
				return 1; //Alice win
			else
				return -1; //Bob win
		}
		return 0; // Draw
	}
	
	public ProtocolSpec getProtocolSpec(){
		return PositiveSecret.PROTOCOL_SPEC; 
	}
	
	private static PositiveSecret instance = new PositiveSecret();
	
    public static PositiveSecret getInstance() {
		return instance;
	}
    
	public PositiveSecret(){ }
    /** Parse an instance of PositiveSecret from the given String */
    public static PositiveSecret parse(String inpt) throws scg.ParseException{
    	return instance;
    }
    /** Parse an instance of PositiveSecret from the given Stream */
    public static PositiveSecret parse(java.io.InputStream inpt) throws scg.ParseException{
    	return instance;
    }
    /** Parse an instance of PositiveSecret from the given Reader */
    public static PositiveSecret parse(java.io.Reader inpt) throws scg.ParseException{
    	return instance;
    }

	@Override
	public String toString() {
		return "";
	}
	
	 // return true iff the strengthenedClaim is stronger than the old claim
	public boolean strengthenP(Claim oldClaim, Claim strengthenedClaim){
		return strengthenedClaim.getQuality() > oldClaim.getQuality();
	}
	
	public double getStrengthenedClaimQuality(double quality, double minStrengthening) {
		return quality + minStrengthening;
	}
}



