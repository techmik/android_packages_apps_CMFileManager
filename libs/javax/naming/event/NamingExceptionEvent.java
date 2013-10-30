package javax.naming.event;

import java.util.EventObject;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.event:
//            EventContext, NamingListener

public class NamingExceptionEvent extends EventObject
{

    private NamingException exception;
    private static final long serialVersionUID = 0xbc4f019fab3b5a30L;

    public NamingExceptionEvent(EventContext eventcontext, NamingException namingexception)
    {
        super(eventcontext);
        exception = namingexception;
    }

    public void dispatch(NamingListener naminglistener)
    {
        naminglistener.namingExceptionThrown(this);
    }

    public EventContext getEventContext()
    {
        return (EventContext)getSource();
    }

    public NamingException getException()
    {
        return exception;
    }
}
