package scg.net.avatar;

import java.io.IOException;
//import mmg.MMGConfig;
//import mmg.avatar.MMGAvatar;

import scg.AvatarI;
import scg.Config;
import scg.Constants;
import scg.logging.Logger;


/** Main Player Class, Registers a player, and sets up a server */
public class PlayerMain {
    private static final int DEFAULT_PORT = 8888;

    /** logger instance for the player */
    private static scg.logging.Logger log;

    /** Run the Player... */
    public static void main(String[] argArr) throws Exception{
        if (argArr.length < 5) {
            System.err.println("Usage: java scg.net.avatar.PlayerMain <listen port> <scg server> <team name> <password> <id>");
            System.exit(1);
        }
        try {
            log = Logger.text(System.out, scg.Util.logFileName("player"));
           // Config mmg = MMGConfig.getDefaultConfig();           
           // AvatarI a = new MMGAvatar(mmg);
            int port = Integer.parseInt(argArr[0]);
            int tid = Integer.parseInt(argArr[4]);
            Register register = new Register(port, Constants.DEF_REG_PORT, argArr[1], argArr[2], argArr[3], tid, log);
            register.doRegister();
           // PlayerServer.run(mmg, port, log, a);
        } catch (IOException ie) {
            log.error("IOException: " + ie.getMessage());
        }
        log.notify("Player Shutdown");
    }
}
