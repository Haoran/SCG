package scg.net.avatar;

import hsr.HSRConfig;
import hsr.avatar.HSRAvatar;

import java.io.IOException;

import scg.AvatarI;
import scg.Config;
import scg.logging.Logger;
import csp.CSPConfig;
import csp.avatar.CSPAvatar;

public class TestPlayerMainI {
    private static final int DEFAULT_PORT = 8887;

    /** logger instance for the player */
    private static scg.logging.Logger log;

    /** Run the Player... */
    public static void main(String[] argArr) throws Exception{
        try {
            log = Logger.text(System.out, scg.Util.logFileName("player"));
            Config cfg = HSRConfig.getDefaultConfig();
            AvatarI a = new HSRAvatar(cfg);
//            Config cfg = CSPConfig.getDefaultConfig();
//            AvatarI a = new CSPAvatar(cfg);
            // test avatar without registration
            PlayerServer.run(cfg, DEFAULT_PORT, log, a);
        } catch (IOException ie) {
            log.error("IOException: " + ie.getMessage());
        }
        log.notify("Player Shutdown");
    }
}
