package javax.servlet;

import java.util.Collection;
import java.util.EnumSet;

// Referenced classes of package javax.servlet:
//            Registration

public interface FilterRegistration
    extends Registration
{
    /* member class not found */
    class Dynamic {}


    public transient abstract void addMappingForServletNames(EnumSet enumset, boolean flag, String as[]);

    public abstract Collection getServletNameMappings();

    public transient abstract void addMappingForUrlPatterns(EnumSet enumset, boolean flag, String as[]);

    public abstract Collection getUrlPatternMappings();
}