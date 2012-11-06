// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;



/** Interface representation of ProtocolI */
public interface ProtocolI{

	double getResult(Claim claim, SolutionI[] solutions, InstanceI[] instances);
	ProtocolSpec getProtocolSpec();
	boolean strengthenP(Claim oldClaim, Claim strengthenedClaim);
	double getStrengthenedClaimQuality(double quality, double minStrengthening);
	

}


