package scg.tournament;


import scg.Util;
import scg.exception.AuthenticationException;
import scg.exception.NoUserExistsException;
import scg.exception.UserExistsException;
import scg.exception.UserNotApprovedException;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Users {
  private static final String USER_STATE_FILE = "UserState.dat";
  private static final String ROOT = "root";
  private final Object _lock = new Object();
  private final HashMap<String, User> _nameMap = new HashMap<String, User>();
  private final HashMap<String, Session> _sessions = new HashMap<String, Session>();

  public Users(String rootPassword) {
    loadUserState(rootPassword);
  }

  /**
   * Attempt to log a user into the web frontend
   * @param username
   * @param password
   * @return Session object for the user attempting to login
   * @throws AuthenticationException Thrown if the user password is wrong
   * @throws UserNotApprovedException Thrown if the user is not entered in the system
   */
  public Session login(String username, String password) throws AuthenticationException, UserNotApprovedException {
    synchronized (_lock) {
      User user = _nameMap.get(username);
      if (user == null || !user.getPasswordHash().equals(Util.encrypt(password))) {
        throw new AuthenticationException("Invalid username or password");
      }
      if (!user.isApproved()) {
        throw new UserNotApprovedException();
      }
      Session s = new Session(user);
      _sessions.put(s.getKey(), s);
      return s;
    }
  }

  /**
   * Get an existing session for a user
   * @param key Session key, an encrypted string of username and login time
   * @return Session object for the key (if one exists)
   */
  public Session getSession(String key) {
    synchronized (_lock) {
      return _sessions.get(key);
    }
  }

  public void logout(Session session) {
    synchronized (_lock) {
      _sessions.remove(session.getKey());
    }
  }

  /**
   * Put a user into the state where they have signed up, but are still waiting approval
   * @param username
   * @param password
   * @return User object
   * @throws UserExistsException Thrown if a user tries to signup with an already used name
   */
  public User signup(String username, String password) throws UserExistsException {
    synchronized (_lock) {
      if (_nameMap.containsKey(username)) {
        throw new UserExistsException(username);
      }
      User newUser = new User(username, Util.encrypt(password));
      _nameMap.put(username, newUser);
      saveUserState();
      return newUser;
    }
  }

  public void approveUser(String username) throws NoUserExistsException {
    synchronized (_lock) {
      if (!_nameMap.containsKey(username)) {
        throw new NoUserExistsException(username);
      }
      _nameMap.put(username, _nameMap.get(username).approve());
      saveUserState();
    }
  }

  public void removeUser(String username) throws NoUserExistsException {
    synchronized (_lock) {
      if (!_nameMap.containsKey(username)) {
        throw new NoUserExistsException(username);
      }
      _nameMap.remove(username);
      saveUserState();
    }
  }

  public List<User> getAllUsers() {
    synchronized (_lock) {
      return new ArrayList<User>(_nameMap.values());
    }
  }

  public List<User> getApprovedUsers() {
    synchronized (_lock) {
      List<User> users = new ArrayList<User>();
      for (User user : _nameMap.values()) {
        if (user.isApproved()) {
          users.add(user);
        }
      }
      return users;
    }
  }

  public List<User> getUnApprovedUsers() {
    synchronized (_lock) {
      List<User> users = new ArrayList<User>();
      for (User user : _nameMap.values()) {
        if (!user.isApproved()) {
          users.add(user);
        }
      }
      return users;
    }
  }

  /**
   * Writes out the serialized user state to disk
   * @see Serializable
   */
  private void saveUserState() {
    synchronized (_lock) {
      System.out.println("Saving User state...");
      OutputStream file = null;
      OutputStream buffer = null;
      ObjectOutput output = null;

      try {
        file = new FileOutputStream(USER_STATE_FILE);
        buffer = new BufferedOutputStream(file);
        output = new ObjectOutputStream(buffer);

        output.writeObject(getAllUsers());

        System.out.println("Save successful");
      } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
      } finally {
        try {
          if (output != null) {
            output.close();
          }
          if (buffer != null) {
            buffer.close();
          }
          if (file != null) {
            file.close();
          }
        } catch (Exception ex) {
        }
      }
    }
  }

  /**
   * Reads the serialized user state to disk (if it exists)
   * @see Serializable
   */
  private synchronized void loadUserState(String rootPassword) {
    System.out.println("Attempting to load user state...");
    InputStream file = null;
    InputStream buffer = null;
    ObjectInput input = null;

    _nameMap.put(ROOT, new User(ROOT, Util.encrypt(rootPassword)).root());
    try {
      file = new FileInputStream(USER_STATE_FILE);
      buffer = new BufferedInputStream(file);
      input = new ObjectInputStream(buffer);

      Collection<User> savedUsers = (Collection<User>) input.readObject();

      for (User user : savedUsers) {
        //remove old root user
        if (!user.isRoot()) {
          System.out.println("Loading user " + user.getName() + " into memory");
          _nameMap.put(user.getName(), user);
        }
      }
    } catch (FileNotFoundException fof) {
      System.out.println("No file to load user state from");
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    } finally {
      try {
        if (input != null) {
          input.close();
        }
        if (buffer != null) {
          buffer.close();
        }
        if (file != null) {
          file.close();
        }
      } catch (Exception ex) {
      }
    }

  }
}
