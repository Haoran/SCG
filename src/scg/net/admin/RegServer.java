package scg.net.admin;

import edu.neu.ccs.demeterf.http.classes.*;
import edu.neu.ccs.demeterf.http.server.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;


import scg.exception.AuthenticationException;
import scg.exception.ConnectionException;
import scg.logging.Logger;
import scg.Util;
import scg.Constants;
import scg.net.ParseException;
import scg.net.PlayerSpec;
import scg.tournament.TournamentManager;
import scg.tournament.TournamentSetup;

import edu.neu.ccs.demeterf.lib.List;
import edu.neu.ccs.demeterf.lib.Map;
import edu.neu.ccs.demeterf.lib.Option;
import edu.neu.ccs.demeterf.util.CLI;

/**
 * Player/Competition Registration Server. Waits for registration requests, and
 * responds accordingly.
 * <p>
 * The registration protocol is as follows:
 * <ul>
 * <li>The Player sends a {@link scg.gen.PlayerSpec PlayerSpec} as the body of
 * a POST to the RegServer, including a URL argument.</li>
 * <li>The full URL request will be: <quote>
 * <tt>RegServer.PATH_ENTRY+"?"+RegServer.PASS_URL_ARG+"="+PASSWORD</tt>
 *        </quote>
 *        where <tt>PASSWORD</tt> is the Player/Team password as registered with
 *        the Teaching Staff (to be described separately).</li>
 *    <li>If registration succeeds, an HTTP Response with code 200 (OK) will be
 *        sent back, with a short the Player's name as a body.<li>
 *  </ul>
 *  </p>
 */
@Server
public class RegServer extends scg.HTML {

    /** Listening (incoming) Port */
    @Port
    private int port;
    /** Max Message Size, 1K should do */
    @MaxMessageSize
    private int maxMessage = 1024;

    private final TournamentManager tournaments;
    /** Logger for the Registration Process */
    private final Logger log;

    public RegServer(TournamentManager tm, Logger l) {
        this(tm, l, Constants.DEF_REG_PORT);
    }

    public RegServer(TournamentManager tm, Logger l, int p) {
        tournaments = tm;
        port = p;
        log = l;
    }

    /** Handle any Exceptions prior to dispatch */
    @ExceptionHandler
    public HTTPResp exception(Exception e, Socket s){
        //Throwable t = Util.rootCause(e);
        //log.error("Request/Response Exception ["+t.getClass().getSimpleName()+"] from ["+s.getInetAddress()+"]");
        return null; //errTextResp("", "");
    }

    /** Main URL handler for the RegServer */
    @Path(Constants.REG_PATH_ENTRY)
    public synchronized HTTPResp registerResp(HTTPReq req, Socket sock){
        log.event("Registration Request from: " + sock.getInetAddress());
        PlayerSpec spec;
        try {
            spec = PlayerSpec.parse(req.getBodyString());
            if (spec.getAddress().equals(Constants.REG_AUTO)) {
                spec = spec.changeAddress(sock.getInetAddress().getHostAddress());
            }
        } catch (ParseException pe) {
            return errTextResp("Parse Error", log.error("Error Parsing Registration (gen.PlayerSpec)"));
        }
        Map<String, String> args = req.urlArgs();
        if (!args.containsKey(Constants.PASS_URL_ARG)) {
            return errTextResp("Missing Argument", log.error("No Password Given"));
        }
        if (!args.containsKey(Constants.TOURNAMENT_URL_ARG)) {
            return errTextResp("Missing Argument", log.error("No tournament id given"));
        }
        int tid;
        try {
            tid = Integer.parseInt(args.get(Constants.TOURNAMENT_URL_ARG));
        } catch (NumberFormatException e) {
            return errTextResp("Invalid tourament id", log.error("Invalid tournament id '"+args.get(Constants.TOURNAMENT_URL_ARG)+"'"));
        }
        TournamentSetup t = tournaments.getTournament(tid);
        try {
            t.registerPlayer(spec, args.get(Constants.PASS_URL_ARG));
        }
        catch (ConnectionException e) {
            return errTextResp("Cannot register for tournament", log.error(e.getMessage()));
        }
        catch (AuthenticationException e) {
            return errTextResp("Invalid authentication", log.error(e.getMessage()));
        }
        String message = "Player '" + spec.getName() + "' ";
        log.notify("Registering '" + spec.getName() + "' at " + spec.getAddress() + ":" + spec.getPort());
        log.event(message + "has been Registered");
        return okTextResp("You have been successfully registered");
    }
}
