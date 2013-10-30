package javax.servlet;

import java.util.EventListener;

// Referenced classes of package javax.servlet:
//            ServletRequestEvent

public interface ServletRequestListener
    extends EventListener
{

    public abstract void requestDestroyed(ServletRequestEvent servletrequestevent);

    public abstract void requestInitialized(ServletRequestEvent servletrequestevent);
}
