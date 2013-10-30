package javax.naming;

import com.sun.naming.internal.ResourceManager;
import java.util.Hashtable;
import javax.naming.spi.NamingManager;

// Referenced classes of package javax.naming:
//            Context, Name, NamingException, NoInitialContextException, 
//            NameParser, NamingEnumeration

public class InitialContext
    implements Context
{

    protected Hashtable myProps;
    protected Context defaultInitCtx;
    protected boolean gotDefault;

    public InitialContext()
        throws NamingException
    {
        myProps = null;
        defaultInitCtx = null;
        gotDefault = false;
        init(null);
    }

    public InitialContext(Hashtable hashtable)
        throws NamingException
    {
        myProps = null;
        defaultInitCtx = null;
        gotDefault = false;
        if(hashtable != null)
        {
            hashtable = (Hashtable)hashtable.clone();
        }
        init(hashtable);
    }

    protected InitialContext(boolean flag)
        throws NamingException
    {
        myProps = null;
        defaultInitCtx = null;
        gotDefault = false;
        if(!flag)
        {
            init(null);
        }
    }

    public Object addToEnvironment(String s, Object obj)
        throws NamingException
    {
        myProps.put(s, obj);
        return getDefaultInitCtx().addToEnvironment(s, obj);
    }

    public void bind(String s, Object obj)
        throws NamingException
    {
        getURLOrDefaultInitCtx(s).bind(s, obj);
    }

    public void bind(Name name, Object obj)
        throws NamingException
    {
        getURLOrDefaultInitCtx(name).bind(name, obj);
    }

    public void close()
        throws NamingException
    {
        myProps = null;
        if(defaultInitCtx != null)
        {
            defaultInitCtx.close();
            defaultInitCtx = null;
        }
        gotDefault = false;
    }

    public String composeName(String s, String s1)
        throws NamingException
    {
        return s;
    }

    public Name composeName(Name name, Name name1)
        throws NamingException
    {
        return (Name)name.clone();
    }

    public Context createSubcontext(String s)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(s).createSubcontext(s);
    }

    public Context createSubcontext(Name name)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(name).createSubcontext(name);
    }

    public void destroySubcontext(String s)
        throws NamingException
    {
        getURLOrDefaultInitCtx(s).destroySubcontext(s);
    }

    public void destroySubcontext(Name name)
        throws NamingException
    {
        getURLOrDefaultInitCtx(name).destroySubcontext(name);
    }

    protected Context getDefaultInitCtx()
        throws NamingException
    {
        if(!gotDefault)
        {
            defaultInitCtx = NamingManager.getInitialContext(myProps);
            gotDefault = true;
        }
        if(defaultInitCtx == null)
        {
            throw new NoInitialContextException();
        } else
        {
            return defaultInitCtx;
        }
    }

    public Hashtable getEnvironment()
        throws NamingException
    {
        return getDefaultInitCtx().getEnvironment();
    }

    public String getNameInNamespace()
        throws NamingException
    {
        return getDefaultInitCtx().getNameInNamespace();
    }

    public NameParser getNameParser(String s)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(s).getNameParser(s);
    }

    public NameParser getNameParser(Name name)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(name).getNameParser(name);
    }

    protected Context getURLOrDefaultInitCtx(String s)
        throws NamingException
    {
        if(NamingManager.hasInitialContextFactoryBuilder())
        {
            return getDefaultInitCtx();
        }
        String s1 = getURLScheme(s);
        if(s1 != null)
        {
            Context context = NamingManager.getURLContext(s1, myProps);
            if(context != null)
            {
                return context;
            }
        }
        return getDefaultInitCtx();
    }

    protected Context getURLOrDefaultInitCtx(Name name)
        throws NamingException
    {
        if(NamingManager.hasInitialContextFactoryBuilder())
        {
            return getDefaultInitCtx();
        }
        if(name.size() > 0)
        {
            String s = name.get(0);
            String s1 = getURLScheme(s);
            if(s1 != null)
            {
                Context context = NamingManager.getURLContext(s1, myProps);
                if(context != null)
                {
                    return context;
                }
            }
        }
        return getDefaultInitCtx();
    }

    private static String getURLScheme(String s)
    {
        int i = s.indexOf(':');
        int j = s.indexOf('/');
        if(i > 0 && (j == -1 || i < j))
        {
            return s.substring(0, i);
        } else
        {
            return null;
        }
    }

    protected void init(Hashtable hashtable)
        throws NamingException
    {
        myProps = ResourceManager.getInitialEnvironment(hashtable);
        if(myProps.get("java.naming.factory.initial") != null)
        {
            getDefaultInitCtx();
        }
    }

    public NamingEnumeration list(String s)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(s).list(s);
    }

    public NamingEnumeration list(Name name)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(name).list(name);
    }

    public NamingEnumeration listBindings(String s)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(s).listBindings(s);
    }

    public NamingEnumeration listBindings(Name name)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(name).listBindings(name);
    }

    public Object lookup(String s)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(s).lookup(s);
    }

    public Object lookup(Name name)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(name).lookup(name);
    }

    public Object lookupLink(String s)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(s).lookupLink(s);
    }

    public Object lookupLink(Name name)
        throws NamingException
    {
        return getURLOrDefaultInitCtx(name).lookupLink(name);
    }

    public void rebind(String s, Object obj)
        throws NamingException
    {
        getURLOrDefaultInitCtx(s).rebind(s, obj);
    }

    public void rebind(Name name, Object obj)
        throws NamingException
    {
        getURLOrDefaultInitCtx(name).rebind(name, obj);
    }

    public Object removeFromEnvironment(String s)
        throws NamingException
    {
        myProps.remove(s);
        return getDefaultInitCtx().removeFromEnvironment(s);
    }

    public void rename(String s, String s1)
        throws NamingException
    {
        getURLOrDefaultInitCtx(s).rename(s, s1);
    }

    public void rename(Name name, Name name1)
        throws NamingException
    {
        getURLOrDefaultInitCtx(name).rename(name, name1);
    }

    public void unbind(String s)
        throws NamingException
    {
        getURLOrDefaultInitCtx(s).unbind(s);
    }

    public void unbind(Name name)
        throws NamingException
    {
        getURLOrDefaultInitCtx(name).unbind(name);
    }
}
