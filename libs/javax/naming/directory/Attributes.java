package javax.naming.directory;

import java.io.Serializable;
import javax.naming.NamingEnumeration;

// Referenced classes of package javax.naming.directory:
//            Attribute

public interface Attributes
    extends Cloneable, Serializable
{

    public abstract Object clone();

    public abstract Attribute get(String s);

    public abstract NamingEnumeration getAll();

    public abstract NamingEnumeration getIDs();

    public abstract boolean isCaseIgnored();

    public abstract Attribute put(String s, Object obj);

    public abstract Attribute put(Attribute attribute);

    public abstract Attribute remove(String s);

    public abstract int size();
}
