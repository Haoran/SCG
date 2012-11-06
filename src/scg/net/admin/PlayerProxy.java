package scg.net.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import scg.Config;
import scg.Constants;
import scg.Request;
//import scg.game.PlayerContext;
import scg.Response;
import scg.net.PlayerSpec;
import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;

/**
 * An extra level of indirection supporting both distributed and direct
 * Admin/Player interactions
 */
public abstract class PlayerProxy implements PlayerProxyI {

    /** The Player we are a proxy for */
    private final PlayerSpec spec;

    /** Create a Proxy for the given PlayerSpec */
    public PlayerProxy(PlayerSpec sp) {
        spec = sp;
    }

    /** Return the PlayerSpec this proxy represents */
    public PlayerSpec getSpec(){
        return spec;
    }

    public String getName(){
        return getSpec().getName();
    }

    public String getAddress(){
        return getSpec().getName();
    }

    /** Take the Player turn by contacting the player and getting its response */
    public Response takeTurn(Config config, Request inRequest){
        HTTPReq req = null;
        HTTPResp resp = null;
        try {
            req = HTTPReq.Post(Constants.PLAYER_PATH_ENTRY, inRequest.toString());
            resp = contactPlayer(req, config.getScgCfg().getTurnDuration());
        }catch(Exception e) {
            throw new HTTPTransException(req, resp, e);
        }
        if (resp.isError())
            throw new HTTPTransException(req, resp, resp.getBodyString());
            
        try {
            String bodyString = resp.getBodyString();
			return Response.parse(bodyString);
        } catch (scg.ParseException e) {
            throw new HTTPTransException(req, resp, e);
        }
    }

    /** The go-between method: Request -> Response */
    public abstract HTTPResp contactPlayer(HTTPReq req, int timeout);
    
    /** Errors within HTTP */
    public static class HTTPTransException extends RuntimeException {

        HTTPReq req;
        HTTPResp resp;

        public HTTPTransException(HTTPReq rq, HTTPResp rsp, Exception cause) {
            super(cause);
            req = rq;
            resp = rsp;
        }
        public HTTPTransException(HTTPReq rq, HTTPResp rsp, String cause) {
            super(cause);
            req = rq;
            resp = rsp;
        }

        /** Save HTTP interactions? */
        private static java.io.PrintStream save = null;

        /** Save HTTP responses? */
        public static void setSaveFile(String file) throws IOException{
            save = new PrintStream(new FileOutputStream(file));
        }

        /** Log the Exception to the file */
        public void storeException(String player){
            if (save == null) {
                return;
            }
            Throwable e = this.getCause();
            String stack = "";
            for(StackTraceElement stk:e.getStackTrace())
                stack += "    "+stk.toString()+"\n";
            save.println("************ EXCEPTION[" + player + "]: "+e.getClass().getName()+" *************\n"
                    + "------------------ REQUEST ------------------------\n"
                    + req + "\n------------------ RESPONSE -----------------------\n"
                    + resp + "\n------------------  STACK  ------------------------\n"
                    + stack + "************ END[" + player + "] *************\n");
            save.flush();
        }
    }
}
