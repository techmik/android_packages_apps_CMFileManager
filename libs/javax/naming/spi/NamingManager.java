package javax.naming.spi;

import com.sun.naming.internal.*;
import java.net.MalformedURLException;
import java.util.Hashtable;
import javax.naming.*;

// Referenced classes of package javax.naming.spi:
//            ContinuationContext, InitialContextFactory, InitialContextFactoryBuilder, ObjectFactory, 
//            ObjectFactoryBuilder, Resolver, StateFactory

public class NamingManager
{

    private static boolean debug = true;
    static VersionHelper helper = VersionHelper.getVersionHelper();
    private static ObjectFactoryBuilder object_factory_builder = null;
    private static final String defaultPkgPrefix = "com.sun.jndi.url";
    private static InitialContextFactoryBuilder initctx_factory_builder = null;
    public static final String CPE = "java.naming.spi.CannotProceedException";

    NamingManager()
    {
    }

    private static Object createObjectFromFactories(Object obj, Name name, Context context, Hashtable hashtable)
        throws Exception
    {
        FactoryEnumeration factoryenumeration = ResourceManager.getFactories("java.naming.factory.object", hashtable, context);
        if(factoryenumeration == null)
        {
            return null;
        }
        ObjectFactory objectfactory;
        Object obj1;
        for(obj1 = null; obj1 == null && factoryenumeration.hasMore(); obj1 = objectfactory.getObjectInstance(obj, name, context, hashtable))
        {
            objectfactory = (ObjectFactory)factoryenumeration.next();
        }

        return obj1;
    }

    static Context getContext(Object obj, Name name, Context context, Hashtable hashtable)
        throws NamingException
    {
        if(obj instanceof Context)
        {
            return (Context)obj;
        }
        Object obj1;
        try
        {
            obj1 = getObjectInstance(obj, name, context, hashtable);
        }
        catch(NamingException namingexception)
        {
            throw namingexception;
        }
        catch(Exception exception)
        {
            NamingException namingexception1 = new NamingException();
            namingexception1.setRootCause(exception);
            throw namingexception1;
        }
        return (obj1 instanceof Context) ? (Context)obj1 : null;
    }

    public static Context getContinuationContext(CannotProceedException cannotproceedexception)
        throws NamingException
    {
        Hashtable hashtable = cannotproceedexception.getEnvironment();
        if(hashtable == null)
        {
            hashtable = new Hashtable(7);
            cannotproceedexception.setEnvironment(hashtable);
        }
        hashtable.put("java.naming.spi.CannotProceedException", cannotproceedexception);
        ContinuationContext continuationcontext = new ContinuationContext(cannotproceedexception);
        return continuationcontext.getTargetContext();
    }

    public static Context getInitialContext(Hashtable hashtable)
        throws NamingException
    {
        InitialContextFactoryBuilder initialcontextfactorybuilder = getInitialContextFactoryBuilder();
        InitialContextFactory initialcontextfactory;
        if(initialcontextfactorybuilder == null)
        {
            String s = hashtable == null ? null : (String)hashtable.get("java.naming.factory.initial");
            if(s == null)
            {
                NoInitialContextException noinitialcontextexception = new NoInitialContextException("Need to specify class name in environment or system property, or as an applet pa" +
"rameter, or in an application resource file:  java.naming.factory.initial"
);
                throw noinitialcontextexception;
            }
            try
            {
                initialcontextfactory = (InitialContextFactory)helper.loadClass(s).newInstance();
            }
            catch(Exception exception)
            {
                NoInitialContextException noinitialcontextexception1 = new NoInitialContextException("Cannot instantiate class: " + s);
                noinitialcontextexception1.setRootCause(exception);
                throw noinitialcontextexception1;
            }
        } else
        {
            initialcontextfactory = initialcontextfactorybuilder.createInitialContextFactory(hashtable);
        }
        return initialcontextfactory.getInitialContext(hashtable);
    }

    private static InitialContextFactoryBuilder getInitialContextFactoryBuilder()
    {
        return initctx_factory_builder;
    }

    static ObjectFactoryBuilder getObjectFactoryBuilder()
    {
        return object_factory_builder;
    }

    static ObjectFactory getObjectFactoryFromReference(Reference reference, String s)
        throws IllegalAccessException, InstantiationException, MalformedURLException
    {
        Class class1 = null;
        try
        {
            class1 = helper.loadClass(s);
        }
        catch(ClassNotFoundException _ex) { }
        String s1;
        if(class1 == null && (s1 = reference.getFactoryClassLocation()) != null)
        {
            try
            {
                class1 = helper.loadClass(s, s1);
            }
            catch(ClassNotFoundException _ex) { }
        }
        return class1 == null ? null : (ObjectFactory)class1.newInstance();
    }

