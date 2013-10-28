package javax.servlet;

import java.util.Collection;
import java.util.Set;

// Referenced classes of package javax.servlet:
//            Registration

public interface ServletRegistration
    extends Registration
{
    /* member class not found */
    class Dynamic {}


    public transient abstract Set addMapping(String as[]);

    public abstract Collection getMappings();

    public abstract String getRunAsRole();
}