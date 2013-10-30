package javax.naming.spi;

import com.sun.naming.internal.FactoryEnumeration;
import com.sun.naming.internal.ResourceManager;
import java.util.Hashtable;
import javax.naming.*;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;

// Referenced classes of package javax.naming.spi:
//            NamingManager, ContinuationDirContext, DirObjectFactory, DirStateFactory, 
//            ObjectFactory, ObjectFactoryBuilder, StateFactory

public class DirectoryManager extends NamingManager
{

    DirectoryManager()
    {
    }

    private static Object createObjectFromFactories(Object obj, Name name, Context context, Hashtable hashtable, Attributes attributes)
        throws Exception
    {
        FactoryEnumeration factoryenumeration = ResourceManager.getFactories("java.naming.factory.object", hashtable, context);
        if(factoryenumeration == null)
        {
            return null;
        }
        Object obj1;
        for(obj1 = null; obj1 == null && factoryenumeration.hasMore();)
        {
            ObjectFactory objectfactory = (ObjectFactory)factoryenumeration.next();
            if(objectfactory instanceof DirObjectFactory)
            {
                obj1 = ((DirObjectFactory)objectfactory).getObjectInstance(obj, name, context, hashtable, attributes);
            } else
            {
                obj1 = objectfactory.getObjectInstance(obj, name, context, hashtable);
            }
        }

        return obj1;
    }

    public static DirContext getContinuationDirContext(CannotProceedException cannotproceedexception)
        throws NamingException
    {
        Hashtable hashtable = cannotproceedexception.getEnvironment();
        if(hashtable == null)
        {
            hashtable = new Hashtable(7);
            cannotproceedexception.setEnvironment(hashtable);
        }
        hashtable.put("java.naming.spi.CannotProceedException", cannotproceedexception);
        return new ContinuationDirContext(cannotproceedexception);
    }

    public static Object getObjectInstance(Object obj, Name name, Context context, Hashtable hashtable, Attributes attributes)
        throws Exception
    {
        ObjectFactoryBuilder objectfactorybuilder = NamingManager.getObjectFactoryBuilder();
        if(objectfactorybuilder != null)
        {
            ObjectFactory objectfactory = objectfactorybuilder.createObjectFactory(obj, hashtable);
            if(objectfactory instanceof DirObjectFactory)
            {
                return ((DirObjectFactory)objectfactory).getObjectInstance(obj, name, context, hashtable, attributes);
            } else
            {
                return objectfactory.getObjectInstance(obj, name, context, hashtable);
            }
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
                ObjectFactory objectfactory1 = NamingManager.getObjectFactoryFromReference(reference, s);
                if(objectfactory1 instanceof DirObjectFactory)
                {
                    return ((DirObjectFactory)objectfactory1).getObjectInstance(reference, name, context, hashtable, attributes);
                }
                if(objectfactory1 != null)
                {
                    return objectfactory1.getObjectInstance(reference, name, context, hashtable);
                } else
                {
                    return obj;
                }
            }
            Object obj1 = NamingManager.processURLAddrs(reference, name, context, hashtable);
            if(obj1 != null)
            {
                return obj1;
            }
        }
        Object obj2 = createObjectFromFactories(obj, name, context, hashtable, attributes);
        return obj2 == null ? obj : obj2;
    }

    public static DirStateFactory.Result getStateToBind(Object obj, Name name, Context context, Hashtable hashtable, Attributes attributes)
        throws NamingException
    {
        FactoryEnumeration factoryenumeration = ResourceManager.getFactories("java.naming.factory.state", hashtable, context);
        if(factoryenumeration == null)
        {
            return new DirStateFactory.Result(obj, attributes);
        }
        DirStateFactory.Result result;
        for(result = null; result == null && factoryenumeration.hasMore();)
        {
            StateFactory statefactory = (StateFactory)factoryenumeration.next();
            if(statefactory instanceof DirStateFactory)
            {
                result = ((DirStateFactory)statefactory).getStateToBind(obj, name, context, hashtable, attributes);
            } else
            {
                Object obj1 = statefactory.getStateToBind(obj, name, context, hashtable);
                if(obj1 != null)
                {
                    result = new DirStateFactory.Result(obj1, attributes);
                }
            }
        }

        return result == null ? new DirStateFactory.Result(obj, attributes) : result;
    }
}
