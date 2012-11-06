package scg.net.admin;

import hsr.HSRConfig;
import scg.Config;
import scg.game.BinaryGame;
import scg.net.PlayerSpec;
import edu.neu.ccs.demeterf.http.classes.ParseException;

public class TestAdminMain {
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		PlayerSpec playerSpec = new PlayerSpec("Basic", "localhost", 8887);
		RemotePlayerProxy rpp1 = new RemotePlayerProxy(playerSpec, 6000000, 100);
		
		PlayerSpec playerSpec2 = new PlayerSpec("Smart", "localhost", 8888);
		RemotePlayerProxy rpp2 = new RemotePlayerProxy(playerSpec2, 6000000, 100);
	
	}
}
