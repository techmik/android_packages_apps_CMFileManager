package javax.servlet;

import java.io.IOException;

// Referenced classes of package javax.servlet:
//            ServletException, FilterConfig, ServletRequest, ServletResponse, 
//            FilterChain

public interface Filter
{

    public abstract void init(FilterConfig filterconfig)
        throws ServletException;

    public abstract void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
        throws IOException, ServletException;

    public abstract void destroy();
}