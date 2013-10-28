package javax.servlet;

import java.util.EventListener;

// Referenced classes of package javax.servlet:
//            ServletContextEvent

public interface ServletContextListener
    extends EventListener
{

    public abstract void contextInitialized(ServletContextEvent servletcontextevent);

    public abstract void contextDestroyed(ServletContextEvent servletcontextevent);
}