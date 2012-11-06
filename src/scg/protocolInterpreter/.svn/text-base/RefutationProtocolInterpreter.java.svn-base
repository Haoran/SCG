package scg.protocolInterpreter;

import scg.Claim;
import scg.net.admin.RemotePlayerProxy;

public class RefutationProtocolInterpreter extends ProtocolInterpreter {
	
	public RefutationProtocolInterpreter(RemotePlayerProxy alice, boolean updateReputationsOnlyWhenBobWins,
			RemotePlayerProxy bob,Claim claim) {
		super(alice, updateReputationsOnlyWhenBobWins, bob, claim);
	}
	public RefutationProtocolInterpreter(RemotePlayerProxy alice,
			RemotePlayerProxy bob,Claim claim) {
		super(alice, false /* reputations are always updated*/, bob, claim);
	}
}