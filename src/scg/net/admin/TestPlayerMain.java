package scg.net.admin;

import java.util.LinkedList;

import scg.Claim;
import scg.Config;
import scg.ProtocolRequest;
import scg.Request;
import scg.Response;
import scg.net.PlayerSpec;
import edu.neu.ccs.demeterf.http.classes.ParseException;
import edu.neu.ccs.demeterf.lib.List;


public class TestPlayerMain {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		PlayerSpec playerSpec = new PlayerSpec("test", "localhost", 8888);
		RemotePlayerProxy rpp = new RemotePlayerProxy(playerSpec, 6000000, 100);
		List<Claim> forbidden = List.create();
		List<Claim> claimsToOppose = List.create();
		List<ProtocolRequest> protocolRequests = List.create();
		Request inRequest = new Request(forbidden, claimsToOppose, protocolRequests);
	}

}
