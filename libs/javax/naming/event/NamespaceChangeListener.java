package javax.naming.event;


// Referenced classes of package javax.naming.event:
//            NamingListener, NamingEvent

public interface NamespaceChangeListener
    extends NamingListener
{

    public abstract void objectAdded(NamingEvent namingevent);

    public abstract void objectRemoved(NamingEvent namingevent);

    public abstract void objectRenamed(NamingEvent namingevent);
}
