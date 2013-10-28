package javax.servlet.http;

import java.util.EventListener;

// Referenced classes of package javax.servlet.http:
//            HttpSessionBindingEvent

public interface HttpSessionBindingListener
    extends EventListener
{

    public abstract void valueBound(HttpSessionBindingEvent httpsessionbindingevent);

    public abstract void valueUnbound(HttpSessionBindingEvent httpsessionbindingevent);
}