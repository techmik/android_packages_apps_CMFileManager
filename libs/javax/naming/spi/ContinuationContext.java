package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.*;

// Referenced classes of package javax.naming.spi:
//            NamingManager, Resolver, ResolveResult

class ContinuationContext
    implements Context, Resolver
{

    protected CannotProceedException cpe;
    protected Context contCtx;

    protected ContinuationContext(CannotProceedException cannotproceedexception)
    {
        contCtx = null;
        cpe = cannotproceedexception;
    }

    public Object addToEnvironment(String s, Object obj)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.addToEnvironment(s, obj);
    }

    public void bind(String s, Object obj)
        throws NamingException
    {
        Context context = getTargetContext();
        context.bind(s, obj);
    }

    public void bind(Name name, Object obj)
        throws NamingException
    {
        Context context = getTargetContext();
        context.bind(name, obj);
    }

    public void close()
        throws NamingException
    {
        cpe = null;
        if(contCtx != null)
        {
            contCtx.close();
            contCtx = null;
        }
    }

    public String composeName(String s, String s1)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.composeName(s, s1);
    }

    public Name composeName(Name name, Name name1)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.composeName(name, name1);
    }

    public Context createSubcontext(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.createSubcontext(s);
    }

    public Context createSubcontext(Name name)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.createSubcontext(name);
    }

    public void destroySubcontext(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        context.destroySubcontext(s);
    }

    public void destroySubcontext(Name name)
        throws NamingException
    {
        Context context = getTargetContext();
        context.destroySubcontext(name);
    }

    public Hashtable getEnvironment()
        throws NamingException
    {
        Context context = getTargetContext();
        return context.getEnvironment();
    }

    public String getNameInNamespace()
        throws NamingException
    {
        Context context = getTargetContext();
        return context.getNameInNamespace();
    }

    public NameParser getNameParser(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.getNameParser(s);
    }

    public NameParser getNameParser(Name name)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.getNameParser(name);
    }

    protected Context getTargetContext()
        throws NamingException
    {
        if(contCtx == null)
        {
            if(cpe.getResolvedObj() == null)
            {
                throw (NamingException)cpe.fillInStackTrace();
            }
            contCtx = NamingManager.getContext(cpe.getResolvedObj(), cpe.getAltName(), cpe.getAltNameCtx(), cpe.getEnvironment());
            if(contCtx == null)
            {
                throw (NamingException)cpe.fillInStackTrace();
            }
        }
        return contCtx;
    }

    public NamingEnumeration list(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.list(s);
    }

    public NamingEnumeration list(Name name)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.list(name);
    }

    public NamingEnumeration listBindings(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.listBindings(s);
    }

    public NamingEnumeration listBindings(Name name)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.listBindings(name);
    }

    public Object lookup(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.lookup(s);
    }

    public Object lookup(Name name)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.lookup(name);
    }

    public Object lookupLink(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.lookupLink(s);
    }

    public Object lookupLink(Name name)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.lookupLink(name);
    }

    public void rebind(String s, Object obj)
        throws NamingException
    {
        Context context = getTargetContext();
        context.rebind(s, obj);
    }

    public void rebind(Name name, Object obj)
        throws NamingException
    {
        Context context = getTargetContext();
        context.rebind(name, obj);
    }

    public Object removeFromEnvironment(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        return context.removeFromEnvironment(s);
    }

    public void rename(String s, String s1)
        throws NamingException
    {
        Context context = getTargetContext();
        context.rename(s, s1);
    }

    public void rename(Name name, Name name1)
        throws NamingException
    {
        Context context = getTargetContext();
        context.rename(name, name1);
    }

    public ResolveResult resolveToClass(String s, Class class1)
        throws NamingException
    {
        if(cpe.getResolvedObj() == null)
        {
            throw (NamingException)cpe.fillInStackTrace();
        }
        Resolver resolver = NamingManager.getResolver(cpe.getResolvedObj(), cpe.getAltName(), cpe.getAltNameCtx(), cpe.getEnvironment());
        if(resolver == null)
        {
            throw (NamingException)cpe.fillInStackTrace();
        } else
        {
            return resolver.resolveToClass(s, class1);
        }
    }

    public ResolveResult resolveToClass(Name name, Class class1)
        throws NamingException
    {
        if(cpe.getResolvedObj() == null)
        {
            throw (NamingException)cpe.fillInStackTrace();
        }
        Resolver resolver = NamingManager.getResolver(cpe.getResolvedObj(), cpe.getAltName(), cpe.getAltNameCtx(), cpe.getEnvironment());
        if(resolver == null)
        {
            throw (NamingException)cpe.fillInStackTrace();
        } else
        {
            return resolver.resolveToClass(name, class1);
        }
    }

    public void unbind(String s)
        throws NamingException
    {
        Context context = getTargetContext();
        context.unbind(s);
    }

    public void unbind(Name name)
        throws NamingException
    {
        Context context = getTargetContext();
        context.unbind(name);
    }
}
