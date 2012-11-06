package scg;

import edu.neu.ccs.demeterf.http.classes.HTTPReq;
import edu.neu.ccs.demeterf.http.classes.HTTPResp;
import edu.neu.ccs.demeterf.http.server.Path;

public class HTML {
    /** Add the Server Header for the Admin */
    static HTTPResp addServer(HTTPResp res){
        return res.addHeader(Constants.SERVER_KEY, Constants.ADMIN_SERVER_NAME);
    }
    /** Create an Error HTML response for the browser */
    public static HTTPResp errHTMLResp(String msg, String body){ return addServer(HTTPResp.htmlError(HTTPResp.MIN_ERROR, msg, errorPage(body))); }
    /** Create an Error Text response */
    public static HTTPResp errTextResp(String msg, String body){ return addServer(HTTPResp.textError(HTTPResp.MIN_ERROR, msg, body)); }
    /** Create an OK HTML response for the browser */
    public static HTTPResp okHTMLResp(String body){ return addServer(HTTPResp.htmlResponse(body)); }
    /** Create an OK Text response */
    public static HTTPResp okTextResp(String body){ return addServer(HTTPResp.textResponse(body)); }
    
    /** Wrap some text in a Tag */
    public static String wrap(String s, String tag){
        return "<"+tag+">"+s+"</"+tag+">";    
    }
    /** Wrap some text in a Tag, with the given HTML class */
    public static String wrap(String s, String tag, String cls){
        return "<"+tag+" class=\""+cls+"\">"+s+"</"+tag+">";    
    }
    
    /** Default response to unknown requests */
    @Path()
    public static HTTPResp defaultResp(HTTPReq req){
        return HTTPResp.htmlError(errorPage("Unaccepted URL Request:<br/><br/>"+
                "<span style='color:red'>"
                + req.trimmedUrl() + "</span>"));
    }

    /** Present an HTML Error Page */
    public static String errorPage(String msg){
        return htmlPage("!ERROR!", "div{ textalign:center;width:400px;height:200px;border:solid red 1px' }",
                wrap(wrap(wrap("ERROR<br/><br/>" + msg,"h3"),"div"),"center"));
    }
    
    /** Present a refreshable HTML Page */
    public static String htmlRefreshPage(int seconds, String title, String style, String body){
        return wrap(wrap(wrap(title,"title")+wrap(style,"style")+
                (seconds>0?("<meta http-equiv=\"refresh\" content=\""+seconds+"\"/>"):""),"head")+wrap("\n"+body, "body"), "html");
    }
    
    /** Present an HTML Page */
    public static String htmlPage(String title, String style, String body){
        return htmlRefreshPage(0,title,style,body);
    }
}
