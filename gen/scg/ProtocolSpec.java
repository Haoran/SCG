// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of ProtocolSpec */
public class ProtocolSpec{
    protected List<Step> steps;

    /** Construct a(n) ProtocolSpec Instance */
    public ProtocolSpec(List<Step> steps){
        this.steps = steps;
    }
    /** Is the given object Equal to this ProtocolSpec? */
    public boolean equals(Object o){
        if(!(o instanceof ProtocolSpec))return false;
        if(o == this)return true;
        ProtocolSpec oo = (ProtocolSpec)o;
        return (((Object)steps).equals(oo.steps));
    }
    /** Parse an instance of ProtocolSpec from the given String */
    public static ProtocolSpec parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_ProtocolSpec();
    }
    /** Parse an instance of ProtocolSpec from the given Stream */
    public static ProtocolSpec parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProtocolSpec();
    }
    /** Parse an instance of ProtocolSpec from the given Reader */
    public static ProtocolSpec parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_ProtocolSpec();
    }

    /** Field Class for ProtocolSpec.steps */
    public static class steps extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field ProtocolSpec.steps */
    public void setSteps(List<Step> _steps){ steps = _steps; }
    /** Getter for field ProtocolSpec.steps */
    public List<Step> getSteps(){ return steps; }

}


