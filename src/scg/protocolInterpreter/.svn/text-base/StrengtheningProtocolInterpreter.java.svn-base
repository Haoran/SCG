package scg.protocolInterpreter;

import scg.Claim;
import scg.ProtocolRequest;
import scg.ProvideAction;
import scg.SolveAction;
import scg.Step;
import scg.net.admin.RemotePlayerProxy;

public class StrengtheningProtocolInterpreter extends ProtocolInterpreter{
	
	Claim originalClaim;
	
	public StrengtheningProtocolInterpreter(RemotePlayerProxy alice,
			RemotePlayerProxy bob,Claim strengthenedClaim, Claim originalClaim) {
		super(alice, false /* Reputations are always updated*/, bob, strengthenedClaim);
		this.originalClaim = originalClaim;
	}

	public void proceed() {
		if (!claim.getProtocol().strengthenP(originalClaim, claim)) {
			updateReputation(0, 1); // Alice wins
		} else {
			if (currentStepIndex < numberOfSteps) {
				ProtocolRequest protocolRequest = null;
				Step currentStep = steps.lookup(currentStepIndex);
				RemotePlayerProxy player = players[currentStep.getRole()
						.ordingal()];
				if (currentStep.getAction() instanceof ProvideAction) {
					protocolRequest = getRequest(claim);
				} else if (currentStep.getAction() instanceof SolveAction) {
					protocolRequest = getRequest(instances[0]);
				}
				player.addProtocolRequest(protocolRequest);
				currentStepIndex++;
			} else {
				double result = getResult();
				if (result == -1) { // Bob Wins
					updateReputation(1, Math.abs(this.claim.getQuality()
							- this.originalClaim.getQuality()));
				} else if (result == 1) { // Alice Wins
					updateReputation(0, result);
				}
				currentStepIndex++;
			}
		}
	}
}