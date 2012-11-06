package scg.protocolInterpreter;

import scg.Action;
import scg.Claim;
import scg.InstanceI;
import scg.ProtocolI;
import scg.ProtocolRequest;
import scg.ProtocolSpec;
import scg.ProvideAction;
import scg.ProvideRequest;
import scg.SolutionI;
import scg.SolveAction;
import scg.SolveRequest;
import scg.Step;
import scg.net.admin.RemotePlayerProxy;
import edu.neu.ccs.demeterf.lib.List;
import edu.neu.ccs.demeterf.lib.Some;


public class ProtocolInterpreter {
	protected final Claim claim;
	protected final RemotePlayerProxy[] players;
	protected final ProtocolI protocol;
	protected final ProtocolSpec protocolSpec;
	protected final List<Step> steps;
	protected int numberOfSteps;
	protected String winner="";
	protected double pointsWon = 0.0;

	// State Variables
	protected int currentStepIndex = 0;
	protected InstanceI[] instances;
	int instanceIndex = 0;
	protected SolutionI[] solutions;
	int solutionIndex = 0;
	
	// A flag that prevents reputations from being changed when Bob wins
	// should the refutation protocol be used to implement agreement.
	final boolean updateReputationsOnlyWhenBobLoses;
	
//	public ProtocolInterpreter(RemotePlayerProxy alice, RemotePlayerProxy bob, Claim claim) {
//		this(alice, true, bob, claim);
//	}
	
	public ProtocolInterpreter(RemotePlayerProxy alice, boolean updateReputationsOnlyWhenBobLoses, RemotePlayerProxy bob, Claim claim) {
		this.updateReputationsOnlyWhenBobLoses = updateReputationsOnlyWhenBobLoses;
		this.claim = claim;
		this.players = new RemotePlayerProxy[]{alice, bob};
		this.protocol = claim.getProtocol();
		this.protocolSpec = protocol.getProtocolSpec();
		this.steps = protocolSpec.getSteps();
		this.numberOfSteps = steps.length();
		instances = new InstanceI[getNoOfObjectTypeInProtocol("instance")];
		solutions = new SolutionI[getNoOfObjectTypeInProtocol("solution")];
	}

	public int getNoOfObjectTypeInProtocol(String objectType) {
		int tempcurrentStepIndex = 0;
		int retnVal = 0;
		for(;tempcurrentStepIndex < numberOfSteps; tempcurrentStepIndex++) {
			Step currentStep = steps.lookup(tempcurrentStepIndex);
			Action currentAction = currentStep.getAction();
			if(objectType.equals("instance")) {
				if(currentAction instanceof ProvideAction){
					retnVal++;
				}
			}
			if(objectType.equals("solution")) {
				if(currentAction instanceof SolveAction){
					retnVal++;
				}
			}
		}
		return retnVal;
	}
	
	public int getCurrentIndex() {
		return currentStepIndex;
	}
	
	public void setInstance(InstanceI instance) {
		try {
		instances[instanceIndex++] = instance;
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	public void setSolution(SolutionI solution) {
		solutions[solutionIndex++] = solution;
	}

	public boolean isComplete() {
		return currentStepIndex > numberOfSteps;
	}
	
	public void proceed() {
		System.out.println("in proceed function");
		System.out.println(currentStepIndex);
		System.out.println(numberOfSteps);
		if(currentStepIndex < numberOfSteps) {
			ProtocolRequest protocolRequest = null;
			Step currentStep = steps.lookup(currentStepIndex);
			RemotePlayerProxy player = players[currentStep.getRole().ordingal()];
			if(currentStep.getAction() instanceof ProvideAction) {
				protocolRequest = getRequest(claim);
			} else if(currentStep.getAction() instanceof SolveAction) {
				protocolRequest	= getRequest(instances[0]);
			}
			player.addProtocolRequest(protocolRequest);
			currentStepIndex++;
		} else {
			System.out.println("go in to else in proceed");
			double result = getResult();
			if(result == -1)  { // Bob Wins
				updateReputation(1, result * -1);
			} else if(result == 1) {
				updateReputation(0, result);
			}
			currentStepIndex++;
		}
	}
	
	protected void updateReputation(int playerNum, double result) {
		if(updateReputationsOnlyWhenBobLoses && playerNum != 1) return;
		RemotePlayerProxy player1 = players[playerNum];
		RemotePlayerProxy player2 = players[1 - playerNum];
		double player1InitialReputation = player1.getReputation();
		double player2InitialReputation = player2.getReputation();
		players[playerNum].setReputation(players[playerNum].getReputation() + claim.getConfidence() * result);
		players[1 - playerNum].setReputation(players[1 - playerNum].getReputation() - claim.getConfidence() * result);
		double player1FinalReputation = player1.getReputation();
		double player2FinalReputation = player2.getReputation();
		if(player1FinalReputation - player1InitialReputation >= 0){
			winner = player1.getName();
			pointsWon = player1FinalReputation - player1InitialReputation;
		}else{
			winner = player2.getName();
			pointsWon = player2FinalReputation - player2InitialReputation;
		}
	}
	
	public String getWinner(){
		return winner;
	}
	
	public double getPointsWon(){
		return pointsWon;
	}
	
	public ProtocolRequest getRequest(Claim claim) {
		return new ProvideRequest(claim);
	}
	
	public ProtocolRequest getRequest(InstanceI instance) {
		return new SolveRequest(instance, new Some<Claim>(claim));
	}
	
	public double getResult() {
		System.out.println("in GetResult function");
		System.out.println(currentStepIndex);
		System.out.println(numberOfSteps);
		if(currentStepIndex < numberOfSteps) {
			throw new RuntimeException("Requesting result for unfinished protocol");
		}
		return protocol.getResult(claim, solutions, instances);
	}
}