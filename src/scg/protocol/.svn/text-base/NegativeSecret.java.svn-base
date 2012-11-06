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

public class NegativeSecret implements ProtocolI{
	
	private static ProtocolSpec PROTOCOL_SPEC;
	static{
		try{
			PROTOCOL_SPEC = ProtocolSpec.parse( 
			"instance from Alice " +
			"solution of 0 from Alice " +
			"solution of 0 from Bob "
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
			
			SolveResponse alicesolveResponse = (SolveResponse)replies.lookup(1);
			SolutionI aliceSolution = alicesolveResponse.getSolution();
						
			SolveResponse bobsolveResponse = (SolveResponse)replies.lookup(2);
			SolutionI bobSolution = bobsolveResponse.getSolution();
						
			if(i.valid(bobSolution) ==0 && i.valid(aliceSolution) == 0) return 0; 
			if(i.valid(aliceSolution) ==0 ) return -1;
			if(i.valid(bobSolution) ==0 ) return 1;
			if(i.quality(bobSolution) >= (i.quality(aliceSolution) * claim.getQuality()))
				return -1; //Bob win
			else
				return 1; //Alice win
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
			SolutionI aliceSolution = solutions[0];
			SolutionI bobSolution = solutions[1];
//			Deleted valid check assuming that it is checked by the Admin
			if(i.quality(bobSolution) >= (i.quality(aliceSolution) * claim.getQuality()))
				return -1; //Bob win
			else
				return 1; //Alice win
		}
		return 0; // Draw
	}
	
	public ProtocolSpec getProtocolSpec(){
		return NegativeSecret.PROTOCOL_SPEC; 
	}
	
	private static NegativeSecret instance = new NegativeSecret();
	
	
	
    public static NegativeSecret getInstance() {
		return instance;
	}

	public NegativeSecret(){ }    
    /** Parse an instance of NegativeSecret from the given String */
    public static NegativeSecret parse(String inpt) throws scg.ParseException{
    	return instance;
    }
    /** Parse an instance of NegativeSecret from the given Stream */
    public static NegativeSecret parse(java.io.InputStream inpt) throws scg.ParseException{
    	return instance;
    }
    /** Parse an instance of NegativeSecret from the given Reader */
    public static NegativeSecret parse(java.io.Reader inpt) throws scg.ParseException{
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


