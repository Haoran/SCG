package scg.exception;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;

/** Errors within HTTP */
public class HTTPTransException extends RuntimeException {

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
