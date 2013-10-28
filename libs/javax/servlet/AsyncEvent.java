package javax.servlet;


// Referenced classes of package javax.servlet:
//            AsyncContext, ServletRequest, ServletResponse

public class AsyncEvent
{

    public AsyncEvent(AsyncContext context)
    {
        this(context, null, null, null);
    }

    public AsyncEvent(AsyncContext context, ServletRequest request, ServletResponse response)
    {
        this(context, request, response, null);
    }

    public AsyncEvent(AsyncContext context, Throwable throwable)
    {
        this(context, null, null, throwable);
    }

    public AsyncEvent(AsyncContext context, ServletRequest request, ServletResponse response, Throwable throwable)
    {
        this.context = context;
        this.request = request;
        this.response = response;
        this.throwable = throwable;
    }

    public AsyncContext getAsyncContext()
    {
        return context;
    }

    public ServletRequest getSuppliedRequest()
    {
        return request;
    }

    public ServletResponse getSuppliedResponse()
    {
        return response;
    }

    public Throwable getThrowable()
    {
        return throwable;
    }

    private AsyncContext context;
    private ServletRequest request;
    private ServletResponse response;
    private Throwable throwable;
}