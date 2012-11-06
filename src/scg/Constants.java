package scg;

public interface Constants {

    /** Path the RegServer Listens On */
    public static final String REG_PATH_ENTRY = "/register";
    /** Path the Player Listens On */
    public static final String PLAYER_PATH_ENTRY = "/src/scg/net/avatar";
    /** Default Registration Port */
    public static final int DEF_REG_PORT = 7005;
    /** Default Admin Status Port */
    public static final int DEF_STAT_PORT = 7007;
    /** Number of minutes prior to tournamnet start that registration is allowed **/
    public static final int REGISTRATION_WINDOW = 90;
    /** Game Revision Number */
    //public static final String REV = scg.game.Game.REV;
    /**
     * Used for automatic Player Address Registration, Pulled from the Socket
     * over which registration is done.
     */
    public static final String REG_AUTO = "auto";

    // FILES
    /** Hashed Passwords File */
    public static final String FILES_PATH = "files/";
    public static final String PASS_FILE = FILES_PATH +  "passwords.pwd";
    /** Players File... the result of running standalone Registration */
    public static final String PLAYERS_FILE = FILES_PATH + "players.txt";
    /** Hashed Passwords File */
    public static final String PREPASS_FILE = FILES_PATH + "passwords.txt";
    /** Team Members File */
    public static final String PRETEAM_FILE = FILES_PATH + "teams.txt";

    /** Admin History output file prefix */
    public static final String HISTORY_FILE_PREFIX = "history";
    public static final String MAIN_HISTORY_FOLDER = "history";
    public static final String RAW_HISTORY_FOLDER = "history";
    public static final String SMART_HISTORY_FOLDER = "smartHistory";
    /** Plain text files... */
    public static final String HISTORY_FILE_SUFFIX = ".txt";
    /** Admin configuration file */
    public static final String CONFIG_FILE = FILES_PATH + "config.txt";

    /** Password Argument Name */
    public static final String PASS_URL_ARG = "password";
    /** Tournamend ID Name */
    public static final String TOURNAMENT_URL_ARG = "tournament";

    /** Server HTTP Header Key */
    public static final String SERVER_KEY = "Server";
    /** Admin's Reg/PreReg server name for HTTP headers */
    public static final String ADMIN_SERVER_NAME = "SCGAdmin";
    
    /** Alice wins */
    public static final double ALICE_WIN = 1;
    /** Bob wins */
    public static final double BOB_WIN = -1;
    /** Draw */
    public static final double DRAW = 0;
    
}
