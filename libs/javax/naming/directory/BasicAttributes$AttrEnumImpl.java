package javax.naming.directory;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.directory:
//            BasicAttributes

class elements
    implements NamingEnumeration
{

    Enumeration elements;

    public void close()
        throws NamingException
    {
        elements = null;
    }

    public boolean hasMore()
        throws NamingException
    {
        return hasMoreElements();
    }

    public boolean hasMoreElements()
    {
        return elements.hasMoreElements();
    }

    public Object next()
        throws NamingException
    {
        return nextElement();
    }

    public Object nextElement()
    {
        return elements.nextElement();
    }

    public ()
    {
        elements = attrs.elements();
    }
}
