package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.*;

public interface StateFactory
{

    public abstract Object getStateToBind(Object obj, Name name, Context context, Hashtable hashtable)
        throws NamingException;
}
