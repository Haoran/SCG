// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;



/** Interface representation of AvatarI */
public interface AvatarI{

	public List<Claim> propose(List<Claim> forbiddenClaims);
	public List<OpposeAction> oppose(List<Claim> claimsToBeOpposed);
	public InstanceI provide(Claim claimToBeProvided);
	public SolutionI solve(SolveRequest solveRequest);

}


