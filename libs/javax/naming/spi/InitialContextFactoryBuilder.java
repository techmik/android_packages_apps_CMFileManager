package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.spi:
//            InitialContextFactory

public interface InitialContextFactoryBuilder
{

    public abstract InitialContextFactory createInitialContextFactory(Hashtable hashtable)
        throws NamingException;
}
