package scg.tournament;

import java.io.Serializable;
import java.util.*;
import scg.Config;
import scg.tournament.TournamentSetup.Status;

/**
 * A serializable representation of the TournamentSetup object
 * @author CS5500
 * @see scg.tournament.TournamentSetup
 */
public class SerializedTournamentSetup implements Serializable, Comparable<SerializedTournamentSetup>
{
  private int id;
  private Date runTime;
  private String name;
  private String config;
  private Hashtable<String,String> players;
  private Status status;
  private Hashtable<String, Double> finalTournamentScores;

  public SerializedTournamentSetup(int id, String name, Config config, Date runTime, Hashtable<String,String> players, Status status, 
		  Hashtable<String, Double> finalTournamentScores)
  {
    this.id = id;
    this.name = name;
    this.config = config.print();
    this.runTime = runTime;
    this.players = players;
    this.status = status; 
    this.finalTournamentScores = finalTournamentScores;
  }

  public int getId() { return id; }
  public String getName() { return name; }
  public Config getConfig() {
    Config c = null;
    try {
      c = Config.parse(config);
    } catch (scg.ParseException e) {
    }
    return c;
  }
  public Date getRunTime() { return runTime; }
  public Hashtable<String,String> getPlayers() { return players; }
  public Status getStatus() { return status; }
  public Hashtable<String, Double> getFinalTournamentScores() { return finalTournamentScores; }

  public int compareTo(SerializedTournamentSetup o) {
    return runTime.compareTo(o.runTime);
  }
}
