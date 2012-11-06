package scg.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import scg.Claim;

public class Game {
  private final ArrayList<Socket> players;
  private final String fullyQualifiedClass;
  private final int MAX_ROUNDS = 5;
  private final PrintWriter p1Send;
  private final PrintWriter p2Send;
  private final BufferedReader p1Recieve;
  private final BufferedReader p2Recieve;

  public Game(String fullyQualifiedClass, Collection<Socket> players) throws IOException {
    this.players = new ArrayList<Socket>(players);
    this.fullyQualifiedClass = fullyQualifiedClass;
    p1Send = new PrintWriter(this.players.get(0).getOutputStream(), true);
    p1Recieve = new BufferedReader(new InputStreamReader(
        this.players.get(0).getInputStream()));
    p2Send = new PrintWriter(this.players.get(1).getOutputStream(), true);
    p2Recieve = new BufferedReader(new InputStreamReader(
        this.players.get(1).getInputStream()));
  }

  public void run() throws IOException, scg.ParseException
  {
    System.out.println("Starting game with Player1 vs. Player2");
    for (int i = 0; i < MAX_ROUNDS; ++i) {
      round(i + 1);
      try {
        Thread.sleep(2000);
      } catch (Exception e) {
      }
    }

    players.add(players.remove(0));

    System.out.println("Continuing game with Player2 vs. Player1");
    for (int i = 0; i < MAX_ROUNDS; ++i) {
      round(i + 1);
      try {
        Thread.sleep(2000);
      } catch (Exception e) {
      }
    }
  }

  protected void round(int roundNum) throws IOException, scg.ParseException {
    /* 
     * Old code, can probably be ripped out if when we merge with common Game
     *
    System.out.println("Starting round "+roundNum);
    String in = "";
    System.out.println("Sending propose request to client 1");
    // First send a propose request to the client
    p1Send.println("request[propose ]");
    in = p1Recieve.readLine();

    // Ok, we need to read this into a Response object, and then check all the 
    // claims using the instance set object to make sure they're valid...
    System.out.println("Player 1 sent: " + in);
    PlayerResponse pr = PlayerResponse.parse(in);
    ProposeResponse ppr = (ProposeResponse) pr.getTransaction();
    for (Claim c : ppr.getClaims())
    {
      c.finishParse();
      System.out.println("Claim: " + c.print());
    }

    System.out.println(pr.print());
    System.out.println(ppr.print());

    p2Send.println(in);
    in = p2Recieve.readLine();

    // Ok, we need to read this into a Response object, and then check all the 
    // claims using the instance set object to make sure they're valid...
    System.out.println("Player 2 sent: " + in);
    pr = PlayerResponse.parse(in);
    ppr = (ProposeResponse) pr.getTransaction();
    for (Claim c : ppr.getClaims())
    {
      c.finishParse();
      System.out.println("Claim: " + c.print());
    }

    System.out.println(pr.print());
    System.out.println(ppr.print());
    */
  }
}
