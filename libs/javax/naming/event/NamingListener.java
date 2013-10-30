package javax.naming.event;

import java.util.EventListener;

// Referenced classes of package javax.naming.event:
//            NamingExceptionEvent

public interface NamingListener
    extends EventListener
{

    public abstract void namingExceptionThrown(NamingExceptionEvent namingexceptionevent);
}
