package scg.protocolInterpreter;

import java.util.HashMap;
import java.util.IdentityHashMap;

import edu.neu.ccs.demeterf.lib.List;
import scg.Claim;
import scg.ProtocolI;
import scg.net.admin.RemotePlayerProxy;
import scg.protocol.ExistsForAll;
import scg.protocol.ForAllExists;
import scg.protocol.NegativeSecret;
import scg.protocol.PositiveSecret;

@Deprecated
public class AgreementProtocolInterpreter extends ProtocolInterpreter{
	List<ProtocolInterpreter> pitList = List.<ProtocolInterpreter>create();
	double minStrengthening;
	Claim oldClaim = null;
	
	public AgreementProtocolInterpreter(RemotePlayerProxy alice, RemotePlayerProxy bob,Claim claim, double minStrengthening) {
		super(alice,true, bob, claim);
		numberOfSteps = 4;
		this.minStrengthening = minStrengthening;
	}
	
	public AgreementProtocolInterpreter(RemotePlayerProxy alice, RemotePlayerProxy bob, Claim claim) {
		super(alice, false /* reputations are always updated*/, bob, claim);
		numberOfSteps = 4;
	}

	// Changed by Madhu - from HashMap to IdentityHashMap
 	public IdentityHashMap<Claim, ProtocolInterpreter> createRpi(IdentityHashMap<Claim, ProtocolInterpreter> listOfRefutationInterpreter
 			,IdentityHashMap<Claim,Claim> newClaimOriginalClaim) {
 		ProtocolInterpreter pit = null;
 		Claim currentClaim = null;
 		if(currentStepIndex == 0) {
 			pit = new RefutationProtocolInterpreter(players[1], players[0], claim);
 			currentClaim = claim;
		} else 	if(currentStepIndex == 1) {
			// change this step to Bob refutes the negated claim
			currentClaim = new Claim(claim.getInstanceSet(), claim.getProtocol(), claim.getProtocol().getStrengthenedClaimQuality(claim.getQuality(), minStrengthening), claim.getConfidence());
			pit = new StrengtheningProtocolInterpreter(players[0], players[1], currentClaim, claim);
//			currentClaim = getNegatedClaim(claim);
//			pit = new RefutationProtocolInterpreter(players[0], players[1], currentClaim);
		} else 	if(currentStepIndex == 2) {
 			pit = new RefutationProtocolInterpreter(players[0], players[1], claim);
 			currentClaim = claim;
		} else 	if(currentStepIndex == 3) {
			// change this step to Alice refutes the negated claim
			currentClaim = new Claim(claim.getInstanceSet(), claim.getProtocol(), claim.getQuality() + minStrengthening, claim.getConfidence());
			pit = new StrengtheningProtocolInterpreter(players[1], players[0], currentClaim, claim);
//			currentClaim = getNegatedClaim(claim);
//			pit= new RefutationProtocolInterpreter(players[1], players[0], currentClaim);
		}
 		currentStepIndex++;
 		pit.proceed();
 		pitList = pitList.append(pit);
 		// bug?
        if(oldClaim != null) {
        	listOfRefutationInterpreter.remove(oldClaim);
        	Claim originalClaim = newClaimOriginalClaim.get(oldClaim);
        	newClaimOriginalClaim.remove(oldClaim);
        	newClaimOriginalClaim.put(currentClaim,originalClaim);
        }
		oldClaim = currentClaim;
 		listOfRefutationInterpreter.put(currentClaim, pit);
		return listOfRefutationInterpreter;
	}
 	
// 	private Claim getNegatedClaim(Claim oldC){
//		ProtocolI protocol = oldC.getProtocol();
//		if (protocol instanceof PositiveSecret){
//			protocol = new NegativeSecret();
//		} else if (protocol instanceof NegativeSecret) {
//			protocol = new PositiveSecret();
//		} else if (protocol instanceof ForAllExists){
//			protocol = new ExistsForAll();
//		} else {
//			protocol = new ForAllExists();
//		}
//		return new Claim(oldC.getInstanceSet(), protocol, oldC.getQuality(), oldC.getConfidence());
// 	}
	
	public boolean isComplete() {
		boolean complete = true;
		for(java.util.Iterator<ProtocolInterpreter> rpiIterator = pitList.iterator(); rpiIterator.hasNext();) {
			ProtocolInterpreter rpi = rpiIterator.next();
			complete = complete && rpi.isComplete();
		}
		return complete;
	}
	
	public boolean areAllStepsExecuted() {
		return currentStepIndex >= numberOfSteps;
	}
	
	public List<ProtocolInterpreter> getProtocolInterpreters() {
		return this.pitList;
	}
	
	public boolean checkResult() {
		int stepIndex = 0;
		for(java.util.Iterator<ProtocolInterpreter> rpiIterator = this.getProtocolInterpreters().iterator(); rpiIterator.hasNext();) {
			ProtocolInterpreter pit = rpiIterator.next();
			if(stepIndex == 0) {
				double result = pit.getResult();
				if(result != -1) {
					updateReputation(0, 1);
					return false;
				}
			} else if(stepIndex == 1) {
				double result = pit.getResult();
				if(result != -1 ) {
					updateReputation(0, 1);
					return false;
				}
			} else if(stepIndex == 2) {
				double result = pit.getResult();
				if(result != 1) { 
					updateReputation(1, 1);
					return false;
				}
			} else if(stepIndex == 3) {
				double result = pit.getResult();
				if(result != 1) {
					updateReputation(1, 1);
					return false;
				}
			}
			stepIndex++;
		}
		return true;
	}
}