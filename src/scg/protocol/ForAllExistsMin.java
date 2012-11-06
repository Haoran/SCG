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

public class ForAllExistsMin extends ForAllExists implements ProtocolI{

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
//		if (solutionQuality <= claimedQuality)
//			return true;
//		else 
//			return false;
		
		Double sQ = new Double(solutionQuality);
		Double cQ = new Double(claimedQuality);
		
		double result  = sQ.compareTo(cQ);
		
		if(result <= 0.0d)
			return true;
		else 
			return false;
	}
		

//	public ProtocolSpec getProtocolSpec(){
//		return ForAllExistsMin.PROTOCOL_SPEC; 
//	}	

	/* Singleton instance*/
	private static ForAllExistsMin instance = new ForAllExistsMin();
	public ForAllExistsMin() {}
	public static ForAllExistsMin getInstance(){
		return instance;
	}
	
    /** Parse an instance of ForAllExists from the given String */
    public static ForAllExistsMin parse(String inpt) throws scg.ParseException{
        return instance;
    }
    /** Parse an instance of ForAllExists from the given Stream */
    public static ForAllExistsMin parse(java.io.InputStream inpt) throws scg.ParseException{
        return instance;
    }
    /** Parse an instance of ForAllExists from the given Reader */
    public static ForAllExistsMin parse(java.io.Reader inpt) throws scg.ParseException{
        return instance;
    }
		
//	@Override
//	public String toString() {
//		return "";
//	}
//	
    @Override
	 // return true iff the strengthenedClaim is stronger than the old claim
	public boolean strengthenP(Claim oldClaim, Claim strengthenedClaim){
		return strengthenedClaim.getQuality() < oldClaim.getQuality();
	}
//	
//	public double getStrengthenedClaimQuality(double quality, double minStrengthening) {
//		return quality + minStrengthening;
//	}
}


