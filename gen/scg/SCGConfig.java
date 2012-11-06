// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import java.io.Serializable;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of SCGConfig */
public class SCGConfig implements Serializable{
	transient protected FullyQualifiedClassName domain;
    transient protected Cons<FullyQualifiedClassName> protocols;
    transient protected TournamentStyle tournamentStyle;
    protected int turnDuration;
    protected int maxNumAvatars;
    protected double minStrengthening;
    protected double initialReputation;
    protected double maxReputation;
    protected double reputationFactor;
    protected int minProposals;
    protected int maxProposals;
    protected int numRounds;
    protected boolean proposedClaimMustBeNew;
    protected double minConfidence;
    protected boolean isPersistentPlayground;
    protected int numOfTournamentRounds;

    /** Construct a(n) SCGConfig Instance */
    public SCGConfig(FullyQualifiedClassName domain, Cons<FullyQualifiedClassName> protocols, TournamentStyle tournamentStyle, int turnDuration, int maxNumAvatars, double minStrengthening, double initialReputation, double maxReputation, double reputationFactor, int minProposals, int maxProposals, int numRounds, boolean proposedClaimMustBeNew, double minConfidence, boolean isPersistentPlayground, int numOfTournamentRounds){
        this.domain = domain;
        this.protocols = protocols;
        this.tournamentStyle = tournamentStyle;
        this.turnDuration = turnDuration;
        this.maxNumAvatars = maxNumAvatars;
        this.minStrengthening = minStrengthening;
        this.initialReputation = initialReputation;
        this.maxReputation = maxReputation;
        this.reputationFactor = reputationFactor;
        this.minProposals = minProposals;
        this.maxProposals = maxProposals;
        this.numRounds = numRounds;
        this.proposedClaimMustBeNew = proposedClaimMustBeNew;
        this.minConfidence = minConfidence;
        this.isPersistentPlayground = isPersistentPlayground;
        this.numOfTournamentRounds = numOfTournamentRounds;
    }
   
			
	/** Is the given object Equal to this SCGConfig? */
    public boolean equals(Object o){
        if(!(o instanceof SCGConfig))return false;
        if(o == this)return true;
        SCGConfig oo = (SCGConfig)o;
        return (((Object)domain).equals(oo.domain))&&(((Object)protocols).equals(oo.protocols))&&(((Object)tournamentStyle).equals(oo.tournamentStyle))&&(((Object)turnDuration).equals(oo.turnDuration))&&(((Object)maxNumAvatars).equals(oo.maxNumAvatars))&&(((Object)minStrengthening).equals(oo.minStrengthening))&&(((Object)initialReputation).equals(oo.initialReputation))&&(((Object)maxReputation).equals(oo.maxReputation))&&(((Object)reputationFactor).equals(oo.reputationFactor))&&(((Object)minProposals).equals(oo.minProposals))&&(((Object)maxProposals).equals(oo.maxProposals))&&(((Object)numRounds).equals(oo.numRounds))&&(((Object)proposedClaimMustBeNew).equals(oo.proposedClaimMustBeNew))&&(((Object)minConfidence).equals(oo.minConfidence))&&(((Object)isPersistentPlayground).equals(oo.isPersistentPlayground))&&(((Object)numOfTournamentRounds).equals(oo.numOfTournamentRounds));
    }
    /** Parse an instance of SCGConfig from the given String */
    public static SCGConfig parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_SCGConfig();
    }
    /** Parse an instance of SCGConfig from the given Stream */
    public static SCGConfig parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SCGConfig();
    }
    /** Parse an instance of SCGConfig from the given Reader */
    public static SCGConfig parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SCGConfig();
    }

    /** Field Class for SCGConfig.domain */
    public static class domain extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.protocols */
    public static class protocols extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.tournamentStyle */
    public static class tournamentStyle extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.turnDuration */
    public static class turnDuration extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.maxNumAvatars */
    public static class maxNumAvatars extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.minStrengthening */
    public static class minStrengthening extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.initialReputation */
    public static class initialReputation extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.maxReputation */
    public static class maxReputation extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.reputationFactor */
    public static class reputationFactor extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.minProposals */
    public static class minProposals extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.maxProposals */
    public static class maxProposals extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.numRounds */
    public static class numRounds extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.proposedClaimMustBeNew */
    public static class proposedClaimMustBeNew extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.minConfidence */
    public static class minConfidence extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.isPersistentPlayground */
    public static class isPersistentPlayground extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for SCGConfig.numOfTournamentRounds */
    public static class numOfTournamentRounds extends edu.neu.ccs.demeterf.Fields.any{}

	private static SCGConfig DEFAULT_SCG_CONFIG;
	static{
			try{
			DEFAULT_SCG_CONFIG = SCGConfig.parse( 
				"scg_config[\n" +
				"domain: hsr.HSRDomain\n" +
				"protocols: scg.protocol.ForAllExists scg.protocol.ExistsForAll\n" +
				"tournamentStyle: full round-robin\n" +
				"turnDuration: 60 //seconds\n" +
				"maxNumAvatars: 20\n" +
				"minStrengthening: 0.01\n" +
				"initialReputation: 100.0\n" +
				"maxReputation: 1000.0\n" +
				"reputationFactor: 0.4\n" +
				"minProposals: 2\n" +
				"maxProposals: 5\n" +
				"numRounds: 9\n" +
				"proposedClaimMustBeNew: true\n" +
				"minConfidence: 0.01\n" +
				"isPersistentPlayground: false\n" +
				"numOfTournamentRounds: 0\n" +
				"]\n"
			);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static SCGConfig getDefaultSCGConfig(){
		return SCGConfig.DEFAULT_SCG_CONFIG;
	}

    /** DGP method from Class Display */
    public String display(){ return scg.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return scg.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return scg.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return scg.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return scg.HashCode.HashCodeM(this); }
    /** Setter for field SCGConfig.domain */
    public void setDomain(FullyQualifiedClassName _domain){ domain = _domain; }
    /** Setter for field SCGConfig.protocols */
    public void setProtocols(Cons<FullyQualifiedClassName> _protocols){ protocols = _protocols; }
    /** Setter for field SCGConfig.tournamentStyle */
    public void setTournamentStyle(TournamentStyle _tournamentStyle){ tournamentStyle = _tournamentStyle; }
    /** Setter for field SCGConfig.turnDuration */
    public void setTurnDuration(int _turnDuration){ turnDuration = _turnDuration; }
    /** Setter for field SCGConfig.maxNumAvatars */
    public void setMaxNumAvatars(int _maxNumAvatars){ maxNumAvatars = _maxNumAvatars; }
    /** Setter for field SCGConfig.minStrengthening */
    public void setMinStrengthening(double _minStrengthening){ minStrengthening = _minStrengthening; }
    /** Setter for field SCGConfig.initialReputation */
    public void setInitialReputation(double _initialReputation){ initialReputation = _initialReputation; }
    /** Setter for field SCGConfig.maxReputation */
    public void setMaxReputation(double _maxReputation){ maxReputation = _maxReputation; }
    /** Setter for field SCGConfig.reputationFactor */
    public void setReputationFactor(double _reputationFactor){ reputationFactor = _reputationFactor; }
    /** Setter for field SCGConfig.minProposals */
    public void setMinProposals(int _minProposals){ minProposals = _minProposals; }
    /** Setter for field SCGConfig.maxProposals */
    public void setMaxProposals(int _maxProposals){ maxProposals = _maxProposals; }
    /** Setter for field SCGConfig.numRounds */
    public void setNumRounds(int _numRounds){ numRounds = _numRounds; }
    /** Setter for field SCGConfig.proposedClaimMustBeNew */
    public void setProposedClaimMustBeNew(boolean _proposedClaimMustBeNew){ proposedClaimMustBeNew = _proposedClaimMustBeNew; }
    /** Setter for field SCGConfig.minConfidence */
    public void setMinConfidence(double _minConfidence){ minConfidence = _minConfidence; }
    /** Setter for field SCGConfig.isPersistentPlayground */
    public void setIsPersistentPlayground(boolean _isPersistentPlayground){ isPersistentPlayground = _isPersistentPlayground; }
    /** Setter for field SCGConfig.numOfTournamentRounds */
    public void setNumOfTournamentRounds(int _numOfTournamentRounds){ numOfTournamentRounds = _numOfTournamentRounds; }
    /** Getter for field SCGConfig.domain */
    public FullyQualifiedClassName getDomain(){ return domain; }
    /** Getter for field SCGConfig.protocols */
    public Cons<FullyQualifiedClassName> getProtocols(){ return protocols; }
    /** Getter for field SCGConfig.tournamentStyle */
    public TournamentStyle getTournamentStyle(){ return tournamentStyle; }
    /** Getter for field SCGConfig.turnDuration */
    public int getTurnDuration(){ return turnDuration; }
    /** Getter for field SCGConfig.maxNumAvatars */
    public int getMaxNumAvatars(){ return maxNumAvatars; }
    /** Getter for field SCGConfig.minStrengthening */
    public double getMinStrengthening(){ return minStrengthening; }
    /** Getter for field SCGConfig.initialReputation */
    public double getInitialReputation(){ return initialReputation; }
    /** Getter for field SCGConfig.maxReputation */
    public double getMaxReputation(){ return maxReputation; }
    /** Getter for field SCGConfig.reputationFactor */
    public double getReputationFactor(){ return reputationFactor; }
    /** Getter for field SCGConfig.minProposals */
    public int getMinProposals(){ return minProposals; }
    /** Getter for field SCGConfig.maxProposals */
    public int getMaxProposals(){ return maxProposals; }
    /** Getter for field SCGConfig.numRounds */
    public int getNumRounds(){ return numRounds; }
    /** Getter for field SCGConfig.proposedClaimMustBeNew */
    public boolean getProposedClaimMustBeNew(){ return proposedClaimMustBeNew; }
    /** Getter for field SCGConfig.minConfidence */
    public double getMinConfidence(){ return minConfidence; }
    /** Getter for field SCGConfig.isPersistentPlayground */
    public boolean getIsPersistentPlayground(){ return isPersistentPlayground; }
    /** Getter for field SCGConfig.numOfTournamentRounds */
    public int getNumOfTournamentRounds(){ return numOfTournamentRounds; }

}


