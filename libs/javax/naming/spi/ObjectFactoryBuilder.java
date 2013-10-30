package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.spi:
//            ObjectFactory

public interface ObjectFactoryBuilder
{

    public abstract ObjectFactory createObjectFactory(Object obj, Hashtable hashtable)
        throws NamingException;
}
