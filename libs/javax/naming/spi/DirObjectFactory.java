package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.directory.Attributes;

// Referenced classes of package javax.naming.spi:
//            ObjectFactory

public interface DirObjectFactory
    extends ObjectFactory
{

    public abstract Object getObjectInstance(Object obj, Name name, Context context, Hashtable hashtable, Attributes attributes)
        throws Exception;
}
