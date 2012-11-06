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

public class Survivor extends DRYClass{
	
	private static ProtocolSpec PROTOCOL_SPEC;

	
	
	@Override
	/**
	 * @authors Madhu, Karan, Sandeep
	 * Implements the getResult method 
	 * of ProtocolI
	 */
	
	public boolean compareQuality(Double bobSolutionQuality,
			Double aliceSolutionQuality) {
		// I'm the best - so quality must strictly be greater.
		if(bobSolutionQuality > aliceSolutionQuality)
			return true;
		else
			return false;
	}
	
	public ProtocolSpec getProtocolSpec(){
		return Survivor.PROTOCOL_SPEC; 
	}
	
	private static Survivor instance = new Survivor();	
	
	
    public static Survivor getInstance() {
		return instance;
	}

	public Survivor(){ }    
    /** Parse an instance of NegativeSecret from the given String */
    public static Survivor parse(String inpt) throws scg.ParseException{
    	return instance;
    }
    /** Parse an instance of NegativeSecret from the given Stream */
    public static Survivor parse(java.io.InputStream inpt) throws scg.ParseException{
    	return instance;
    }
    /** Parse an instance of NegativeSecret from the given Reader */
    public static Survivor parse(java.io.Reader inpt) throws scg.ParseException{
    	return instance;
    }


}


