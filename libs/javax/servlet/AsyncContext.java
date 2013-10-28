package javax.servlet;


// Referenced classes of package javax.servlet:
//            ServletException, ServletRequest, ServletResponse, ServletContext, 
//            AsyncListener

public interface AsyncContext
{

    public abstract ServletRequest getRequest();

    public abstract ServletResponse getResponse();

    public abstract boolean hasOriginalRequestAndResponse();

    public abstract void dispatch();

    public abstract void dispatch(String s);

    public abstract void dispatch(ServletContext servletcontext, String s);

    public abstract void complete();

    public abstract void start(Runnable runnable);

    public abstract void addListener(AsyncListener asynclistener);

    public abstract void addListener(AsyncListener asynclistener, ServletRequest servletrequest, ServletResponse servletresponse);

    public abstract AsyncListener createListener(Class class1)
        throws ServletException;

    public abstract void setTimeout(long l);

    public abstract long getTimeout();

    public static final String ASYNC_REQUEST_URI = "javax.servlet.async.request_uri";
    public static final String ASYNC_CONTEXT_PATH = "javax.servlet.async.context_path";
    public static final String ASYNC_PATH_INFO = "javax.servlet.async.path_info";
    public static final String ASYNC_SERVLET_PATH = "javax.servlet.async.servlet_path";
    public static final String ASYNC_QUERY_STRING = "javax.servlet.async.query_string";
}