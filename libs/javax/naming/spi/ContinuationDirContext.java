package javax.naming.spi;

import javax.naming.*;
import javax.naming.directory.*;

// Referenced classes of package javax.naming.spi:
//            ContinuationContext, DirContextNamePair, DirContextStringPair, NamingManager, 
//            ResolveResult, Resolver

class ContinuationDirContext extends ContinuationContext
    implements DirContext
{

    ContinuationDirContext(CannotProceedException cannotproceedexception)
    {
        super(cannotproceedexception);
    }

    public void bind(String s, Object obj, Attributes attributes)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        dircontextstringpair.getDirContext().bind(dircontextstringpair.getString(), obj, attributes);
    }

    public void bind(Name name, Object obj, Attributes attributes)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        dircontextnamepair.getDirContext().bind(dircontextnamepair.getName(), obj, attributes);
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public DirContext createSubcontext(String s, Attributes attributes)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().createSubcontext(dircontextstringpair.getString(), attributes);
    }

    public DirContext createSubcontext(Name name, Attributes attributes)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().createSubcontext(dircontextnamepair.getName(), attributes);
    }

    public Attributes getAttributes(String s)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().getAttributes(dircontextstringpair.getString());
    }

    public Attributes getAttributes(String s, String as[])
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().getAttributes(dircontextstringpair.getString(), as);
    }

    public Attributes getAttributes(Name name)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().getAttributes(dircontextnamepair.getName());
    }

    public Attributes getAttributes(Name name, String as[])
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().getAttributes(dircontextnamepair.getName(), as);
    }

    public DirContext getSchema(String s)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().getSchema(dircontextstringpair.getString());
    }

    public DirContext getSchema(Name name)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().getSchema(dircontextnamepair.getName());
    }

    public DirContext getSchemaClassDefinition(String s)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().getSchemaClassDefinition(dircontextstringpair.getString());
    }

    public DirContext getSchemaClassDefinition(Name name)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().getSchemaClassDefinition(dircontextnamepair.getName());
    }

    protected DirContextStringPair getTargetContext(String s)
        throws NamingException
    {
        if(super.cpe.getResolvedObj() == null)
        {
            throw (NamingException)super.cpe.fillInStackTrace();
        }
        Context context = NamingManager.getContext(super.cpe.getResolvedObj(), super.cpe.getAltName(), super.cpe.getAltNameCtx(), super.cpe.getEnvironment());
        if(context instanceof DirContext)
        {
            return new DirContextStringPair((DirContext)context, s);
        }
        if(context instanceof Resolver)
        {
            Resolver resolver = (Resolver)context;
            ResolveResult resolveresult = resolver.resolveToClass(s, javax.naming.directory.DirContext.class);
            DirContext dircontext = (DirContext)resolveresult.getResolvedObj();
            Name name = resolveresult.getRemainingName();
            String s1 = name == null ? "" : name.toString();
            return new DirContextStringPair(dircontext, s1);
        }
        Object obj = context.lookup(s);
        if(obj instanceof DirContext)
        {
            return new DirContextStringPair((DirContext)obj, "");
        } else
        {
            throw (NamingException)super.cpe.fillInStackTrace();
        }
    }

    protected DirContextNamePair getTargetContext(Name name)
        throws NamingException
    {
        if(super.cpe.getResolvedObj() == null)
        {
            throw (NamingException)super.cpe.fillInStackTrace();
        }
        Context context = NamingManager.getContext(super.cpe.getResolvedObj(), super.cpe.getAltName(), super.cpe.getAltNameCtx(), super.cpe.getEnvironment());
        if(context == null)
        {
            throw (NamingException)super.cpe.fillInStackTrace();
        }
        if(context instanceof DirContext)
        {
            return new DirContextNamePair((DirContext)context, name);
        }
        if(context instanceof Resolver)
        {
            Resolver resolver = (Resolver)context;
            ResolveResult resolveresult = resolver.resolveToClass(name, javax.naming.directory.DirContext.class);
            DirContext dircontext = (DirContext)resolveresult.getResolvedObj();
            return new DirContextNamePair(dircontext, resolveresult.getRemainingName());
        }
        Object obj = context.lookup(name);
        if(obj instanceof DirContext)
        {
            return new DirContextNamePair((DirContext)obj, new CompositeName());
        } else
        {
            throw (NamingException)super.cpe.fillInStackTrace();
        }
    }

    public void modifyAttributes(String s, int i, Attributes attributes)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        dircontextstringpair.getDirContext().modifyAttributes(dircontextstringpair.getString(), i, attributes);
    }

    public void modifyAttributes(String s, ModificationItem amodificationitem[])
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        dircontextstringpair.getDirContext().modifyAttributes(dircontextstringpair.getString(), amodificationitem);
    }

    public void modifyAttributes(Name name, int i, Attributes attributes)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        dircontextnamepair.getDirContext().modifyAttributes(dircontextnamepair.getName(), i, attributes);
    }

    public void modifyAttributes(Name name, ModificationItem amodificationitem[])
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        dircontextnamepair.getDirContext().modifyAttributes(dircontextnamepair.getName(), amodificationitem);
    }

    public void rebind(String s, Object obj, Attributes attributes)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        dircontextstringpair.getDirContext().rebind(dircontextstringpair.getString(), obj, attributes);
    }

    public void rebind(Name name, Object obj, Attributes attributes)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        dircontextnamepair.getDirContext().rebind(dircontextnamepair.getName(), obj, attributes);
    }

    public NamingEnumeration search(String s, String s1, SearchControls searchcontrols)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().search(dircontextstringpair.getString(), s1, searchcontrols);
    }

    public NamingEnumeration search(String s, String s1, Object aobj[], SearchControls searchcontrols)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().search(dircontextstringpair.getString(), s1, aobj, searchcontrols);
    }

    public NamingEnumeration search(String s, Attributes attributes)
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().search(dircontextstringpair.getString(), attributes);
    }

    public NamingEnumeration search(String s, Attributes attributes, String as[])
        throws NamingException
    {
        DirContextStringPair dircontextstringpair = getTargetContext(s);
        return dircontextstringpair.getDirContext().search(dircontextstringpair.getString(), attributes, as);
    }

    public NamingEnumeration search(Name name, String s, SearchControls searchcontrols)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().search(dircontextnamepair.getName(), s, searchcontrols);
    }

    public NamingEnumeration search(Name name, String s, Object aobj[], SearchControls searchcontrols)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().search(dircontextnamepair.getName(), s, aobj, searchcontrols);
    }

    public NamingEnumeration search(Name name, Attributes attributes)
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().search(dircontextnamepair.getName(), attributes);
    }

    public NamingEnumeration search(Name name, Attributes attributes, String as[])
        throws NamingException
    {
        DirContextNamePair dircontextnamepair = getTargetContext(name);
        return dircontextnamepair.getDirContext().search(dircontextnamepair.getName(), attributes, as);
    }
}
