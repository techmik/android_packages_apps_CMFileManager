package javax.servlet.http;

import java.util.EventListener;

// Referenced classes of package javax.servlet.http:
//            HttpSessionEvent

public interface HttpSessionActivationListener
    extends EventListener
{

    public abstract void sessionWillPassivate(HttpSessionEvent httpsessionevent);

    public abstract void sessionDidActivate(HttpSessionEvent httpsessionevent);
}
