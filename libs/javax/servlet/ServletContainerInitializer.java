package javax.servlet;

import java.util.Set;

// Referenced classes of package javax.servlet:
//            ServletException, ServletContext

public interface ServletContainerInitializer
{

    public abstract void onStartup(Set set, ServletContext servletcontext)
        throws ServletException;
}