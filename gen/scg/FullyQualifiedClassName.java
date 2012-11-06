// ** This file was generated with DemFGen (vers:4/15/2011)

package scg;

import java.io.Serializable;

import edu.neu.ccs.demeterf.lib.*;





/** Representation of FullyQualifiedClassName */
public class FullyQualifiedClassName implements Serializable{
    protected ident name;
    transient protected DSLOI rest;

    /** Construct a(n) FullyQualifiedClassName Instance */
    public FullyQualifiedClassName(ident name, DSLOI rest){
        this.name = name;
        this.rest = rest;
    }
    /** Is the given object Equal to this FullyQualifiedClassName? */
    public boolean equals(Object o){
        if(!(o instanceof FullyQualifiedClassName))return false;
        if(o == this)return true;
        FullyQualifiedClassName oo = (FullyQualifiedClassName)o;
        return (((Object)name).equals(oo.name))&&(((Object)rest).equals(oo.rest));
    }
    /** Parse an instance of FullyQualifiedClassName from the given String */
    public static FullyQualifiedClassName parse(String inpt) throws scg.ParseException{
        return new scg.TheParser(new java.io.StringReader(inpt)).parse_FullyQualifiedClassName();
    }
    /** Parse an instance of FullyQualifiedClassName from the given Stream */
    public static FullyQualifiedClassName parse(java.io.InputStream inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_FullyQualifiedClassName();
    }
    /** Parse an instance of FullyQualifiedClassName from the given Reader */
    public static FullyQualifiedClassName parse(java.io.Reader inpt) throws scg.ParseException{
        return new scg.TheParser(inpt).parse_FullyQualifiedClassName();
    }

    /** Field Class for FullyQualifiedClassName.name */
    public static class name extends edu.neu.ccs.demeterf.Fields.any{}
    /** Field Class for FullyQualifiedClassName.rest */
    public static class rest extends edu.neu.ccs.demeterf.Fields.any{}

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
    /** Setter for field FullyQualifiedClassName.name */
    public void setName(ident _name){ name = _name; }
    /** Setter for field FullyQualifiedClassName.rest */
    public void setRest(DSLOI _rest){ rest = _rest; }
    /** Getter for field FullyQualifiedClassName.name */
    public ident getName(){ return name; }
    /** Getter for field FullyQualifiedClassName.rest */
    public DSLOI getRest(){ return rest; }

}


