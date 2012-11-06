package scg.tournament;

import java.io.Serializable;

import scg.game.ActiveGame;
import edu.neu.ccs.demeterf.lib.List;

public class TournamentStatus implements Serializable {
  private final java.util.List<PlayerStatus> registeredPlayers;
  private final java.util.List<ActiveGame> activeGames;

  public TournamentStatus(List<PlayerStatus> registeredPlayers, List<ActiveGame> activeGames) {
    this.registeredPlayers = registeredPlayers.toJavaList();
    this.activeGames = activeGames.toJavaList();
  }

  public java.util.List<PlayerStatus> getRegisteredPlayers() {
    return registeredPlayers;
  }

  public java.util.List<ActiveGame> getActiveGames() {
    return activeGames;
  }
}