package scg.tournament;

import scg.Util;

/**
 * Class which stores information about a logged into the website.
 * 
 * @author Patrick
 * 
 */
public class Session {
  public static final long EXPIRATION_MILLIS = 1000 * 60 * 10; // 10 Mins
  private final String _key;
  private final User _user;
  private final long _expire;

  /**
   * Create a new session for the given user.
   * 
   * @param user
   */
  public Session(User user) {
    _user = user;
    long now = System.currentTimeMillis();
    _key = Util.encrypt(_user.getName() + now);
    _expire = now + EXPIRATION_MILLIS;
  }

  /**
   * The key for the session
   * 
   * @return
   */
  public String getKey() {
    return _key;
  }

  /**
   * The user for the session
   * 
   * @return
   */
  public User getUser() {
    return _user;
  }

  /**
   * 
   * @return True if EXPIRATION_MILLIS milliseconds 
   * have passed since the session was created
   */
  public boolean hasExpired() {
    return System.currentTimeMillis() > _expire;
  }
}
