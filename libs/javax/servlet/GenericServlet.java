package javax.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.ResourceBundle;

// Referenced classes of package javax.servlet:
//            Servlet, ServletConfig, ServletException, ServletContext, 
//            ServletRequest, ServletResponse

public abstract class GenericServlet
    implements Servlet, ServletConfig, Serializable
{

    public GenericServlet()
    {
    }

    public void destroy()
    {
    }

    public String getInitParameter(String name)
    {
        ServletConfig sc = getServletConfig();
        if(sc == null)
            throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
        else
            return sc.getInitParameter(name);
    }

    public Enumeration getInitParameterNames()
    {
        ServletConfig sc = getServletConfig();
        if(sc == null)
            throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
        else
            return sc.getInitParameterNames();
    }

    public ServletConfig getServletConfig()
    {
        return config;
    }

    public ServletContext getServletContext()
    {
        ServletConfig sc = getServletConfig();
        if(sc == null)
            throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
        else
            return sc.getServletContext();
    }

    public String getServletInfo()
    {
        return "";
    }

    public void init(ServletConfig config)
        throws ServletException
    {
        this.config = config;
        init();
    }

    public void init()
        throws ServletException
    {
    }

    public void log(String msg)
    {
        getServletContext().log(getServletName() + ": " + msg);
    }

    public void log(String message, Throwable t)
    {
        getServletContext().log(getServletName() + ": " + message, t);
    }

    public abstract void service(ServletRequest servletrequest, ServletResponse servletresponse)
        throws ServletException, IOException;

    public String getServletName()
    {
        ServletConfig sc = getServletConfig();
        if(sc == null)
            throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
        else
            return sc.getServletName();
    }

    private static final String LSTRING_FILE = "javax.servlet.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.LocalStrings");
    private transient ServletConfig config;

}