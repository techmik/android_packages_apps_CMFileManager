package javax.servlet;

import java.util.EventObject;

// Referenced classes of package javax.servlet:
//            ServletContext, ServletRequest

public class ServletRequestEvent extends EventObject
{

    public ServletRequestEvent(ServletContext sc, ServletRequest request)
    {
        super(sc);
        this.request = request;
    }

    public ServletRequest getServletRequest()
    {
        return request;
    }

    public ServletContext getServletContext()
    {
        return (ServletContext)super.getSource();
    }

    private ServletRequest request;
}