package scg.net.avatar;

import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;

import scg.logging.Logger;
import scg.Constants;
import scg.net.PlayerSpec;
import edu.neu.ccs.demeterf.lib.List;
import edu.neu.ccs.demeterf.lib.Map;
import edu.neu.ccs.demeterf.util.CLI;
import edu.neu.ccs.demeterf.util.Util;

/** Register a Player with the Administrator */
public class Register {

    /** The Registration Server Address, e.g., "blaster.ccs.neu.edu" */
    String regServer;
    /** The Registration Server Port */
    int regPort, playerPort;
    /** Tournament ID */
    int tid;
    /** A logger instance */
    Logger log;
    String teamName, pass;
    
    /** Construct a PlayerMain */
    Register(int playerPort, int regPort, String regServer, String teamName, String pass, int tid, Logger log) {
        this.playerPort = playerPort;
    	this.regServer = regServer;
        this.regPort = regPort;
        this.teamName = teamName;
        this.pass = pass;
        this.log = log;
        this.tid = tid;
//      regPort = Constants.DEF_REG_PORT;
    }

    /** Print usage information and Quit */
    static void usage(String err){
        System.err.println("\n !! " + err + "\n\n" + " ** usage: java Register <PlayerPort> <RegServerAddr> "
                + "<TeamName> <Password> <TournamentID>\n\n" + " Typical Usage(s) will be:\n"
                + "    java player.Register 7000 aurail.ccs.neu.edu:8000 \"MyTeam\" \"MyPass\" 42\n"
                + "    java player.Register 7000 aurail.ccs.neu.edu \"MyTeam\" \"MyPass\" 42\n");
        System.exit(1);
    }

    /** Register a Player... */
    public static void main(String[] argArr) throws Exception{
        List<String> args = CLI.splitArgs(argArr)[CLI.ARGS];
        if (args.length() != 5) {
            usage("Not enough mandatory arguments");
            return;
        }
        // Port the Player will be waiting on
        int port = Integer.parseInt(args.lookup(0));
        int regPort = Integer.parseInt(args.lookup(1));
        String regServer = args.lookup(2), teamName = args.lookup(3), pass = args.lookup(4);
        int tid = Integer.parseInt(args.lookup(5));

        // Setup a logger to StdOut, and a file
        Logger log = Logger.text(System.out, scg.Util.logFileName("player"));

        // New register instance
        Register reg = new Register(port, regPort, regServer, teamName, pass, tid, log);
        // If registration fails, just exit
        if (!reg.doRegister()) {
            log.shutdown();
            System.exit(1);
        }
        // Otherwise, Success!
        log.event("Player '" + teamName + "' Registered Successfully");
        log.shutdown();
    }

    /** Register this Player with the Administrator's registration server */
    public HTTPResp register() throws Exception {
        String URL = Constants.REG_PATH_ENTRY + "?" + Constants.PASS_URL_ARG + "=" + scg.Util.encrypt(pass) + "&" + Constants.TOURNAMENT_URL_ARG + "=" + tid;
        System.out.println(URL);
//        String URL = Constants.REG_PATH_ENTRY + "?" + Constants.PASS_URL_ARG + "=" + pass;
        HTTPResp res = HTTPReq.Post(URL, "" + new PlayerSpec(this.teamName, Constants.REG_AUTO, this.playerPort)).send(regServer, regPort);
        return res;
    }

    /** Try to signUp the player, and check the response */
    boolean doRegister(){
        try {
            // Check the registration
            HTTPResp res = register();
            // Error response
            if (res.isError()) {
                log.error("Couldn't Register Team '" + this.teamName + "' with Password '" + pass + "'");
                Map<String, String> headers = res.getHeaders();
                // See if the Server identified itself...
                if (headers.containsKey(Constants.SERVER_KEY)) {
                    String server = headers.get(Constants.SERVER_KEY);
                    if (server.equals(Constants.ADMIN_SERVER_NAME))
                        log.error("Reason: " + res.getBody());
                    else
                        log.error("Unknown Server Type: " + server);
                }
                return false;
            }
            return (res.isOK() && res.getBodyString().equals(this.teamName));
        } catch (Exception e) {
            // Exception means the socket was bad
            log.error("Error Registering Player '" + this.teamName + "'");
            log.error("Reason: " + e);
            e.printStackTrace();
            return false;
        }
    }
}
