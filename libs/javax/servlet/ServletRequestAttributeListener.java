package javax.servlet;

import java.util.EventListener;

// Referenced classes of package javax.servlet:
//            ServletRequestAttributeEvent

public interface ServletRequestAttributeListener
    extends EventListener
{

    public abstract void attributeAdded(ServletRequestAttributeEvent servletrequestattributeevent);

    public abstract void attributeRemoved(ServletRequestAttributeEvent servletrequestattributeevent);

    public abstract void attributeReplaced(ServletRequestAttributeEvent servletrequestattributeevent);
}
