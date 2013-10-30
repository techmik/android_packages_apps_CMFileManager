package javax.naming.event;

import java.util.EventObject;
import javax.naming.Binding;

// Referenced classes of package javax.naming.event:
//            EventContext, NamespaceChangeListener, ObjectChangeListener, NamingListener

public class NamingEvent extends EventObject
{

    public static final int OBJECT_ADDED = 0;
    public static final int OBJECT_REMOVED = 1;
    public static final int OBJECT_RENAMED = 2;
    public static final int OBJECT_CHANGED = 3;
    protected Object changeInfo;
    protected int type;
    protected Binding oldBinding;
    protected Binding newBinding;
    private static final long serialVersionUID = 0x9d18b00289d22f45L;

    public NamingEvent(EventContext eventcontext, int i, Binding binding, Binding binding1, Object obj)
    {
        super(eventcontext);
        type = i;
        oldBinding = binding1;
        newBinding = binding;
        changeInfo = obj;
    }

    public void dispatch(NamingListener naminglistener)
    {
        switch(type)
        {
        case 0: // '\0'
            ((NamespaceChangeListener)naminglistener).objectAdded(this);
            break;

        case 1: // '\001'
            ((NamespaceChangeListener)naminglistener).objectRemoved(this);
            break;

        case 2: // '\002'
            ((NamespaceChangeListener)naminglistener).objectRenamed(this);
            break;

        case 3: // '\003'
            ((ObjectChangeListener)naminglistener).objectChanged(this);
            break;
        }
    }

    public Object getChangeInfo()
    {
        return changeInfo;
    }

    public EventContext getEventContext()
    {
        return (EventContext)getSource();
    }

    public Binding getNewBinding()
    {
        return newBinding;
    }

    public Binding getOldBinding()
    {
        return oldBinding;
    }

    public int getType()
    {
        return type;
    }
}
