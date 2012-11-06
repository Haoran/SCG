// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of SolveAction */
public class SolveAction implements Action{
    protected int stepNo;

    /** Construct a(n) SolveAction Instance */
    public SolveAction(int stepNo){
        this.stepNo = stepNo;
    }
    /** Is the given object Equal to this SolveAction? */
    public boolean equals(Object o){
        if(!(o instanceof SolveAction))return false;
        if(o == this)return true;
        SolveAction oo = (SolveAction)o;
        return (((Object)stepNo).equals(oo.stepNo));
    }
    /** Parse an instance of SolveAction from the given String */
    public static SolveAction parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_SolveAction();
    }
    /** Parse an instance of SolveAction from the given Stream */
    public static SolveAction parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SolveAction();
    }
    /** Parse an instance of SolveAction from the given Reader */
    public static SolveAction parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_SolveAction();
    }

    /** Field Class for SolveAction.stepNo */
    public static class stepNo extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field SolveAction.stepNo */
    public void setStepNo(int _stepNo){ stepNo = _stepNo; }
    /** Getter for field SolveAction.stepNo */
    public int getStepNo(){ return stepNo; }

}


