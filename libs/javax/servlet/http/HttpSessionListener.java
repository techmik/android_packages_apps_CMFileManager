package javax.servlet.http;

import java.util.EventListener;

// Referenced classes of package javax.servlet.http:
//            HttpSessionEvent

public interface HttpSessionListener
    extends EventListener
{

    public abstract void sessionCreated(HttpSessionEvent httpsessionevent);

    public abstract void sessionDestroyed(HttpSessionEvent httpsessionevent);
}