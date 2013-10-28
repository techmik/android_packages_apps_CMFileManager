package javax.servlet;

import java.io.IOException;

// Referenced classes of package javax.servlet:
//            ServletException, ServletRequest, ServletResponse

public interface RequestDispatcher
{

    public abstract void forward(ServletRequest servletrequest, ServletResponse servletresponse)
        throws ServletException, IOException;

    public abstract void include(ServletRequest servletrequest, ServletResponse servletresponse)
        throws ServletException, IOException;
}