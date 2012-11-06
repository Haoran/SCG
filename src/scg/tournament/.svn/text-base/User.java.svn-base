package scg.tournament;

import java.io.Serializable;

/**
 * Class which stores information about user states in the system.
 * @author rkeilty
 *
 */
public class User implements Serializable, Comparable<User> {
  private final String _name;
  private final String _passwordHash;
  private final boolean _approved;
  private final boolean _root;

  public User(String name, String passwordHash) {
    this(name, passwordHash, false, false);
  }

  private User(String name, String passwordHash, boolean approved, boolean root) {
    _name = name;
    _passwordHash = passwordHash;
    _approved = approved;
    _root = root;
  }

  public String getName() {
    return _name;
  }

  public String getPasswordHash() {
    return _passwordHash;
  }

  public boolean isApproved() {
    return _approved;
  }

  public boolean isRoot() {
    return _root;
  }

  public User approve() {
    return new User(_name, _passwordHash, true, _root);
  }

  public User root() {
    return new User(_name, _passwordHash, true, true);
  }

  @Override
  public int hashCode() {
    return 31 + ((_name == null) ? 0 : _name.hashCode());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (_name == null) {
      if (other._name != null)
        return false;
    } else if (!_name.equals(other._name))
      return false;
    return true;
  }

  @Override
  public int compareTo(User o) {
    return _name.compareTo(o._name);
  }
}