    public static Object getObjectInstance(Object obj, Name name, Context context, Hashtable hashtable)
        throws Exception
    {
        ObjectFactoryBuilder objectfactorybuilder = getObjectFactoryBuilder();
        if(objectfactorybuilder != null)
        {
            ObjectFactory objectfactory = objectfactorybuilder.createObjectFactory(obj, hashtable);
            return objectfactory.getObjectInstance(obj, name, context, hashtable);
        }
        Reference reference = null;
        if(obj instanceof Reference)
        {
            reference = (Reference)obj;
        } else
        if(obj instanceof Referenceable)
        {
            reference = ((Referenceable)obj).getReference();
        }
        if(reference != null)
        {
            String s = reference.getFactoryClassName();
            if(s != null)
            {
                ObjectFactory objectfactory1 = getObjectFactoryFromReference(reference, s);
                if(objectfactory1 != null)
                {
                    return objectfactory1.getObjectInstance(reference, name, context, hashtable);
                } else
                {
                    return obj;
                }
            }
            Object obj1 = processURLAddrs(reference, name, context, hashtable);
            if(obj1 != null)
            {
                return obj1;
            }
        }
        Object obj2 = createObjectFromFactories(obj, name, context, hashtable);
        return obj2 == null ? obj : obj2;
    }

    static Resolver getResolver(Object obj, Name name, Context context, Hashtable hashtable)
        throws NamingException
    {
        if(obj instanceof Resolver)
        {
            return (Resolver)obj;
        }
        Object obj1;
        try
        {
            obj1 = getObjectInstance(obj, name, context, hashtable);
        }
        catch(NamingException namingexception)
        {
            throw namingexception;
        }
        catch(Exception exception)
        {
            NamingException namingexception1 = new NamingException();
            namingexception1.setRootCause(exception);
            throw namingexception1;
        }
        return (obj1 instanceof Resolver) ? (Resolver)obj1 : null;
    }

    public static Object getStateToBind(Object obj, Name name, Context context, Hashtable hashtable)
        throws NamingException
    {
        FactoryEnumeration factoryenumeration = ResourceManager.getFactories("java.naming.factory.state", hashtable, context);
        if(factoryenumeration == null)
        {
            return obj;
        }
        StateFactory statefactory;
        Object obj1;
        for(obj1 = null; obj1 == null && factoryenumeration.hasMore(); obj1 = statefactory.getStateToBind(obj, name, context, hashtable))
        {
            statefactory = (StateFactory)factoryenumeration.next();
        }

        return obj1 == null ? obj : obj1;
    }

    public static Context getURLContext(String s, Hashtable hashtable)
        throws NamingException
    {
        Object obj = getURLObject(s, null, null, null, hashtable);
        if(obj instanceof Context)
        {
            return (Context)obj;
        } else
        {
            return null;
        }
    }

    private static Object getURLObject(String s, Object obj, Name name, Context context, Hashtable hashtable)
        throws NamingException
    {
        ObjectFactory objectfactory = (ObjectFactory)ResourceManager.getFactory("java.naming.factory.url.pkgs", hashtable, context, "." + s + "." + s + "URLContextFactory", "com.sun.jndi.url");
        if(objectfactory == null)
        {
            return null;
        }
        try
        {
            return objectfactory.getObjectInstance(obj, name, context, hashtable);
        }
        catch(NamingException namingexception)
        {
            throw namingexception;
        }
        catch(Exception exception)
        {
            NamingException namingexception1 = new NamingException();
            namingexception1.setRootCause(exception);
            throw namingexception1;
        }
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

    public static boolean hasInitialContextFactoryBuilder()
    {
        return initctx_factory_builder != null;
    }

    private static Object processURL(Object obj, Name name, Context context, Hashtable hashtable)
        throws NamingException
    {
        if(obj instanceof String)
        {
            String s = (String)obj;
            String s1 = getURLScheme(s);
            if(s1 != null)
            {
                Object obj1 = getURLObject(s1, obj, name, context, hashtable);
                if(obj1 != null)
                {
                    return obj1;
                }
            }
        }
        if(obj instanceof String[])
        {
            String as[] = (String[])obj;
            for(int i = 0; i < as.length; i++)
            {
                String s2 = getURLScheme(as[i]);
                if(s2 != null)
                {
                    Object obj2 = getURLObject(s2, obj, name, context, hashtable);
                    if(obj2 != null)
                    {
                        return obj2;
                    }
                }
            }

        }
        return null;
    }

    static Object processURLAddrs(Reference reference, Name name, Context context, Hashtable hashtable)
        throws NamingException
    {
        for(int i = 0; i < reference.size(); i++)
        {
            RefAddr refaddr = reference.get(i);
            if((refaddr instanceof StringRefAddr) && refaddr.getType().equalsIgnoreCase("URL"))
            {
                String s = (String)refaddr.getContent();
                Object obj = processURL(s, name, context, hashtable);
                if(obj != null)
                {
                    return obj;
                }
            }
        }

        return null;
    }

    public static synchronized void setInitialContextFactoryBuilder(InitialContextFactoryBuilder initialcontextfactorybuilder)
        throws NamingException
    {
        if(initctx_factory_builder != null)
        {
            throw new IllegalStateException("InitialContextFactoryBuilder already set");
        }
        SecurityManager securitymanager = System.getSecurityManager();
        if(securitymanager != null)
        {
            securitymanager.checkSetFactory();
        }
        initctx_factory_builder = initialcontextfactorybuilder;
    }

    public static synchronized void setObjectFactoryBuilder(ObjectFactoryBuilder objectfactorybuilder)
        throws NamingException
    {
        if(object_factory_builder != null)
        {
            throw new IllegalStateException("ObjectFactoryBuilder already set");
        }
        SecurityManager securitymanager = System.getSecurityManager();
        if(securitymanager != null)
        {
            securitymanager.checkSetFactory();
        }
        object_factory_builder = objectfactorybuilder;
    }

}
