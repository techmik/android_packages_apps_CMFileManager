package javax.naming.directory;

import java.io.Serializable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.directory:
//            DirContext

public interface Attribute
    extends Cloneable, Serializable
{

    public static final long serialVersionUID = 0x78d7ee3675a55244L;

    public abstract void add(int i, Object obj);

    public abstract boolean add(Object obj);

    public abstract void clear();

    public abstract Object clone();

    public abstract boolean contains(Object obj);

    public abstract Object get()
        throws NamingException;

    public abstract Object get(int i)
        throws NamingException;

    public abstract NamingEnumeration getAll()
        throws NamingException;

    public abstract DirContext getAttributeDefinition()
        throws NamingException;

    public abstract DirContext getAttributeSyntaxDefinition()
        throws NamingException;

    public abstract String getID();

    public abstract boolean isOrdered();

    public abstract Object remove(int i);

    public abstract boolean remove(Object obj);

    public abstract Object set(int i, Object obj);

    public abstract int size();
}
