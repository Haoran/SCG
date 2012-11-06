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

public abstract class DRYClass implements ProtocolI{
	
/*  Authors : Madhu, Karan, Sandeep
 * 	Base class that implements ProtocolI
 *  The 2 derived classes will now only implement the compare method,
 *  instead of the getResult method
 */
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
	
	public double getResult(Claim claim, SolutionI[] solutions,
			InstanceI[] instances) {
		if(solutions.length == 2 && instances.length == 1){
			InstanceI i = instances[0];
			SolutionI aliceSolution = solutions[0];
			SolutionI bobSolution = solutions[1];
			
			Double BobSolutionQuality = i.quality(bobSolution);
			Double AliceSolutionQuality = i.quality(aliceSolution);

			if(compareQuality(BobSolutionQuality,AliceSolutionQuality))
				return -1; //Bob wins
			else
				return 1; //Alice wins
		}
		return 0; // Draw
	}
	
	
	public boolean compareQuality(Double bobSolutionQuality,
			Double aliceSolutionQuality)
	{
		return false;
	}
	


	public ProtocolSpec getProtocolSpec(){
		return DRYClass.PROTOCOL_SPEC; 
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


