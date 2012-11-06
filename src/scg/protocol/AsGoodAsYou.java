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

public class AsGoodAsYou extends DRYClass{

	private static ProtocolSpec PROTOCOL_SPEC;

	@Override
	public boolean compareQuality(Double bobSolutionQuality,
			Double aliceSolutionQuality) {
		// As good, so  quality can be equal or greater.
		if(bobSolutionQuality >= aliceSolutionQuality)
			return true;
		else
			return false;
	}

	public ProtocolSpec getProtocolSpec(){
		return AsGoodAsYou.PROTOCOL_SPEC; 
	}

	private static AsGoodAsYou instance = new AsGoodAsYou();	

	public static AsGoodAsYou getInstance() {
		return instance;
	}

	public AsGoodAsYou(){ }    
	/** Parse an instance of NegativeSecret from the given String */
	public static AsGoodAsYou parse(String inpt) throws scg.ParseException{
		return instance;
	}
	/** Parse an instance of NegativeSecret from the given Stream */
	public static AsGoodAsYou parse(java.io.InputStream inpt) throws scg.ParseException{
		return instance;
	}
	/** Parse an instance of NegativeSecret from the given Reader */
	public static AsGoodAsYou parse(java.io.Reader inpt) throws scg.ParseException{
		return instance;
	}


}


