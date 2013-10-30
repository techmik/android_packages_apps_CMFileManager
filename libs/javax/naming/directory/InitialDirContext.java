package javax.naming.directory;

import java.util.Hashtable;
import javax.naming.*;

// Referenced classes of package javax.naming.directory:
//            DirContext, Attributes, ModificationItem, SearchControls

public class InitialDirContext extends InitialContext
    implements DirContext
{

    public InitialDirContext()
        throws NamingException
    {
    }

    public InitialDirContext(Hashtable hashtable)
        throws NamingException
    {
        super(hashtable);
    }

    protected InitialDirContext(boolean flag)
        throws NamingException
    {
        super(flag);
    }

    public void bind(String s, Object obj, Attributes attributes)
        throws NamingException
    {
        getURLOrDefaultInitDirCtx(s).bind(s, obj, attributes);
    }

    public void bind(Name name, Object obj, Attributes attributes)
        throws NamingException
    {
        getURLOrDefaultInitDirCtx(name).bind(name, obj, attributes);
    }

    public DirContext createSubcontext(String s, Attributes attributes)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(s).createSubcontext(s, attributes);
    }

    public DirContext createSubcontext(Name name, Attributes attributes)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(name).createSubcontext(name, attributes);
    }

    public Attributes getAttributes(String s)
        throws NamingException
    {
        return getAttributes(s, null);
    }

    public Attributes getAttributes(String s, String as[])
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(s).getAttributes(s, as);
    }

    public Attributes getAttributes(Name name)
        throws NamingException
    {
        return getAttributes(name, null);
    }

    public Attributes getAttributes(Name name, String as[])
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(name).getAttributes(name, as);
    }

    public DirContext getSchema(String s)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(s).getSchema(s);
    }

    public DirContext getSchema(Name name)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(name).getSchema(name);
    }

    public DirContext getSchemaClassDefinition(String s)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(s).getSchemaClassDefinition(s);
    }

    public DirContext getSchemaClassDefinition(Name name)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(name).getSchemaClassDefinition(name);
    }

    private DirContext getURLOrDefaultInitDirCtx(String s)
        throws NamingException
    {
        javax.naming.Context context = getURLOrDefaultInitCtx(s);
        if(!(context instanceof DirContext))
        {
            if(context == null)
            {
                throw new NoInitialContextException();
            } else
            {
                throw new NotContextException("Not an instance of DirContext");
            }
        } else
        {
            return (DirContext)context;
        }
    }

    private DirContext getURLOrDefaultInitDirCtx(Name name)
        throws NamingException
    {
        javax.naming.Context context = getURLOrDefaultInitCtx(name);
        if(!(context instanceof DirContext))
        {
            if(context == null)
            {
                throw new NoInitialContextException();
            } else
            {
                throw new NotContextException("Not an instance of DirContext");
            }
        } else
        {
            return (DirContext)context;
        }
    }

    public void modifyAttributes(String s, int i, Attributes attributes)
        throws NamingException
    {
        getURLOrDefaultInitDirCtx(s).modifyAttributes(s, i, attributes);
    }

    public void modifyAttributes(String s, ModificationItem amodificationitem[])
        throws NamingException
    {
        getURLOrDefaultInitDirCtx(s).modifyAttributes(s, amodificationitem);
    }

    public void modifyAttributes(Name name, int i, Attributes attributes)
        throws NamingException
    {
        getURLOrDefaultInitDirCtx(name).modifyAttributes(name, i, attributes);
    }

    public void modifyAttributes(Name name, ModificationItem amodificationitem[])
        throws NamingException
    {
        getURLOrDefaultInitDirCtx(name).modifyAttributes(name, amodificationitem);
    }

    public void rebind(String s, Object obj, Attributes attributes)
        throws NamingException
    {
        getURLOrDefaultInitDirCtx(s).rebind(s, obj, attributes);
    }

    public void rebind(Name name, Object obj, Attributes attributes)
        throws NamingException
    {
        getURLOrDefaultInitDirCtx(name).rebind(name, obj, attributes);
    }

    public NamingEnumeration search(String s, String s1, SearchControls searchcontrols)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(s).search(s, s1, searchcontrols);
    }

    public NamingEnumeration search(String s, String s1, Object aobj[], SearchControls searchcontrols)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(s).search(s, s1, aobj, searchcontrols);
    }

    public NamingEnumeration search(String s, Attributes attributes)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(s).search(s, attributes);
    }

    public NamingEnumeration search(String s, Attributes attributes, String as[])
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(s).search(s, attributes, as);
    }

    public NamingEnumeration search(Name name, String s, SearchControls searchcontrols)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(name).search(name, s, searchcontrols);
    }

    public NamingEnumeration search(Name name, String s, Object aobj[], SearchControls searchcontrols)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(name).search(name, s, aobj, searchcontrols);
    }

    public NamingEnumeration search(Name name, Attributes attributes)
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(name).search(name, attributes);
    }

    public NamingEnumeration search(Name name, Attributes attributes, String as[])
        throws NamingException
    {
        return getURLOrDefaultInitDirCtx(name).search(name, attributes, as);
    }
}
