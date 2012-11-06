package scg.admin;

import edu.neu.ccs.demeterf.http.server.Factory;
import edu.neu.ccs.demeterf.http.server.ServerThread;



import scg.exception.AddTournamentException;
import scg.exception.NoUserExistsException;
import scg.exception.UserExistsException;
import scg.logging.Logger;
import scg.net.admin.RegServer;
import scg.tournament.TournamentManager;
import scg.tournament.Users;
import scg.web.PageDispatcher;
import scg.Util;
import scg.Constants;
import scg.Command;
import scg.AddTournament;
import scg.TournamentState;
import scg.SignUp;
import scg.ApproveUser;
import scg.RegisterPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class Admin {
  private static TournamentManager tournamentManager;
  private static Users users;

  /**
   * The main entry point to the SCG Court system
   * This main method spins up several threads:
   * 1) A TournamentManager thread which handles adjusting the status of tournaments
   * 2) The HTTP server thread
   * 3) The registration thread
   * It then spins waiting for input commands from the user, and will exit if the exit command is used.
   * @param args This parameter needs at least one element, specifying the root user password. 
   */
  public static void main(String[] args) {
    String rootPassword;
    if (args.length != 0) {
      rootPassword = args[0];
    } else {
      System.err.println("scg.admin.Admin <root password>");
      return;
    }
    Logger log;
    try {
      log = Logger.text(System.out, Util.logFileName("admin"));
    } catch (IOException e) {
      throw new RuntimeException("Unable to create logger: "+e.getMessage());
    }
    // Fire up the tournament manager
    tournamentManager = new TournamentManager();
    Thread tournamentManagerThread = new Thread(tournamentManager);
    tournamentManagerThread.start();

    users = new Users(rootPassword);

    System.out.println("PageDispatcher...");
    PageDispatcher dispatcher = new PageDispatcher(tournamentManager, users,
        Constants.DEF_STAT_PORT);
    System.out.println("ServerThread...");
    ServerThread statusServer = null;
    try {
      statusServer = Factory.create(dispatcher, false, 20);
    } catch (IOException e) {
      System.err.println("Failed to start a server thread: " + e.getMessage());
    }
    System.out.println("running...");

    RegServer regDispatch = new RegServer(tournamentManager, log);
    ServerThread regServer = null;
    try {
      regServer = Factory.create(regDispatch, false, 50);
    } catch (IOException e) {
      System.err.println("Failed to start registration server: "+e.getMessage());
    }

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String inpt = "";
    System.out.println("\n ** Type 'exit' to shutdown: ");
    try {
      while (true) {
        System.out.flush();
        inpt = input.readLine().trim();
        if (inpt.equals("exit")) {
          break;
        }
        else if(inpt.startsWith("tournament_start")){
        	try{
        	String[] inputArgs = inpt.split(" ");
        	tournamentManager.setTournamentRuntime(Integer.parseInt(inputArgs[1]), new Date());
        	} catch (Exception ex){}
        	continue;
        }
       
        Command cmd;
        try {
          cmd = Command.parse(inpt);
        } catch (scg.ParseException e) {
          invalidLine(e.getMessage(), inpt);
          continue;
        }
        if (cmd instanceof AddTournament) {
          AddTournament at = (AddTournament)cmd;
          Date time = null;
          try {
            time = runtimeToDate(at.getTime());
          } catch (NumberFormatException e) {
            invalidLine(at.getFormat(), inpt);
            continue;
          }
          try {
            tournamentManager.addTournament(at.getName(), at.getConfig(), time);
          } catch (AddTournamentException e) {
            System.out.println(e.getMessage());
          }
        } else if (cmd instanceof TournamentState) {
          tournamentManager.printState();
        } else if (cmd instanceof SignUp) {
          SignUp s = (SignUp) cmd;
          try {
            users.signup(s.getName(), s.getPassword());
          } catch (UserExistsException e) {
            System.out.println(e.getMessage());
          }
        } else if (cmd instanceof ApproveUser) {
          ApproveUser au = (ApproveUser) cmd;
          try {
            users.approveUser(au.getName());
            System.out.println(au.getName() + " approved.");
          } catch (NoUserExistsException e) {
            System.out.println(e.getMessage());
            continue;
          }
        } else if (cmd instanceof RegisterPlayer) {
          RegisterPlayer rp = (RegisterPlayer) cmd;
          tournamentManager.enrollPlayer(rp.getId(), rp.getName(), rp.getPassword());
        } else {
          System.err.println("Unknown command: " + inpt);
          System.err.println("Valid commands: add_tournament, tournament_state, sign_up, approve_user, register_player");
        }
      }
    } catch (IOException e) {
      System.err.println("Read error" + e.getMessage());
    }

    // Shut down all our threads...
    System.out.println("Shutting down tournament manager...");
    tournamentManager.stop();
    try {
      tournamentManagerThread.join();
    } catch (InterruptedException e) {
      // nothing, we tried
    }
    System.out.println("Tournament manager safely shutdown...");

    System.out.println("Shutting down SCG Court system...");
    try {
      if (statusServer != null)
        statusServer.shutdown();
      if (regServer != null)
        regServer.shutdown();
    } catch (IOException e) {
      // nothing, we tried
    }
  }

  private static void invalidLine(String line) {
    invalidLine("", line);
  }

  private static void invalidLine(String extra, String line) {
    if (!extra.isEmpty()) {
      extra = " (" + extra + ")";
    }
    System.err.println("Invalid command line" + extra + ": " + line);
  }

  public static Date runtimeToDate(String runtime) {
    return runtimeToDate(Integer.parseInt(runtime));
  }

  public static Date runtimeToDate(int runtime) {
    Calendar now = Calendar.getInstance();
    now.add(Calendar.MINUTE, runtime);
    return now.getTime();
  }
}
