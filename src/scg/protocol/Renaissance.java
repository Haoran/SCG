package scg.protocol;

import scg.Claim;
import scg.InstanceI;
import scg.ProtocolI;
import scg.ProtocolSpec;
import scg.Response;
import scg.SolutionI;
import edu.neu.ccs.demeterf.lib.*;

public class Renaissance implements ProtocolI{
	
	private static ProtocolSpec PROTOCOL_SPEC;
	static{
		try{
			PROTOCOL_SPEC = ProtocolSpec.parse( 
			"instance from Alice " +
			"instance from Alice " +
			"instance from Bob " +
			"instance from Bob " +
			"solution of 0 from Bob " +
			"solution of 1 from Bob " +
			"solution of 2 from Alice " +
			"solution of 3 from Alice "
			);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public double getResult(Claim claim, List<Response> replies){
		//TODO: implement
		return 1; // Alice always wins
	}
	
	public ProtocolSpec getProtocolSpec(){
		return Renaissance.PROTOCOL_SPEC; 
	}

	private static Renaissance instance = new Renaissance();
    private Renaissance(){ }
    
    public static Renaissance getInstance() {
		return instance;
	}

	/** Parse an instance of Renaissance from the given String */
    public static Renaissance parse(String inpt) throws scg.ParseException{
    	return instance;
    }
    /** Parse an instance of Renaissance from the given Stream */
    public static Renaissance parse(java.io.InputStream inpt) throws scg.ParseException{
    	return instance;
    }
    /** Parse an instance of Renaissance from the given Reader */
    public static Renaissance parse(java.io.Reader inpt) throws scg.ParseException{
    	return instance;
    }

 	@Override
	public String toString() {
		return "";
	}

	@Override
	public double getResult(Claim claim, SolutionI[] solutions,
			InstanceI[] instances) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Please change the below 2 methods for this protocol
	public boolean strengthenP(Claim oldClaim, Claim strengthenedClaim){
		return strengthenedClaim.getQuality() < oldClaim.getQuality();
	}
	
	public double getStrengthenedClaimQuality(double quality, double minStrengthening) {
		return quality - minStrengthening;
	}
}