package javax.naming.spi;

import javax.naming.Name;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.spi:
//            ResolveResult

public interface Resolver
{

    public abstract ResolveResult resolveToClass(String s, Class class1)
        throws NamingException;

    public abstract ResolveResult resolveToClass(Name name, Class class1)
        throws NamingException;
}
