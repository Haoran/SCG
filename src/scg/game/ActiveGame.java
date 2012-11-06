package scg.game;

import java.io.Serializable;

import scg.tournament.PlayerStatus;


public class ActiveGame implements Serializable{
  private PlayerStatus p1;
  private PlayerStatus p2;
  private int round;

  public ActiveGame(PlayerStatus p1, PlayerStatus p2, int round) {
    this.p1 = p1;
    this.p2 = p2;
    this.round = round;
  }

  public PlayerStatus getP1() {
    return p1;
  }

  public PlayerStatus getP2() {
    return p2;
  }

  public int getRound() {
    return round;
  }
  
  public void setPlayerStatus(PlayerStatus p1, PlayerStatus p2) {
	  this.p1 = p1;
	  this.p2 = p2;
  }
  
  public void setRound(int round) {
	  this.round = round;
  }
}