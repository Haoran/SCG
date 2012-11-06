// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of Strengthening */
public class Strengthening extends OpposeAction{
    protected double newQuality;

    /** Construct a(n) Strengthening Instance */
    public Strengthening(double newQuality){
        this.newQuality = newQuality;
    }
    /** Is the given object Equal to this Strengthening? */
    public boolean equals(Object o){
        if(!(o instanceof Strengthening))return false;
        if(o == this)return true;
        Strengthening oo = (Strengthening)o;
        return (((Object)newQuality).equals(oo.newQuality));
    }
    /** Parse an instance of Strengthening from the given String */
    public static Strengthening parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_Strengthening();
    }
    /** Parse an instance of Strengthening from the given Stream */
    public static Strengthening parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Strengthening();
    }
    /** Parse an instance of Strengthening from the given Reader */
    public static Strengthening parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_Strengthening();
    }

    /** Field Class for Strengthening.newQuality */
    public static class newQuality extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field Strengthening.newQuality */
    public void setNewQuality(double _newQuality){ newQuality = _newQuality; }
    /** Getter for field Strengthening.newQuality */
    public double getNewQuality(){ return newQuality; }

}


