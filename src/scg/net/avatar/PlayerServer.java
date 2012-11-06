package scg.net.avatar;

import edu.neu.ccs.demeterf.http.classes.*;
import edu.neu.ccs.demeterf.http.server.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import response.ResponseGetter;
import scg.logging.Logger;
import scg.AvatarI;
import scg.Config;
import scg.Response;
import scg.Util;
import edu.neu.ccs.demeterf.lib.*;

@Server
public class PlayerServer {

	/** Path the player server listens for */
	public static final String EntryPath = "/src/scg/net/avatar";
	/** Receives a competition "start" message at this path */
	public static final String StartPath = "/start";
	/** Receives a competition "end" message at this path */
	public static final String EndPath = "/end";
	/** Default port for the Player */
	public static final int DEFAULT_PORT = 8000;
	public static long startTime = 0;
	private final Config config;
	/** Port number for this player instance */
	@Port
	protected final int port;
	/** logger instance for the player */
	private final Logger log;
	/** Avatar in this PlayerServer */
	private final AvatarI avatar;
	
	public PlayerServer(Config c, Logger l, AvatarI a) {
		this(c, DEFAULT_PORT, l, a);
	}
	
	public PlayerServer(Config c, int p, Logger l, AvatarI a) {
		config = c;
		port = p;
		log = l;
		avatar = a;
		
	}

	/** Handle an Admin request at the EntryPath */
	/** Modified by Astro */
	@Path(EntryPath)
	public HTTPResp playerResponse(HTTPReq req) {
		System.out.println("GET REQUEST11111");
		try {
			long turnStart = System.currentTimeMillis();
			startTime = (long) (System.currentTimeMillis() / 1000.0);
			ResponseGetter resGetter = new ResponseGetter();
			Response avatarResp =  resGetter.getResponse(req.getBodyString(), avatar);
			HTTPResp resp = createResponse(avatarResp);
			log.notify("Turn Completed: " + Util.format((System.currentTimeMillis() - turnStart) / 1000.0) + " sec");
			return resp;
		} catch (Exception e) {
			// Error Creating the Player's Context
			log.error("Exception: " + e.getMessage());
			log.error("StackTrace:");
			for (StackTraceElement se : Util.rootCause(e).getStackTrace())
				log.notify(se.toString());
			return HTTPResp.textError("" + e);
		}
	}

	/** Handle an Admin competition "start" message */
	@Path(StartPath)
	public HTTPResp startResponse(HTTPReq req) {
		return HTTPResp.textResponse("OK");
	}

	/** Handle an Admin competition "end" message */
	@Path(EndPath)
	public HTTPResp endResponse(HTTPReq req) {
		return HTTPResp.textResponse("OK");
	}

	/** Default Handler for other paths */
	@Path
	public HTTPResp defaultResponse() {
		return HTTPResp.textError("Unknown Request");
	}

	/** Formulate a player response for a given Request */
	public HTTPResp createResponse(Response avatarResp) {
		
		// modified Response.toString ("propose" -> "propose ")
		return HTTPResp.textResponse(avatarResp.toString());
	}
	
	/** Clear message for Linux terminals */
	static String clearer = List.create(0x1b, 0x5b, 0x48, 0x1b, 0x5b, 0x32,
			0x4a, 0x00).map(new List.Map<Integer, Character>() {
		public Character map(Integer i) {
			return (char) (int) i;
		}
	}).toString("", "");

	/** Main method to run the PlayerServer. Will be called by Player Main. */
	public static void run(Config c, int port, Logger log, AvatarI a)
			throws IOException {
		// Create a new Server
		ServerThread server = Factory.create(new PlayerServer(c, port, log, a));

		// Buffer text from the terminal
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inpt = "";
		do {
			System.out.print("\n ** Type 'exit' to shutdown: ");
			System.out.flush();
			inpt = input.readLine().trim();
			// Respond to (limited) input commands
			if (inpt.equals("clear"))
				System.err.print(clearer);
			//if (inpt.equals("finalprefs"))
				//Tools.printPrefs();
		} while (!inpt.equals("exit"));
		log.event("Shutting down Player Server");
		// Kill the PlayerServer thread
		server.shutdown();
	}
}
