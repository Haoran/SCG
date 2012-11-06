package scg.net.avatar;

import hsr.HSRConfig;
import hsr.avatar.HSRAvatar;

import java.io.IOException;

import scg.AvatarI;
import scg.Config;
import scg.logging.Logger;

public class TestPlayerMainII {
    private static final int DEFAULT_PORT = 8888;
    /** logger instance for the player */
    private static scg.logging.Logger log;

    /** Run the Player... */
    public static void main(String[] argArr) throws Exception{
        try {
            log = Logger.text(System.out, scg.Util.logFileName("player"));
            Config cfg = HSRConfig.getDefaultConfig();
            AvatarI b = new HSRAvatar(cfg);
//            Config cfg = CSPConfig.getDefaultConfig();
//            AvatarI b = new CSPAvatarSmart(cfg);
            // test avatar without registration
            PlayerServer.run(cfg, DEFAULT_PORT, log, b);
        } catch (IOException ie) {
            log.error("IOException: " + ie.getMessage());
        }
        log.notify("Player Shutdown");
    }
}
