package javax.servlet.http;

import java.util.EventListener;

// Referenced classes of package javax.servlet.http:
//            HttpSessionBindingEvent

public interface HttpSessionAttributeListener
    extends EventListener
{

    public abstract void attributeAdded(HttpSessionBindingEvent httpsessionbindingevent);

    public abstract void attributeRemoved(HttpSessionBindingEvent httpsessionbindingevent);

    public abstract void attributeReplaced(HttpSessionBindingEvent httpsessionbindingevent);
}
