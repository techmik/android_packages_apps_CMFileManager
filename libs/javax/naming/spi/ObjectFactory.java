package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;

public interface ObjectFactory
{

    public abstract Object getObjectInstance(Object obj, Name name, Context context, Hashtable hashtable)
        throws Exception;
}
