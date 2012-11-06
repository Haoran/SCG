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

public class ForAllExistsEqual extends ForAllExists implements ProtocolI{

//	private static ProtocolSpec PROTOCOL_SPEC;
//	static{
//		try{
//			PROTOCOL_SPEC = ProtocolSpec.parse( 
//			"instance from Bob " +
//			"solution of 0 from Alice "
//			);
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
//	}

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
	
	public ProtocolSpec getProtocolSpec(){
		return ForAllExistsEqual.PROTOCOL_SPEC; 
	}

	
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
			// Deleted the check for valid method assuming that it is done in Admin
			// Added by Madhu
			if(compareQuality(i.quality(solution), claimedQuality))
				return 1;
			else	
				return -1;
			
//			if(i.quality(solution) >= claimedQuality){
//				return 1; //Refutation fails. Alice wins
//			}
//			else{
//				return -1; //Refutation success. Bob wins
//			}
		}
		return 0; //Draw
	}
	
	public boolean compareQuality(double solutionQuality, double claimedQuality) 
	{
		if (solutionQuality == claimedQuality)
			return true;
		else 
			return false;
	}
		

//	public ProtocolSpec getProtocolSpec(){
//		return ForAllExistsMax.PROTOCOL_SPEC; 
//	}	

	/* Singleton instance*/
	private static ForAllExistsEqual instance = new ForAllExistsEqual();
	public ForAllExistsEqual() {}
	public static ForAllExistsEqual getInstance(){
		return instance;
	}
	
    /** Parse an instance of ForAllExists from the given String */
    public static ForAllExistsEqual parse(String inpt) throws scg.ParseException{
        return instance;
    }
    /** Parse an instance of ForAllExists from the given Stream */
    public static ForAllExistsEqual parse(java.io.InputStream inpt) throws scg.ParseException{
        return instance;
    }
    /** Parse an instance of ForAllExists from the given Reader */
    public static ForAllExistsEqual parse(java.io.Reader inpt) throws scg.ParseException{
        return instance;
    }
		
//	@Override
//	public String toString() {
//		return "";
//	}
//	
	 // return true iff the strengthenedClaim is stronger than the old claim
	public boolean strengthenP(Claim oldClaim, Claim strengthenedClaim){
		return strengthenedClaim.getQuality() == oldClaim.getQuality();
	}
//	
//	public double getStrengthenedClaimQuality(double quality, double minStrengthening) {
//		return quality + minStrengthening;
//	}
}


