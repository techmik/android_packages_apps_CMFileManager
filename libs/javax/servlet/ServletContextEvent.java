package javax.servlet;

import java.util.EventObject;

// Referenced classes of package javax.servlet:
//            ServletContext

public class ServletContextEvent extends EventObject
{

    public ServletContextEvent(ServletContext source)
    {
        super(source);
    }

    public ServletContext getServletContext()
    {
        return (ServletContext)super.getSource();
    }
}
