// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of SolveResponse */
public class SolveResponse extends ProtocolResponse{
    protected RWrap<SolutionI> solutionWrapper;

    /** Construct a(n) SolveResponse Instance */
    public SolveResponse(RWrap<SolutionI> solutionWrapper){
        this.solutionWrapper = solutionWrapper;
    }
    /** Is the given object Equal to this SolveResponse? */
    public boolean equals(Object o){
        if(!(o instanceof SolveResponse))return false;
        if(o == this)return true;
        SolveResponse oo = (SolveResponse)o;
        return (((Object)solutionWrapper).equals(oo.solutionWrapper));
    }
    /** Parse an instance of SolveResponse from the given String */
    public static SolveResponse parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_SolveResponse();
    }
    /** Parse an instance of SolveResponse from the given Stream */
    public static SolveResponse parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SolveResponse();
    }
    /** Parse an instance of SolveResponse from the given Reader */
    public static SolveResponse parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SolveResponse();
    }

    /** Field Class for SolveResponse.solutionWrapper */
    public static class solutionWrapper extends edu.neu.ccs.demeterf.Fields.any{}
 
	public SolveResponse(SolutionI solution){
		this(new RWrap(solution));
	}
	
	public SolutionI getSolution(){
		return getSolutionWrapper().getWrapee();
	}

    /** DGP method from Class Display */
    public String display(){ return scg.Display.DisplayM(this); }
    /** DGP method from Class Print */
    public String print(){ return scg.Print.PrintM(this); }
    /** DGP method from Class ToStr */
    public String toStr(){ return scg.ToStr.ToStrM(this); }
    /** DGP method from Class PrintToString */
    public String toString(){ return scg.PrintToString.PrintToStringM(this); }
    /** DGP method from Class HashCode */
    public int hashCode(){ return scg.HashCode.HashCodeM(this); }
    /** Setter for field SolveResponse.solutionWrapper */
    public void setSolutionWrapper(RWrap<SolutionI> _solutionWrapper){ solutionWrapper = _solutionWrapper; }
    /** Getter for field SolveResponse.solutionWrapper */
    public RWrap<SolutionI> getSolutionWrapper(){ return solutionWrapper; }

}


