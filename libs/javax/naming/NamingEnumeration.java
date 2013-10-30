package javax.naming;

import java.util.Enumeration;

// Referenced classes of package javax.naming:
//            NamingException

public interface NamingEnumeration
    extends Enumeration
{

    public abstract void close()
        throws NamingException;

    public abstract boolean hasMore()
        throws NamingException;

    public abstract Object next()
        throws NamingException;
}
