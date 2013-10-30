package javax.naming.directory;

import java.util.Enumeration;
import java.util.Vector;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.directory:
//            BasicAttribute

class list
    implements NamingEnumeration
{

    Enumeration list;

    public void close()
        throws NamingException
    {
        list = null;
    }

    public boolean hasMore()
        throws NamingException
    {
        return list.hasMoreElements();
    }

    public boolean hasMoreElements()
    {
        return list.hasMoreElements();
    }

    public Object next()
        throws NamingException
    {
        return list.nextElement();
    }

    public Object nextElement()
    {
        return list.nextElement();
    }

    ()
    {
        list = values.elements();
    }
}
