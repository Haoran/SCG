package scg.net.avatar;

import java.io.FileReader;
import java.io.IOException;

import mmg.MMGConfig;
import mmg.avatar.MMGAvatar;

import scg.AvatarI;
import scg.Config;
import scg.Constants;
import scg.SCGConfig;
import scg.logging.Logger;

/** Main Player Class, Registers a player, and sets up a server */
public class PlayerMainMMG {
	private static final int DEFAULT_PORT = 8888;

	/** logger instance for the player */
	private static scg.logging.Logger log;

	/** Run the Player... */
	public static void main(String[] argArr) throws Exception {
		if (argArr.length < 7) {
			System.err
					.println("Usage: java scg.net.avatar.PlayerMain <listen port> <scg server> <team name> <password> <id> <scgconfigfile> <domainfile>");
			System.exit(1);
		}
		try {
			log = Logger.text(System.out, scg.Util.logFileName("player"));
			// MMG
			SCGConfig scgConfig = SCGConfig.parse(new FileReader(argArr[5]));
			Config cfg;
			if (argArr[6].equals("./Playgroundconfig/mmgDomain.txt")) {
				MMGConfig domainConfig = MMGConfig.parse(new FileReader(
						argArr[6]));
				cfg = new Config(scgConfig, domainConfig);
			}  else {
				System.out.println("get the default config");
				cfg = MMGConfig.getDefaultConfig();
			}

			AvatarI a = new MMGAvatar(cfg);
			// PlayerServer.run(cfg, DEFAULT_PORT, log, a);
			int port = Integer.parseInt(argArr[0]);
			int tid = Integer.parseInt(argArr[4]);
			Register register = new Register(port, Constants.DEF_REG_PORT,
					argArr[1], argArr[2], argArr[3], tid, log);
			register.doRegister();
			PlayerServer.run(cfg, port, log, a);
		} catch (IOException ie) {
			log.error("IOException: " + ie.getMessage());
		}
		log.notify("Player Shutdown");
	}
}
