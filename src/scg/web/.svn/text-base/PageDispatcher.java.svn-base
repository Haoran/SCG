package scg.web;

import scg.tournament.TournamentManager;
import scg.tournament.Users;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;
import edu.neu.ccs.demeterf.http.server.MaxMessageSize;
import edu.neu.ccs.demeterf.http.server.Path;
import edu.neu.ccs.demeterf.http.server.Port;
import edu.neu.ccs.demeterf.http.server.Server;

@Server
/**
 * Dispatches HTTP requests to the appropriate web page
 */
public class PageDispatcher {
  private final TournamentManager _manager;
  private final Users _users;
  @Port
  private final int _port;
  @MaxMessageSize
  private final int _maxMessage = 8096;

  /**
   * Create an instance of the PageDispatcher
   * 
   * @param manager
   * @param users
   * @param port
   */
  public PageDispatcher(TournamentManager manager, Users users, int port) {
    _manager = manager;
    _users = users;
    _port = port;
  }

  /**
   * Get the response for an AdminPage request
   * 
   * @param requ The request from the user
   * @return The response from the server
   */
  @Path(AdminPage.PATH)
  public synchronized HTTPResp adminPageReq(HTTPReq requ) {
    return new AdminPage(_manager, _users, requ).getResponse();
  }

  /**
   * Get the response for a ServerStatus request
   * 
   * @param requ The request from the user
   * @return The response from the server
   */
  @Path(ServerStatus.PATH)
  public synchronized HTTPResp serverStatusReq(HTTPReq requ) {
    return new ServerStatus(_manager, _users, requ).getResponse();
  }

  /**
   * Get the response for a TournamentStatus request
   * 
   * @param requ The request from the user
   * @return The response from the server
   */
  @Path(TournamentStatus.PATH)
  public synchronized HTTPResp tournamentStatusReq(HTTPReq requ) {
    return new TournamentStatus(_manager, _users, requ).getResponse();
  }

  /**
   * Get the response for a TournamentResource request
   * 
   * @param requ The request from the user
   * @return The response from the server
   */
  @Path(TournamentResource.PATH)
  public synchronized HTTPResp tournamentResourceReq(HTTPReq requ) {
    return new TournamentResource(_manager, _users, requ).getResponse();
  }

  /**
   * Get the response for a SignIn request
   * 
   * @param requ The request from the user
   * @return The response from the server
   */
  @Path(SignIn.PATH)
  public synchronized HTTPResp signInReq(HTTPReq requ) {
    return new SignIn(_manager, _users, requ).getResponse();
  }

  /**
   * Get the response for a SignUp request
   * 
   * @param requ The request from the user
   * @return The response from the server
   */
  @Path(SignUp.PATH)
  public synchronized HTTPResp signUpReq(HTTPReq requ) {
    return new SignUp(_manager, _users, requ).getResponse();
  }
}
