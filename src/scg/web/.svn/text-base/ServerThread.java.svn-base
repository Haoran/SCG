package scg.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;
import edu.neu.ccs.demeterf.http.server.ResponseException;
import edu.neu.ccs.demeterf.http.server.ServerDispatch;
import edu.neu.ccs.demeterf.util.Util;

/**
 * Represents the Listening/Dispatch portion of an HTTP Server. Given a Map of Paths to Methods, it
 * is responsible for calling methods when given a specific request.
 */
public class ServerThread extends Thread {
  private static final int DEFAULT_BACKLOG = 20;
  private final Object _lock = new Object();
  private final ServerSocket _socket;
  private final ServerDispatch _dispatch;
  private final List<Thread> _servants = new ArrayList<Thread>();
  private final boolean _single;
  private final long _maxRequest;
  private final int _backlog;
  private final Method _exHandler;
  private boolean _done = false;

  /** Create a ServerThread... */
  protected ServerThread(int port, boolean sing, ServerDispatch disp, long max) throws IOException {
    this(port, sing, disp, max, null, DEFAULT_BACKLOG);
  }

  /** Create a ServerThread... */
  protected ServerThread(int port, boolean single, ServerDispatch dispatch, long maxRequest,
      Method exHandler, int backlog) throws IOException {
    _socket = new ServerSocket(port, backlog);
    _dispatch = dispatch;
    _single = single;
    _maxRequest = maxRequest;
    _backlog = backlog;
    _exHandler = exHandler;
  }

  @Override
  public void run() {
    while (!isDone()) {
      try {
        println("Waiting for connection...");
        Socket req = _socket.accept();
        println("Got one from: " + req.getInetAddress() + ":" + req.getPort());
        if (numServants() < _backlog) {
          DispatchThread t = new DispatchThread(req);
          addServant(t);
          t.start();
          try {
            if (_single) {
              t.join();
            }
          } catch (InterruptedException ie) {
          }
        } else {
          //TODO: I would give an error response, but that takes too long
          req.close();
        }
        Thread.yield();
      } catch (IOException e) {
        if (!isDone()) {
          System.err.println(" ServerThread Exception: " + e.getMessage());
          synchronized (_lock) {
            _done = true;
          }
        }
      }
    }
  }

  /** Add a Servant Thread to the List */
  private synchronized void addServant(Thread t) {
    _servants.add(t);
  }

  /** Remove a Servant Thread from the List */
  private synchronized void removeServant(Thread t) {
    _servants.remove(t);
    this.notify();
  }

  /** Remove a Servant Thread from the List */
  private synchronized int numServants() {
    return _servants.size();
  }

  /** Await the completion of all Servant Threads */
  private synchronized void waitServants() {
    println("Waiting for Servants...");
    while (!_servants.isEmpty()) {
      try {
        this.wait(1000);
      } catch (InterruptedException ie) {
      }
      println("Still Waiting...");
    }
    println("Done");
  }

  /** Kill the Server listening thread, though workers will continue/complete */
  public void shutdown() throws IOException {
    shutdown(true);
  }

  /** Kill the Server listening thread, maybe wait for workers */
  public void shutdown(boolean wait) throws IOException {
    synchronized (_lock) {
      _done = true;
    }
    _socket.close();
    if (wait)
      waitServants();
  }

  private boolean isDone() {
    synchronized (_lock) {
      return _done;
    }
  }

  /** Handles the dispatch of a Request to a Server Method */
  private class DispatchThread extends Thread {
    private final Socket _sock;

    DispatchThread(Socket s) {
      _sock = s;
    }

    public void run() {
      println("In Dispatch Thread...");
      HTTPReq req = null;
      try {
        req = HTTPReq.fromSocket(_sock, 2000, _maxRequest);
      } catch (Exception e) {
        if (_exHandler != null) {
          try {
            //invoke method
            HTTPResp res = Util.applyMethod(_exHandler, _dispatch.getTarget(), new Object[] {
                e, _sock });
            res.toSocket(_sock);
            removeServant(this);
            _sock.close();
            return;
          } catch (Exception ee) {
            e = ee;
          }
          return;
        }
        removeServant(this);
        try {
          _sock.close();
        } catch (Exception ee) {
        }
        return;
      }
      try {
        HTTPResp res = _dispatch.handle(req, _sock);
        res.toSocket(_sock);
        _sock.close();
      } catch (Exception e) {
        removeServant(this);
        throw new ResponseException(e);
      }
      removeServant(this);
    }
  }
  
  private void println(String s) {
      System.out.println(" ** " + s);
  }
}
