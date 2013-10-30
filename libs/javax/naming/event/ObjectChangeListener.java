package javax.naming.event;


// Referenced classes of package javax.naming.event:
//            NamingListener, NamingEvent

public interface ObjectChangeListener
    extends NamingListener
{

    public abstract void objectChanged(NamingEvent namingevent);
}
