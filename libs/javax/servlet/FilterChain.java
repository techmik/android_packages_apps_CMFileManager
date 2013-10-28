package javax.servlet;

import java.io.IOException;

// Referenced classes of package javax.servlet:
//            ServletException, ServletRequest, ServletResponse

public interface FilterChain
{

    public abstract void doFilter(ServletRequest servletrequest, ServletResponse servletresponse)
        throws IOException, ServletException;
}