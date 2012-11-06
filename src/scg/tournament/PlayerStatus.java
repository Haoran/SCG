package scg.tournament;

import java.io.Serializable;

public class PlayerStatus implements Serializable, Comparable<PlayerStatus> {
  private final String name;
  private double score;

  public PlayerStatus(String name, double score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  @Override
  public int compareTo(PlayerStatus o) {
    // descending order
    return Double.compare(o.score, score);
  }
}