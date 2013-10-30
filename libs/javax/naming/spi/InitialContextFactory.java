package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;

public interface InitialContextFactory
{

    public abstract Context getInitialContext(Hashtable hashtable)
        throws NamingException;
}
