package javax.naming.directory;

import javax.naming.*;

// Referenced classes of package javax.naming.directory:
//            Attributes, ModificationItem, SearchControls

public interface DirContext
    extends Context
{

    public static final int ADD_ATTRIBUTE = 1;
    public static final int REPLACE_ATTRIBUTE = 2;
    public static final int REMOVE_ATTRIBUTE = 3;

    public abstract void bind(String s, Object obj, Attributes attributes)
        throws NamingException;

    public abstract void bind(Name name, Object obj, Attributes attributes)
        throws NamingException;

    public abstract DirContext createSubcontext(String s, Attributes attributes)
        throws NamingException;

    public abstract DirContext createSubcontext(Name name, Attributes attributes)
        throws NamingException;

    public abstract Attributes getAttributes(String s)
        throws NamingException;

    public abstract Attributes getAttributes(String s, String as[])
        throws NamingException;

    public abstract Attributes getAttributes(Name name)
        throws NamingException;

    public abstract Attributes getAttributes(Name name, String as[])
        throws NamingException;

    public abstract DirContext getSchema(String s)
        throws NamingException;

    public abstract DirContext getSchema(Name name)
        throws NamingException;

    public abstract DirContext getSchemaClassDefinition(String s)
        throws NamingException;

    public abstract DirContext getSchemaClassDefinition(Name name)
        throws NamingException;

    public abstract void modifyAttributes(String s, int i, Attributes attributes)
        throws NamingException;

    public abstract void modifyAttributes(String s, ModificationItem amodificationitem[])
        throws NamingException;

    public abstract void modifyAttributes(Name name, int i, Attributes attributes)
        throws NamingException;

    public abstract void modifyAttributes(Name name, ModificationItem amodificationitem[])
        throws NamingException;

    public abstract void rebind(String s, Object obj, Attributes attributes)
        throws NamingException;

    public abstract void rebind(Name name, Object obj, Attributes attributes)
        throws NamingException;

    public abstract NamingEnumeration search(String s, String s1, SearchControls searchcontrols)
        throws NamingException;

    public abstract NamingEnumeration search(String s, String s1, Object aobj[], SearchControls searchcontrols)
        throws NamingException;

    public abstract NamingEnumeration search(String s, Attributes attributes)
        throws NamingException;

    public abstract NamingEnumeration search(String s, Attributes attributes, String as[])
        throws NamingException;

    public abstract NamingEnumeration search(Name name, String s, SearchControls searchcontrols)
        throws NamingException;

    public abstract NamingEnumeration search(Name name, String s, Object aobj[], SearchControls searchcontrols)
        throws NamingException;

    public abstract NamingEnumeration search(Name name, Attributes attributes)
        throws NamingException;

    public abstract NamingEnumeration search(Name name, Attributes attributes, String as[])
        throws NamingException;
}
