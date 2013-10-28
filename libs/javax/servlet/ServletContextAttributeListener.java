package javax.servlet;

import java.util.EventListener;

// Referenced classes of package javax.servlet:
//            ServletContextAttributeEvent

public interface ServletContextAttributeListener
    extends EventListener
{

    public abstract void attributeAdded(ServletContextAttributeEvent servletcontextattributeevent);

    public abstract void attributeRemoved(ServletContextAttributeEvent servletcontextattributeevent);

    public abstract void attributeReplaced(ServletContextAttributeEvent servletcontextattributeevent);
}