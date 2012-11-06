package scg.net.admin;

import scg.ProtocolRequest;
import scg.net.PlayerSpec;

public interface PlayerProxyI {

	/** Get the specification for the represented Player */
    PlayerSpec getSpec();

    /** Get the player name */
    String getName();
    
	void addProtocolRequest(ProtocolRequest protocolRequest);
	
	public String getAddress();

}
