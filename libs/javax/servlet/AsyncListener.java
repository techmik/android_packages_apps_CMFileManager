package javax.servlet;

import java.io.IOException;
import java.util.EventListener;

// Referenced classes of package javax.servlet:
//            AsyncEvent

public interface AsyncListener
    extends EventListener
{

    public abstract void onComplete(AsyncEvent asyncevent)
        throws IOException;

    public abstract void onTimeout(AsyncEvent asyncevent)
        throws IOException;

    public abstract void onError(AsyncEvent asyncevent)
        throws IOException;

    public abstract void onStartAsync(AsyncEvent asyncevent)
        throws IOException;
}