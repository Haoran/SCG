// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Step */
public class Step{
    protected Action action;
    protected Role role;

    /** Construct a(n) Step Instance */
    public Step(Action action, Role role){
        this.action = action;
        this.role = role;
    }
    /** Is the given object Equal to this Step? */
    public boolean equals(Object o){
        if(!(o instanceof Step))return false;
        if(o == this)return true;
        Step oo = (Step)o;
        return (((Object)action).equals(oo.action))&&(((Object)role).equals(oo.role));
    }
    /** Parse an instance of Step from the given String */
    public static Step parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Step();
    }
    /** Parse an instance of Step from the given Stream */
    public static Step parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Step();
    }
    /** Parse an instance of Step from the given Reader */
    public static Step parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Step();
    }

    /** Field Class for Step.action */
    public static class action extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for Step.role */
    public static class role extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field Step.action */
    public void setAction(Action _action){ action = _action; }
    /** Setter for field Step.role */
    public void setRole(Role _role){ role = _role; }
    /** Getter for field Step.action */
    public Action getAction(){ return action; }
    /** Getter for field Step.role */
    public Role getRole(){ return role; }

}


