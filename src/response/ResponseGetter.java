package response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;


import edu.neu.ccs.demeterf.lib.List;

import scg.AvatarI;
import scg.Config;
import scg.InstanceI;
import scg.InstanceSetI;
import scg.ProtocolRequest;
import scg.ProvideRequest;
import scg.RWrap;
import scg.Request;
import scg.Response;
import scg.SolutionI;
import scg.SolveRequest;

/*
 * Created by team Astro
 * 
 * Take a request.input and a config.input, produce a list of responses
 */
public class ResponseGetter {
	
	private final File fFile;
	
	public ResponseGetter(){
		fFile = null;
	}
	
	public ResponseGetter(String aFileName){
	    fFile = new File(aFileName);  
	}

public String getProtocolResponse(ProtocolRequest p, AvatarI a){
	String protocolResponse = "";
	if (p.toString().contains("provide")){
		try{
			// get the ProvideRequest
			ProvideRequest provideRequest = (ProvideRequest)p;
			InstanceI providedInstance = a.provide(provideRequest.getClaimToBeProvided());
			// get the InstanceSetWrapper and get the fullyQualifiedClassName
			RWrap<InstanceSetI> instanceSetWrapper = provideRequest.getClaimToBeProvided().getInstanceSetWrapper();
			int endIndex = instanceSetWrapper.toString().indexOf("Set");
			String fullyQualifiedClassName =  instanceSetWrapper.toString().substring(0, endIndex);
			// parse the ProvideResponse
			protocolResponse = "provide " + fullyQualifiedClassName + "{{" + providedInstance + "}}";
			}catch(Exception e){
				System.out.println("Exception thrown while parsing ProvideResponse: "+ e.getMessage());
			}	
	}
	else{
		try{
			SolveRequest solveRequest = (SolveRequest)p;
			SolutionI solution = a.solve(solveRequest);
			// get the InstanceWrapper and get the fullyQualifiedClassName
			RWrap<InstanceI> instanceWrapper = solveRequest.getInstanceWrapper();
			int endIndex = instanceWrapper.toString().indexOf("Instance");
			String fullyQualifiedClassName =  instanceWrapper.toString().substring(0, endIndex) + "Solution";
			// parse the SolveResponse
			protocolResponse = "solve " + fullyQualifiedClassName + "{{" + solution + "}}";
		}catch(Exception e){
			System.out.println("Exception thrown while parsing SolveResponse: "+ e.getMessage());
		}
	}
	return protocolResponse;

}
	
public Response getResponse (String request, AvatarI a){
	Response res = null;
	try{
		// parse the Request
		Request req = Request.parse(request);
		
		// parse the Response				
		List<ProtocolRequest> protocolRequests = req.getProtocolRequests();
		String pr = "";
		Iterator<ProtocolRequest> i = protocolRequests.iterator();
		while (i.hasNext()){
			pr += getProtocolResponse(i.next(), a);
		}
		res = Response.parse("propose " + a.propose(req.getForbidden()) 
				+ " oppose " + a.oppose(req.getClaimsToOppose())
				+ " protocolResponse " + pr);
	}catch(Exception e){
		System.out.println("Exception thrown while parsing: "+ e.getMessage());
	}
	return res;
}


public final void processLineByLine(AvatarI a) throws FileNotFoundException {
  Scanner scanner = new Scanner(new FileReader(fFile));
  ResponseGetter r = new ResponseGetter("");
  
  try {
    //use a Scanner to get each request
    while (scanner.hasNextLine() ){
      r.getResponse(scanner.nextLine(), a);
    }
  }catch(Exception e){
	  System.out.println("Exception thrown: "+ e.getMessage());
  }
  finally {
    //ensure the underlying stream is always closed
    //this only has any effect if the item passed to the Scanner
    //constructor implements Closeable (which it does in this case).
    scanner.close();
  }
}

// In the main function, we used both hsr and csp domain to test this program.
// So when you run the program, you will get two lists of responses.
public static void main(String args[]) {
}
}
